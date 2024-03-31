package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;

public class CommandKothVersion extends VCommand {

	public CommandKothVersion(KothPlugin plugin) {
		super(plugin);
		this.addSubCommand("version", "?", "v");
		this.setDescription(Message.DESCRIPTION_SPAWN);
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		message(this.sender, "§aPlugin verzió§7: §2" + plugin.getDescription().getVersion());
		message(this.sender, "§aAuthor§7: §2MrBarneyy");
		message(this.sender, "§aDiscord§7: §2https://dc.mythicisland.eu");
		message(this.sender, "§aWebsite §7: §2https://www.mythicisland.eu");

		return CommandType.SUCCESS;
	}

}
