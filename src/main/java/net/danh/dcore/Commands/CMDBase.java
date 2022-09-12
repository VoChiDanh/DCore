package net.danh.dcore.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 */
public abstract class CMDBase implements CommandExecutor, TabCompleter {

    protected JavaPlugin core;

    /**
     * @param core Plugin main class
     * @param name label
     */
    public CMDBase(JavaPlugin core, String name) {
        this.core = core;
        PluginCommand pluginCommand = core.getCommand(name);
        Objects.requireNonNull(pluginCommand).setExecutor(this);
        pluginCommand.setTabCompleter(this);
    }

    /**
     * @param p    Player
     * @param args args
     */
    public abstract void playerexecute(Player p, String[] args);

    /**
     * @param c    ConsoleCommandSender
     * @param args args
     */
    public abstract void consoleexecute(ConsoleCommandSender c, String[] args);

    /**
     * @param sender  Player/Console
     * @param command cmd
     * @param label   label
     * @param args    args
     * @return /label args ...
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            playerexecute((Player) sender, args);
        }
        if (sender instanceof ConsoleCommandSender) {
            consoleexecute((ConsoleCommandSender) sender, args);
        }
        return true;
    }

    /**
     * @param sender sender
     * @param cmd    cmd
     * @param label  label
     * @param args   args
     * @return tab
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return TabComplete(sender, args);
    }

    /**
     * @param sender sender
     * @param args   args
     * @return tab
     */
    public abstract List<String> TabComplete(CommandSender sender, String[] args);
}
