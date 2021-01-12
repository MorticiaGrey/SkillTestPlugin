package morticia.skilltestplugin.Morticia.events;

import morticia.skilltestplugin.Morticia.Utils.MiningLevelProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoins implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setAllowFlight(true);
        new MiningLevelProfile(player);
    }
}
