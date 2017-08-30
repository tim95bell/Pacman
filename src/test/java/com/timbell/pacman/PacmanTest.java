package com.timbell.pacman;

import junit.framework.TestCase;

public class PacmanTest extends TestCase {
	private Pacman pacman;
	
	@Override
	public void setUp(){
		PlaceCommand placeCommand = new PlaceCommand(0,0,Direction.NORTH);
		this.pacman = Pacman.create(placeCommand);
	}
	
	// ============================ create ============================ 
	public void testValidCreate()
    {
        PlaceCommand placeCommand = new PlaceCommand(2, 3, Direction.NORTH);
		Pacman createdPacman = Pacman.create(placeCommand);
		assertNotNull(createdPacman);
		assertEquals(2, createdPacman.getX());
		assertEquals(3, createdPacman.getY());
		assertEquals(Direction.NORTH, createdPacman.getDirection());
    }
	
	public void testValidCreateLowerBounds()
    {
        PlaceCommand placeCommand = new PlaceCommand(0, 0, Direction.NORTH);
		Pacman createdPacman = Pacman.create(placeCommand);
		assertNotNull(createdPacman);
		assertEquals(0, createdPacman.getX());
		assertEquals(0, createdPacman.getY());
		assertEquals(Direction.NORTH, createdPacman.getDirection());
    }
	
	public void testValidCreateUpperBounds()
    {
        PlaceCommand placeCommand = new PlaceCommand(4, 4, Direction.NORTH);
		Pacman createdPacman = Pacman.create(placeCommand);
		assertNotNull(createdPacman);
		assertEquals(4, createdPacman.getX());
		assertEquals(4, createdPacman.getY());
		assertEquals(Direction.NORTH, createdPacman.getDirection());
    }
	
	public void testInvalidCreateBelowLowerBounds(){
		PlaceCommand placeCommand = new PlaceCommand(-1, -1, Direction.NORTH);
		Pacman createdPacman = Pacman.create(placeCommand);
		assertNull(createdPacman);
	}
	
	public void testInvalidCreateAboveUpperBounds(){
		PlaceCommand placeCommand = new PlaceCommand(5, 5, Direction.NORTH);
		Pacman createdPacman = Pacman.create(placeCommand);
		assertNull(createdPacman);
	}
	
	// ============================ place ============================ 
	public void testValidPlace(){
		PlaceCommand placeCommand = new PlaceCommand(1, 4, Direction.SOUTH);
		pacman.place(placeCommand);
		assertEquals(1, this.pacman.getX());
		assertEquals(4, this.pacman.getY());
		assertEquals(Direction.SOUTH, this.pacman.getDirection());
	}
	
	public void testValidPlaceLowerBounds(){
		PlaceCommand placeCommand = new PlaceCommand(0, 0, Direction.SOUTH);
		pacman.place(placeCommand);
		assertEquals(0, this.pacman.getX());
		assertEquals(0, this.pacman.getY());
		assertEquals(Direction.SOUTH, this.pacman.getDirection());
	}
	
	public void testValidPlaceUpperBounds(){
		PlaceCommand placeCommand = new PlaceCommand(4, 4, Direction.SOUTH);
		pacman.place(placeCommand);
		assertEquals(4, this.pacman.getX());
		assertEquals(4, this.pacman.getY());
		assertEquals(Direction.SOUTH, this.pacman.getDirection());
	}
	
	public void testInvalidPlaceBelowLowerBounds(){
		PlaceCommand placeCommand = new PlaceCommand(-1, -1, Direction.SOUTH);
		pacman.place(placeCommand);
		assertEquals(0, this.pacman.getX());
		assertEquals(0, this.pacman.getY());
		assertEquals(Direction.NORTH, this.pacman.getDirection());
	}
	
	public void testInvalidPlaceAboveUpperBounds(){
		PlaceCommand placeCommand = new PlaceCommand(5, 5, Direction.SOUTH);
		pacman.place(placeCommand);
		assertEquals(0, this.pacman.getX());
		assertEquals(0, this.pacman.getY());
		assertEquals(Direction.NORTH, this.pacman.getDirection());
	}
	
	// ============================ turnRight ============================ 
	public void testTurnRight(){
		assertEquals(Direction.NORTH, this.pacman.getDirection());
		this.pacman.turnRight();
		assertEquals(Direction.EAST, this.pacman.getDirection());
	}
	
	// ============================ turnLeft ============================ 
	public void testTurnLeft(){
		assertEquals(Direction.NORTH, this.pacman.getDirection());
		this.pacman.turnLeft();
		assertEquals(Direction.WEST, this.pacman.getDirection());
	}
	
	// ============================ move ============================ 
	public void testValidMoveNorth(){
		this.pacman.place( new PlaceCommand(0, 0, Direction.NORTH) );
		boolean valid = this.pacman.move();
		assertTrue(valid);
		assertEquals(1, this.pacman.getY());
	}
	
	public void testValidMoveEast(){
		this.pacman.place( new PlaceCommand(0, 0, Direction.EAST) );
		boolean valid = this.pacman.move();
		assertTrue(valid);
		assertEquals(1, this.pacman.getX());
	}
	
	public void testValidMoveSouth(){
		this.pacman.place( new PlaceCommand(1, 1, Direction.SOUTH) );
		boolean valid = this.pacman.move();
		assertTrue(valid);
		assertEquals(0, this.pacman.getY());
	}
	
	public void testValidMoveWest(){
		this.pacman.place( new PlaceCommand(3, 3, Direction.WEST) );
		boolean valid = this.pacman.move();
		assertTrue(valid);
		assertEquals(2, this.pacman.getX());
	}
	
	public void testInvalidMoveNorth(){
		this.pacman.place( new PlaceCommand(0, 4, Direction.NORTH) );
		boolean valid = this.pacman.move();
		assertFalse(valid);
		assertEquals(4, this.pacman.getY());
	}
	
	public void testInvalidMoveEast(){
		this.pacman.place( new PlaceCommand(4, 0, Direction.EAST) );
		boolean valid = this.pacman.move();
		assertFalse(valid);
		assertEquals(4, this.pacman.getX());
	}
	
	public void testInvalidMoveSouth(){
		this.pacman.place( new PlaceCommand(1, 0, Direction.SOUTH) );
		boolean valid = this.pacman.move();
		assertFalse(valid);
		assertEquals(0, this.pacman.getY());
	}
	
	public void testInvalidMoveWest(){
		this.pacman.place( new PlaceCommand(0, 0, Direction.WEST) );
		boolean valid = this.pacman.move();
		assertFalse(valid);
		assertEquals(0, this.pacman.getX());
	}
	
	// ============================ getReportString ============================ 
	public void testGetReportString(){
		String reportString = this.pacman.getReportString();
		assertEquals("x:0, y:0, facing:north", this.pacman.getReportString());
	}
	
}