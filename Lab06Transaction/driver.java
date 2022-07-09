package Lab06;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Lab02InsertionSort.InsertionSort;
import Lab04HeapSort.heapSort;

public class driver extends sortingAlgorithms{
	
	public static void main(String[] args) throws IOException {

	/*
	 * Insertion Sort
	 */		
		
	//Read and Scan Files
	long startTime = System.currentTimeMillis();
	//int[] intArray = new int[] {};

	int inputArrayInsertionSort[] = new int[1050];

	try (Scanner scInsertion = new Scanner(new FileReader("input_Sorted.txt"))) {
		int i = 0;
		while(scInsertion.hasNextInt()) {
			inputArrayInsertionSort[i++] = scInsertion.nextInt();
		}
		scInsertion.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	
		
		 System.out.println("\nInput Array before Insertion Sort: ");
	     System.out.println(Arrays.toString(inputArrayInsertionSort));
		// Driver method 
	    {
	        int arr[] = inputArrayInsertionSort;
	 
	        InsertionSort inputText = new InsertionSort();
	        inputText.insertionSort(arr);
	 
	       
	        System.out.println("\nAfter Insertion Sort Algorithm: ");
	        long endTime = System.currentTimeMillis();
	        System.out.println("Insertion Sort took " + (endTime - startTime) / Math.pow(10, 9) + " nanoseconds"); 
	        System.out.println("##############################################################");	    
	    }
	    
	

//-------------------------------------------------------------------------------------------------//
/*
 * Merge Sort
 */	
	int inputArrayMerge[] = new int[1050];
	try (Scanner scMergeSort = new Scanner(new FileReader("input_Sorted.txt"))) {
		int i = 0;
		while(scMergeSort.hasNextInt()) {
			inputArrayMerge[i++] = scMergeSort.nextInt();
		}
		scMergeSort.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}

    //Driver Code Implementing the Sorting 
    System.out.println("\nInput Array before Merge Sort: ");
    System.out.println(Arrays.toString(inputArrayMerge));
    long startTimeMergeSort = System.currentTimeMillis();
    //System.out.println("\nSorting Process Started at " + startTime);

    //formatted output after sort
    int[] tempArray = new int[inputArrayMerge.length];  // Temp array to store split results.
    mergeSort(inputArrayMerge, tempArray, 0 , inputArrayMerge.length-1);
    System.out.println("\nAfter Merge Sort Algorithm: ");
    System.out.println(Arrays.toString(inputArrayMerge));
    long endTimeMergeSort = System.currentTimeMillis();
    //System.out.println("\nSorting Process Ended at " + endTime);
    System.out.println("It took " + (endTimeMergeSort - startTimeMergeSort) / Math.pow(10, 9) + " nanoseconds");
    System.out.println("##############################################################");	   


//-------------------------------------------------------------------------------------------------//
/*
 * Heap Sort
 */	 
	//instantiate new object in class
	heapSort heap = new heapSort();
	List<Integer> input_arrayHeapSort = new ArrayList<>();
	
	//Scan in file and write to Array List
	try {
		File file = new File("input_Sorted.txt");   
		Scanner scHeapSort = new Scanner(file); 
		while (scHeapSort.hasNext()) {
		    if (scHeapSort.hasNextInt()) { 
		    	input_arrayHeapSort.add(scHeapSort.nextInt());
		    } 
		    else {
		    	scHeapSort.next();
		    } 
		}
		scHeapSort.close();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	
	//Print Unsorted Array (before MaxHeap sorting algorithm)
	System.out.println("Input Array before Heap Sort: " + input_arrayHeapSort);
	
	//calculate elapsed time in nanoseconds
	int size = input_arrayHeapSort.size();
	// start time
	long startTimeHeapSort = System.currentTimeMillis();
	for(int i = size / 2 - 1; i >= 0; i--) {
		heap.MaxHeapify(input_arrayHeapSort, i, size);
	}
	for(int i = size - 1; i >= 0; i--) {
		Collections.swap(input_arrayHeapSort, i, 0);
		heap.MaxHeapify(input_arrayHeapSort, 0, i);
	}
	// end time
	System.out.println("\nAfter Heap Sort Algorithm" + input_arrayHeapSort);
		long endTimeHeapSort = System.currentTimeMillis();
	System.out.println("It took " + (endTimeHeapSort - startTimeHeapSort) / Math.pow(10, 9) + " nanoseconds");
	System.out.println("##############################################################");	   
//-------------------------------------------------------------------------------------------------//
/*
* Basic Quick Sort
*/	

	int inputArrayBasicQS[] = new int[1050];
	
	try (Scanner scBasicQS = new Scanner(new FileReader("input_Sorted.txt"))) {
		int i = 0;
		while(scBasicQS.hasNextInt()) {
			inputArrayBasicQS[i++] = scBasicQS.nextInt();
		}
		scBasicQS.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	
	//Array before the Quick Sort Algorithm
	System.out.println("\nInput Array before Basic Quick Sort: ");
	System.out.println(Arrays.toString(inputArrayBasicQS));
	long startTimeBasicQS = System.currentTimeMillis();
	//System.out.println("\nSorting Process Started at " + startTime);
	
	//Driver Code Implementing the Basic Quick Sort 
	//Array after Quick Sort Algorithm
	basicQuickSortAlgorithm(0, inputArrayBasicQS.length-1,inputArrayBasicQS);
	
	for (int i =0; i< inputArrayBasicQS.length; i++){
	  //System.out.println(inputArray[i]); // print the response
	}
	System.out.println("\nAfter Basic Quick Sort Algorithm ");
	System.out.println(Arrays.toString(inputArrayBasicQS));
	long endTimeBasicQS = System.currentTimeMillis();
	System.out.println("It took " + (endTimeBasicQS - startTimeBasicQS) / Math.pow(10, 9) + " nanoseconds");
	System.out.println("##############################################################");	   
//-------------------------------------------------------------------------------------------------//
/*
* Median of 3 Quick Sort
*/	
	int inputArrayMedianQS[] = new int[1050];
	
	try (Scanner scMedianQS = new Scanner(new FileReader("input_Sorted.txt"))) {
		int i = 0;
		while(scMedianQS.hasNextInt()) {
			inputArrayMedianQS[i++] = scMedianQS.nextInt();
		}
		scMedianQS.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	
	//Array before the Quick Sort Algorithm
	System.out.println("\nInput Array before Median of 3 Quick Sort: ");
	System.out.println(Arrays.toString(inputArrayMedianQS));
	long startTimeMedianQS = System.currentTimeMillis();
	//System.out.println("\nSorting Process Started at " + startTime);
	
	//Driver Code Implementing the Sorting 
	//Array after Quick Sort Algorithm
	medianOf3quickSortAlgorithm(0, inputArrayMedianQS.length-1,inputArrayMedianQS);
	
	for (int i =0; i< inputArrayMedianQS.length; i++){
	  //System.out.println(inputArray[i]); // print the response
	}
	System.out.println("\nArray after Median of 3 Quick Sort ");
	System.out.println(Arrays.toString(inputArrayMedianQS));
	long endTimeMedianQS = System.currentTimeMillis();
	System.out.println("It took " + (endTimeMedianQS - startTimeMedianQS) / Math.pow(10, 9) + " nanoseconds");
	System.out.println("##############################################################");	   
	}
}

