package morticia.skilltestplugin.Morticia.inventories;

import morticia.skilltestplugin.Morticia.items.DisplayMiningLevelItem;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MiningLevelScreen implements InventoryHolder {
    private Inventory inv;

    public MiningLevelScreen() {
        inv = Bukkit.createInventory(this, 9, "Mining Level");
    }

    public void init(int level, int experience) {
        DisplayMiningLevelItem displayItem = new DisplayMiningLevelItem();
        displayItem.init(level, experience);

        for (int i = 0; i < 9; ++i) {
            inv.setItem(i, displayItem.DisplayItem);
        }
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
