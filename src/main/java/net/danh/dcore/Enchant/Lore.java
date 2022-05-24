package net.danh.dcore.Enchant;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static net.danh.dcore.Utils.Player.sendPlayerMessage;

/**
 * @version 1.2
 */
public class Lore {
    /**
     * @param core      Plugin
     * @param key       key
     * @param p         Player
     * @param itemStack Item
     * @param lore      lore
     * @param level     level
     */
    public static void addEnchant(JavaPlugin core, String key, Player p, ItemStack itemStack, String lore, Integer level) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return;
        }
        if (meta.getLore() == null) {
            return;
        }
        List<String> itemlores = new ArrayList<>();
        if (meta.hasLore()) {
            int line = 0;
            for (int i = 0; i < meta.getLore().size(); i++) {
                if (meta.getLore().get(i).startsWith(ChatColor.GRAY + lore) || meta.getLore().get(i).startsWith(ChatColor.DARK_GRAY + lore)) {
                    line = i;
                    break;
                }
            }
            itemlores = meta.getLore();
            itemlores.set(line, ChatColor.GRAY + lore + " " + level);
        }
        meta.setLore(itemlores);
        meta.getPersistentDataContainer().set(new NamespacedKey(core, key), PersistentDataType.INTEGER, level);
        itemStack.setItemMeta(meta);
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
