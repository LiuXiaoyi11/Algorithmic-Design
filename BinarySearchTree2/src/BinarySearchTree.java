/*
 * Written by Xiaoyi Liu 03/29/2019
 */
public class BinarySearchTree
{
	private Node root;

	//Constructor
	public BinarySearchTree()
	{
		root = null;
		}
	// Method to check if the tree is empty 
	public boolean isEmpty()
	{
		return root == null;
		}
	//Method to insert the data 
	public void insert(double area,String shapeType,int side1,int side2,int radius)
	{
		root = insert(root, area,shapeType,side1,side2,radius);
		}
	// Method to insert the data recursively 
	private Node insert(Node node, double area,String shapeType,int side1,int side2,int radius)
	{
		if (node == null)
			node = new Node(area,shapeType,side1,side2,radius);
		else
		{
			if (area <= node.getArea())
				node.left = insert(node.left, area,shapeType,side1,side2,radius);
			else
				node.right = insert(node.right, area,shapeType,side1,side2,radius);
			}
		return node;
		}

	// Functions to delete node by area
	public void deleteByArea(double area) {
		root = deleteByAreaHelper(root, area);
	}
	public Node deleteByAreaHelper(Node root, double area) {
		
		if (root != null) {
			if (root.getArea() > area) {
				// delete root node and its right child,
				// and update root first, then apply the helper function on the left child 
				root = root.left;
				root = deleteByAreaHelper(root, area);
			} else if (root.getArea() == area) {
				// delete right child
				root.right = null;
			} else { // root.getArea() < area
				// apply the helper function on the right child,
				// then, update the right child of the root
				root.right = deleteByAreaHelper(root.right, area);
			}
		}
		return root;
	}
	
	public void delete(Node targetNode) {
	  Node toBeRemoved = root;
	  Node parent = null;
	  boolean found = false;
	  while (!found && toBeRemoved != null)
	  {
	  if (targetNode.isEqual(toBeRemoved)) {
		  found = true;
	  }
	  else
	  {
	  parent = toBeRemoved;
	  if (targetNode.getArea()<toBeRemoved.getArea())
	     toBeRemoved = toBeRemoved.left;
	  else
	     toBeRemoved = toBeRemoved.right;
	  }
	  }

	  if (!found) return;

	  // toBeRemoved contains obj

	  // If one of the children is empty, use the other

	  if (toBeRemoved.left == null || toBeRemoved.right == null)
	  {
		  Node newChild;
		  if (toBeRemoved.left == null)
			  newChild = toBeRemoved.right;
		  else
			  newChild = toBeRemoved.left;
	
		  if (parent == null) // Found in root
			  root = newChild;
		  else if (parent.left.isEqual(toBeRemoved))
			  parent.left = newChild;
		  else
			  parent.right = newChild;
		  return;
	  }
	    
	  // Neither subtree is empty

	  // Find smallest element of the right subtree

	  Node smallestParent = toBeRemoved;
	  Node smallest = toBeRemoved.right;
	  while (smallest.left != null)
	  {
		  smallestParent = smallest;
		  smallest = smallest.left;
	  }

	  // smallest contains smallest child in right subtree

	  // Move contents, unlink child

	  toBeRemoved.copyData(smallest);
	  if (smallestParent.isEqual(toBeRemoved))
		  smallestParent.right = smallest.right;
	  else
		  smallestParent.left = smallest.right;

	}
	
	//Find the max
	public double findMax()
	{
	  double maxval=0.0;
	  Node tempNode = root;
	  while (tempNode != null) {
		  if (tempNode.right == null) {
			  break;
		  } else {
			  tempNode = tempNode.right;
		  }
	  }
	  maxval = tempNode.getArea();
	  return maxval;
	}      
	   
	//Method for pre-order traversal 
	public void preorder()
	{
		preorder(root);
		}
	private void preorder(Node r)
	{
		if (r != null)
		{
			System.out.print(r.getShapeType()+" ");
			if(r.getShapeType().equals("Rectangle")||r.getShapeType().equals("Right Triangle")){
				System.out.print(" Side 1: "+(double)r.getSide1()+" Side 2: "+(double)r.getSide2()+" ");
				}
			if(r.getShapeType().equals("Circle")){
				System.out.print(" Radius: "+(double)r.getRadius()+" ");
				}
			System.out.print("Area: "+r.getArea() +"\n");
			preorder(r.getLeft());   
			preorder(r.getRight());
			}
		}
	
	//Method for inorder traversal 
	public void inorder()
	{
		inorder(root);
		}
	private void inorder(Node r)
	{
		if (r != null)
		{
			inorder(r.getLeft());
			System.out.print(r.getShapeType()+" ");
			if(r.getShapeType().equals("Rectangle")||r.getShapeType().equals("Right Triangle")){
				System.out.print(" Side 1: "+(double)r.getSide1()+" Side 2: "+(double)r.getSide2()+" ");
				}
			if(r.getShapeType().equals("Circle")){
				System.out.print(" Radius: "+(double)r.getRadius()+" ");
				}
			System.out.print("Area: "+r.getArea() +"\n");
			inorder(r.getRight());
			}
		}
	
	//Method for postorder traversal 
	public void postorder()
	{
		postorder(root);
	}
	private void postorder(Node r)
	{
		if (r != null)
		{
			postorder(r.getLeft());   
			postorder(r.getRight());
			System.out.print(r.getShapeType()+" ");
			if(r.getShapeType().equals("Rectangle")||r.getShapeType().equals("Right Triangle")){
				System.out.print(" Side 1: "+(double)r.getSide1()+" Side 2: "+(double)r.getSide2()+" ");
				}
			if(r.getShapeType().equals("Circle")){
				System.out.print(" Radius: "+(double)r.getRadius()+" ");
				}
			System.out.print("Area: "+r.getArea() +"\n");
			}
		} 
}