package morticia.skilltestplugin.Morticia.items;

import morticia.skilltestplugin.Morticia.Utils.Constants;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SpeedBoots {
    public static ItemStack SpeedBootsItem;

    public static void init() {
        ItemStack item = new ItemStack(Constants.SpeedBootsMaterial, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Boots");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Speeds you up!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SpeedBootsItem = item;
    }
}
