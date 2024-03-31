package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

import java.util.Arrays;

public class CommandKothAddCommand extends VCommand {

    public CommandKothAddCommand(KothPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.MYTHICKOTH_COMMAND_ADD);
        this.addSubCommand("addcommand", "ac");
        this.setDescription(Message.DESCRIPTION_SPAWN);
        this.addRequireArg("name", (a, b) -> plugin.getKothManager().getNameKoths());
        this.addRequireArg("type", (a, b) -> Arrays.asList("start", "win"));
        this.addRequireArg("command");
        this.setExtendedArgs(true);
    }

    @Override
    protected CommandType perform(KothPlugin plugin) {

        if (this.args.length < 3) return CommandType.SYNTAX_ERROR;

        String name = argAsString(0);
        String type = argAsString(1);

        if (!type.equalsIgnoreCase("start") && !type.equalsIgnoreCase("win")) {
            return CommandType.SYNTAX_ERROR;
        }

        StringBuilder command = new StringBuilder();
        for (int index = 3; index != this.args.length; index++) {
            command.append(this.args[index]).append(" ");
        }

        this.manager.addCommand(sender, name, type, command);

        return CommandType.SUCCESS;
    }

}
