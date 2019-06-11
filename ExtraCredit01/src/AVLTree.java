/*
 * Written By Xiaoyi Liu 04/17/2019
 */
public class AVLTree<T extends Comparable<T>>
{

	private AVLNode<T> root;

	public AVLNode<T> getRoot() {
		return root;
	}
	
	public void addValue(T val)
	{
	  if(root == null)
	  {
	   root = new AVLNode<T>(val, null);
	  }
	  else
	  {
	   AVLNode<T> current = root;
	   AVLNode<T> parent;
	   while(true)
	   {
	    if(current.data == val)
	    {
	     System.out.println(val + " is already added to the tree.");
	     return;
	    }

	    parent = current;
	    boolean isLeft;
	    
	    if(current.data.compareTo(val)>0)
	     isLeft = true;
	    else
	     isLeft = false;
	    
	    if(isLeft)
	     current = current.left;
	    else
	     current = current.right;
	    
	    if(current == null)
	    {
	     if(isLeft)
	      parent.left = new AVLNode<T>(val, parent);
	     else
	      parent.right = new AVLNode<T>(val, parent);
	     
	     rebalance(parent);
	     break;
	    }
	   }
	  }
	}

	public void remove(T val)
	{
	  if(root == null)
	  {
	   System.out.println("Tree is empty.");
	   return;
	  }
	  
	  AVLNode<T> current = root;
	  AVLNode<T> parent = root;  
	  AVLNode<T> child = root;
	  AVLNode<T> nodeToRemove = null;

	  while(child != null)
	  {
	   parent = current;
	   current = child;
	   
	   if(val.compareTo(current.data) >= 0)
	    child = current.right;
	   else
	    child = current.left;
	      
	   if(val == current.data)
	    nodeToRemove = current;
	  }

	  if(nodeToRemove != null)
	  {
	   nodeToRemove.data = current.data;
	   
	   if(current.left != null)
	    child = current.left;
	   else
	    child = current.right;
	   
	   if(root.data == val)
	   {
	    root = child;
	   }
	   else
	   {
	    if(parent.left == current)
	     parent.left = child;
	    else
	     parent.right = child;
	    
	    rebalance(parent);
	   }
	  }
	  
	  if(nodeToRemove == null)
	   System.out.println(val + " is not found in the tree.");
//	  else
//	   System.out.println(nodeToRemove.data + " is removed from the tree.");
	}

	private void rebalance(AVLNode<T> current)
	{
	  setBalance(current);

	  if(current.balance == -2)
	  {
	   if(height(current.left.left) >= height(current.left.right))
	    current = rotateRight(current);
	   else
	    current = rotateLeftRight(current);

	  }
	  else if(current.balance == 2)
	  {
	   if(height(current.right.right) >= height(current.right.left))
	    current = rotateLeft(current);
	   else
	    current = rotateRightLeft(current);
	  }

	  if(current.parent != null)
	   rebalance(current.parent);
	  else
	   root = current;
	}

	private AVLNode<T> rotateLeft(AVLNode<T> current)
	{
	  AVLNode<T> node = current.right;
	  node.parent = current.parent;

	  current.right = node.left;

	  if(current.right != null)
	   current.right.parent = current;

	  node.left = current;
	  current.parent = node;

	  if(node.parent != null)
	  {
	   if(node.parent.right == current)
	    node.parent.right = node;
	   else
	    node.parent.left = node;
	  }

	  setBalance(current, node);

	  return node;
	}

	private AVLNode<T> rotateRight(AVLNode<T> current)
	{
	  AVLNode<T> node = current.left;
	  node.parent = current.parent;

	  current.left = node.right;

	  if(current.left != null)
	   current.left.parent = current;

	  node.right = current;
	  current.parent = node;

	  if(node.parent != null)
	  {
	   if(node.parent.right == current)
	    node.parent.right = node;
	   else
	    node.parent.left = node;
	  }

	  setBalance(current, node);

	  return node;
	}

	private AVLNode<T> rotateLeftRight(AVLNode<T> current)
	{
	  current.left = rotateLeft(current.left);
	  return rotateRight(current);
	}

	private AVLNode<T> rotateRightLeft(AVLNode<T> current)
	{
	  current.right = rotateRight(current.right);
	  return rotateLeft(current);
	}

	private int height(AVLNode<T> current)
	{
	  if(current == null)
	   return -1;
	  return 1 + Math.max(height(current.left), height(current.right));
	}

	private void setBalance(AVLNode<T>... nodes)
	{
	  for(AVLNode<T> current : nodes)
	   current.balance = height(current.right) - height(current.left);
	}

	public String toString()
	{
	  return inOrder();
	}

	private String inOrder(AVLNode<T> current)
	{
	  String result = "";
	  
	  if(current != null)
	  {
	   result += inOrder(current.left);
	   result += current.data + " ";
	   result += inOrder(current.right);
	  }
	  
	  return result;
	}

	public String preOrder() {
		return preOrder(root);
	}
	
	private String preOrder(AVLNode<T> current)
	{
	  String result = "";
	  
	  if(current != null)
	  {
	   result += current.data + " ";
	   result += preOrder(current.left);
	   result += preOrder(current.right);
	  }
	  
	  return result;
	}

	public String inOrder() {
		return inOrder(root);
	}	
	
	private String postOrder(AVLNode<T> current)
	{
	  String result = "";
	  
	  if(current != null)
	  {
	   result += postOrder(current.left);
	   result += postOrder(current.right);
	   result += current.data + " ";
	  }
	  
	  return result;
	}
	
	public String postOrder() {
		return postOrder(root);
	}


}