package net.danh.dcore.Indicator;

import net.danh.dcore.Utils.Chat;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Hologram {
    public static Map<Entity, Integer> indicators = new HashMap<>();

    public static double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5) random *= -1;
        return random;
    }

    public static void create(Entity target, String string) {
        target.getWorld().spawn(target.getLocation().clone().add(getRandomOffset(), 1, getRandomOffset()), ArmorStand.class, armorStand -> {
            armorStand.setMarker(true);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(true);
            armorStand.setCustomNameVisible(true);
            armorStand.setCustomName(Chat.colorize(string));
        });
    }
}
