package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;

public class DCore {

    public static String getDCoreVersion() {
        return "v1.0";
    }

    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

}
