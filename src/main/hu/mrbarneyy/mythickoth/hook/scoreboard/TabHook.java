package main.hu.mrbarneyy.mythickoth.hook.scoreboard;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.api.KothScoreboard;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;

public class TabHook implements KothScoreboard {
    private final KothPlugin plugin;

    public TabHook(KothPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public void toggle(Player player, Consumer<Player> after) {
        TabAPI api = TabAPI.getInstance();
        TabPlayer tabPlayer = api.getPlayer(player.getUniqueId());
        ScoreboardManager manager = TabAPI.getInstance().getScoreboardManager();
        if (tabPlayer != null && manager != null) {
            manager.toggleScoreboard(tabPlayer, false);
            Bukkit.getScheduler().runTaskLater(this.plugin, () -> after.accept(player), 10);
        }
    }

    @Override
    public void hide(Player player, Consumer<Player> after) {
        this.toggle(player, after);
    }
}
