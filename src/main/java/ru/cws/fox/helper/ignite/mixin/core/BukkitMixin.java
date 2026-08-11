package ru.cws.fox.helper.ignite.mixin.core;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.cws.fox.loader.Fox;

@Mixin(value = Bukkit.class, remap = false)
public class BukkitMixin {
    /**
     * @author DomamaN202
     * @reason Z
     */
    @Overwrite(remap = false)
    public static @NotNull String getVersionMessage() {
        return "This server is running FoX version " + Fox.VERSION;
    }
}
