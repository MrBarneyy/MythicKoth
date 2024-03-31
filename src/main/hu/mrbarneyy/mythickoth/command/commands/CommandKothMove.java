package main.hu.mrbarneyy.mythickoth.command.commands;

import main.hu.mrbarneyy.mythickoth.KothPlugin;
import main.hu.mrbarneyy.mythickoth.Selection;
import main.hu.mrbarneyy.mythickoth.command.VCommand;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Message;
import main.hu.mrbarneyy.mythickoth.mcore.enums.Permission;
import main.hu.mrbarneyy.mythickoth.mcore.utils.commands.CommandType;
import org.bukkit.Location;

import java.util.Optional;

public class CommandKothMove extends VCommand {

	public CommandKothMove(KothPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.MYTHICKOTH_MOVE);
		this.addSubCommand("move");
		this.setDescription(Message.DESCRIPTION_MOVE);
		this.addRequireArg("name", (a,b) -> plugin.getKothManager().getNameKoths());
	}

	@Override
	protected CommandType perform(KothPlugin plugin) {

		String name = argAsString(0);

		Optional<Selection> optional = this.manager.getSelection(this.player.getUniqueId());

		if (!optional.isPresent()) {
			message(this.sender, Message.CREATE_ERROR_SELECTION);
			return CommandType.DEFAULT;
		}

		Selection selection = optional.get();

		if (!selection.isValid()) {
			message(this.sender, Message.CREATE_ERROR_SELECTION);
			return CommandType.DEFAULT;
		}

		if (!selection.isCorrect()) {
			message(this.sender, Message.CREATE_ERROR_SIZE);
			return CommandType.DEFAULT;
		}

		Location minLocation = selection.getRightLocation();
		Location maxLocation = selection.getLeftLocation();
		this.manager.moveKoth(this.player, maxLocation, minLocation, name);
		
		return CommandType.SUCCESS;
	}

}
