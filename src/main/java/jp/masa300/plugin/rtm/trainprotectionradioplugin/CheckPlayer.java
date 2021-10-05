package jp.masa300.plugin.rtm.trainprotectionradioplugin;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckPlayer extends BukkitRunnable {
    private final TrainProtectionRadioPlugin plugin;

    public CheckPlayer(TrainProtectionRadioPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(TrainProtectionRadioPlugin.protectionList.getList().isEmpty()) return;
        for(Player p : plugin.getServer().getOnlinePlayers()) {
            if(TrainProtectionRadioPlugin.protectionList.isPlayerInside(p)) {
                p.playSound(p.getLocation(), "minecraft:note.harp", 2.0F, 2.0F);
            }
        }
    }
}
