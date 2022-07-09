package Lab05QuickSort;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class medianOf3QuickSort {
	public static void main(String args []) throws IOException {

		int inputArray[] = new int[100];

		try (Scanner sc = new Scanner(new FileReader("input_100.txt"))) {
			int i = 0;
			while(sc.hasNextInt()) {
				inputArray[i++] = sc.nextInt();
			} 
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

        //Array before the Quick Sort Algorithm
        System.out.println("\nInput Array before Quick Sort: ");
        System.out.println(Arrays.toString(inputArray));
        long startTime = System.currentTimeMillis();
        //System.out.println("\nSorting Process Started at " + startTime);

        //Driver Code Implementing the Sorting 
        //Array after Quick Sort Algorithm
        medianOf3quickSortAlgorithm(0, inputArray.length-1,inputArray);
        long endTime = System.currentTimeMillis();

       for (int i =0; i< inputArray.length; i++){
          //System.out.println(inputArray[i]); // print the response
      }
        System.out.println("\nInput Array after Quick Sort ");
        System.out.println(Arrays.toString(inputArray));
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
    }

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
            	exchangeElements(i, j, QSArray);
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
    public static void exchangeElements(int i, int j, int[] QSArray){
        int temp = QSArray[i];
        QSArray[i] = QSArray[j];
        QSArray[j] = temp;
    }
}