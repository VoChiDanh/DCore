package net.danh.dcore.Utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TranslatableComponent;

public class Player {

    public static void sendPlayerMessage(org.bukkit.entity.Player p, String... msg) {
        for (String string : msg) {
            p.sendMessage(Chat.colorize(string));
        }
    }

    public static void sendPlayerActionBar(org.bukkit.entity.Player p, String... msg) {
        for (String string : msg) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TranslatableComponent(Chat.colorize(string)));
        }
    }
}
