package main.hu.mrbarneyy.mythickoth.hook;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.api.KothTeam;
import main.hu.mrbarneyy.mythickoth.hook.teams.BetterTeamHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.GangsHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.HuskTownHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.LandHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.SaberFactionHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.SimpleClanHook;
import main.hu.mrbarneyy.mythickoth.hook.teams.SuperiorSkyblock2Hook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;

public enum TeamPlugin {

    LANDS("Lands", LandHook.class),
    HUSKTOWN("HuskTowns", HuskTownHook.class),
    SUPERIORSKYBLOCK("SuperiorSkyblock2", SuperiorSkyblock2Hook.class),
    BETTERTEAMS("BetterTeams", BetterTeamHook.class),
    FACTIONS("Factions", SaberFactionHook.class),
    SIMPLECLANS("SimpleClans", SimpleClanHook.class),
    GANGSPLUS("GangsPlus", GangsHook.class),

    ;

    private final String pluginName;
    private final Class<? extends KothTeam> teamHook;

    TeamPlugin(String pluginName, Class<? extends KothTeam> teamHook) {
        this.pluginName = pluginName;
        this.teamHook = teamHook;
    }

    public String getPluginName() {
        return pluginName;
    }

    public boolean isEnable() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(this.pluginName);
        return plugin != null && plugin.isEnabled();
    }

    public KothTeam init(KothPlugin plugin) {
        try {
            return teamHook.getConstructor(KothPlugin.class).newInstance(plugin);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
