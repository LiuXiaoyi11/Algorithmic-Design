import java.util.*;
public class LinkedBSTree <T extends Comparable <T>> {
	private class Node
	{
		private T data;
		private Node leftChild; // left is always less than
		private Node rightChild; // right is always greater than or =
		public Node (T adata)
		{
			data = adata;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public LinkedBSTree() {
		root = null;
	}
	public void insert (T adata)
	{
		if (root == null)
			root = new Node(adata);
		else 
			insert(adata);
	}
	public Node insert(Node anode, T adata)// recursive method
	{
		if (anode == null) {
			anode = new Node(adata);
		}
		else if(adata.compareTo(anode.data) <0)// Go left
			anode.leftChild = insert(anode.leftChild,adata);
		else if(adata.compareTo(anode.data)>=0)// go right
			anode.rightChild = insert(anode.rightChild,adata);
		return anode;
	}
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	private void printPreOrder(Node anode) 
	{
		if(anode == null)
			return;
		System.out.println(anode.data);
		if(anode.leftChild != null)
			printPreOrder(anode.leftChild);
		if(anode.rightChild !=null )
			printPreOrder(anode.rightChild);
	}
	
	public void printInOrder()
	{
		printInOrder();
	}
	private void printInOrder(Node anode)
	{
		if(anode == null)
			return;
		if(anode.leftChild != null)
			printInOrder(anode.leftChild);
		System.out.println(anode.data);
		if(anode.rightChild != null)
			printInOrder(anode.rightChild);
	}
	
	public boolean search (T adata)
	{
		return search (adata);
	}
	private boolean search (Node anode, T adata)
	{
		if (anode == null) // Reached a leaf before finding it
			return false;
		if(adata.compareTo(anode.data) == 0)// found it 
			return true;
		else if(adata.compareTo(anode.data)< 0) // go left
			return search(anode.leftChild,adata);
		else
			return search (anode.rightChild, adata);
	}
	
	public int getHeight()
	{
		return getHeight(root, 0);
	}
	private int getHeight(Node anode, int count) {
		if(anode == null)
			return count;
		count++;
		return Math.max(getHeight(anode.leftChild,count),
				        getHeight(anode.rightChild,count));
		
	}
	
	public void printBreadthOrder()
	{
		int nodeCount = 1;
		int maxNodeAtDepth =1;
		int maxNodes = (int)Math.pow(2.0, getHeight()); //2^height
		int totalNodeCount = 0;
		Queue<Node> nQ = new LinkedList<Node>();
		nQ.add(root);
		while(!nQ.isEmpty() && totalNodeCount < maxNodes)
		{
			//Dequeue
			Node anode = nQ.remove();
			if(anode != null)
			{
				System.out.println(anode.data +" ");
				nQ.add(anode.leftChild);
				nQ.add(anode.rightChild);
			}
			else // this is a lead so it's null
			{
				System.out.println("X ");
				nQ.add(null);
				nQ.add(null);
			}
			if(nodeCount >= maxNodeAtDepth)
			{
				System.out.println("|\n-------------" +
				          (int)(Math.log(maxNodeAtDepth) +
				        		  Math.log(2)));
				totalNodeCount += nodeCount;
				nodeCount = 1;
				maxNodeAtDepth *= 2;
			}
			else 
			{
				if(nodeCount != 1 && nodeCount %2 ==0)
					System.out.println("|");
				nodeCount++;
			}
			System.out.println();
		}
		public void delete(T adata)
		{
			root = delete (root, adata);
		}
		private Node delete(Node anode, T adata)
		{
			if(anode == null)
				return null;
			if(adata.compareTo(anode.data) < 0) {
				anode.leftChild = delete(anode.leftChild,adata);
			}
			else if (adata.compareTo(anode.data)>0)
			{
				anode.rightChild = delete(anode.rightChild,adata);
			}
			else {
				if(anode.rightChild == null)
				{
					return anode.leftChild;
				}
				if(anode.leftChild == null) {
					return anode.rightChild;
				}
				//TODO find min in tree
				Mode min = findMinInTree(anode.rightChild);
				anode.data = min.data;
				delete(anode.rightChild, min.data);
				
			}
			return anode;
		}
		private Nde findMinTree(Node anode) {
			if(anode == null)
				return null;
			if (anode.leftChild == null)
				return anode;
			else
			return finMinInTree(anode.leftChild)
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
