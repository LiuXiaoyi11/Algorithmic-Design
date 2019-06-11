/*
 * 	Written by Xiaoyi Liu 22/02/2019
 */
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class RobotCommandSimulator {

	public static char[][] loadBoard(String boardFilePath) throws FileNotFoundException {
		char[][] board = new char[10][10];
		
	    // pass the path to the file as a parameter 
	    File file = new File(boardFilePath); 
	    Scanner sc = new Scanner(file); 
	  
	    int rowIndex = 0;
	    while (sc.hasNextLine() && rowIndex < 10) {
	      String line = sc.nextLine();
	      for(int index = 0; index<10; index++) {
	    	  board[rowIndex][index] = line.charAt(index);
	      }
	      rowIndex++;
	    }
	    sc.close();
		return board;
	}
	
	public static void displayBoard(char[][] board, int rows, int columns) {
		for(int i = 0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				// print out each element at the current row indicated by the value of i
				System.out.print(board[i][j]);
			}
			// print out a newline symbol
			System.out.println("");
		}
	}
	
	public static LinkedListQueue<String> loadCommands(String boardFilePath) throws FileNotFoundException {
		LinkedListQueue<String> q = new LinkedListQueue<>(); 
		
	    // pass the path to the file as a parameter 
	    File file = new File(boardFilePath); 
	    Scanner sc = new Scanner(file); 
	  
	    while (sc.hasNextLine()) {
	      String command = sc.nextLine();
	      q.enqueue(command);
	    }
	    sc.close();
		return q;
	}
	
	public static void simulation(char[][] board, LinkedListQueue<String> commandQueue) {
		System.out.println("Simulation begins");
		
		int commandNumber = 0;
		int robotX = 0, robotY=0;
		int rows = board.length, columns = board[0].length;
		while(!commandQueue.isEmpty()) {
			System.out.println("Command " + Integer.toString(commandNumber));
			int oldX = robotX, oldY = robotY;
			
			// dequeue the head and store it into "command"
			String command = commandQueue.deque();
			if (command.equals("Move Right")) {
				robotY += 1;
			} else 	if (command.equals("Move Left")) {
				robotY -= 1;
			} else 	if (command.equals("Move Up")) {
				robotX -= 1;
			} else 	if (command.equals("Move Down")) {
				robotX += 1;
			}
			
			// Check if robotX and robotY exceed the bounds
			if ((robotX < columns && robotX >= 0) && (robotY < rows && robotY >= 0)) {
				if (board[robotX][robotY] == 'X') {
					// System.out.println(debugMsg);
					System.out.println("CRASH-X!");
					break;
				} else {
					// Move the robot and update the board
					board[oldX][oldY] = '_';
					board[robotX][robotY] = 'O';
					
					// Display the board
					displayBoard(board, rows, columns);
					System.out.println("");
				}
			} else {
				// System.out.println(debugMsg);
				System.out.println("CRASH-Out of bound!");
				break;
			}
			
			commandNumber++;
		}
		
		System.out.println("Simulation ends");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		boolean quitSimulation = true;
		do {
			System.out.println("Welcome to the Robot Simulator");
			
			// Obtain file paths for board and commands
			System.out.println("Enter file for the Board");
			String boardFilePath = keyboard.nextLine();

			System.out.println("Enter file for the Robot Commands");
			String CommandsFilePath = keyboard.nextLine();
			
			// Run simulation
			char[][] board = new char[10][10];
			try {
				board = loadBoard(boardFilePath);
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
			
			
			LinkedListQueue<String> commandQueue = new LinkedListQueue<>();
			try {
				commandQueue = loadCommands(CommandsFilePath);
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}			
			
			// Display the board
			displayBoard(board, 10, 10);
			System.out.println("");
			
			// Navigate the robot
			simulation(board, commandQueue);
			
			// Current simulation ends. Ask the user if she wants another simulation
			System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
			String decision = keyboard.nextLine();
			if(decision.equalsIgnoreCase("true")) {
				quitSimulation = true;
			} else {
				quitSimulation = false;
			}
			
		} while (!quitSimulation);
				
		
		keyboard.close();
	}

}
