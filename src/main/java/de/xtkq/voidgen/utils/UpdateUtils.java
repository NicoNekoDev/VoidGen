package de.xtkq.voidgen.utils;

import com.google.gson.Gson;
import de.xtkq.voidgen.VoidGen;
import lombok.Getter;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class UpdateUtils {
    private static final String GITHUB_API = "https://api.github.com/repos/NicoNekoDev/%s/releases/latest";
    @Getter
    private static boolean updateAvailable = false;
    @Getter
    private static String latestRelease;
    @Getter
    private static String latestReleaseURL;
    private final VoidGen plugin;

    public UpdateUtils(VoidGen paramPlugin) {
        this.plugin = paramPlugin;
        latestRelease = paramPlugin.getDescription().getVersion();
    }

    public void checkForUpdates() {
        VoidGen.morePaperLib.scheduling().asyncScheduler().runAtFixedRate(() -> {
            Gson gson = new Gson();
            try {
                URL url = new URI(String.format(GITHUB_API, this.plugin.getName())).toURL();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("accept", "application/vnd.github.v3+json");

                if (httpsURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    Map<?, ?> map = gson.fromJson(bufferedReader.readLine(), Map.class);
                    bufferedReader.close();

                    if (isUpdateAvailable(this.plugin.getDescription().getVersion(), ((String) map.get("name")).substring(1))) {
                        updateAvailable = true;
                        latestRelease = ((String) map.get("name")).substring(1);
                        latestReleaseURL = (String) map.get("html_url");
                        this.plugin.getLogger().warning("Update v" + latestRelease + " is available: " + latestReleaseURL);
                    }
                }
            } catch (Exception ignored) {
            }

        }, Duration.ofMillis(2400L * 50L), Duration.ofMillis(216000L * 50L));
    }

    /**
     * Returns True if the provided Version is higher than the local plugin version. Also returns False if the versions are equal.
     *
     * @param paramGithubVersion the plugin version which was retrieved from github.
     * @param paramPluginVersion the local plugin version.
     * @return True if the version on the forums is newer than the local version. False otherwise.
     */
    private boolean isUpdateAvailable(String paramPluginVersion, String paramGithubVersion) {
        String[] localVersion = paramPluginVersion.split("\\.");
        String[] serverVersion = paramGithubVersion.split("\\.");
        int result;
        int i = 0;
        while (i < localVersion.length && i < serverVersion.length && localVersion[i].equals(serverVersion[i])) {
            i++;
        }
        if (i < localVersion.length && i < serverVersion.length) {
            int diff = Integer.valueOf(localVersion[i]).compareTo(Integer.valueOf(serverVersion[i]));
            result = Integer.signum(diff);
        } else {
            result = Integer.signum(localVersion.length - serverVersion.length);
        }
        return result == -1;
    }
}

