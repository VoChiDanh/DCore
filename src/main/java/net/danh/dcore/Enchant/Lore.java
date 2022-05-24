package net.danh.dcore.Enchant;

import net.danh.dcore.Utils.Chat;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static net.danh.dcore.Utils.Player.sendPlayerMessage;

public class Lore {

    /**
     * @param itemStack Item
     * @param lore      Lore
     */
    private static void removeLore(ItemStack itemStack, String lore) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return;
        }
        if (meta.getLore() == null) {
            return;
        }
        int line = 0;
        for (int i = 0; i < meta.getLore().size(); i++) {
            if (meta.getLore().get(i).startsWith(Chat.colorize(lore))) {
                line = i;
                break;
            }
        }

        meta.getLore().remove(line);
        itemStack.setItemMeta(meta);
    }

    /**
     * @param core      Plugin
     * @param key       key (upper_case_plz)
     * @param p         Player
     * @param itemStack Item
     * @param lore      lore
     * @param level     level
     */
    public static void addEnchant(JavaPlugin core, String key, Player p, ItemStack itemStack, String lore, Integer level) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            sendPlayerMessage(p, "&cKhông thề phù phép vật phẩm này");
            return;
        }
        if (meta.getLore() == null) {
            sendPlayerMessage(p, "&cKhông thề phù phép vật phẩm này");
            return;
        }
        removeLore(itemStack, lore);
        List<String> itemlores = new ArrayList<>();
        if (meta.hasLore()) {
            itemlores = meta.getLore();
        }
        itemlores.add(Chat.colorize(lore + " " + level));
        meta.setLore(itemlores);
        meta.getPersistentDataContainer().set(new NamespacedKey(core, key), PersistentDataType.INTEGER, level);
        itemStack.setItemMeta(meta);
        sendPlayerMessage(p, "&aPhù phép thành công enchant " + lore + " &cLv." + level);
    }

    /**
     * @param core      Plugin
     * @param key       key (upper_case_plz)
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
     * @param key       key (upper_case_plz)
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
