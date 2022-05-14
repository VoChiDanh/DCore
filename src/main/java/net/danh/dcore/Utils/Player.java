package net.danh.dcore.Utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TranslatableComponent;

import java.util.List;

public class Player {

    public static void sendPlayerMessage(org.bukkit.entity.Player p, String... msg) {
        for (String string : msg) {
            p.sendMessage(Chat.colorize(string));
        }
    }

    public static void sendPlayerMessageList(org.bukkit.entity.Player p, List<String> msg) {
        for (String string : msg) {
            p.sendMessage(Chat.colorize(string));
        }
    }

    public static void sendPlayerActionBar(org.bukkit.entity.Player p, String... msg) {
        for (String string : msg) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TranslatableComponent(Chat.colorize(string)));
        }
    }

    public static void sendPlayerMessageType(org.bukkit.entity.Player p, String type, String... msg) {
        for (String string : msg) {
            p.spigot().sendMessage(ChatMessageType.valueOf(type), new TranslatableComponent(Chat.colorize(string)));
        }
    }
}
