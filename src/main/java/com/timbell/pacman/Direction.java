package com.timbell.pacman;

/**
 * Represents a direction.
 */
public enum Direction{
	NORTH, EAST, SOUTH, WEST;
	
	/**
	* Turns 90 degrees left.
	* @return a new direction that is 90 degrees left from the current direction.
	*/
	public Direction turnLeft(){
		int index = ordinal()-1;
		if(index < 0){
			index = 3;
		}
		return values()[index];
	}
	
	/**
	* Turns 90 degrees right.
	* @return a new direction that is 90 degrees right from the current direction.
	*/
	public Direction turnRight(){
		int index = ordinal()+1;
		if(index > 3){
			index = 0;
		}
		return values()[index];
	}
}