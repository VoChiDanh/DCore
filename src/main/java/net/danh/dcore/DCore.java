package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public class DCore {

    public static String getDCoreVersion() {
        return "v1.0";
    }

    public static void dCoreLog(JavaPlugin core, String... message) {
        for (String messages : message) {
            core.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

}
