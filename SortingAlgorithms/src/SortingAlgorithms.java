/*
 * Written by Xiaoyi Liu 03/29/2019
 */}
import java.util.Random;
public class SortingAlgorithms {
	public static final int MAX_TEST = 20;;
	public static final int MAX_NUM = 1000;
	private static String algorithms[] = {"Selection Sort", "Bubble Sort", "Merge Sort", "Quick Sort"};
	   private static int comparisons[] = {0, 0, 0, 0};
 
	   public static void main(String[] args)
	   {
		   System.out.println("---------------------------");
		   System.out.println("Sorting Method Complexity Tester");
		   System.out.println("---------------------------");
		
		   int [] groundTrue = createGroundTrue();

		   
		   for(int j=0; j< MAX_TEST; j++)
		   {  
		       // create 4 random arrays for sorting
		       int[] arrSel = createGroundTrue();
		       shuffleArray(arrSel);
		       int[] arrBub = createGroundTrue();
		       shuffleArray(arrBub);
		       int[] arrMer = createGroundTrue();
		       shuffleArray(arrMer);
		       int[] arrQui = createGroundTrue();
		       shuffleArray(arrQui);		         

			   
		       // sorting
		       selectionSort(arrSel);
		       //System.out.println("insertion sort:");
		       //displayArray(arrSel, MAX_NUM);
		       
		       bubbleSort(arrBub);
		       //System.out.println("bubble sort:");
		       //displayArray(arrBub, MAX_NUM);
		       
		       mergeSort(arrMer);
		       //System.out.println("merge sort:");
		       //displayArray(arrMer, MAX_NUM);
		       
		       quickSort(arrQui); 
		       //System.out.println("quick sort:");
		       //displayArray(arrQui, MAX_NUM);
		       
		       // print out result
			   System.out.println("-----------\n"+ "Test" + j +"\n" +"-----------");
			   
			   System.out.println("Selection sort successful? "
					   + Boolean.toString(isSorted(arrSel, groundTrue, MAX_NUM)));
			   System.out.println("Bubble sort successful? " 
					   + Boolean.toString(isSorted(arrBub, groundTrue, MAX_NUM)));
			   System.out.println("Merge sort successful? " 
					   + Boolean.toString(isSorted(arrMer, groundTrue, MAX_NUM)));
			   System.out.println("Quick sort successful? " 
					   + Boolean.toString(isSorted(arrQui, groundTrue, MAX_NUM)));
		   }

	    	   System.out.println("\n------------------------------");
	           System.out.printf("%-15s%15s\n", "Average Checks", "");
	           System.out.println("------------------------------");
	       for(int i = 0; i < algorithms.length; i++)
	       {
	           System.out.printf("%-15s%15d\n", algorithms[i], comparisons[i]);
	       }  
	       System.out.println("------------------------------");
	   }
	   
	   public static int [] createGroundTrue() {
		   int [] groundTrue = new int[MAX_NUM];
		   for(int i=0; i<MAX_NUM; i++) {
			   groundTrue[i] = i;
		   }
		   return groundTrue;
	   }
	   
	   public static void shuffleArray(int[] array)
	   {
	       int index, temp;
	       Random random = new Random();
	       for (int i = array.length - 1; i > 0; i--)
	       {
	           index = random.nextInt(i + 1);
	           temp = array[index];
	           array[index] = array[i];
	           array[i] = temp;
	       }
	   }

	   public static void displayArray(int [] arr, int len) {
		   for(int i = 0; i < len; i++) {
			   System.out.print(arr[i]);
			   System.out.print(" ");
		   }
		   System.out.println();
	   }
       public static boolean isSorted(int [] testArr, int [] groundTrue, int len) {
    	   for(int i=0; i<len; i++) {
    		   if(testArr[i]!=groundTrue[i]) {
    			   return false;
    		   }
    	   }
    	   return true;
       }	   
	   
	   public static void selectionSort(int[] val)
	   {
	       for(int i = 0; i < val.length - 1; i++)
	       {
	           int mP = i;

	           for(int j = i + 1; j < val.length; j++)
	           {
	               comparisons[0] = comparisons[0] + 1;
	               if(val[j] < val[mP])
	               {
	                   mP = j;
	               }
	           }
	           if(mP != i)
	           {
	               int temp = val[mP];
	               val[mP] = val[i];
	               val[i] = temp;
	           }           
	       }
	   } 
	   //BubbleSort method
	   public static void bubbleSort(int[] val)
	   {
	       boolean flag = true;      
	       while(flag)
	       {
	           flag = false;
	           for(int j = 0; j < val.length - 1; j++)
	           {
	               comparisons[1] = comparisons[1] + 1;
	               if(val[j] > val[j + 1])
	               {
	                   int temp = val[j];
	                   val[j] = val[j + 1];
	                   val[j + 1] = temp;
	                   flag = true;
	               }
	           }
	       }  
	   } 
	   
	   public static void mergeSort(int[] val)
	   {
	       int n = val.length;
	       int[] temp1 = new int[n / 2];
	       int[] temp2 = new int[n - temp1.length];

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
	   private static void merge(int[] temp1, int[] temp2, int[] val)
	   {
	       int p = temp1.length;
	       int q = temp2.length;
	       int i = 0;
	       int j = 0;
	       int k = 0;

	       while(i < p && j < q)
	       {
	           comparisons[2] = comparisons[2] + 1;
	           if(temp1[i] <= temp2[j])
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
	  
	   // quickSort method
	   public static void quickSort(int[] val)
	   {
	       quickSort(val, 0, val.length - 1);
	   } 
	   private static void quickSort(int[] val, int l, int r)
	   {
	       int s = partition(val, l, r);

	       if(l < s - 1)
	           quickSort(val, l, s - 1);
	       if(s < r)
	           quickSort(val, s, r);
	   } 
	   
	   // partition method
	   private static int partition(int[] val, int l, int r)
	   {
	       int p = l;
	       int q = r;
	       int temp;
	       int pivot;
	       pivot = val[(l + r) / 2];

	       while(p <= q)
	       {
	           comparisons[3] = comparisons[3] + 1;
	           while(val[p] < pivot)
	               p++;
	          
	           comparisons[3] = comparisons[3] + 1;
	           while(val[q] > pivot)
	               q--;

	           if(p <= q)
	           {
	               temp = val[p];
	               val[p] = val[q];
	               val[q] = temp;
	               p++;
	               q--;
	           }
	       }
	       return p;    
	   }    
	}
