package morticia.skilltestplugin.Morticia.commands;

import morticia.skilltestplugin.Morticia.Utils.MiningLevelProfile;
import morticia.skilltestplugin.Morticia.inventories.MiningLevelScreen;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Makes sure only a player can execute commands
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Skill Test Plugin] Only players may use that command");

            return true;
        }

        Player player = (Player) sender;
        MiningLevelProfile profile = MiningLevelProfile.searchProfiles(player);

        if (profile == null) {
            return true;
        }

        MiningLevelScreen gui = new MiningLevelScreen();
        gui.init(profile.level, profile.experience);
        player.openInventory(gui.getInventory());

        return true;
    }
}
