/*
 * Written by Xiaoyi Liu 04/05/2019
 */
public class SheepHeap {

    private Sheep[] aSheep;
	public static final int DEF_SIZE=128; 
    //private static int lastIndex;
	// static member is a common member for all objects, but does not belong to any objects.
	
	private int lastIndex;
	
    public SheepHeap()
    {
        aSheep = (Sheep[])(new Comparable[DEF_SIZE]);
        lastIndex = 0;
    }
    public SheepHeap(int aSize)
    {
        aSheep = new Sheep[aSize];
        // initialize lastIndex
        lastIndex=0;
    }
    public SheepHeap(SheepHeap sh) {
    	this.aSheep = sh.aSheep.clone();
    	this.lastIndex = sh.lastIndex;
    }
    
    public void addSheep(Sheep val)
    {
        if(lastIndex >= aSheep.length)
            return;
        aSheep[lastIndex] = val;
        this.climbUp();
        lastIndex++;
    }

    public void climbUp()
    {
    	int tempIndex=this.lastIndex;
//		while(tempIndex > 0 && aSheep[(tempIndex-1)/2].compareTo(aSheep[tempIndex])<0)
		while(tempIndex > 0 && aSheep[(tempIndex-1)/2].compareTo(aSheep[tempIndex])>0)    	
		{ // when the weight of the parent sheep is larger than that of the child sheep, swap them
			
			Sheep temp=aSheep[(tempIndex-1)/2];
			aSheep[(tempIndex-1)/2]=aSheep[tempIndex];
			aSheep[tempIndex]=temp;
			tempIndex=(tempIndex-1)/2;
		}
    }
    

    public Sheep removeSheep()
    {
    	if (lastIndex == 0) { // no sheep in the heap
    		return null;
    	} else if (lastIndex == 1) { // only one sheep in the heap
    		lastIndex--;
    		return aSheep[0];
    	} else { // more than one sheep
	    	Sheep repVal= aSheep[0];
			aSheep[0]=aSheep[lastIndex-1];// set root to the last element 
			aSheep[lastIndex-1]=null;
			lastIndex--;
			this.climbDown();
			return repVal;
    	}
    }
    
	private void climbDown()
	{
		int tempIndex=0;
		while(tempIndex*2+1< lastIndex)
		{
			// find smaller child
			int smallIndex=tempIndex*2+1;//Assume the left child is smaller
			if(tempIndex*2+2<lastIndex && 
					aSheep[tempIndex*2+1].compareTo(aSheep[tempIndex*2+2])>0)
			{
				//there is a right child and it is smaller than the left child.
				smallIndex=tempIndex*2+2;
			}
			// compare smaller child to the parent
			// if the parent is larger, then swap the smaller child and the parent
			// such the min-heap property is kept.
			if(aSheep[tempIndex].compareTo(aSheep[smallIndex])>0)
			{
				Sheep temp = aSheep[tempIndex];
				aSheep[tempIndex]=aSheep[smallIndex];
				aSheep[smallIndex]=temp;
				tempIndex=smallIndex;
			}
			else { // the parent is smaller than the smaller child. Stop
				break;
			}

		}		
			}
	
	public boolean isEmpty() {
		return this.lastIndex == 0 ? true : false;
	}
	
	  public Sheep[] sheepHeapSort() 
	    {
		  // make a copy of the heap before calling remove method to do sorting.
		  Sheep[] sortedHeap = new Sheep[this.lastIndex];
		  SheepHeap tempHeap = new SheepHeap(this);
		  for(int i = 0; i < lastIndex; i++) {
			  sortedHeap[i] = tempHeap.removeSheep();
		  }
		  return sortedHeap;
	    }

	public void sheepRollCall()
    {  
        //System.out.println("Adding 15 Sheeps and roll call them in breadth order");

    		for (Sheep val:aSheep) // print out array 
    		{
    			if(val !=null)
    				System.out.println(val.toString());			
    		}
    }
}
