
public class GCManager {
	private BSTreeLL <GameCollectionItem>gameItems;
	public GCManager()
	{
		gameItems = new BSTreeLL<GameCollectionItem>();
	}
	public void addItem(GameCollectionItem i)
	{
		gameItems.insert(i);
	}
	public void delteItem

}
