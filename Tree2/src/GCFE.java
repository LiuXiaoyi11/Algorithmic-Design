import java.util.*;
public class GCFE {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args)
	{
		GCManager gM = new GCManager();
		int choice = 0;
		while(true)
		{
			printOps();
			choice = keyboard,next.Int();
			keyboard.nextLine();
			swich(choice)
			{
				case1:
					gM.addItem(createItem);
			break;
			case 2:
				
			break;
			case 9:
				System.exit(0);
			}
			gM.print();
		}
	}
	public static void printOps()
	{
		System.out.println("Enter 1: to add an item\n"
				+"Enter 2: to add a game\n")
	}
	public static GameCollectionItem createItem()
	{
		System.out.prinln("Entern name then price");
		String name = keyboard.nextLine();
		double price = keyboard.nextDouble();
		keyboard.hasNextLine();
		
		
	}
}
