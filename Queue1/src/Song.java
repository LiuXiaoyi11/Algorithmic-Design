
/*
 * Written by Xiaoyi Liu
 */
public class Song {
	private String name;
	private String artist;
	private int totalTime;
	private int currentTime;
	
	public Song() {
		this.name = "";
		this.artist = "";
		this.totalTime = 0;
		this.currentTime = 0;
	}
	
	public Song (String name, String artist, int totalTime) {
		this.name = name;
		this.artist = artist;
		this.totalTime = totalTime;
		this.currentTime = 0;
	}
	
	// Accessors
	public String getName() {
		return name;
	}
	public String getArtist() {
		return artist;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public int getCurrentTime() {
		return currentTime;
	}
	
	// Mutators
	public void setName(String newName) {
		name = newName;
	}
	public void setArtist(String newArtist) {
		artist = newArtist;
	}
	public void setTotalTime(int newTotalTime) {
		if (newTotalTime >= 0) {
			totalTime = newTotalTime;
		}
	}
	public void setCurrentTime(int newCurrentTime) {
		if (newCurrentTime>=0 && newCurrentTime <= totalTime) {
			currentTime = newCurrentTime;
		}
	}
	
	public String toString() {
		return "Name: " + name + " Artist: " + artist + " Length: " + Integer.toString(totalTime);
	}
	
	public int getTimeRemaining() {
		return (totalTime - currentTime);
	}
}




