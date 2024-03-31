package main.hu.mrbarneyy.mythickoth.hook.scoreboard;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.api.KothScoreboard;
import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

public class TitleManagerHook implements KothScoreboard {

    private TitleManagerAPI api;

    public TitleManagerHook(KothPlugin plugin){

    }

    @Override
    public void toggle(Player player, Consumer<Player> after) {
        if (api == null)
            api = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        api.giveDefaultScoreboard(player);
    }

    @Override
    public void hide(Player player, Consumer<Player> after) {
        if (api == null)
            api = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        api.removeScoreboard(player);
    }

}
