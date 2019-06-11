/*
 * Written by Xiaoyi Liu 02/27/2019
 */
import java.util.Scanner;

public class SongPlaylistFrontEnd {

	public static void main(String[] args) {
		System.out.println("Welcome to the Song Playlist!");
		boolean isQuit = false;
		
		Scanner keyboard = new Scanner(System.in);
		SongPlaylist playlist = new SongPlaylist();
		while(!isQuit) {
			System.out.println("Enter 1: to Add a Song");
			System.out.println("Enter 2: to Start the Playlist");
			System.out.println("Enter 9: to Quit");
			int userChoice = 0;
			userChoice = keyboard.nextInt();
			keyboard.nextLine(); // remove the newline character
			if (userChoice == 1) {
				System.out.println("Enter the name, the artist, and the total time (seconds)");
				String name = keyboard.nextLine();
				String artist = keyboard.nextLine();
				int totalTime = keyboard.nextInt();
				keyboard.nextLine();
				Song newSong = new Song(name, artist, totalTime);
				playlist.addSong(newSong);				
			} else if (userChoice == 2) {
				System.out.println("Starting the Playlist");
				while (!playlist.isEmpty()) {
					playlist.advanceOneSecond();
				}
				System.out.println("");
			} else if (userChoice == 9) {
				isQuit = true;
			} else {
				System.out.println("[Error] you enter the wrong option! Try again.");
			}
		}
		System.out.println("Goodbye");
		keyboard.close();

	}

}