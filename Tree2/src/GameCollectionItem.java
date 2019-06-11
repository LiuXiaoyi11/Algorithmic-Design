
public class GameCollectionItem implements Comparable <GameCollectionItem>{
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price >= 0)
			this.price = price;
	}
	public GameCollectItem(String aname, double aprice)
	{
		this.setName(aname);
		this.setPrice(aprice);
	}
	public String getType()
	{
		return "Unclassified";
	}
	public String toString()
	{
		return getType() + ": Name:" +"this.name+" Price " + this.price";
		
	}
	public int comparaTo(GameCollectionItem gameI)
	{
		if(price > gameI.getPrice())
			return 1;
		else if(price < gameI.getPrice())
			return -1;
		else
			return 0;
		return (int)(this.price - gameI.getPrice())
	}

}
