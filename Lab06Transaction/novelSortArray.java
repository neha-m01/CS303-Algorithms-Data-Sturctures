package Lab06;

import java.util.Arrays;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class novelSortArray {
	
	// Driver code to test the novel sorting algorithm
	public static void main(String args[]) throws IOException {

		novelSortArray nsa = new novelSortArray();

		// Read and Scan Files
		// Reading file given the input and editing count given the size.
		int count = 5000;
		int inputArray[] = new int[count];
		try {
			Scanner s = new Scanner(new FileReader("input_5000.txt"));
			for (int i = 0; i < count; i++) {
				inputArray[i] = s.nextInt();
			}
			s.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("\nOriginal UnSorted array: ");
		System.out.print(Arrays.toString(inputArray));
		long startTime = System.currentTimeMillis();
	    //System.out.println("\nSorting Process Started at " + startTime);

	    //Driver Code Implementing the Sorting 
		nsa.novelSort(inputArray);
	    long endTime = System.currentTimeMillis();

		System.out.println("\n");
		System.out.println("\nSorted array: ");
		System.out.print(Arrays.toString(inputArray));
		System.out.println("\nIt took " + (endTime - startTime) + " milliseconds");

	}

    public void novelSort(int inputArray[]) {
    	
    	//creating a variable for length of the inputArrayy.
        int inputArraySize = inputArray.length;

        //Creating a for loop for half the size of the array since we are finding smallest element and largest element in one loop
        for (int i = 0; i <= inputArraySize / 2; i++) {
            //Because the array gets shortened every time (-2) as we find the new smallest and largest element, i continuosly changes as well
            int startIndex = i;
            int endIndex = i-1;
        	
            // Find the smallest element and its index in the array
            int smallestElement = inputArray[i];
            //start from the new beginning after i number of elements and increment till the new end of array
            for (int j = i + 1; j < inputArraySize - i; j++) {
            	//if j is less than current smallest element then insert the smallest element in it's correct index which is the start of the "new" array
                if (inputArray[j] < smallestElement) {
                    smallestElement = inputArray[j]; 
                    startIndex = j;
                }
            }

            // Find the largest element and its index in the array
            int largestElement = inputArray[i];
            ////start from the new beginning after i number of elements and increment till the new end of array
            for (int j = i + 1; j < inputArraySize - i; j++) {
            	//if j is greater than current largest element then insert the largest element in it's correct index which is the end of the "new" array
                if (inputArray[j] > largestElement) {
                    largestElement = inputArray[j]; 
                    endIndex = j;
                }
            }
            //This is my exchange function for the given smallest and largest elements: 
            
            // Moving smallest element to the last array index of current for loop (i) it is in
            smallestElement = inputArray[startIndex];
            inputArray[startIndex] = inputArray[i];
            inputArray[i] = smallestElement;

            // Moving largest element to the last array index of current for loop (i) it is in
            largestElement = inputArray[endIndex];
            inputArray[endIndex] = inputArray[inputArraySize - i - 1];
            inputArray[inputArraySize - i - 1] = largestElement;
        }
    }
}