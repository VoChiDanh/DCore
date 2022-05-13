package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class DCore {

    public static String getDCoreVersion() {
        return "v1.0";
    }

    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().log(Level.INFO, Chat.colorize(messages));
        }
    }

}
