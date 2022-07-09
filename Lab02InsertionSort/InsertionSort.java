package Lab02InsertionSort;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//	Implement insertion sort algorithm
//	Evaluate performance of insertion sort with increasing array size 

//	Implement a method that will sort a given array using the insertion
//	sort algorithm (given below).
//	
//	Write a driver program to test the insertion algorithms 
//	implemented  in  Question  1.
//	Read  the input file “input_100.txt” for the input numbers 
//	and store them in an array.
//	Sort this array using insertion sort.
//

public class InsertionSort {

	// Read and Scan Files
	public static void main(String[] args) throws IOException {

		// Driver method for Ascending Sorting
		Integer[] inputArray1 = scanFile();
		System.out.println("\nInput Array before Ascending Insertion Sort:");
		System.out.println(Arrays.toString(inputArray1));
		long startTime = System.currentTimeMillis();
		insertionSort(inputArray1, "Asscending");
		long endTime = System.currentTimeMillis();
		System.out.println("\nAfter Ascending Sorted Insertion Sort: ");
		System.out.println(Arrays.toString(inputArray1));
		System.out.println("Ascending Sorted Insertion Sort took for given inputArray size " + (endTime - startTime)
				+ " milliseconds");

		// ________________________________________________________________________________________
		//
		// Driver method for Descending Sorting
		Integer[] inputArray2 = scanFile();
		System.out.println("\nInput Array before Descending Insertion Sort:");
		System.out.println(Arrays.toString(inputArray2));
		long startTime2 = System.currentTimeMillis();
		insertionSort(inputArray2, "Descending");
		long endTime2 = System.currentTimeMillis();
		System.out.println("\nAfter Descending Sorted Insertion Sort: ");
		System.out.println(Arrays.toString(inputArray2));
		System.out.println("Reverse Sorted Insertion Sort took for given inputArray size " + (endTime2 - startTime2)
				+ " milliseconds");

	}

	private static Integer[] scanFile() {
		List<Integer> inputList = new ArrayList<Integer>();
		Integer[] inputArray = {}; // Initializing Array
		try (Scanner sc = new Scanner(new FileReader("input_50000.txt"))) {
			while (sc.hasNext()) {
				if (sc.hasNextInt()) {
					inputList.add(sc.nextInt());
				}
			}
			inputArray = inputList.toArray(new Integer[0]); // Converting ArrayList into Array
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return inputArray;
	}

	public static void insertionSort(Integer arr[], String sortOrder) {
		// set n = length of array
		int n = arr.length;
		for (int j = 1; j < n; j++) {

			int key = arr[j];
			// inserting array into sorted sequence
			int i = j - 1;

			// comparing the key elements with previous elements
			// array of index starts from 0 thus we must state -1
				while (((i >= 0 && arr[i] > key) && sortOrder.equals("Ascending")) || ((i >= 0 && arr[i] < key) && sortOrder.equals("Descending"))) {
				// If previous element is greater than element then move previous element to
				// next position.
				// Compare against key in array
				arr[i + 1] = arr[i];
				// put element according to order of elements
				i = i - 1;
			}
			arr[i + 1] = key;
		}
	} 

}
