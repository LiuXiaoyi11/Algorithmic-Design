import java.io.*;
import java.util.*;
import java.lang.*;

class BSTTNode
{
    public double datitm;
    public BSTTNode lftchid;
    public BSTTNode rghtchild;
    public void displynodFunc()
    {
        System.out.print("[");
        System.out.print(datitm);
        System.out.print("]");
    }
}
class StcknodCls
{
    public BSTTNode datitm;
    public StcknodCls nxtnod;
    public StcknodCls(BSTTNode val)
    {
        datitm = val;
    }

}
class LinkdListCls
{
    private StcknodCls first;
    public LinkdListCls()
    {
        first = null;
    }
    public boolean IsEmtyFunc()
    {
        return (first==null);
    }
    public void insertFunc(BSTTNode key)
    {
        StcknodCls newLLNode = new StcknodCls(key);
        newLLNode.nxtnod = first;
        first = newLLNode;
    }
    public BSTTNode delete()
    {
        StcknodCls temp = first;
        first = first.nxtnod;
        return temp.datitm;
    }
}