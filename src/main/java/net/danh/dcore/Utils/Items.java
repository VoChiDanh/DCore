package net.danh.dcore.Utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public static List<String> Lore(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        return output;
    }

}
