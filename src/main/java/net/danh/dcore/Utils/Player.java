package net.danh.dcore.Utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TranslatableComponent;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;

public class Player {

    /**
     * @param p Player
     * @param msg Message... send to player
     */
    public static void sendPlayerMessage(org.bukkit.entity.Player p, String... msg) {
        for (String string : msg) {
            p.sendMessage(Chat.colorize(string));
        }
    }

    /**
     * @param p Player
     * @param msg List Message send to player
     */
    public static void sendPlayerMessage(org.bukkit.entity.Player p, List<String> msg) {
        for (String string : msg) {
            p.sendMessage(Chat.colorize(string));
        }
    }

    /**
     * @param c ConsoleCommandSender
     * @param msg Message... send to console without [DCore]
     */
    public static void sendConsoleMessage(ConsoleCommandSender c, String... msg) {
        for (String string : msg) {
            c.sendMessage(Chat.colorize(string));
        }
    }

    /**
     * @param c ConsoleCommandSender
     * @param msg List Message send to console without [DCore]
     */
    public static void sendConsoleMessage(ConsoleCommandSender c, List<String> msg) {
        for (String string : msg) {
            c.sendMessage(Chat.colorize(string));
        }
    }

    /**
     * @param p Player
     * @param type CHAT, ACTION_BAR
     * @param msg Message send to player
     */
    public static void sendPlayerMessageType(org.bukkit.entity.Player p, String type, String msg) {
        if (type != null) {
            p.spigot().sendMessage(ChatMessageType.valueOf(type), new TranslatableComponent(Chat.colorize(msg)));
        } else {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TranslatableComponent(Chat.colorize(msg)));
        }
    }
}
