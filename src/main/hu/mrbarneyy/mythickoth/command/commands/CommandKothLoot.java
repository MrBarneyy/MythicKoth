package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

import java.util.Arrays;

public class CommandKothLoot extends VCommand {

    public CommandKothLoot(KothPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.MYTHICKOTH_LOOT);
        this.addSubCommand("loot");
        this.setDescription(Message.DESCRIPTION_SPAWN);
        this.addRequireArg("name", (a, b) -> plugin.getKothManager().getNameKoths());
        this.addOptionalArg("page", (a, b) -> Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    @Override
    protected CommandType perform(KothPlugin plugin) {

        String name = argAsString(0);
        int page = argAsInteger(1, 1);
        if (page < 1) return CommandType.SYNTAX_ERROR;
        this.manager.updateLoots(this.player, name, page);

        return CommandType.SUCCESS;
    }

}
