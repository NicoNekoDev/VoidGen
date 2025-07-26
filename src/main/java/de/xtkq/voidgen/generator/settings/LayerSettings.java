package de.xtkq.voidgen.generator.settings;

import lombok.*;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LayerSettings {
    @NotNull
    private Material material = Material.AIR;

    private int height = 1;
}
