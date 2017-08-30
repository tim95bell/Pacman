package com.timbell.pacman;

import java.util.Scanner;
import java.lang.NumberFormatException;

/**
* Handles getting and interpreting input from the user.
*/
public class Input{
	private Scanner in;
	
	public Input(){
		this.in = new Scanner(System.in);
	}
	
	/**
	* Gets the next command.
	* @return a Command object representing the next command.
	*/
	public Command getNext(){
		System.out.print("Next command: ");
		System.out.flush();
		String line = in.nextLine();
		
		return interpretCommand(line);
	}
	
	/**
	* Takes a line, and turns it into a Command object.
	* @return the relevant Command.
	*/
	public Command interpretCommand(String line){
		Command command = null;
		String[] lineSpaceSplit = line.trim().split(" ");
		if(lineSpaceSplit.length == 0){
			command = new Command(Command.Type.INVALID);
		}
		else if(lineSpaceSplit.length == 1){
			// MOVE, LEFT, RIGHT, REPORT, EXIT, or INVALID
			command = interpretOneArgumentCommand(lineSpaceSplit[0]);
		} else{
			// PLACE or INVALID
			command = interpretMultiArgumentCommand(lineSpaceSplit);
		}
		return command;
	}
	
	/**
	* Turns a one line argument into a Command.
	* @return the relevant Command.
	*/
	public Command interpretOneArgumentCommand(String commandString){
		Command command = null;
		switch(commandString.toLowerCase()){
			case "move":
			{
				command = new Command(Command.Type.MOVE);
			} break;
			case "left":
			{
				command = new Command(Command.Type.LEFT);
			} break;
			case "right":
			{
				command = new Command(Command.Type.RIGHT);
			} break;
			case "report":
			{
				command = new Command(Command.Type.REPORT);
			} break;
			case "exit":
			{
				command = new Command(Command.Type.EXIT);
			} break;
			default:
			{
				command = new Command(Command.Type.INVALID);
			} break;
		}
		return command;
	}
	
	/**
	* Turns a multi line argument into a Command.
	* @return the relevant Command.
	*/
	public Command interpretMultiArgumentCommand(String[] lineSpaceSplit){
		Command command = null;
		if(lineSpaceSplit[0].toLowerCase().equals("place")){
			// PLACE
			command = interpretPlaceCommand(lineSpaceSplit);
		} else{
			// INVALID
			command = new Command(Command.Type.INVALID);
		}
		return command;
	}
	
	/**
	* Turns a multi line argument that starts with "place" into a Command.
	* @return the relevant Command.
	*/
	public Command interpretPlaceCommand(String[] lineSpaceSplit){
		Command command = null;
		StringBuilder xyf = new StringBuilder();
		for(int i = 1; i < lineSpaceSplit.length; ++i){
			xyf.append(lineSpaceSplit[i]);
		}
		String[] xyfCommaSplit = xyf.toString().split(",");
		
		if(xyfCommaSplit.length == 3){
			// has 3 arguments
			int x;
			int y;
			try{
				x = Integer.parseInt(xyfCommaSplit[0]);
				y = Integer.parseInt(xyfCommaSplit[1]);
				String f = xyfCommaSplit[2];
				switch(f.toLowerCase()){
					case "north":
					{
						command = new PlaceCommand(x, y, Direction.NORTH);
					} break;
					case "east":
					{
						command = new PlaceCommand(x, y, Direction.EAST);
					} break;
					case "south":
					{
						command = new PlaceCommand(x, y, Direction.SOUTH);
					} break;
					case "west":
					{
						command = new PlaceCommand(x, y, Direction.WEST);
					} break;
					default:
					{
						command = new Command(Command.Type.INVALID);
					} break;
				}
			} catch(NumberFormatException e){
				// one of the numbers is an invalid format
				command = new Command(Command.Type.INVALID);
			}
		} else{
			// doesnt have 3 arguments
			command = new Command(Command.Type.INVALID);
		}
		return command;
	}
	
}