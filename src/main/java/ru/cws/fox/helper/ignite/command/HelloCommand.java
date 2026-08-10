package ru.cws.fox.helper.ignite.command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class HelloCommand extends BukkitCommand {
  public HelloCommand() {
    super("hello");
    this.setPermission("bukkit.command.help");
  }

  @Override
  public boolean execute(@NonNull CommandSender commandSender, @NonNull String currentAlias, @NonNull String @NonNull[] args) {
    if (!this.testPermission(commandSender)) {
      return true;
    } else {
      commandSender.sendMessage("Здарова, " + commandSender.getName() + "!");
    }

    return false;
  }
}
