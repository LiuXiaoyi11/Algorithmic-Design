/*
 * Written By Xiaoyi Liu 04/18/2019
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class WordFinder {

	public static HashSet<String> dict = new HashSet<String>();
	public static int M = 5;
	
	public static void displayBoard(char[][] board, int m) {
		for(int i = 0; i < m; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	
	// A recursive function to print all words present on boggle 
	public static void findWordsUtil(char board[][], boolean visited[][], int i, 
	                   int j, String str) 
	{ 
	    // Mark current cell as visited and append current character to str 
	    visited[i][j] = true; 
	    str = str + board[i][j]; 
	  
	    // If the length of str is in [2,6] and str is present in dictionary, then print it 
	    if ((str.length()>=2 && str.length()<=6) && dict.contains(str)) {
	    	System.out.println("Found Word: "+str);
	    }

	    // if the length of current str is smaller than 6, expand str using DFS.
	    // otherwise, skip further search.
	    if (str.length() < 6) {
		    // Traverse 8 adjacent cells of board[i][j] 
		    for (int row=i-1; row<=i+1 && row<M; row++) 
		      for (int col=j-1; col<=j+1 && col<M; col++) 
		        if (row>=0 && col>=0 && !visited[row][col]) 
		          findWordsUtil(board,visited, row, col, str); 
	    }
	    
	    // Erase current character from string and mark visited 
	    // of current cell as false 
	    str=removeLastElem(str); 
	    visited[i][j] = false; 
	} 
	
	public static String removeLastElem(String str) {
	    if (str != null && str.length() > 0) {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	// Prints all words present in dictionary. 
	public static void findWords(char board[][]) 
	{ 
	    // Mark all characters as not visited 
	    boolean[][] visited = new boolean[M][M];
	    for(boolean[] row : visited) {
	    	Arrays.fill(row, false);
	    }

	    // Initialize current string 
	    String str = ""; 
	  
	    // Consider every character and look for all words starting with this character 
	    for (int i=0; i<M; i++) {
	       for (int j=0; j<M; j++) {
	    	   System.out.println("Starting " + Integer.toString(i) + " " + Integer.toString(j));
	             findWordsUtil(board, visited, i, j, str);
	       }
	    }
	} 	
	
	public static void main(String[] args) throws FileNotFoundException {

		// create the 5X5 board
		char[][] board = new char[M][M];
		char[] line1 = {'R', 'A', 'H', 'J', 'M'};
		char[] line2 = {'Y', 'U', 'W', 'W', 'K'};
		char[] line3 = {'R', 'X', 'N', 'F', 'M'};
		char[] line4 = {'Q', 'G', 'E', 'E', 'B'};
		char[] line5 = {'E', 'O', 'A', 'P', 'E'};
		board[0] = line1;
		board[1] = line2;
		board[2] = line3;
		board[3] = line4;
		board[4] = line5;
		displayBoard(board, M);
		
		// load the dictionary
	    Scanner file = new Scanner(new File("dict.txt"));
	    while (file.hasNext()) {
	    	WordFinder.dict.add(file.next().toUpperCase());
	    }
	    file.close();
        
        findWords(board);
		
		
	}

}
