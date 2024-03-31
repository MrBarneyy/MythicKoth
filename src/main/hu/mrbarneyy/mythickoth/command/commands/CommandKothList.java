package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKothList extends VCommand {

    public CommandKothList(KothPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.MYTHICKOTH_LIST);
        this.addSubCommand("list");
        this.setDescription(Message.DESCRIPTION_LIST);
    }

    @Override
    protected CommandType perform(KothPlugin plugin) {
        this.manager.sendKothList(this.sender);
        return CommandType.SUCCESS;
    }

}
