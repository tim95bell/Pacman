package com.timbell.pacman;

/**
 * Represents Pacman.
 */
public class Pacman{
	private int x, y;
	private Direction direction;
	
	private Pacman(int x, int y, Direction direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	/**
	 * Creates a new Pacman based on the given PlaceCommand.
	 * @param placeCommand the command for where to place pacman
	 * @return The pacman that was created, or null if the PlaceCommand was invalid.
	 */
	public static Pacman create(PlaceCommand placeCommand){
		int x = placeCommand.getX();
		int y = placeCommand.getY();
		if(x >= App.MIN_X && x <= App.MAX_X && y >= App.MIN_Y && y <= App.MAX_Y){
			return new Pacman(x, y, placeCommand.getDirection());
		} else{
			return null;
		}
	}
	
	/**
	 * Places Pacman based on the given PlaceCommand.
	 * @param placeCommand the command for where to place pacman
	 * @return True if the PlaceCommand was valid and pacman was placed, otherwise False.
	 */
	public boolean place(PlaceCommand placeCommand){
		int x = placeCommand.getX();
		int y = placeCommand.getY();
		if(x >= App.MIN_X && x <= App.MAX_X && y >= App.MIN_Y && y <= App.MAX_Y){
			this.x = x;
			this.y = y;
			this.direction = placeCommand.getDirection();
			return true;
		} else{
			return false;
		}
	}
	
	public void turnLeft(){
		this.direction = this.direction.turnLeft();
	}
	
	public void turnRight(){
		this.direction = this.direction.turnRight();
	}
	
	/**
	 * Moves pacman one unit in the direction that he is facing, if this is a valid movement.
	 * @return True if the movement was valid, otherwise False.
	 */
	public boolean move(){
		boolean valid = false;
		switch(direction){
			case NORTH:
			{
				if(this.y < App.MAX_Y){
					++this.y;
					valid = true;
				}
			} break;
			case EAST:
			{
				if(this.x < App.MAX_X){
					++this.x;
					valid = true;
				}
			} break;
			case SOUTH:
			{
				if(this.y > App.MIN_Y){
					--this.y;
					valid = true;
				}
			} break;
			case WEST:
			{
				if(this.x > App.MIN_X){
					--this.x;
					valid = true;
				}
			} break;
		}
		return valid;
	}
	
	public void report(){
		System.out.println( getReportString() );
	}
	
	public String getReportString(){
		return String.format("x:%d, y:%d, facing:%s", x, y, getDirectionString());
	}
	
	/**
	 * Takes a command and reacts to it accordingly.
	 * @param command the commmand.
	 * @return True if the command was valid, otherwise False.
	 */
	public boolean handle(Command command){
		boolean valid = false;
		if(command instanceof PlaceCommand){
			valid = place( (PlaceCommand)command);
		} else {
			switch(command.getType()){
				case MOVE:
				{
					valid = move();
				} break;
				case RIGHT:
				{
					turnRight();
					valid = true;
				} break;
				case LEFT:
				{
					turnLeft();
					valid = true;
				} break;
				case REPORT:
				{
					report();
					valid = true;
				} break;
				case INVALID:
				{
					valid = false;
				} break;
			}
		}
		return valid;
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
	
	public String getDirectionString(){
		String answer = null;
		switch(direction){
			case NORTH:
			{
				answer = "north";
			} break;
			case EAST:
			{
				answer = "east";
			} break;
			case SOUTH:
			{
				answer = "south";
			} break;
			case WEST:
			{
				answer = "west";
			} break;
		}
		return answer;
	}
}