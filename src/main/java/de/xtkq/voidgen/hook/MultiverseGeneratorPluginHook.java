package de.xtkq.voidgen.hook;

import org.mvplugins.multiverse.core.world.generators.GeneratorPlugin;
import org.mvplugins.multiverse.external.jetbrains.annotations.NotNull;
import org.mvplugins.multiverse.external.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class MultiverseGeneratorPluginHook implements GeneratorPlugin {

    @Override
    public @NotNull Collection<String> suggestIds(@Nullable String currentIdInput) {
        //todo: json tab complete
        return List.of();
    }

    @Override
    public @Nullable Collection<String> getExampleUsages() {
        return List.of(
                "  - VoidGen",
                "  - VoidGen:{\"biome\":\"crimson_forest\"}",
                "  - VoidGen:{\"decoration\":true,\"structures\":true,\"mobs\":true,\"biome\":\"end_barrens\"}"
        );
    }

    @Override
    public @Nullable String getInfoLink() {
        return "https://github.com/NicoNekoDev/VoidGen/blob/master/docs/tutorial.md";
    }

    @Override
    public @NotNull String getPluginName() {
        return "VoidGen";
    }
}
