class StakCls
{
    private LinkdListCls listObj;
    public StakCls()
    {
        listObj = new LinkdListCls();
    }
    public void push(BSTTNode num)
    {
        listObj.insertFunc(num);
    }
    public BSTTNode pop()
    {
        return listObj.delete();
    }
    public boolean IsEmtyFunc()
    {
        return listObj.IsEmtyFunc();
    }
}