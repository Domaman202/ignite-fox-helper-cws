package ru.cws.fox.helper.ignite.command;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import space.vectrix.ignite.Ignite;
import space.vectrix.ignite.mod.ModContainer;

public class ModsCommand extends BukkitCommand {
  public ModsCommand() {
    super("mods-ignite");
    this.description = "Gets a list of ignite mods running on the server";
    this.usageMessage = "/bukkit:mods-ignite";
    this.setPermission("bukkit.command.plugins");
  }

  @Override
  public boolean execute(@NotNull CommandSender sender, @NotNull String currentAlias, @NotNull String @NonNull [] args) {
    if (!testPermission(sender)) return true;

    sender.sendMessage("Mods " + getPluginList());
    return true;
  }

  @NotNull
  @Override
  public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String @NonNull [] args) throws IllegalArgumentException {
    return Collections.emptyList();
  }

  @NotNull
  private String getPluginList() {
    StringBuilder modList = new StringBuilder();
    ModContainer[] mods = Ignite.mods().containers().toArray(ModContainer[]::new);

    modList.append(ChatColor.WHITE);
    for (int i = 0; i < mods.length; i++) {
      ModContainer mod = mods[i];

      modList.append(mod.id()).append(" (").append(ChatColor.ITALIC).append(mod.version()).append(ChatColor.RESET).append(ChatColor.WHITE).append(")");

      if (i + 1 < mods.length) {
        modList.append(", ");
      }
    }

    return "(" + mods.length + "): " + modList;
  }
}
