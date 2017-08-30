package com.timbell.pacman;

public class Command{
	public enum Type{
		PLACE, MOVE, LEFT, RIGHT, REPORT, EXIT, INVALID
	}
	
	private Type type;
	
	public Command(Type type){
		this.type = type;
	}
	
	public Type getType(){
		return type;
	}
}