package main.hu.mrbarneyy.mythickoth.api.events;

import main.hu.mrbarneyy.mythickoth.api.Koth;

public class KothSpawnEvent extends CancelledKothEvent {

	private final Koth koth;

	public KothSpawnEvent(Koth koth) {
		super();
		this.koth = koth;
	}

	/**
	 * @return the koth
	 */
	public Koth getKoth() {
		return koth;
	}

}
