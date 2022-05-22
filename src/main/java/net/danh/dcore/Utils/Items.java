package net.danh.dcore.Utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 */
public class Items {

    /**
     * @param input List Lore
     * @return input with color code
     */
    public static List<String> Lore(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(Chat.colorize(string));
        }
        return output;
    }

    /**
     * @param material    Material
     * @param data        Data (For legacy version 1.13 below), null if you use 1.13+
     * @param amount      int
     * @param glow        true/false
     * @param HideFlag    true/false
     * @param Unbreakable true/false
     * @param name        Item name
     * @param lore        Item lore
     * @return ItemStack
     */
    public static ItemStack makeItem(Material material, Short data, Integer amount, Boolean glow, Boolean HideFlag, Boolean Unbreakable, String name, List<String> lore) {
        ItemStack itemStack;
        if (data == null) {
            itemStack = new ItemStack(material, amount);
            ItemMeta itemMeta = itemStack.getItemMeta();
            Objects.requireNonNull(itemMeta).setDisplayName(Chat.colorize(name));
            if (lore != null) {
                itemMeta.setLore(Lore(lore));
            }
            if (glow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (HideFlag) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            if (Unbreakable) {
                itemMeta.setUnbreakable(true);
            }
            itemStack.setItemMeta(itemMeta);
        } else {
            itemStack = new ItemStack(material, amount, data);
            ItemMeta itemMeta = itemStack.getItemMeta();
            Objects.requireNonNull(itemMeta).setDisplayName(Chat.colorize(name));
            if (lore != null) {
                itemMeta.setLore(Lore(lore));
            }
            if (glow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (HideFlag) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            if (Unbreakable) {
                itemMeta.setUnbreakable(true);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }

    /**
     * @param material    Material
     * @param data        Data (For legacy version 1.13 below), null if you use 1.13+
     * @param amount      int
     * @param glow        true/false
     * @param HideFlag    true/false
     * @param Unbreakable true/false
     * @param name        Item name
     * @param lore        Item lore
     * @return ItemStack
     */
    public static ItemStack makeItem(Material material, Short data, Integer amount, Boolean glow, Boolean HideFlag, Boolean Unbreakable, String name, String... lore) {
        ItemStack itemStack;
        if (data == null) {
            itemStack = new ItemStack(material, amount);
            ItemMeta itemMeta = itemStack.getItemMeta();
            Objects.requireNonNull(itemMeta).setDisplayName(Chat.colorize(name));
            if (lore != null) {
                List<String> l = new ArrayList<>();
                for (String lores : lore) {
                    l.add(Chat.colorize(lores));
                }
                itemMeta.setLore(Lore(l));
            }
            if (glow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (HideFlag) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            if (Unbreakable) {
                itemMeta.setUnbreakable(true);
            }
            itemStack.setItemMeta(itemMeta);
        } else {
            itemStack = new ItemStack(material, amount, data);
            ItemMeta itemMeta = itemStack.getItemMeta();
            Objects.requireNonNull(itemMeta).setDisplayName(Chat.colorize(name));
            if (lore != null) {
                List<String> l = new ArrayList<>();
                for (String lores : lore) {
                    l.add(Chat.colorize(lores));
                }
                itemMeta.setLore(l);
            }
            if (glow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (HideFlag) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            if (Unbreakable) {
                itemMeta.setUnbreakable(true);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }


    /**
     * @param core        Plugin
     * @param key         String
     * @param type        PersistentDataType
     * @param value       String
     * @param material    Material
     * @param amount      int
     * @param glow        true/false
     * @param HideFlag    true/false
     * @param Unbreakable true/false
     * @param name        Item name
     * @param lore        Item lore
     * @return ItemStack
     */
    public static ItemStack makeItem(JavaPlugin core, String key, PersistentDataType<String, String> type, String value, Material material, Integer amount, Boolean glow, Boolean HideFlag, Boolean Unbreakable, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(core, key);
        Objects.requireNonNull(itemMeta).getPersistentDataContainer().set(namespacedKey, type, value);
        if (name != null) {
            itemMeta.setDisplayName(Chat.colorize(name));
        }
        if (lore != null) {
            itemMeta.setLore(Lore(lore));
        }
        if (glow) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (HideFlag) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        if (Unbreakable) {
            itemMeta.setUnbreakable(true);
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    /**
     * @param core        Plugin
     * @param key         String
     * @param type        PersistentDataType
     * @param value       String
     * @param material    Material
     * @param amount      int
     * @param glow        true/false
     * @param HideFlag    true/false
     * @param Unbreakable true/false
     * @param name        Item name
     * @param lore        Item lore
     * @return ItemStack
     */
    public static ItemStack makeItem(JavaPlugin core, String key, PersistentDataType<String, String> type, String value, Material material, Integer amount, Boolean glow, Boolean HideFlag, Boolean Unbreakable, String name, String... lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(core, key);
        Objects.requireNonNull(itemMeta).getPersistentDataContainer().set(namespacedKey, type, value);
        if (name != null) {
            itemMeta.setDisplayName(Chat.colorize(name));
        }
        if (lore != null) {
            List<String> l = new ArrayList<>();
            for (String lores : lore) {
                l.add(Chat.colorize(lores));
            }
            itemMeta.setLore(Lore(l));
        }
        if (glow) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (HideFlag) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        if (Unbreakable) {
            itemMeta.setUnbreakable(true);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static boolean hasKey(JavaPlugin core, ItemStack is, String targetKey, PersistentDataType<String, String> type) {
        NamespacedKey key = new NamespacedKey(core, targetKey);
        ItemMeta itemMeta = is.getItemMeta();
        PersistentDataContainer container = Objects.requireNonNull(itemMeta).getPersistentDataContainer();
        boolean foundKey = false;
        if (container.has(key, type)) {
            foundKey = container.get(key, type) != null;
        }
        return foundKey;
    }
}
