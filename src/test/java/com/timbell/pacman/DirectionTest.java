package com.timbell.pacman;

import junit.framework.TestCase;

public class DirectionTest extends TestCase {
	private Direction direction;
	
	@Override
	public void setUp(){
		this.direction = direction.NORTH;
	}
	
	public void testTurnRight(){
		assertEquals( direction.NORTH, this.direction );
		
		this.direction = this.direction.turnRight();
		assertEquals( direction.EAST, this.direction );
		
		this.direction = this.direction.turnRight();
		assertEquals( direction.SOUTH, this.direction );
		
		this.direction = this.direction.turnRight();
		assertEquals( direction.WEST, this.direction );
		
		this.direction = this.direction.turnRight();
		assertEquals( direction.NORTH, this.direction );
	}
	
	public void testTurnLeft(){
		assertEquals( direction.NORTH, this.direction );
		
		this.direction = this.direction.turnLeft();
		assertEquals( direction.WEST, this.direction );
		
		this.direction = this.direction.turnLeft();
		assertEquals( direction.SOUTH, this.direction );
		
		this.direction = this.direction.turnLeft();
		assertEquals( direction.EAST, this.direction );
		
		this.direction = this.direction.turnLeft();
		assertEquals( direction.NORTH, this.direction );
	}
	
	public void testTurnRightThenLeft(){
		assertEquals( direction.NORTH, this.direction );
		
		this.direction = this.direction.turnRight();
		this.direction = this.direction.turnLeft();
		
		assertEquals( direction.NORTH, this.direction );
	}
	
}