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
 * 5.  Modify all algorithms you have implemented so far to sort in the reverse order.
 * Run the modified algorithms using the given input files(inside the lab7/InputFilesfolder).
 * Compare the performance of the algorithms.
 */

public class selectionSort {

    // Read and Scan Files
    public static void main(String[] args) throws IOException {
    	//Driver Method for Ascending Sorted
        Integer[] inputArray1 = scanFile();
        System.out.println("\nInput Array before Ascending Selection Sort:");
        System.out.println(Arrays.toString(inputArray1));
        long startTime = System.currentTimeMillis();
        selectionSort.selectionSortAlgorithm(inputArray1,"Ascending");
        long endTime = System.currentTimeMillis();
        System.out.println("\nAfter Sorted Selection Sort: ");
        System.out.println(Arrays.toString(inputArray1));
        System.out.println("Ascending Selection Sort took for given inputArray size " + (endTime - startTime) + " milliseconds");

//________________________________________________________________________________________
//
         //Driver Method for Descending Sorted
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
        Integer[] inputArray2 = scanFile();
        System.out.println("\nInput Array before Descending  Selection Sort:");
        System.out.println(Arrays.toString(inputArray2));
        long startTimeReverse = System.currentTimeMillis();
        selectionSort.selectionSortAlgorithm(inputArray2,"Descending");
        long endTimeReverse = System.currentTimeMillis();
        System.out.println("\nAfter Descending Selection Sort: ");
        System.out.println(Arrays.toString(inputArray2));
        System.out.println("Descending Selection Sort took for given inputArray size " + (endTimeReverse - startTimeReverse) + " milliseconds");
    }

    private static Integer[] scanFile() {
        List<Integer> inputList = new ArrayList<Integer>();
        Integer[] inputArray ={};  // Initializing Array
        try (Scanner sc = new Scanner(new FileReader("input_50000.txt"))) {
            while (sc.hasNext()){
                if(sc.hasNextInt()){
                    inputList.add(sc.nextInt());
                }
            } 
            inputArray = inputList.toArray(new Integer[0]);  // Converting ArrayList into Array
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        return inputArray;
    }

    public static void selectionSortAlgorithm(Integer[] arr, String sortOrder) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Searches list to find the smallest item in the array and moves it to first
            // position
            // i loop: incrementing with each element one by one moving pointer of unsorted
            // array

            int smallestElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // Find the smallest element in unsorted array
                // j loop: comparing each element in the list with the i also known as the
                // smallest element of subarray starts at first unsorted item continuing through
                // last item in list

                // if j less than smallest element then swap!
                if (arr[smallestElementIndex] > arr[j] && sortOrder.equals("Ascending") || arr[smallestElementIndex] < arr[j] && sortOrder.equals("Descending")) {
                    smallestElementIndex = j;
                }
            }
            // Swap new smallest element with current small element
            if (smallestElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[smallestElementIndex];
                arr[smallestElementIndex] = temp;
            }

        }

    }

}