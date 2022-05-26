package net.danh.dcore.Enchant;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @version 1.2
 */
public class Lore {

    private static boolean full;

    public static boolean isFull() {
        return full;
    }

    /**
     * @param level Integer
     * @return Roman Number
     */
    public static String formatLevel(Integer level) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        AtomicReference<StringBuilder> roman = new AtomicReference<>(new StringBuilder());

        for (int i = 0; i < values.length; i++) {
            while (level >= values[i]) {
                level -= values[i];
                roman.get().append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    /**
     * @param core        Plugin
     * @param key         key
     * @param p           Player
     * @param itemStack   Item
     * @param lore        lore
     * @param level       level
     * @param defaultlore Lore
     */
    public static void addEnchant(JavaPlugin core, String key, Player p, ItemStack itemStack, String lore, Integer level, String defaultlore) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return;
        }
        if (meta.getLore() == null) {
            return;
        }
        List<String> itemlores = meta.getLore();
        int line = 0;
        for (int i = 0; i < meta.getLore().size(); i++) {
            if (hasEnchant(core, key, itemStack)) {
                if (meta.getLore().get(i).startsWith(ChatColor.GRAY + lore)) {
                    line = i;
                    full = false;
                    break;
                }
            } else {
                if (meta.getLore().contains(ChatColor.DARK_GRAY + defaultlore)) {
                    if (meta.getLore().get(i).startsWith(ChatColor.DARK_GRAY + defaultlore)) {
                        line = i;
                        full = false;
                    }
                } else {
                    full = true;
                }
                break;
            }
        }
        if (!full) {
            itemlores.set(line, ChatColor.GRAY + lore + " " + formatLevel(level));
            meta.setLore(itemlores);
            meta.getPersistentDataContainer().set(new NamespacedKey(core, key), PersistentDataType.INTEGER, level);
            itemStack.setItemMeta(meta);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
        } else {
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
        }
    }

    /**
     * @param core      Plugin
     * @param key       key
     * @param itemStack item
     * @return true/false
     */
    public static boolean hasEnchant(JavaPlugin core, String key, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return false;
        }
        if (meta.getLore() == null) {
            return false;
        }
        return meta.getPersistentDataContainer().has(new NamespacedKey(core, key), PersistentDataType.INTEGER);
    }

    /**
     * @param core      Plugin
     * @param key       key
     * @param itemStack item
     * @return number
     */
    public static int getEnchantLevel(JavaPlugin core, String key, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return 0;
        }
        if (meta.getLore() == null) {
            return 0;
        }
        if (!hasEnchant(core, key, itemStack)) {
            return 0;
        }
        return meta.getPersistentDataContainer().getOrDefault(new NamespacedKey(core, key), PersistentDataType.INTEGER, 0);
    }
}
