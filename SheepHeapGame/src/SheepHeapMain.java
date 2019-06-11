/*
 * Written by Xiaoyi Liu 04/05/2019
 */
public class SheepHeapMain {

    private Sheep[]aSheep;
	public static final int DEF_SIZE = 128;
    private static int tailIndex;

    public SheepHeapMain()
    {
        aSheep = (Sheep[])(new Comparable[DEF_SIZE]);
        tailIndex = 0;
    }
    public SheepHeapMain(int size)
    {
    	aSheep = new Sheep[size];
    }

    public void addSheep(Sheep val)
    {
        if(tailIndex >= aSheep.length)
            return;
        aSheep[tailIndex] = val;
        this.climbUp();
        tailIndex++;
    }

    public void climbUp()
    {
    	int tempIndex=this.tailIndex;
		while(tempIndex > 0 && aSheep[(tempIndex-1)/2].compareTo(aSheep[tempIndex])<0)
		{
			Sheep temp=aSheep[(tempIndex-1)/2];
			aSheep[(tempIndex-1)/2]=aSheep[tempIndex];
			aSheep[tempIndex]=temp;
			tempIndex=(tempIndex-1)/2;
		}
    }
    

    public Sheep removeSheep()
    {
    	Sheep repVal= aSheep[0];
		aSheep[0]=aSheep[tailIndex-1];// set root to the last element 
		aSheep[tailIndex-1]=null;
		tailIndex--;
		this.climbDown();
		return repVal;
    }
    
	private void climbDown()
	{
		int tempIndex=0;
		while(tempIndex*2+2< tailIndex)
		{
			// find larger child
			int bigIndex=tempIndex*2+2;//Assume the left child is bigger
			if(tempIndex*2+2<tailIndex && 
					aSheep[tempIndex*2+2].compareTo(aSheep[tempIndex*2+1])<0)
			{
				//there is a right child and its bigger.
				bigIndex=tempIndex*2+1;
			}
			//compare child to the parent
			if(aSheep[tempIndex].compareTo(aSheep[bigIndex])<0)//parent smaller than child
			{
				Sheep temp = aSheep[tempIndex];
				aSheep[tempIndex]=aSheep[bigIndex];
				aSheep[bigIndex]=temp;
			}
			else 
				break;
			tempIndex=bigIndex;
		}
	}

    public void sheepRollCall()
    {  
    		for (Sheep val:aSheep)
    		{
    			if(val !=null)
    				System.out.println(val);			
    		}
    }

    public void sheepHeapSort()
    {
    	for(int i=0;i<5;i++)
    	{
    		removeSheep();
    	}
        for(int i=tailIndex;i>0;i--)
        {
            System.out.println(removeSheep());
        	
        }
    }
}