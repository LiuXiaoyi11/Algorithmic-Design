/*
 * Written by Xiaoyi Liu 03/29/2019
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BSTDemo {
   public static void main(String[] args)
{   
       File file=new File("shapeFile.txt");
       Scanner a=null;
       String shapeType;
       int side1,side2,radius = 0;
       try {
    	   a = new Scanner(file);
    	   } catch (FileNotFoundException e) {
    		   e.printStackTrace();
    		   }
       //Create object of the Binary Search Tree
       BinarySearchTree bst = new BinarySearchTree();
       System.out.println("Welcome to the shape tree tester!\n");
       System.out.println("Reading from file");
       while(a.hasNext()){
    	   shapeType=a.next();
    	   if(shapeType.equals("Circle")){
    		   radius=a.nextInt();
    		   System.out.println("Circle "+radius);
    		   bst.insert(3.1412*radius*radius,"Circle",0,0,radius);
    		   }
    	   
    	   if(shapeType.equals("Rectangle")){
    		   side1=a.nextInt();
    		   side2=a.nextInt();
               System.out.println("Rectangle "+side1+" "+side2);
               bst.insert(side1*side2,"Rectangle",side1,side2,0);
               }
    	  
    	   if(shapeType.equals("Right")){
    		   a.next();
    		   side1=a.nextInt();
    		   side2=a.nextInt();
    		   System.out.println("Right Triangle "+side1+" "+side2 );
    		   bst.insert(0.5*side1*side2,"Right Triangle",side1,side2,0);
    		   }
    	   }
       //Display the tree
       System.out.println("");
       System.out.println("Printing pre-order : ");
       bst.preorder();
       System.out.println("");
       System.out.println("Printing in-order : ");
       bst.inorder();
       System.out.println("");
       System.out.println("Printing post-order : ");
       bst.postorder();
       
     //get max area
       System.out.println("\nMaximum is: " + bst.findMax());
       
       System.out.println("\nDeleting Rectangle Side 1: 2.0 Side 2: 7.0 Area: 14.0");
       Node nodeToDelete = new Node(14.0, "Rectangle", 2.0, 7.0, 0.0);
       bst.delete(nodeToDelete);
       bst.delete(new Node(50.2592,"Circle", 0.0,0.0,4.0));
       bst.delete(new Node(40.5, "Right", 0.0,0.0,9.0));
       System.out.println("Printing in order");
       bst.inorder();
       
    // delete by area
       System.out.println("\nDeleting values larger than 30");
       bst.deleteByArea(30.0);
       System.out.println("Printing in order");
       bst.inorder();
     }
       }
   