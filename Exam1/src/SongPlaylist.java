/*
 * Written by Xiaoyi Liu 02/27/2019
 */
public class SongPlaylist {
	private Queue<Song> playlist;
	
	public SongPlaylist() {
		playlist = new Queue<Song>();
	}
	
	public void addSong(Song newSong) {
		playlist.enqueue(newSong);
	}
	
	public Song getCurrentSong() {
		return playlist.peek();
	}
	
	public void advanceOneSecond() {
		Song currentSong = getCurrentSong();
		String playingResult = "";
		playingResult += currentSong.toString();
		int currentTime = currentSong.getCurrentTime();
		playingResult += " Elapsed Time: " + Integer.toString(currentTime);
		System.out.println(playingResult);
		
		if (currentSong.getTimeRemaining() == 0) {
			// The last second of the current song has been played,
			// so, remove the current song
			playlist.deque();
		} else {
			// advance the current song for one second
			currentSong.setCurrentTime(currentTime+1);
		}
	}
	
	public boolean isEmpty() {
		return playlist.isEmpty();
	}
}
