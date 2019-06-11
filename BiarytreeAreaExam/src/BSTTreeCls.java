class BSTTreeCls
{
    public BSTTNode root;
    public BSTTreeCls()
    { root = null; }
    public BSTTNode returnRoot()
    {
        return root;
    }
    //function inserting into BST
    public void insertFunc(double id)
    {
        BSTTNode newNode = new BSTTNode();
        newNode.datitm = id;
        if(root==null)
            root = newNode;
        else
        {
            BSTTNode currentnod = root;
            BSTTNode parent;
            while(true)
            {
                parent = currentnod;
                if(id < currentnod.datitm)
                {
                    currentnod = currentnod.lftchid;
                    if(currentnod == null)
                    {
                        parent.lftchid = newNode;
                        return;
                    }
                }
                else
                {
                    currentnod = currentnod.rghtchild;
                    if(currentnod == null)
                    {
                        parent.rghtchild = newNode;
                        return;
                    }
                }
            }
        }
    }

//function for finding maximum
public double findMax(BSTTNode t )
{
  double maxval=0;
        if( t != null )
  {
              while( t.rghtchild != null )
   {
                  t = t.rghtchild;
             maxval=t.datitm;
   }
  }
        return maxval;
    }
    public void preOrder(BSTTNode Root)
    {
        if(Root != null)
        {  
            System.out.print(Root.datitm + " ");
            preOrder(Root.lftchid);
            preOrder(Root.rghtchild);
        }
    }
    public void inOrder(BSTTNode Root)
    {
        if(Root != null)
        {
            inOrder(Root.lftchid);
            System.out.print(Root.datitm + " ");
            inOrder(Root.rghtchild);
        }
    }
    public void postOder(BSTTNode Root)
    {
        if(Root != null)
        {
            postOder(Root.lftchid);
            postOder(Root.rghtchild);
            System.out.print(Root.datitm + " ");
        }
    }
   
}