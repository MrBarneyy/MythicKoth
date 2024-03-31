package main.hu.mrbarneyy.mythickoth.api.events;

import main.hu.mrbarneyy.mythickoth.api.Koth;
import org.bukkit.entity.Player;


public class KothLooseEvent extends CancelledKothEvent {

	private final Player player;
	private final Koth koth;

	/**
	 * @param player
	 * @param koth
	 */
	public KothLooseEvent(Player player, Koth koth) {
		super();
		this.player = player;
		this.koth = koth;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the koth
	 */
	public Koth getKoth() {
		return koth;
	}

}
