package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @version 1.0
 */
public class DCore{
    public static boolean papistatus = false;
    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return instance;
    }
    /**
     * @return API Version
     */
    public static String getDCoreVersion() {
        return "v1.3";
    }

    /**
     * @param message Message send to console with [DCore]
     */
    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

    /**
     * @param core Main of your plugins
     */
    public static void RegisterDCore(JavaPlugin core) {
        dCoreLog("&3" + core.getDescription().getName() + " is using DCore " + getDCoreVersion());
        papistatus = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        instance = core;
    }
}
