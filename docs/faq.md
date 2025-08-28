## I keep getting this everytime
```terminaloutput
[00:00:00 INFO]: [VoidGen] > ——————————————————————[ world ]——————————————————————
[00:00:00 INFO]: [VoidGen] >
[00:00:00 INFO]: [VoidGen] > Generator settings have not been set, we will use the default settings:
[00:00:00 INFO]: [VoidGen] > {"biome":"the_void"}
[00:00:00 INFO]: [VoidGen] >
[00:00:00 INFO]: [VoidGen] > ——————————————————————[ world ]——————————————————————
```

This is normal behaviour, as it prints what generator parameters are (not) set for that world. You can ignore the log safely.
<br>However, if you want to set the parameters of the world yourself, you can [read the wiki](https://github.com/NicoNekoDev/VoidGen/wiki/Parameters)!
<br>In the setting.yml, you can disable this log by setting `enable_verbose` to `false`.