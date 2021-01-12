package morticia.skilltestplugin.Morticia;

import morticia.skilltestplugin.Morticia.Utils.MiningLevelProfile;
import morticia.skilltestplugin.Morticia.commands.GiveCommands;
import morticia.skilltestplugin.Morticia.commands.LevelCommand;
import morticia.skilltestplugin.Morticia.events.DoubleJumpBootsEvents;
import morticia.skilltestplugin.Morticia.events.MiningLevelsEvents;
import morticia.skilltestplugin.Morticia.events.PlayerJoins;
import morticia.skilltestplugin.Morticia.events.SpeedBootsEvents;
import morticia.skilltestplugin.Morticia.items.DoubleJumpBoots;
import morticia.skilltestplugin.Morticia.items.SpeedBoots;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class skillTestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register events
        getServer().getPluginManager().registerEvents(new DoubleJumpBootsEvents(), this);
        getServer().getPluginManager().registerEvents(new SpeedBootsEvents(), this);
        getServer().getPluginManager().registerEvents(new MiningLevelsEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoins(), this);

        // Commands
        getCommand("get_d_jump_boots").setExecutor(new GiveCommands());
        getCommand("get_speed_boots").setExecutor(new GiveCommands());
        getCommand("level").setExecutor(new LevelCommand());

        // Initialize items
        DoubleJumpBoots.init();
        SpeedBoots.init();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Skill Test Plugin] Plugin Enabled");
    }

    @Override
    public void onDisable() {
        //MiningLevelProfile.resetProfiles();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Skill Test Plugin] Plugin Disabled");
    }
}
