package com.timbell.pacman;

/**
 * Controls the application, manages the state and flow.
 */
public class App {
	public static final int MIN_X = 0;
	public static final int MAX_X = 4;
	public static final int MIN_Y = 0;
	public static final int MAX_Y = 4;
	private static final String PLACE_FORMAT = "PLACE x,y,f\nSuch that x = [0,4], y = [0,4], f = NORTH, SOUTH, EAST, or WEST";
	private static final String VALID_COMMANDS = "Commands: | PLACE x,y,f | MOVE | LEFT | RIGHT | REPORT | EXIT |";
	private boolean running;
	private Input input;
	private Pacman pacman;
	
	public App(){
		this.running = false;
		this.input = new Input();
		this.pacman = null;
	}
	
	public void run(){
		this.running = true;	
		System.out.println("\nWelcome to Pacman, place pacman somewhere within the 5x5 grid to begin.\n" + PLACE_FORMAT);
		
		// Get initial place command
		while(pacman == null && running){
			System.out.println();
			Command command = input.getNext();
			if(command instanceof PlaceCommand){
				pacman = Pacman.create( (PlaceCommand)command );
			} else if(command.getType() == Command.Type.EXIT){
				close();
			}
			
			if(pacman == null && running){
				System.out.println("INPUT INVALID: Ensure valid format.\n"+PLACE_FORMAT);
			}
		}
		
		// Report successful place command
		if(running){
			System.out.println("Pacman successfully placed");
			pacman.report();
		}
		
		// Take and execute commands
		while(running){
			System.out.println("\n"+VALID_COMMANDS);
			Command command = input.getNext();
			if(command.getType() == Command.Type.EXIT){
				close();
			} else {
				boolean valid = pacman.handle(command);
				if(valid){
					System.out.println("SUCCESSFUL");
				} else {
					System.out.println("INVALID COMMAND, Try Again");
				}
			}
		}
	}
	
	public void close(){
		System.out.println("\nGoodbye");
		this.running = false;
	}
}