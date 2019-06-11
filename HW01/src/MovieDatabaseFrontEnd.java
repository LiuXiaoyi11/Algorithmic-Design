import java.util.Scanner;

public class MovieDatabaseFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome database administrator!");
		
		MovieDatabase db = new MovieDatabase();
		
		Scanner keyboard = new Scanner(System.in);
		int option;
		while(true) {
			System.out.println("\nWhat do you want to do? Pick one option please.");
			String options = "Enter 1: To Add a Movie\n"
							+ "Enter 2: To Remove a Movie by its Title\n"
							+ "Enter 3: To search for a Title\n"
							+ "Enter 4: To search for moves by a Director\n"
							+ "Enter 5: To search for movies of a given Year\n"
							+ "Enter 6: To search for movies of a certain Rating\n"
							+ "Enter 7: To print out all movies\n"
							+ "Enter 8: To print to a database file\n"
							+ "Enter 9: To load a database file\n"
							+ "Enter 0: To quit\n";
			System.out.println(options);
			

			option = Integer.parseInt(keyboard.nextLine());
			if (option == 0) {
				System.out.println("Goodbye, Administrator!");
				break;
			}
			switch(option) {
				case 1:
					System.out.println("\nPlease enter the information of the movie.");
					System.out.println("Name:");
					String name = keyboard.nextLine();
					System.out.println("Year:");
					int year = Integer.parseInt(keyboard.nextLine());
					System.out.println("Rating:");
					int rating = Integer.parseInt(keyboard.nextLine());
					System.out.println("Director:");
					String director = keyboard.nextLine();
					System.out.println("Box Office Gross:");
					double boxOfficeGross = Double.parseDouble(keyboard.nextLine());
					
					db.addMovie(new Movie(name, year, rating, director, boxOfficeGross));
					System.out.println("The database after adding the new movie:");
					db.print();
					break;
				case 2:
					System.out.println("\nPlease enter the title of the movive that you wnat to remove.");
					String title = keyboard.nextLine();
					db.removeBytitle(title);
					System.out.println("The database after removing the movie, "+ title + ":");
					db.print();
					break;
				case 3:
					System.out.println("\nPlease enter a movie's title for searching");
					String titleToSearch = keyboard.nextLine();
					GenLinkedList<Movie> titleSearchResult = db.searchByTitle(titleToSearch);
					System.out.println("Search Result:");
					titleSearchResult.print();
					break;
				case 4:
					System.out.println("\nPlease enter a movie's director for searching");
					String directorToSearch = keyboard.nextLine();
					GenLinkedList<Movie> directorSearchResult = db.searchByDirector(directorToSearch);
					System.out.println("Search Result:");
					directorSearchResult.print();
					break;
				case 5:
					System.out.println("\nPlease enter a movie's year for searching");
					int yearToSearch = Integer.parseInt(keyboard.nextLine());
					GenLinkedList<Movie> yearSearchResult = db.searchByYear(yearToSearch);
					System.out.println("Search Result:");
					yearSearchResult.print();					
					break;
				case 6:
					System.out.println("\nPlease enter a movie's rating for searching");
					int ratingToSearch = Integer.parseInt(keyboard.nextLine());
					GenLinkedList<Movie> ratingSearchResult = db.searchByRating(ratingToSearch);
					System.out.println("Search Result:");
					ratingSearchResult.print();
					break;	
				case 7:
					System.out.println("\nAll movies in the database are listed below.");
					db.print();
					break;
				case 8:
					System.out.println("\nPlease enter the filepath for dumping the database.");
					String filepathToDump = keyboard.nextLine();
					db.printToFile(filepathToDump);
					break;
				case 9:
					System.out.println("\nPlease enter the filepath of the loading database.");
					String filepathToLoad = keyboard.nextLine();
					db.readFromFile(filepathToLoad);
					break;
				default:
					System.out.println("[Bad Option] You picked the non-existing option.");
					break;
			}
		}
		keyboard.close();
	}

}



public class PlayListPartI {
    
    public static String songTitle;
    private int countSongs = 0;
    private final int MAX_SONGS = 10;
    private Song[] playList;
    private static String playListReport;
    public PlayListPartI() {
        playList = new Song[MAX_SONGS];
    }
    public String addSong() {
        for (int countSongs = 0; countSongs < MAX_SONGS; countSongs++) { //this i pretty much understand
            songTitle = JOptionPane.showInputDialog("Please enter the name of a song."); //i'm trying to use this to create the titles
            playList[countSongs] = new Song(songTitle); //this instantiates the array object(???). do i need to use MAX_SONGS instead of countSongs?
        }















