# Tutorial Section

- Step 0 - [Where to put the plugin?](#Where-to-put-the-plugin)
- Step 1 - [Setup of the bukkit.yml file](#Setup-of-the-bukkityml-file)
- Step 2 - [Validating json parameters](#Validating-parameters)
- Step 3 - [Restart](#Restart)
- [Parameters](#Parameters)

## Where to put the plugin?

If your server is currently running, Stop it. <br>
Download the [latest plugin release](https://github.com/NicoNekoDev/VoidGen/releases/latest) and drop it in the plugin directory. Afterward start your server back up. The plugin will automatically detect which ChunkGeneration version to use, generate the tiny configuration file and post some infos in your server's console. <br>
To check if the plugin loaded successfully either run the command `/plugins` ingame or from the console and see if the plugin's name is listed green.

## Setup of the bukkit.yml file

Setting up the `bukkit.yml` file is highly recommended, even tho it is only strictly needed for the default worlds. <br>
Open up the `bukkit.yml` file from your server directory and go to the end of the file. At the end of the file the following snippet needs to be added for all the worlds we want the plugin to handle generation. Here we add the worlds we want the plugin to generate. Just replace the placeholders *worldname_1* and *worldname_2* with the actual world names. The list can be extended for however many world you want to use:

    worlds:
      worldname_1:
        generator: VoidGen
      worldname_2:
        generator: VoidGen

It is also possible to modify the basic generator with additional [parameters](#Parameters). You can use any amount of parameters you want to set in any order. Note that specifying the default value of a parameter is the same as not specifying it at all. Chaining multiple parameters together can be done with *commas* as can be seen in the examples:

    worlds:
      worldname_3:
        generator: VoidGen:{"biome":"crimson_forest"}
      worldname_4:
        generator: VoidGen:{"decoration":true, "structures":true, "mobs":true, "biome":"end_barrens"}

## Validating parameters

You need to make sure that your parameters are valid. The plugin will try it's best to understand your json syntax and validate it, but there might be some edge cases that will cause the plugin to not work correctly, and the default parameters will be used instead. Use this [website](https://jsonformatter.curiousconcept.com/) to validate your json syntax.

## Restart

Restart your server for all the changes to take effect. If you configured everything correctly, the generator will work in all newly created chunks. <br>
If you find any bug, have crashed because of the plugin or are still experiencing issues, please report it at my [official Discord server](https://discord.gg/Q7yj32FMFh).

# Parameters

| Parameter    | Definition                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | Values                                                                                                 | Syntax                                                                                                   |
|--------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `biome`      | Sets the biome of all locations in the generated world to the specified value. <br> Not setting this parameter, using a biome that is not supported by your server's version or using anything besides a biome name will result in the vanilla biome grid for your world seed.                                                                                                                                                                                                        | [Biomes for the latest version.](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Biome.html) | `{"biome":"desert"}` <br> All blocks will be set to the desert biome.                                    |
| `caves`      | Controls the creation of vanilla style caves. <br> This includes ravines and similar world features. Not setting this parameter is the same as setting it to false. Since this plugin does not generate terrain, without the `noise` parameter no blocks will generate and therefor no caves.                                                                                                                                                                                         | `true` / `false`                                                                                       | `{"caves":true}` <br> Enables vanilla style caves to generate.                                           |
| `mobs`       | Controls whether you want the server to spawn vanilla mobs or not. <br> Not setting this parameter is the same as setting it to false.                                                                                                                                                                                                                                                                                                                                                | `true` / `false`                                                                                       | `{"mobs":true}` <br> Enables vanilla mobs to spawn.                                                      |
| `structures` | Controls vanilla structure generation. <br> Not setting this parameter is the same as setting it to false. Some structures need the `decoration` parameter to be set to true as well to generate correctly (e.g. strongholds). <br><br> <b>WARNING</b>: If you set the biome parameter, only structures that are able to naturally generate in the specified biome can generate (e.g. no structure can generate in THE_VOID biome, ocean monuments can not generate in a PLAIN biome) | `true` / `false`                                                                                       | `{"structures":true}` <br> `{"structures":true,"decoration":true}` <br> Enables structures to generate.  |
| `decoration` | Controls the creation of vanilla chunk decorations. <br> Not setting this parameter is the same as setting it to false. Mostly used in combination with the `structures` parameter.                                                                                                                                                                                                                                                                                                   | `true` / `false`                                                                                       | `{"decoration":true}` <br> `{"structures":true,"decoration":true}` <br> Enables decorations to generate. |
| `noise`      | Controls the creation of blocks from noise. Think vanilla stone, basically everything between bedrock and the surface. <br> Not setting this parameter is the same as setting it to false.                                                                                                                                                                                                                                                                                            | `true` / `false`                                                                                       | `{"noise":true}` <br> Enabled noise for blocks to generate.                                              |
| `surface`    | Controls the creation of surface blocks. Think vanilla gras blocks. <br> Not setting this parameter is the same as setting it to false. The surface can only generate if blocks are present. The easiest methode of doing so is enabling the `noise` parameter.                                                                                                                                                                                                                       | `true` / `false`                                                                                       | `{"surface":true}` <br> `{"surface":true,"noise":true}` <br> Enables the surface to generate.            |
| `bedrock`    | Controls the creation of the vanilla bedrock layer at the bottom of the world. <br> Not setting this parameter is the same as setting it to false. <br><br> <b>WARNING</b>: In versions 1.19.2 and above, this setting has no effect! The bedrock layer is now part of the `surface` parameter.                                                                                                                                                                                       | `true` / `false`                                                                                       | `{"bedrock":true}` <br> Enables the bedrock layer to generate.                                           |

