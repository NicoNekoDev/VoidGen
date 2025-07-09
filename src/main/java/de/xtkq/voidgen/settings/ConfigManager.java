package de.xtkq.voidgen.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigManager {

    private final Logger LOGGER;
    private final File CONFIGURATION_FILE;
    private Configuration configuration;

    public ConfigManager(JavaPlugin paramPlugin) {
        this.LOGGER = paramPlugin.getLogger();
        this.CONFIGURATION_FILE = new File(paramPlugin.getDataFolder(), "configuration.json");
        this.CONFIGURATION_FILE.getParentFile().mkdirs();

        this.initConfiguration();
    }

    /**
     * Returns the configuration for the plugin. If the configuration is null the default will be returned.
     *
     * @return The configuration.
     */
    public Configuration getConfiguration() {
        if (Objects.isNull(this.configuration)) {
            this.LOGGER.log(Level.WARNING, "Configuration is Null. The configuration on disk will not be used.");
            return new Configuration();
        } else {
            return this.configuration;
        }
    }

    private void initConfiguration() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileReader fileReader;
        FileWriter fileWriter;

        try {
            fileReader = new FileReader(CONFIGURATION_FILE);
            this.configuration = gson.fromJson(fileReader, Configuration.class);
            fileReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            this.LOGGER.log(Level.INFO, "The file:\"" + this.CONFIGURATION_FILE.getName() + "\"was not found.");
            this.LOGGER.log(Level.INFO, "A new file will be generated and the default configuration will be used instead.");
            this.configuration = new Configuration();
        } catch (IOException ioException) {
            LOGGER.log(Level.WARNING, "An IOException was thrown. The FileReader was unable to read the file:\"configuration.json\"", ioException);
        }

        try {
            fileWriter = new FileWriter(CONFIGURATION_FILE);
            gson.toJson(this.configuration, fileWriter);
            fileWriter.close();
        } catch (IOException ioException) {
            this.LOGGER.log(Level.WARNING, "An IOException was thrown. The FileWriter was unable to write to the file:\"configuration.json\"", ioException);
        }
    }
}
