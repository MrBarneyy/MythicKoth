package main.hu.mrbarneyy.mythickoth.api.events;

import main.hu.mrbarneyy.mythickoth.api.Koth;
import org.bukkit.entity.Player;


public class KothWinEvent extends CancelledKothEvent {

	private final Koth koth;
	private final Player player;

	public KothWinEvent(Koth koth, Player player) {
		super();
		this.koth = koth;
		this.player = player;
	}

	/**
	 * @return the koth
	 */
	public Koth getKoth() {
		return koth;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

}
