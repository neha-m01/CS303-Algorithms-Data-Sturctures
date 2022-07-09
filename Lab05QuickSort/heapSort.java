package Lab04HeapSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class heapSort {

	public static void main(String[] args) throws IOException {

		// instantiate new object in class
		heapSort heap = new heapSort();
		List<Integer> input_array = new ArrayList<>();

		scanFiles(input_array);

		// Print Unsorted Array (before MaxHeap sorting algorithm)
		System.out.println("Unsorted Array for HeapSort: " + input_array);

		// calculate elapsed time in nanoseconds
		int size = input_array.size();

		// start time
		long startTime = System.currentTimeMillis();

		// Build Max Heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			heap.MaxHeapify(input_array, i, size);
		}
		for (int i = size - 1; i >= 0; i--) {
			Collections.swap(input_array, i, 0);
			heap.MaxHeapify(input_array, 0, i);
		}
		long endTime = System.currentTimeMillis();
		// end time
		System.out.println("\nAscending Array for HeapSort" + input_array);
		System.out.println("It took " + (endTime - startTime) + " milliseconds");

		// ________________________________________________________________________________________
		//
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------");

		// Driver Method for Reverse Sorted
		List<Integer> input_array2 = new ArrayList<>();
		scanFiles(input_array2);
		
		System.out.println("Unsorted Array for Descending HeapSort: " + input_array2);

		// calculate elapsed time in nanoseconds
		int sizeRev = input_array.size();

		// start time
		long startTimeReversed = System.currentTimeMillis();

		// Build Max Heap
		for (int i = sizeRev / 2 - 1; i >= 0; i--) {
			heap.MaxHeapify(input_array, i, sizeRev);
		}
		for (int i = sizeRev - 1; i >= 0; i--) {
			Collections.swap(input_array, i, 0);
			heap.MaxHeapifyReversed(input_array, 0, i);
		}
		long endTimeReversed = System.currentTimeMillis();
		// end time
		System.out.println("\nSorted Array for Descending HeapSort" + input_array);
		System.out.println("It took " + (endTimeReversed - startTimeReversed) + " milliseconds");
	}

	private static List<Integer> scanFiles(List<Integer> input_array) {
		// Scan in file and write to Array List
		try {
			File file = new File("input_50000.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				if (sc.hasNextInt()) {
					input_array.add(sc.nextInt());
				} else {
					sc.next();
				}
			}
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return input_array;
	}

	// MaxHeap Algorithm Logic following Pseudo Code provided by Professor Unan
	public void MaxHeapify(List<Integer> integer, int index, int size) {
		int largest = index;
		int left = (2 * index) + 1;
		int right = (2 * index) + 2;

		if (left < size && integer.get(left) > integer.get(largest)) {
			largest = left;
		}
		if (right < size && integer.get(right) > integer.get(largest)) {
			largest = right;
		}
		if (largest != index) {
			Collections.swap(integer, index, largest);
			MaxHeapify(integer, largest, size);
		}
	}

	// MaxHeap Algorithm Logic following Pseudo Code provided by Professor Unan
	public void MaxHeapifyReversed(List<Integer> integer, int index, int size) {
		int largest = index;
		int left = (2 * index) + 1;
		int right = (2 * index) + 2;

		if (left < size && integer.get(left) < integer.get(largest)) {
			largest = left;
		}
		if (right < size && integer.get(right) < integer.get(largest)) {
			largest = right;
		}
		if (largest != index) {
			Collections.swap(integer, index, largest);
			MaxHeapifyReversed(integer, largest, size);
		}
	}
}