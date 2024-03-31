package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.save.Config;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;
import org.bukkit.inventory.ItemStack;

public class CommandKothReload extends VCommand {

	public CommandKothReload(KothPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.MYTHICKOTH_RELOAD);
		this.addSubCommand("reload", "rl");
		this.setDescription(Message.DESCRIPTION_RELOAD);
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		plugin.reloadConfig();
		Config.getInstance().load(plugin);
		plugin.reloadFiles();
		message(sender, Message.RELOAD);
		
		return CommandType.SUCCESS;
	}

}
