package main.hu.mrbarneyy.mythickoth;

import main.hu.mrbarneyy.mythickoth.api.KothHologram;
import main.hu.mrbarneyy.mythickoth.api.KothScoreboard;
import main.hu.mrbarneyy.mythickoth.command.commands.CommandKoth;
import main.hu.mrbarneyy.mythickoth.hologram.DecentHologram;
import main.hu.mrbarneyy.mythickoth.hologram.EmptyHologram;
import main.hu.mrbarneyy.mythickoth.hook.ScoreboardPlugin;
import main.hu.mrbarneyy.mythickoth.hook.scoreboard.DefaultHook;
import main.hu.mrbarneyy.mythickoth.placeholder.LocalPlaceholder;
import main.hu.mrbarneyy.mythickoth.save.Config;
import main.hu.mrbarneyy.mythickoth.save.MessageLoader;
import main.hu.mrbarneyy.mythickoth.scheduler.ZkothImplementation;
import main.hu.mrbarneyy.mythickoth.scoreboard.ScoreBoardManager;
import main.hu.mrbarneyy.mythickoth.storage.StorageManager;
import main.hu.mrbarneyy.mythickoth.mcore.logger.Logger;
import main.hu.mrbarneyy.mythickoth.mcore.utils.plugins.Plugins;

/**
 * System to create your plugins very simply Projet:
 * <a href="https://github.com/Maxlego08/TemplatePlugin">https://github.com/Maxlego08/TemplatePlugin</a>
 *
 * @author Maxlego08
 */
public class KothPlugin extends main.hu.mrbarneyy.mythickoth.mcore.MPlugin {

    private final ScoreBoardManager scoreBoardManager = new ScoreBoardManager(this);
    private KothManager kothManager;
    private StorageManager storageManager;
    private KothScoreboard kothScoreboard = new DefaultHook();
    private KothHologram kothHologram = new EmptyHologram();

    @Override
    public void onEnable() {

        LocalPlaceholder placeholder = LocalPlaceholder.getInstance();
        placeholder.setPrefix("mythickoth");

        this.preEnable();

        this.saveResource("koth-example.yml", true);

        this.storageManager = new StorageManager(this);
        this.kothManager = new KothManager(this);

        this.registerCommand("mythickoth", new CommandKoth(this), "koth");

        this.saveDefaultConfig();
        // this.addSave(Config.getInstance());
        this.addSave(new MessageLoader(this));
        this.addSave(this.kothManager);

        this.addListener(new KothListener(this, this.kothManager));

        Config.getInstance().load(this);
        this.loadFiles();

        for (ScoreboardPlugin value : ScoreboardPlugin.values()) {
            if (value.isEnable()) {
                kothScoreboard = value.init(this);
                Logger.info("Register " + value.getPluginName() + " scoreboard implementation.", Logger.LogType.INFO);
                break;
            }
        }
        this.scoreBoardManager.setScoreboard(this.kothScoreboard);

        if (this.isEnable(Plugins.ZSCHEDULERS)) {
            Logger.info("Register MythicScheduler implementation", Logger.LogType.INFO);
            ZkothImplementation implementation = new ZkothImplementation(this);
            implementation.register();
        }

        if (this.isEnable(Plugins.DH)) {
            Logger.info("Register DecentHologram implementation", Logger.LogType.INFO);
            this.kothHologram = new DecentHologram();
        }

        KothPlaceholder kothPlaceholder = new KothPlaceholder(this.kothManager);
        kothPlaceholder.register();

        this.postEnable();
    }

    @Override
    public void onDisable() {

        this.preDisable();

        this.kothHologram.onDisable();
        this.scoreBoardManager.setRunning(false);
        this.saveFiles();

        this.postDisable();
    }

    public KothManager getKothManager() {
        return this.kothManager;
    }

    public KothScoreboard getKothScoreboard() {
        return this.kothScoreboard;
    }

    public StorageManager getStorageManager() {
        return this.storageManager;
    }

    public ScoreBoardManager getScoreBoardManager() {
        return scoreBoardManager;
    }

    public KothHologram getKothHologram() {
        return kothHologram;
    }
}
