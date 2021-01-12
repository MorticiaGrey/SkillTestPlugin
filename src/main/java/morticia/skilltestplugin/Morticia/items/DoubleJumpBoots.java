package morticia.skilltestplugin.Morticia.items;

import morticia.skilltestplugin.Morticia.Utils.Constants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DoubleJumpBoots {
    public static ItemStack DoubleJumpBootsItem;

    public static void init() {
        ItemStack item = new ItemStack(Constants.doubleJumpBootsMaterial, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Double Jump Boots");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Click Space in the Air");
        lore.add(ChatColor.GRAY + "to Jump Again");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        DoubleJumpBootsItem = item;
    }
}
