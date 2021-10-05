package jp.masa300.plugin.rtm.trainprotectionradioplugin.utils;

import jp.masa300.plugin.rtm.trainprotectionradioplugin.TrainProtectionRadioPlugin;
import org.bukkit.entity.Player;

public class ProtectionPoint {
    public int X;
    public int Z;
    private String OwnerName;

    private ProtectionPoint() {}

    public ProtectionPoint(int x, int z, String playerName) {
        this.X = x;
        this.Z = z;
        this.OwnerName = playerName;
    }

    public boolean isPlayerInside(Player player) {
        int x = player.getLocation().getBlockX();
        int z = player.getLocation().getBlockZ();
        int radius = TrainProtectionRadioPlugin.PROTECTION_RADIUS;
        return (this.X - radius < x && x < this.X + radius) && (this.Z - radius < z && z < this.Z + radius);
    }

    public String getOwnerName() { return this.OwnerName; }
}
