import java.util.*;
public class AdjMatrix {
	public static final int DEF_SIZE = 10;
	private double[][] adjMatrix;
	
	public AdjMatrix() {
		init (DEF_SIZE);
	}
	public AdjMatrix( int size) {
		init(size);
	}
	public void init(int size) {
		if(size <= 0)
			return;
		adjMatrix = new double[size][size];
	}
	public void addEdge(int tovert, int fromvert, double weight) {
		if(!isValid(tovert) || !isValid(fromvert)) 
			return;
		adjMatrix[tovert][fromvert] = weight;
	}
	private boolean isValid(int i) {
		return i>=0 && 1<adjMatrix.length;
	}
	private LinkedList<Integer> markedList = new LinkedList<Integer>();
	public void printDFS()
	{
		markedList.clear();
		printDFS(0);
		
	}
	private void printDFS(int index) {
		System.out.println(index);
		markedList.add(index);
		for(int i=0; i<adjMatrix.length;i++) {
			if(!markedList.contains(i) && adjMatrix[index][i] !=0)
				printDFS(i);
		}
		
	}
	Queue<Integer> vQ = new LinkedList<Integer>();
	public void printBFS()
	{
		markedList.clear();
		vQ.clear();
		markedList.add(0);
		vQ.add(0);
		System.out.println(0);
		while(!vQ.isEmpty())
		{
			int currI= vQ.remove();
			markedList.add(currI);
			for(int i = 0; i<adjMatrix.length; i++)
			{
				if(!markedList.contains(i) && !vQ.contains(i) && adjMatrix[currI][i] !=0)
				{
					System.out.println(i);
					vQ.add(i);
				}
			}	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
