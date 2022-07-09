package Lab07;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.Scanner;

/*Implement a method to sort a given array using basic selection sort algorithm.
 * Sample algorithm is provided(see page 2)
 * 2. Implement a method to sort a given array using basic bubble sort algorithm.
 * Sample algorithm is provided(see page 2)
 * 3. Compare the performance of the selection sort algorithm with 3 cases of
 * input files:sorted,reversed sorted,and random.
 * 4.Compare the performance of the bubble sort algorithm with 3 cases of
 * input files:sorted,reversed sorted,and random.
 * Modify all algorithms you have implemented so far to sort in the reverse order.
 * Run the modified algorithms using the given input files(inside the lab7/InputFilesfolder).
 * Compare the performance of the algorithms.
 */

public class bubbleSort {

	// Read and Scan Files
	public static void main(String[] args) throws IOException {

		{
			// Driver method for Sorting
			Integer[] inputArray1 = scanFile();
			System.out.println("\nInput Array before Bubble Sort:");
			System.out.println(Arrays.toString(inputArray1));
			long startTime = System.currentTimeMillis();
			bubbleSort.bubbleSortAlgorithm(inputArray1, "Ascending");
			long endTime = System.currentTimeMillis();
			System.out.println("\nAfter Sorted Bubble Sort: ");
			System.out.println(Arrays.toString(inputArray1));
			System.out.println("Ascending Bubble Sort took for given inputArray size " + (endTime - startTime) + " milliseconds");
//________________________________________________________________________________________

//
			// Driver Method for Descending Sorted
			System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
			Integer[] inputArray2 = scanFile();
			System.out.println("\nInput Array before Descending Bubble Selection Sort:");
			System.out.println(Arrays.toString(inputArray2));
			long startTime2 = System.currentTimeMillis();
			bubbleSort.bubbleSortAlgorithm(inputArray2, "Descending");
			long endTime2 = System.currentTimeMillis();
			System.out.println("\nAfter Descending Bubble Sort: ");
			System.out.println(Arrays.toString(inputArray2));
			System.out.println("Descending Sorted Bubble Sort took for given inputArray size " + (endTime2 - startTime2)
					+ " milliseconds");
		}
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

	public static void bubbleSortAlgorithm(Integer[] arr, String sortOrder) {
		int arrayLength = arr.length;
		for (int i = 0; i < arrayLength - 1; i++) {

			// run from j to end of array -i where i is the number of elements already
			// sorted
			for (int j = 0; j < arrayLength - i - 1; j++) {
				// Repeatedly comparing adjacent elements. Make sure largest element is on the
				// right
				if (((arr[j] >= arr[j + 1]) && sortOrder.equals("Ascending"))

						|| ((arr[j] <= arr[j + 1]) && sortOrder.equals("Descending"))) {

					// swapping j+1 and j to satisfy largest element is on the right side between
					// two elements being compared
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}