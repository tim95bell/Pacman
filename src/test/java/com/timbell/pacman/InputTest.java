package com.timbell.pacman;

import junit.framework.TestCase;

public class InputTest extends TestCase {
	private Input input;
	
	@Override
	public void setUp(){
		this.input = new Input();
	}
	
	// PLACE
	public void testInterpretCommandValidPlace()
    {
        Command command = input.interpretCommand("place 3,2,north");
		assertTrue(command instanceof PlaceCommand);
		PlaceCommand placeCommand = (PlaceCommand)command;
		assertEquals(3, placeCommand.getX());
		assertEquals(2, placeCommand.getY());
		assertEquals(Direction.NORTH, placeCommand.getDirection());
    }
	
	public void testInterpretCommandValidPlaceWithSpaces()
    {
        Command command = input.interpretCommand(" place 3, 2, south ");
		assertTrue(command instanceof PlaceCommand);
		PlaceCommand placeCommand = (PlaceCommand)command;
		assertEquals(3, placeCommand.getX());
		assertEquals(2, placeCommand.getY());
		assertEquals(Direction.SOUTH, placeCommand.getDirection());
    }
	
	public void testInterpretCommandValidPlaceWithCaps()
    {
        Command command = input.interpretCommand("PLACE 3,2,WEST");
		assertTrue(command instanceof PlaceCommand);
		PlaceCommand placeCommand = (PlaceCommand)command;
		assertEquals(3, placeCommand.getX());
		assertEquals(2, placeCommand.getY());
		assertEquals(Direction.WEST, placeCommand.getDirection());
    }
	
	public void testInvalidPlaceCommandShort(){
		 Command command = input.interpretCommand("place 3,2");
		assertFalse(command instanceof PlaceCommand);
		assertEquals(Command.Type.INVALID, command.getType());
	}
	
	// PLACE, MOVE, LEFT, RIGHT, REPORT, EXIT, INVALID
	// MOVE
	public void testValidMove(){
		Command command = input.interpretCommand("move");
		assertEquals(Command.Type.MOVE, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
	public void testValidMoveSpaces(){
		Command command = input.interpretCommand("  move ");
		assertEquals(Command.Type.MOVE, command.getType());
	}
	
	public void testValidMoveCaps(){
		Command command = input.interpretCommand("MOVE");
		assertEquals(Command.Type.MOVE, command.getType());
	}
	
	// LEFT
	public void testValidLeft(){
		Command command = input.interpretCommand("left");
		assertEquals(Command.Type.LEFT, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
	public void testValidLeftSpaces(){
		Command command = input.interpretCommand("  left ");
		assertEquals(Command.Type.LEFT, command.getType());
	}
	
	public void testValidLeftCaps(){
		Command command = input.interpretCommand("LEFT");
		assertEquals(Command.Type.LEFT, command.getType());
	}
	
	// RIGHT
	public void testValidRight(){
		Command command = input.interpretCommand("right");
		assertEquals(Command.Type.RIGHT, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
	public void testValidRightSpaces(){
		Command command = input.interpretCommand("  right ");
		assertEquals(Command.Type.RIGHT, command.getType());
	}
	
	public void testValidRightCaps(){
		Command command = input.interpretCommand("RIGHT");
		assertEquals(Command.Type.RIGHT, command.getType());
	}
	
	// REPORT
	public void testValidReport(){
		Command command = input.interpretCommand("report");
		assertEquals(Command.Type.REPORT, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
	public void testValidReportSpaces(){
		Command command = input.interpretCommand("  report ");
		assertEquals(Command.Type.REPORT, command.getType());
	}
	
	public void testValidReportCaps(){
		Command command = input.interpretCommand("REPORT");
		assertEquals(Command.Type.REPORT, command.getType());
	}
	
	// EXIT
	public void testValidExit(){
		Command command = input.interpretCommand("exit");
		assertEquals(Command.Type.EXIT, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
	public void testValidExitSpaces(){
		Command command = input.interpretCommand("  exit ");
		assertEquals(Command.Type.EXIT, command.getType());
	}
	
	public void testValidExitCaps(){
		Command command = input.interpretCommand("EXIT");
		assertEquals(Command.Type.EXIT, command.getType());
	}
	
	// INVALID
	public void testInvalid(){
		Command command = input.interpretCommand("dfdsf");
		assertEquals(Command.Type.INVALID, command.getType());
		assertFalse(command instanceof PlaceCommand);
	}
	
}