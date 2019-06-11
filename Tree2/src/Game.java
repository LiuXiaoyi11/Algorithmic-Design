
public class Game extends GameCollectionItem {
	private String dev,pub;

	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev = dev;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}
	public Game(String aName, double aPrice, String aDev, String aPub) {
		super(aName, aPrice);
		this.setDev(aDev);
		this.setPub(aPub);
	}
	public String getType()
	{
		return "Gmaes";
	}
	public String toString()
	{
		return super.toString() + "Dev: " + 
	}
}
