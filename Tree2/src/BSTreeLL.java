
public class BSTreeLL <T extends Comparable<T>>{
	private class Node
	{
		private T data;
		private Node leftChild;
		private Node rightChild;
		public Node(T adata)
		{
			data = adata;
			leftChild = rightChild = null;

		}
	}
	private Node root;
	public BSTreeLL()
	{
		root =null;
	}
	public void insert (T adata)
	{
		if(root ==null)
			root = new Node(adata);
		else
			insert (root,adata);
	}
	private Node insert(Node anode, T adata)
	{
		if(anode ==null)
			anode = new Node(adata);
		else if (adata.compareTo(anode.data) < 0)
			anode.leftChild = insert(anode.leftChild,adata);
		else// GO RIGHT
			anode.rightChild = insert (anode.rightChild,adata);
		return anode;
	}
	public void delete(T adata)
	{
		root = delete(root,adata);
	}
	private Node delete(Node anode, T adata) {
		// Find the value
		if(anode == null)
			return null;
		if(adata.compareTo(anode.data) < 0) // go to left
			anode.leftChild = delete(anode.leftChild,adata);
		else if(adata.compareTo(anode.data) >0)
		{
			anode.rightChild = delete(anode.rightChild,adata);
		}
		else
		{
			//Either no children or only left child
			if(anode.rightChild == null)
				return anode.leftChild;
			if(anode.leftChild == null)
				return anode.rightChild;
			//If we reach here it has two children
			Node temp = findMinInTree(anode.rightChild);
			anode.data  = temp.data;
			anode.rightChild = delete(anode.rightChild,temp.data);
		}
		return anode;
	}
	private Node findMinInTree(Node anode)
	{
		if (anode ==null)
			return null;
		if(anode.leftChild == null)
			return anode;
		else
			return findMinInTree(anode.leftChild);
	}
	public void printInorder()
	{
		printInOrder(root);
	}
	private void printInOrder(Node anode)
	{
		if(anode ==null)
			return;
		printInOrder(anode.leftChild);
		System.out.println(anode.data);
		printInOrder(anode.rightChild);
	}
}



























