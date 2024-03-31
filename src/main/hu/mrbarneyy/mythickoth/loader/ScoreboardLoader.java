package main.hu.mrbarneyy.mythickoth.loader;

import main.hu.mrbarneyy.mythickoth.api.utils.ScoreboardConfiguration;
import main.hu.mrbarneyy.mythickoth.mcore.utils.loader.Loader;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class ScoreboardLoader implements Loader<ScoreboardConfiguration> {

    @Override
    public ScoreboardConfiguration load(YamlConfiguration configuration, String path, File file) {

        boolean isEnable = configuration.getBoolean(path + "enable", false);
        String title = configuration.getString(path + "title", "zKoth");
        List<String> lines = configuration.getStringList(path + "lines");

        return new ScoreboardConfiguration(isEnable, title, lines);
    }

    @Override
    public void save(ScoreboardConfiguration scoreboardConfiguration, YamlConfiguration configuration, String path) {

        configuration.set(path + "enable", scoreboardConfiguration.isEnable());
        configuration.set(path + "title", scoreboardConfiguration.getTitle());
        configuration.set(path + "lines", scoreboardConfiguration.getLines());

    }
}
