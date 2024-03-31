package main.hu.mrbarneyy.mythickoth.mcore.enums;

public enum Permission {

	MYTHICKOTH_USE,
	MYTHICKOTH_RELOAD,
	MYTHICKOTH_NOW,
	MYTHICKOTH_AXE,
	MYTHICKOTH_LIST,
	MYTHICKOTH_CREATE, MYTHICKOTH_SPAWN, MYTHICKOTH_STOP, MYTHICKOTH_MOVE, MYTHICKOTH_DELETE, MYTHICKOTH_LOOT, MYTHICKOTH_COMMAND_ADD;

	private String permission;

	private Permission() {
		this.permission = this.name().toLowerCase().replace("_", ".");
	}

	public String getPermission() {
		return permission;
	}

}
