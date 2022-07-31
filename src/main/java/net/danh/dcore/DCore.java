package net.danh.dcore;

import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static net.danh.dcore.Indicator.Hologram.indicators;

/**
 * @version 1.0
 */
public class DCore {
    public static final Set<Entity> stands = indicators.keySet();
    public static final List<Entity> removal = new ArrayList<>();

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
            Bukkit.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

    /**
     * @param core Main of your plugins
     */
    public static void RegisterDCore(JavaPlugin core) {
        dCoreLog("&3" + core.getDescription().getName() + " is using DCore " + getDCoreVersion());
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity stand : stands) {
                    int ticksLeft = indicators.get(stand);
                    if (ticksLeft == 0) {
                        stand.remove();
                        removal.add(stand);
                        continue;
                    }
                    ticksLeft--;
                    indicators.put(stand, ticksLeft);
                }
                removal.forEach(stands::remove);
            }
        }.runTaskTimer(core, 0L, 1L);
    }

}
