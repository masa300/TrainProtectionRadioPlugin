package jp.masa300.plugin.rtm.trainprotectionradioplugin;

import jp.masa300.plugin.rtm.trainprotectionradioplugin.utils.ProtectionPoint;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
            Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("tprp")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("list")) {
                    if(TrainProtectionRadioPlugin.protectionList.getList().isEmpty()) {
                        sender.sendMessage("There was no protections");
                        return true;
                    }
                    for(ProtectionPoint pl : TrainProtectionRadioPlugin.protectionList.getList()) {
                        sender.sendMessage(pl.getOwnerName() + " (" + pl.X + ", " + pl.Z + ")");
                    }
                    return true;

                } else if(args[0].equalsIgnoreCase("allClear")) {
                    TrainProtectionRadioPlugin.protectionList.clearAllList();
                    sender.sendMessage("Protection all cleared");
                    return true;
                }

            } else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("setRadius") && args[1].matches("[0-9]{1,4}")) {
                    TrainProtectionRadioPlugin.PROTECTION_RADIUS = Integer.parseInt(args[1]);
                    sender.sendMessage("Change Protection Radius : " + args[1]);
                    return true;

                } else if(args[0].equalsIgnoreCase("clear")) {
                    TrainProtectionRadioPlugin.protectionList.removeProtectionPos(args[1]);
                    sender.sendMessage(args[1] + "\'s protection cleared");
                    return true;
                }
            }
        }

        if (command.getName().equalsIgnoreCase("bougo")) {
            if (args.length == 0) {
                int x = player.getLocation().getBlockX();
                int z = player.getLocation().getBlockZ();
                sender.sendMessage("ÅòcñhåÏñ≥ê¸î≠ïÒ");
                TrainProtectionRadioPlugin.protectionList.addProtectionPos(x, z, player.getName());
                return true;

            } else if(args.length == 1) {
                if (args[0].equalsIgnoreCase("clear")) {
                    sender.sendMessage("ÅòañhåÏñ≥ê¸âèú");
                    TrainProtectionRadioPlugin.protectionList.removeProtectionPos(player.getPlayerListName());
                    return true;
                }
            }
        }
        return false;
    }
}

