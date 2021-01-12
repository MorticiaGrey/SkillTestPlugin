package morticia.skilltestplugin.Morticia.events;

import morticia.skilltestplugin.Morticia.Utils.Constants;
import morticia.skilltestplugin.Morticia.items.SpeedBoots;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpeedBootsEvents implements Listener {
    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getBoots() == null) {
            player.setWalkSpeed(0.2F);
            return;
        }

        if (player.getInventory().getBoots().getItemMeta().equals(SpeedBoots.SpeedBootsItem.getItemMeta())) {
            player.setWalkSpeed(Constants.SpeedBootsVelocity);
        } else {
            player.setWalkSpeed(0.2F);
        }
    }
}
