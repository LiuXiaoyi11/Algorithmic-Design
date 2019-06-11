// heap start from the bottom, like queue // mer
public class ArrayHeap  < T extends Comparable <T>> {
	private T[] heap;
	public static final int DEF_SIZE =128;
	private int lastindex;
	public ArrayHeap()
	{
		init(DEF_SIZE);
	}
	public ArrayHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size <=0)
			return;
		heap =(T[]) (new Comparable[size]);
		lastindex = 0;
	}
	public void insert (T adata)
	{
		if(lastindex >= heap.length)
			return; // heap is full
		heap[lastindex] = adata;
		bubbleup();
		//TODO bubble up
		lastindex ++;	
	}
	private void bubbleup()
	{
		int index = lastindex;
		while(index >0 && 
				heap[(index-1)/2].compareTo(heap[index]) <0)
		{
			//swap
			T temp = heap[(index-1)/2]; //parent 
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	public T peek()
	{
		return heap[0];
	}
	public void print()
	{
		for(T temp: heap)
			System.out.println(temp); 
	}
	//only remove at heap
	public T delete() 
	{
		T retval = heap[0]; // return value in the root
		heap[0] = heap[lastindex-1];
		heap[lastindex-1] = null;
		lastindex--;
		//TODO bubble down 
		return retval;		
	}
	private void bubbledown()
	{
		int index =0;
		while(index*2+1 <lastindex) // while we have a left child
		{
			//assume the left is larger
			int bigindex = index*2+1;
			//confirm that it is
			if(index*2+2 < lastindex &&
					heap[index*2+1].compareTo(heap[index*2+2]) <0)
				bigindex = index*2+2;
			//check if paretn is larger than child
			if(heap[index].compareTo(heap[bigindex]) <0)
			{
				//swap
				T temp = heap[index];
				heap[index] = heap[bigindex];
				heap[bigindex] = temp;		
			}
			else 
				break; // parent was larger than both children
			index = bigindex;			
		}
	} 
	public void heaopsort() // descending order
	{
		for(int i=0; i<lastindex;i++)
			System.out.println(this.delete());
		
	}
}































