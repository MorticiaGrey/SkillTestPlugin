package morticia.skilltestplugin.Morticia.events;

import morticia.skilltestplugin.Morticia.Utils.Constants;
import morticia.skilltestplugin.Morticia.items.DoubleJumpBoots;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJumpBootsEvents implements Listener {
    private static boolean hasJumped = false;

    @EventHandler
    public static void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
        Player player = e.getPlayer();

        // Returns if player is not wearing boots
        if (player.getInventory().getBoots() == null) {
            return;
        }
        if (!player.getInventory().getBoots().getItemMeta().equals(DoubleJumpBoots.DoubleJumpBootsItem.getItemMeta())) {
            return;
        }

        player.setFlying(false);

        Vector velocityAddition = player.getVelocity().multiply(Constants.DoubleJumpVelocity);

        e.setCancelled(true);

        if (player.getVelocity().getY() > 0.0F && !hasJumped) {
            player.setVelocity(velocityAddition);
            hasJumped = true;
        } else if (player.getVelocity().getY() < 0.0F && !hasJumped) {
            player.setVelocity(velocityAddition.setY(0.7));
            hasJumped = true;
        }
    }

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        // Isn't directly moving isOnGround to hasJumped as to not erase previously set values
        if (player.isOnGround()) {
            hasJumped = false;
        }
    }
}
