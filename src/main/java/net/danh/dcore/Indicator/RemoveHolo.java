package net.danh.dcore.Indicator;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static net.danh.dcore.Indicator.Hologram.indicators;

public class RemoveHolo extends BukkitRunnable {
    public static final Set<Entity> stands = indicators.keySet();
    public static final List<Entity> removal = new ArrayList<>();

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
}

