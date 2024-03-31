package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKothSpawn extends VCommand {

	public CommandKothSpawn(KothPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.MYTHICKOTH_SPAWN);
		this.addSubCommand("spawn");
		this.setDescription(Message.DESCRIPTION_SPAWN);
		this.addRequireArg("name", (a,b) -> plugin.getKothManager().getNameKoths());
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		String name = argAsString(0);
		this.manager.spawnKoth(sender, name, false);
		
		return CommandType.SUCCESS;
	}

}
