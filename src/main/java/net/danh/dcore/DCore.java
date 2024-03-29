package net.danh.dcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * @version 1.0
 */
public class DCore {
    /**
     * @return API Version
     */
    public static String getDCoreVersion() {
        return "v1.4";
    }

    /**
     * @param message Message send to console with [DCore]
     */
    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().log(Level.WARNING, "[DCore] " + messages);
        }
    }

    /**
     * @param core Main of your plugins
     */
    public static void RegisterDCore(JavaPlugin core) {
        dCoreLog(core.getDescription().getName() + " is using DCore " + getDCoreVersion());
    }

}
