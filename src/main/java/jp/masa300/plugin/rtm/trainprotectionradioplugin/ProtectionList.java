package jp.masa300.plugin.rtm.trainprotectionradioplugin;

import jp.masa300.plugin.rtm.trainprotectionradioplugin.utils.ProtectionPoint;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProtectionList {
    private List<ProtectionPoint> protectionList;

    public ProtectionList() {
        this.clearAllList();
    }

    public void addProtectionPos(int x, int z, String ownerName) {
        this.protectionList.add(new ProtectionPoint(x, z, ownerName));
    }

    public void removeProtectionPos(String ownerName) {
        for (int i = 0; i < this.protectionList.size(); i++) {
            if (this.protectionList.get(i).getOwnerName().equalsIgnoreCase(ownerName)) {
                this.protectionList.remove(i);
                --i;
            }
        }
    }

    public void clearAllList() {
        this.protectionList = new ArrayList<>(Collections.emptyList());
    }

    public boolean isPlayerInside(Player player) {
        for (ProtectionPoint pl : this.protectionList) {
            if (pl.isPlayerInside(player)) return true;
        }
        return false;
    }

    public List<ProtectionPoint> getList() {
        return this.protectionList;
    }
}
