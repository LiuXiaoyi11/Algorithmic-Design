
public class ArrayHeap <T extends Comparable<T>> {
	private T[] heap;
	private int lastIndex;
	public static final int DEF_SIZE =128;
	public ArrayHeap() {
		
	}
	public ArrayHeap(int size)
	{
		
	}
	public void init(int size)
	{
		if(size <=0)
			return;
		heap = (T[]) (new Comparable[size]);
	}
	
	
	public void insert (T adata) 
	{
		if(lastIndex >= heap.length)
			return; //heap is full
		heap[lastIndex] = adata;
		bubbleup();
		lastIndex++;
	}
	private void bubbleup()
	{
		int index = lastIndex; // start form newly added item
		while (index >0 && 
				heap[pIndex(index)].compareTo(heap[index]) < 0)
		{
			T temp = heap [pIndex(index)];
			heap[pIndex(index)] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	private int pIndex (int index)
	{
		return (index-1 / 2);
	}
	
	private int lIndex(int index)
	{
		return index*2+2;
		
	}
	private int rIndex(int index)
	{
		return index*2 +2;
		}
	private T peek ()
	{
		return heap[0];
		
	}
	public T remove()
	{
		T temp = peek();
		heap[0] = heap[lastIndex -1];
		heap[lastIndex -1 ]= null;
		lastIndex--;
		bubbleDown();
		return temp;
	}
	public void bubbleDown()
	{
		int index = 0;
		while (lIndex(index) < lastIndex)
		{
			int bigIndex = lIndex(index);// assume left is larger
			if(heap[lIndex(index)].compareTo(heap[rIndex(index)] )< 0)
				bigIndex = rIndex(index); // right is larger
			if(heap[index].compareTo(heap[bigIndex]) < 0) {
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
			
				break;// we didn't have to seap so stop
			index = bigIndex;
		}
	}
	public void print() {
		for(int i=0; i<lastIndex; i++)
		{
			System.out.println(heap[i]);
		}
		
	}
}
































