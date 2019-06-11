/*
 * Written By Xiaoyi Liu 04/17/2019
 */
public class AVLNode<T extends Comparable<T>> implements Comparable<AVLNode<T>>
	{
	  public T data;
	  public int balance;
	  public AVLNode<T> left;
	  public AVLNode<T> right;
	  public AVLNode<T> parent;


	  AVLNode(T val, AVLNode<T> par)
	  {
	   data = val;
	   parent = par;
	   left = null;
	   right = null;
	  }

	  T getVal() {
		  return data;
	  }
	    @Override
	    public int compareTo(AVLNode<T> o) {
	        return getVal().compareTo(o.getVal());
	    }
	  
	  public String toString()
	  {
	   return data + "(" + balance + ")";
	  }
	}