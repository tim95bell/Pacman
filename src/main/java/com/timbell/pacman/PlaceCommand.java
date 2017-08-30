package com.timbell.pacman;

public class PlaceCommand extends Command {
	private int x;
	private int y;
	private Direction direction;
	
	public PlaceCommand(int x, int y, Direction direction){
		super(Type.PLACE);
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Direction getDirection(){
		return direction;
	}
}