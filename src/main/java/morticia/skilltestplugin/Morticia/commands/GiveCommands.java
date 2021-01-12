package morticia.skilltestplugin.Morticia.commands;

import morticia.skilltestplugin.Morticia.items.DoubleJumpBoots;
import morticia.skilltestplugin.Morticia.items.SpeedBoots;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Makes sure only a player can execute commands
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Skill Test Plugin] Only players may use that command");

            return true;
        }

        Player player = (Player) sender;

        // /get d_jump_boots
        if (cmd.getName().equalsIgnoreCase("get_d_jump_boots")) {
            player.getInventory().addItem(DoubleJumpBoots.DoubleJumpBootsItem);
        } else if (cmd.getName().equalsIgnoreCase("get_speed_boots")) {
            player.getInventory().addItem(SpeedBoots.SpeedBootsItem);
        }

        return true;
    }
}
