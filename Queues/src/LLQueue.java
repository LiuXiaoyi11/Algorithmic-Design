import java.util.*;

public class LLQueue <T> implements QueueInterface <T> {
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	private int size;
	public LLQueue()
	{
		head = tail = null;
		size = 0;
	}
	public void enqueue (T aData) // enqueue
	{
		ListNode newNode = new ListNode(aData,null);
		if(head == null)
		{
			head = tail = newNode;
			size = 1;
			return;
		}
		tail.link = newNode;
		tail = newNode;  // tail.link
		size++;
	}
	public T dequeue()  // dequeue
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}
	public void print() {
		for (ListNode temp = head; temp != null; temp=temp.link)  // 2-3-4
			System.out.println(temp.data);
	}
	public int size()
	{
		return this.size;
	}
	//internal class
	private class ListIterator implements Iterator<T>
	{
		private ListNode iCurr;
		public void listIterator(ListNode head)
		{
			iCurr = head;
		}
		public boolean hasNext()
		{
			return iCurr != null;
	
		}
		public T next() {
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	}
	public Iterator<T>Iterator()
	{
		return new ListIterator(head);
	}
	
}





























