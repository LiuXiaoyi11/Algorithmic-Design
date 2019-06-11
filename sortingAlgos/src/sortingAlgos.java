
public class sortingAlgos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void mergeSort(int[] a) {
		int size = a.length;
		if(size<2)
			return;
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for(int i=0; i<leftSize; i++) {
			left[i] = a[i];
		}
			for(int i=mid; i<size; i++)
				right[i-mid] = a[i];
			mergeSort(left);
			mergeSort(right);
			merge(left,right,a);
			
		}
		public static void merge(int[] left, int[] right, int[] a) {
			int leftSize = left.length;
			int rightSize = right.length;
			int i=0;
			int j=0;
			int k=0;
			while (i<leftSize && j<rightSize) {
				if(left[i] <= right[i]) {
					a[k] =left[i];
					i++;
					k++;
				}
				else {
					a[k] = right[j];
					j++;
					k++;
				}
				
			}
			while (i<leftSize) {
				a[k] = left[i];
				k++;
				i++;
			}
			while (j<rightSize) {
				a[k] = right[i];
				k++;
				i++;
			}
		}
		
		public static void quickSort(int[] a, int leftIndex, int rightIndex) {
			int pIndex = partition(a,leftIndex,rightIndex);
			if(leftIndex < pIndex-1)
				quickSort(a, leftIndex, pIndex-1);
			if(rightIndex > pIndex)
				quickSort(a, pIndex, rightIndex);
			
		}
		public static int partition(int[] a, int leftIndex, int rightIndex) {
			int i = leftIndex;
			int j = rightIndex;
			int pivot = a[(leftIndex+rightIndex)/2];
			while(i<=j) {
				while (a[i] < pivot)
				i++;
				while (a[j] > pivot)
				j--;
				if(i <= j) {
					int temp = a[i];
					a[i] = a[j];
					i++;
					j++;
				}
			}
			return i;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
