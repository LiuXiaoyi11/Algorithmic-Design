public class GenLinkedList<T> {
	// internal class for the node in the list
	private class ListNode
	{
		T data;
		ListNode link;
		
		// customized ListNode constructor
		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}
	
	
	ListNode head;
	ListNode current;
	ListNode previous;
	
	public GenLinkedList(){
		head=null;
		current=null;
		previous=null;
	}
	
	// insert the new node at the end of the list
	public void addItem(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head==null) { // the list is empty
			head=newNode;
			current=head;
		} else {
			ListNode testNode = head;
			while(testNode.link!=null) {
				testNode=testNode.link;
			}
			// testNode reaches the last node of the list
			testNode.link=newNode;
		}
	}
	
	// removes an item from the list if it exists
	// only remove the first matched item
	public void removeItem(T aData) {
		if(aData!=null && head!=null) { // the list is not empty
			ListNode testNode = head;
			ListNode prevTestNode = null;
			// search for the node in the list.
			while(testNode!=null && !testNode.data.equals(aData)) {
				prevTestNode=testNode;
				testNode=testNode.link;
			}
			
			if(testNode==current) {
				current=testNode.link;
				if(testNode==head) {
					head=testNode.link;
				}
			} else if(testNode==previous) {
				if(testNode==head) {
					previous=null;
					head=testNode.link;
				} else {
					ListNode prevPrevious=head;
					while(prevPrevious.link!=previous) {
						prevPrevious=prevPrevious.link;
					}
					previous=prevPrevious;
				}
			}
			//link the node before the target node to the node after the target node
			prevTestNode.link=testNode.link;
			testNode.link=null;
			
		}
	}
	
	// return the value of where the current iterator is located
	public T getValueAtCurrent() {
		if(current!=null) {
			return current.data;
		} else {
			return null;
		}
	}
	
	public void forward() {
		if(current!=null) {
			previous=current;
			current=current.link;
		}
	}
	
	public void backward() {
		if(previous!=null) {
			current=previous;
			ListNode prevPrevious=head;
			while(prevPrevious.link!=previous) {
				prevPrevious=prevPrevious.link;
			}
			previous=prevPrevious;
		}
	}
	
	public void moveCurrentToHead() {
		current=head;
		previous=null;
	}
	
	public void print() {
		if(head!=null) {
			ListNode testNode=head;
			while(testNode!=null) {
				// toString() method of type T should exist
				System.out.println(testNode.data.toString());
				testNode=testNode.link;
			}
		}
	}
}
