
public class CM extends Movie implements Comparable<CM>
{
	private double priority;
	public CM(Movie am, MovieWatcher aw)
	{
		super(am.getName(),am.getRating(),am.getTags());
		
	}
	private void cacluatePriority(MovieWatcher aw)
	{
		for(MovieTag tag : super.getTags())
		{
			priority += (aw.getCountFor(tag)* super.getRating());
		}
	}
	public double getPriority()
	{
		return this.priority;
	}
	public String toString()
	{
		return super.toString()+ " Priority: " + this.priority;
	}
	public int compareTo(CM m)
	{
		if(this.priority < m.getPriority)
			return -1;
		else if(this.priority > m.getPriority)
			return 1;
		else
			return 0;
	}
}
