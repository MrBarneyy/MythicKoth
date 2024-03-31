package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.save.Config;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKothNow extends VCommand {

	public CommandKothNow(KothPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.MYTHICKOTH_NOW);
		this.addSubCommand("now");
		this.setDescription(Message.DESCRIPTION_NOW);
		this.addRequireArg("name", (a,b) -> plugin.getKothManager().getNameKoths());
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		String name = argAsString(0);
		this.manager.spawnKoth(sender, name, true);
		
		return CommandType.SUCCESS;
	}

}
