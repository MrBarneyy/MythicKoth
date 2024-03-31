package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKothStop extends VCommand {

    public CommandKothStop(KothPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.MYTHICKOTH_STOP);
        this.addSubCommand("stop");
        this.setDescription(Message.DESCRIPTION_SPAWN);
        this.addRequireArg("name", (a, b) -> plugin.getKothManager().getActiveNameKoths());
    }

    @Override
    protected CommandType perform(KothPlugin plugin) {

        String name = argAsString(0);
        this.manager.stopKoth(sender, name);

        return CommandType.SUCCESS;
    }

}
