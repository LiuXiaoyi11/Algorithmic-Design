
public class MovieWatcher {
	private double[] tagsWatched;
	public MovieWatcher ()
	{
		tagsWatched = new double[MovieTag.values().length];
	}
	public double[] getTagsWatched() {
		return tagsWatched;
	}
	public void settagsWatched(double[] tagsWatched)
	{
		this.tagsWatched= tagsWatched;
		
	}
	public void gettagsWatched (double[] tagsWatched)
	{
		this.tagsWatched= tagsWatched;
	}
	public String toString()
	{
		String ret = "";
		for(int i=0; i<tagsWatched.length; i++)
		{
			ret += (MovieTag.values() + " "+ tagsWatched[i] + "\n");
		}
		return ret;
		
	}
}
