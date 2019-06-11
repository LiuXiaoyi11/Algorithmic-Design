import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class BiarytreeAreaExam
{

    public static void main(String[] args) throws IOException
    {
        BSTTreeCls theTree = new BSTTreeCls();
File file = new File("shapeFile.txt");
try
{
   BufferedReader brnd = new BufferedReader(new FileReader(file));
      String line;
      while ((line = brnd.readLine()) != null)
   {
          String subcode[] = line.split("\t");
   if(subcode[0].equals("Circle"))
   {
    int radus =Integer.parseInt(subcode[1]);
    double circlara=3.14*radus*radus;
    theTree.insertFunc(circlara);
   }
   if(subcode[0].equals("Rectangle"))
   {
    int sid1 =Integer.parseInt(subcode[1]);
    int sid2 =Integer.parseInt(subcode[2]);
    double rectlara=sid1*sid2;
    theTree.insertFunc(rectlara);
   }
   if(subcode[0].equals("Righttriangle"))
   {
    int sid1 =Integer.parseInt(subcode[1]);
    int sid2 =Integer.parseInt(subcode[2]);
    double trilara=0.5*sid1*sid2;
    theTree.insertFunc(trilara);
   }
      }
}
catch(Exception e)
{}

        System.out.println("Inorder BST");
        theTree.inOrder(theTree.returnRoot());
        System.out.println(" ");

        System.out.println("Preorder BST");
        theTree.preOrder(theTree.returnRoot());
        System.out.println(" ");
            
        System.out.println("postorder BST");
        theTree.postOder(theTree.returnRoot());
        System.out.println(" ");
double maxval=theTree.findMax(theTree.returnRoot());
System.out.println("maximum is: "+maxval);
    }
}