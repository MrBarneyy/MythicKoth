package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKoth extends VCommand {

    public CommandKoth(KothPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.MYTHICKOTH_USE);
        this.addSubCommand(new CommandKothReload(plugin));
        this.addSubCommand(new CommandKothAxe(plugin));
        this.addSubCommand(new CommandKothCreate(plugin));
        this.addSubCommand(new CommandKothNow(plugin));
        this.addSubCommand(new CommandKothSpawn(plugin));
        this.addSubCommand(new CommandKothStop(plugin));
        this.addSubCommand(new CommandKothMove(plugin));
        this.addSubCommand(new CommandKothVersion(plugin));
        this.addSubCommand(new CommandKothList(plugin));
        this.addSubCommand(new CommandKothDelete(plugin));
        this.addSubCommand(new CommandKothLoot(plugin));
        this.addSubCommand(new CommandKothAddCommand(plugin));
    }

    @Override
    protected CommandType perform(KothPlugin plugin) {
        syntaxMessage();
        return CommandType.SUCCESS;
    }

}
