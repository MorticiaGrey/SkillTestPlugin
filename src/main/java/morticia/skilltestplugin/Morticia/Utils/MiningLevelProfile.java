package morticia.skilltestplugin.Morticia.Utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MiningLevelProfile {
    public static List<MiningLevelProfile> profiles = new ArrayList<>();

    public Player player;
    public int level = 0;
    public int experience = 0;

    public MiningLevelProfile(Player player) {
        this.player = player;
        profiles.add(this);
    }

    public void updateLevels() {
        if ((experience % 50) == 0) {
            level++;
            experience = 0;
        }
    }

    public static void updateAllProfiles() {
        for (MiningLevelProfile profile : profiles) {
            profile.updateLevels();
        }
    }

    public static void resetProfiles() {
        profiles = new ArrayList<>();
    }

    public static MiningLevelProfile searchProfiles(Player target) {
        for (MiningLevelProfile profile : profiles) {
            if (profile.player.equals(target)) {
                return profile;
            }
        }
        return null;
    }
}
