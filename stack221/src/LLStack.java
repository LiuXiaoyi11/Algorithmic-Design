
public class LLStack <T> implements StackInterface <T>{
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
	private int size;
	public LLStack()
	{
		head =null;
		size =0;
	}
	public void push (T aData)
	{
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
		size++;
	}
	public T pop()
	{
		if(head == null)
		  return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret; //  Exam will cover;
	}
	public T peek()
	{
		if (head == null)
			return null;
		return head.data;
	}
	public void print()
	{
		for(ListNode temp = head; temp !=null; temp=temp.link)
		{
			System.out.println(temp.data);
			System.out.println();
		}
		public int size()
		{
		
		}
	}

}
