package net.danh.dcore.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public static List<String> Lore(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        return output;
    }

    public static ItemStack makeItem(Material material, Integer amount, Boolean glow, Boolean Unbreakable, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (name != null) {
            itemMeta.setDisplayName(name);
        }
        if (lore != null) {
            itemMeta.setLore(lore);
        }
        if (glow) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
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
