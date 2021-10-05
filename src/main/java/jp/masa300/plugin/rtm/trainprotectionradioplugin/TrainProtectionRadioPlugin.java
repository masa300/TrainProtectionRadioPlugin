package jp.masa300.plugin.rtm.trainprotectionradioplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class TrainProtectionRadioPlugin extends JavaPlugin {
    public static int PROTECTION_RADIUS = 500;
    public static ProtectionList protectionList;

    @Override
    public void onEnable() {
        // Plugin startup logic
        TrainProtectionRadioPlugin.protectionList = new ProtectionList();
        getCommand("tprp").setExecutor(new CommandClass());
        getCommand("bougo").setExecutor(new CommandClass());

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new CheckPlayer(this), 0L, 5L);
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
