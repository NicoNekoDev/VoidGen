package de.xtkq.voidgen.generator.settings;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class LayerSettings {
    @NotNull
    private Material material = Material.AIR;

    private int size = 1;
}
