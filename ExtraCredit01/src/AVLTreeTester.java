/*
 * Written By Xiaoyi Liu 04/17/2019
 */
import java.util.ArrayList;
import java.util.Collections;
public class AVLTreeTester
{
public static void main(String[] args)
{




  ArrayList<Integer> myList = new ArrayList<Integer>();
  for(int i=1; i<=15; i++) {
	  myList.add(i);
  }
  int testID=1;
  while(testID<=5) {
	  System.out.println("\nTesting AVL tree " + Integer.toString(testID));
	  
	  // create an AVL tree
	  AVLTree<Integer> avl = new AVLTree<Integer>();
	  
	  // add integers into the AVL tree.
	  // since "myList" is shuffle, the AVL tree created in each
	  // of the 5 tests should be different.
	  Collections.shuffle(myList);
	  for(Integer num: myList) {
		  avl.addValue(num);
	  }
	
	  System.out.println("The AVL tree is as below.");
	  BTreePrinter.printNode(avl.getRoot());
	
	  System.out.println("\n[InOrder Travesal]: \n" + avl.inOrder());
	  System.out.println("\n[PreOrder Travesal]: \n" + avl.preOrder());
	  System.out.println("\n[PostOrder Travesal]: \n" + avl.postOrder());
	  
	  System.out.println("Remove 5 elements from the AVL tree");
	  Collections.shuffle(myList);
	  int removedCnt=0;
	  while(removedCnt<5) {
		  int numToRemove = myList.get(removedCnt);
		  System.out.println("\t["+Integer.toString(removedCnt+1)+"]Removing "+Integer.toString(numToRemove));
		  avl.remove(numToRemove);
		  removedCnt+=1;
	  }
	  System.out.println("The AVL tree after removing the above 5 elemnts is as below:");
	  BTreePrinter.printNode(avl.getRoot());
	  
	  testID+=1;
  }
}



}