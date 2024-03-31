package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;
import org.bukkit.inventory.ItemStack;

public class CommandKothAxe extends VCommand {

	public CommandKothAxe(KothPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.MYTHICKOTH_AXE);
		this.addSubCommand("axe");
		this.setDescription(Message.DESCRIPTION_AXE);
		this.onlyPlayers();
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		ItemStack itemStack = this.manager.getKothAxe();
		this.player.getInventory().addItem(itemStack);
		message(this.sender, Message.AXE_RECEIVE);
		
		return CommandType.SUCCESS;
	}

}
