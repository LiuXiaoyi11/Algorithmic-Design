import java.util.Random;

public class TreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBSTree<Integer> intTree   = new LinkedBSTree<Integer>();
		LinkedBSTree<ThingyDingy> intTree = new LinkedBSTree<ThingyDingy>();
		Random r = new Random(100);
		for(int i=0; i<10;i++)
			
		{
			ThingyDingy a = new TD();
			
		}
			intTree.insert(r.nextInt(100));
		intTree.printPreOrder();
		intTree.printBreadthOrder();
		
	}

}
