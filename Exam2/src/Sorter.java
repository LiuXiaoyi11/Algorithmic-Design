/*
 * Written By Xiaoyi Liu 04/10/2019
 */
public class Sorter {

	   //BubbleSort method
	   public static void bubbleSort(Cylinder [] val)
	   {   
		   int len = val.length;
		   for (int i = 0; i < len-1; i++)       
		  
		       // Last i elements are already in place    
		       for (int j = 0; j < len-i-1; j++)  
				   if(val[j].getVolume() >  val[j+1].getVolume()) {
					   Cylinder temp = val[j];
	                   val[j] = val[j + 1];
	                   val[j + 1] = temp;					   
				   }
	   }
	   
	   
	   public static void mergeSort(Cylinder[] val)
	   {
	       int n = val.length;
	       Cylinder[] temp1 = new Cylinder[n / 2];
	       Cylinder[] temp2 = new Cylinder[n - temp1.length];

	       if(n > 1)
	       {
	           System.arraycopy(val, 0, temp1, 0, n / 2);
	           System.arraycopy(val, n / 2, temp2, 0, temp2.length);
	           mergeSort(temp1);
	           mergeSort(temp2);
	           merge(temp1, temp2, val);
	       }
	   } 

	   // merge method 
	   private static void merge(Cylinder[] temp1, Cylinder[] temp2, Cylinder[] val)
	   {
	       int p = temp1.length;
	       int q = temp2.length;
	       int i = 0;
	       int j = 0;
	       int k = 0;

	       while(i < p && j < q)
	       {
	           if(temp1[i].getVolume() < temp2[j].getVolume())
	           {
	               val[k] = temp1[i];
	               i = i + 1;
	           }
	           else
	           {
	               val[k] = temp2[j];
	               j = j + 1;
	           }

	           k = k + 1;
	       }

	       if(i == p)
	           System.arraycopy(temp2, j, val, k, q - j);
	       else
	           System.arraycopy(temp1, i, val, k, p - i);
	   } 
	   
	   //Heap and heapsort
	   public static class CHeap {

			private Cylinder[] heap;
			private  int size; // indicate the capacity of the heap
			private  int counter=0; // indicate the number of actual processes in the heap
			
			
			public CHeap(Cylinder[] arr){
				this.heap = new Cylinder[arr.length];
			    this.size=arr.length;
			    Cylinder[] tempArr = arr.clone();
			    for(Cylinder c : tempArr) {
			    	this.insert(c);
			    }
			}
			
			   
			public int parent(int i) { return (i-1)/2; }
			
		    // to get index of left child of node at index i 
		    public int left(int i) { return (2*i + 1); } 
		  
		    // to get index of right child of node at index i 
		    public int right(int i) { return (2*i + 2); } 	
			   
			public void insert(Cylinder p) {
				if (counter != size) { // when the heap is not full
					heap[counter] = p; // place as the next element in breadth order
				    counter+=1;
				    // bubble up the process p in the heap
				    int p_index=counter-1;
				    
				    // Fix the max heap property if it is violated
				    while (p_index != 0 && heap[parent(p_index)].getVolume() < heap[p_index].getVolume()) 
			        { 
				    	// swap the node indicated by p_index and the node at parent(p_index) 
				    	Cylinder temp = heap[p_index];
				       	heap[p_index] = heap[parent(p_index)];
				       	heap[parent(p_index)] = temp;
				        // update p_index by moving it up
				        p_index = parent(p_index); 
			        } 
				}
			}
			

			
			// A recursive method to heapify a subtree with the root at given index 
			public void MaxHeapify(int i) 
			{ 
			    int l = left(i); 
			    int r = right(i);
			    
			    // find the node with the largest priority among the three nodes at indices, i, l and r.
			    int largest_index = i; 
			    if (l < counter && heap[l].getVolume() > heap[i].getVolume()) 
			        largest_index = l; 
			    if (r < counter && heap[r].getVolume() > heap[largest_index].getVolume()) 
			        largest_index = r;
			    
			    // if the node at index i violates the property of the max heap, that is,
			    // the priority of the node at index i is lower than at least one of its children
			    // then swap it with the node with the largest priority and then call Maxheapify on the node at largest_index
			    if (largest_index != i)  
			    {
			    	// swap nodes at indices i and largest_index
			    	Cylinder temp = heap[largest_index];
			    	heap[largest_index] = heap[i];
			    	heap[i] = temp;
			
			        MaxHeapify(largest_index); 
			    } 
			}	
			
		    public Cylinder remove(){
		    	if (this.isEmpty()) {
		    		return null;
		    	} else if (counter == 1) {
		    		counter-=1;
		    		return heap[0];
		    	} else {
		    		Cylinder root = heap[0];
		    		heap[0] = heap[counter-1]; // move the last element in the heap (via breadth order)
		    		counter-=1;
		    		// update the heap by bubbling down heap[0]
		    		MaxHeapify(0); 
		    		  
		    		return root;    		
		    	}
		    }


		    public boolean isEmpty(){
		    	if(counter==0) {
		    		return true;
		    	} else {
		    		return false;
		    	}
		    }
		}


	    public static void heapSort(Cylinder[] cArr){
	    	// create a max heap
	    	CHeap tempHeap = new CHeap(cArr);
	    	int len = cArr.length;
	    	for(int i = len-1; i>=0; i--) {
	    		Cylinder c = tempHeap.remove();
	   			cArr[i] = c;
	    	}
	    }

	   
	   

}
