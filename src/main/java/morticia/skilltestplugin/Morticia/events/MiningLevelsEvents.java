package morticia.skilltestplugin.Morticia.events;

import morticia.skilltestplugin.Morticia.Utils.Constants;
import morticia.skilltestplugin.Morticia.Utils.MiningLevelProfile;
import morticia.skilltestplugin.Morticia.inventories.MiningLevelScreen;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MiningLevelsEvents implements Listener {
    @EventHandler
    public static void onPlayerMine(BlockBreakEvent e) {
        Player player = e.getPlayer();

        MiningLevelProfile profile = MiningLevelProfile.searchProfiles(player);
        if (profile != null) {
            if (Math.random() < Constants.ExperienceGainChance) {
                profile.experience += Constants.ExperienceGainAmount;
                profile.updateLevels();
            }
        }
    }

    @EventHandler
    public static void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) { return; }
        if (e.getClickedInventory().getHolder() instanceof MiningLevelScreen) {
            e.setCancelled(true);
        }
    }
}
