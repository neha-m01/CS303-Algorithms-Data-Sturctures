package Lab06;

import java.util.Collections;
import java.util.List;

public class sortingAlgorithms {
	
	//Insertion Sort
	public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int elem = arr[i];
            int j = i - 1;
 
          /* Move elements of arr[0..i-1], that are
             greater than key, to one position ahead
             of their current position */
            while (j >= 0 && arr[j] > elem) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j  + 1] = elem;
        }
    }
 

//-------------------------------------------------------------------------------------------------//
    
    //Merge Sort
	static void mergeSort(int[] A, int[] temp, int p, int r){

    if(p < r) {

        // Midpoint of array
        int q = (p + r) / 2;

        //Splitting until one element is remaining 
        mergeSort(A, temp, p, q);
        mergeSort(A, temp,q + 1, r);

        //Sort and split
        merge(A,temp,p,r,q);
    }
}

    private static void merge(int[] A, int[] temp, int p, int r, int q){

    // Copying into temp array
    for(int i =p ; i<= r ; i++){
        temp[i] = A[i];
    }
    int i = p; //Left
    int j = q+1;  //Right copied
    int k = i; //Sort and Merge

    
     //Iterate through the temp array.Compare the right and left half , copy the smallest element from the 2 array to original
     
    while(i <=q && j <= r){
        if(temp[i] <=temp[j]){
            A[k] = temp[i];
            i++;
        }
        else{
            //when right element < left
            A[k] = temp[j];
            j++;
        }
        k++;
    }

//copy left side of array to targe array
    int l= q-i;
    for (int m = 0 ; m<= l; m++){
        A[k+m] = temp[i+m];
    	}
    }
    
  //-------------------------------------------------------------------------------------------------//

	//Heap Sort
	public void MaxHeapify(List<Integer> integer, int index, int size) {
		int largest = index;
		int left = (2 * index) + 1; 
		int right = (2 * index) + 2;
		
		if(left < size && integer.get(left) > integer.get(largest)) {
			largest = left;
		}
		if(right < size && integer.get(right) > integer.get(largest)) {
			largest = right;
		}
		if(largest != index) {
			Collections.swap(integer, index, largest);
			MaxHeapify(integer, largest, size);
			}
		}
	
	//-------------------------------------------------------------------------------------------------//
	
	//Basic Quick Sort
	public static int[] basicQuickSortAlgorithm(int left, int right, int[] QSArray){
	
	    if(left < right){
	        // pivot is correct after partitioning the list into two 
	    	//figure out pivot location
	        int partition = partition(left,right,QSArray); 
	        
	        //recursive function for sorting left side of pivot
	        basicQuickSortAlgorithm(left, partition-1, QSArray); 
	       //recursive function for sorting right side of pivot
	        basicQuickSortAlgorithm(partition+1, right,QSArray);  
	    }
	    return QSArray;
	}
	
	public static int partition(int left, int right, int[] QSArray){
	
		// basic Quick Sort implies we choose last element as pivot
	    int pivotPoint = QSArray[right]; 
	    int exchange = left;
	    
	    //if i is < pivot then exchange location and ++ exchange to next element 
	    for(int i=left; i<= right - 1; i++){
	        if(QSArray[i] <= pivotPoint){
	        	exchangeElementsBasic(exchange, i, QSArray);
	        	exchange ++;
	        }
	    }
	    //exchange pivot with element on other side. Completion of this step is when pivot is in sorted location
	    exchangeElementsBasic(exchange,right,QSArray); 
	    return exchange;
	}
	
	//exchange element
	public static void exchangeElementsBasic(int i, int j, int[] QSArray){
	    int temp = QSArray[i];
	    QSArray[i] = QSArray[j];
	    QSArray[j] = temp;
	}
	
	//-------------------------------------------------------------------------------------------------//
	
	//Median of 3 QuickSort
	
	public static void medianOf3quickSortAlgorithm(int left, int right, int[] QSArray){
		//create integer values from left and right
		//Partition Implementation 
		int i = left; 
		int j = right;
		
		//Pivot Value from Middle of List
		int pivot = QSArray[left + (right - left) / 2];
	
	    // Two Lists with Pivot in Middle
		//repeat steps until lower bound is greater than upper 
	    while (i <= j) {
	    	// increase lower bound until element is greater than pivot value
	        while (QSArray[i] < pivot) {
	        	i++;
	        }
	     // decrease upper bound until element is l than pivot value
	        while (QSArray[j] > pivot) {
	        	j--;
	        }
	
	        // If val in left list is larger than pivot &  val in the right list 
	        //is smaller than the pivot : then exchange
	        
	        // Implementing then incrementing low and high
	        if (i <= j) {
	        	exchangeElementsMedian(i, j, QSArray);
	            i++;
	            j--;
	    }
	}
		if (left < j)
			medianOf3quickSortAlgorithm(left, j, QSArray);
	    if (i < right)
	    	medianOf3quickSortAlgorithm(i, right, QSArray);
	}
	/**
	 *exchange elements
	 */
	public static void exchangeElementsMedian(int i, int j, int[] QSArray){
	    int temp = QSArray[i];
	    QSArray[i] = QSArray[j];
	    QSArray[j] = temp;
	}
}
