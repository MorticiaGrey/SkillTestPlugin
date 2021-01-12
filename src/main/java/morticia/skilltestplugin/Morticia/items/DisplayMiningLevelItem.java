package morticia.skilltestplugin.Morticia.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DisplayMiningLevelItem {
    public ItemStack DisplayItem;

    public void init(int level, int experience) {
        ItemStack item = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Level: " + level);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Experience: " + ChatColor.GRAY + experience + ChatColor.GRAY + "/50");
        meta.setLore(lore);
        item.setItemMeta(meta);
        DisplayItem = item;
    }
}
