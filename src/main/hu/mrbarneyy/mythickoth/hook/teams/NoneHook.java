package main.hu.mrbarneyy.mythickoth.hook.teams;

import main.hu.mrbarneyy.mythickoth.api.KothTeam;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class NoneHook implements KothTeam {


    @Override
    public String getTeamName(OfflinePlayer player) {
        return player.getName();
    }

    @Override
    public List<Player> getOnlinePlayer(OfflinePlayer player) {
        return Collections.singletonList(player.getPlayer());
    }

    @Override
    public String getLeaderName(OfflinePlayer player) {
        return player.getName();
    }

    @Override
    public String getTeamId(OfflinePlayer player) {
        return player.getUniqueId().toString();
    }
}
