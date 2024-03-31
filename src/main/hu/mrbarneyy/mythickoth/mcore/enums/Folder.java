package main.hu.mrbarneyy.mythickoth.mcore.enums;

public enum Folder {

	UTILS,

	;
	

	public String toFolder(){
		return name().toLowerCase();
	}
	
}
