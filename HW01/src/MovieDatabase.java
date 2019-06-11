import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MovieDatabase {
	GenLinkedList<Movie> db;
	
	public MovieDatabase() {
		db=new GenLinkedList<Movie>();
	}
	public void addMovie(Movie movie) {
		db.addItem(movie);
	}
	
	// A movie's title is its name.
	// just remove the first found movie
	public void removeBytitle(String title) {
		if(db!=null) {
			// search for the movie in the database
			// if found, then remove it.
			// just remove the first found movie			
			GenLinkedList<Movie> resultList = searchByTitle(title);
			db.removeItem(resultList.getValueAtCurrent());
		}
	}
	
	// search by title
	public GenLinkedList<Movie> searchByTitle(String title){
		GenLinkedList<Movie> resultList = new GenLinkedList<Movie>();
		while(true) {
			Movie movie = db.getValueAtCurrent();
			if(movie==null) {//when current iterator moves to the location after the last node
				// reset current and previous iterators
				db.moveCurrentToHead();
				break;
			} else {
				if(movie.name.equals(title)) {
					resultList.addItem(movie);
				}
				// move current iterator one step forward 
				db.forward();
			}
		}
		return resultList;
	}
	
	// search by director
	public GenLinkedList<Movie> searchByDirector(String director){
		GenLinkedList<Movie> resultList = new GenLinkedList<Movie>();
		while(true) {
			Movie movie = db.getValueAtCurrent();
			if(movie==null) {//when current iterator moves to the location after the last node
				// reset current and previous iterators
				db.moveCurrentToHead();
				break;
			} else {
				if(movie.director.equals(director)) {
					resultList.addItem(movie);
				}
				// move current iterator one step forward 
				db.forward();
			}
		}
		return resultList;
	}
	
	// search by year
	public GenLinkedList<Movie> searchByYear(int year){
		GenLinkedList<Movie> resultList = new GenLinkedList<Movie>();
		while(true) {
			Movie movie = db.getValueAtCurrent();
			if(movie==null) {//when current iterator moves to the location after the last node
				// reset current and previous iterators
				db.moveCurrentToHead();
				break;
			} else {
				if(movie.year == year) {
					resultList.addItem(movie);
				}
				// move current iterator one step forward 
				db.forward();
			}
		}
		return resultList;
	}
	
	// search by rating
	public GenLinkedList<Movie> searchByRating(int rating){
		GenLinkedList<Movie> resultList = new GenLinkedList<Movie>();
		while(true) {
			Movie movie = db.getValueAtCurrent();
			if(movie==null) {//when current iterator moves to the location after the last node
				// reset current and previous iterators
				db.moveCurrentToHead();
				break;
			} else {
				if(movie.rating == rating) {
					resultList.addItem(movie);
				}
				// move current iterator one step forward 
				db.forward();
			}
		}
		return resultList;
	}
	
	public void print() {
		while(true) {
			Movie movie = db.getValueAtCurrent();
			if(movie!=null) {
				System.out.println(movie.toString());
				db.forward();
			} else {
				db.moveCurrentToHead();
				break;
			}
		}
	}
	
	public void printToFile(String filepath) {
		// the second argument of FileWriter constructor, true,
		// means that the file will be opened for appending content
		try (FileWriter fw = new FileWriter(filepath, true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw);) {
			while(true) {
				Movie movie = db.getValueAtCurrent();
				if(movie!=null) {
					out.println(movie.toString());
					db.forward();
				} else {
					db.moveCurrentToHead();
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	// Each line of a database file is a record for one movie.
	// Where the movie's all attributes are displayed with a tab as the separator
	public void readFromFile(String filepath) {
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath));){
			String line=reader.readLine();
			while(line!=null) {
				// parse a movie's attributes
				String[] attributes = line.split("\t");
				String name = attributes[0];
				int year = Integer.parseInt(attributes[1]);
				int rating = Integer.parseInt(attributes[2]);
				String director = attributes[3];
				double boxOfficeGross = Double.parseDouble(attributes[4]);
				
				// add to the database
				db.addItem(new Movie(name, year, rating, director, boxOfficeGross));
				
				//read the next line
				line=reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
