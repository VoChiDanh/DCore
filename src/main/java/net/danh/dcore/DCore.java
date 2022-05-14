package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;

public class DCore {

    /**
     * @return v1.0
     */
    public static String getDCoreVersion() {
        return "v1.0";
    }

    /**
     * @param message send message to console
     */
    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

}
