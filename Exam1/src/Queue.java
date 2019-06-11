/*
 * Written by Xiaoyi Liu 02/27/2019
 */
public class Queue<T> // Internal class
{
	class ListNode
	{
		T data;
		ListNode link;
		ListNode(T dat, ListNode lk)
		{
			data = dat;
			link = lk;
		}
	 }
	
	private ListNode head, tail;
	public Queue()
	{
		head = tail = null;
	}
	
	public Queue(T data) 
	{
		enqueue(data);
	}
	
	public void enqueue(T data)
	{
		ListNode n = new ListNode(data, null);
		if(head == null) // check the queue empty or not
			head = tail = n;
		else //add to end if the queue not empty
			{
			tail.link = n;
			tail = n;
			}
	 }
	
	public T deque()
	{
		if(head == null)  // check the queue empty or not
			return null;
		else
		{
			T val = head.data;
			head = head.link; //Move to next node if the queue is not empty
			if(head == null) //if the queue is empty, make the tail null
				tail = null;
			return val;
		}
	 }
	
	public T peek()
	{
		if(head == null) //  Also check the queue is empty or not
			return null;
		else // if not empty return head.data
			return head.data;
	}
	
	public void print() // print out the result
	{
		ListNode n = head;
		while(n != null)
		{
			System.out.println(n.data);
			n = n.link;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		if (head==null) {
			return true;
		} else {
			return false;
		}
	}
}

