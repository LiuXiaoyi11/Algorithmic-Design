package queue;

public class ArrayQueue <T> implements QueueInterface<T> {
	private T[] queue;
	private int tailIndex; // point to the first null item
	public static final int DEF_SIZE=50;
	public ArrayQueue()
	{
		init(DEF_SIZE);
	}
	public ArrayQueue(int size)
	{
		init(size);
	}
	
	

}
