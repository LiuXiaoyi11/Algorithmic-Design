import java.util.Scanner;
import java.util.*;
public class RPCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String iput = keyboard.nextLine();
		LLStack<Integer> iStack = new LLStack <Integer>();
		Scanner strScanner = new Scanner(input);
		while(strScanner.hasNext())
		{
			String symbol = strScanner.next();
			if(symbol.equals("+"))
			{
				if(iStack.size() <=0)
				{
					System.out.println("This is ill format");
					break;
				}
				int n2 = iStack.pop();
				int n1 = iStack.pop();
				iStack.push(n1+n2);
		    }
			// .. the other stuff
			else
			{
				try
				{
					iStack.push(Integer.parseInt(symbol));
				}
				catch(Exception e)
				{
					System.out.println("Not recognized symbol");
				}
			}
		}
		if(iStack.size() == 1)
		{
			System.out.println(iStack.pop());
		}
		else {
			System.out.println("Ill formatted expression");
		}

	}

}
