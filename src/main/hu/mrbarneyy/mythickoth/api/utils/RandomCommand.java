package main.hu.mrbarneyy.mythickoth.api.utils;

import java.util.List;

public class RandomCommand extends main.hu.mrbarneyy.mythickoth.mcore.utils.MUtils {

    private final int percent;
    private final List<String> commands;

    public RandomCommand(int percent, List<String> commands) {
        this.percent = percent;
        this.commands = commands;
    }

    public int getPercent() {
        return percent;
    }

    public List<String> getCommands() {
        return commands;
    }

    public boolean canUse() {
        return percent >= getNumberBetween(0, 100);
    }
}
