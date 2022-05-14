package net.danh.dcore.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
     * @param amount      int
     * @param glow        true/false
     * @param HideFlag    true/false
     * @param Unbreakable true/false
     * @param name        Item name
     * @param lore        Item lore
     * @return ItemStack
     */
    public static ItemStack makeItem(Material material, Short data, Integer amount, Boolean glow, Boolean HideFlag, Boolean Unbreakable, String name, List<String> lore) {
        if (data == null) {
            ItemStack itemStack = new ItemStack(material, amount);
            ItemMeta itemMeta = itemStack.getItemMeta();
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
        } else {
            ItemStack itemStack = new ItemStack(material, amount, data);
            ItemMeta itemMeta = itemStack.getItemMeta();
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
    }

}
