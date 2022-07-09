package Lab05QuickSort;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class basicQuickSort {
    // Read and Scan Files
    public static void main(String[] args) throws IOException {


        // Driver method for Ascending Sorting 
        Integer[] inputArray1 = scanFile();
        System.out.println("\nInput Array before Ascending Quick Sort:");
        System.out.println(Arrays.toString(inputArray1));
        long startTime = System.currentTimeMillis();
        basicQuickSortAlgorithm(0, inputArray1.length - 1, inputArray1, "Ascending");
        long endTime = System.currentTimeMillis();
        System.out.println("\nAfter Ascending Sorted Quick Sort: ");
        System.out.println(Arrays.toString(inputArray1));
        System.out.println("Ascending Sorted Quick Sort took for given inputArray size " + (endTime - startTime) + " milliseconds");

        //________________________________________________________________________________________
        //
        // Driver method for Descending Sorting
        Integer[] inputArray2 = scanFile();
        System.out.println("\nInput Array before Descending Quick Sort:");
        System.out.println(Arrays.toString(inputArray2));
        long startTime2 = System.currentTimeMillis();
        basicQuickSortAlgorithm(0, inputArray2.length - 1, inputArray2, "Descending");
        long endTime2 = System.currentTimeMillis();
        System.out.println("\nAfter Descending Sorted Quick Sort: ");
        System.out.println(Arrays.toString(inputArray2));
        System.out.println("Reverse Sorted Quick Sort took for given inputArray size " + (endTime2 - startTime2) + " milliseconds");

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

    public static Integer[] basicQuickSortAlgorithm(int left, int right, Integer[] QSArray, String sortOrder) {

        if (left < right) {
            // pivot is correct after partitioning the list into two
            // figure out pivot location
            int partition = partition(left, right, QSArray, sortOrder);

            // recursive function for sorting left side of pivot
            basicQuickSortAlgorithm(left, partition - 1, QSArray, sortOrder);
            // recursive function for sorting right side of pivot
            basicQuickSortAlgorithm(partition + 1, right, QSArray, sortOrder);

        }
        return QSArray;
    }

    public static int partition(int left, int right, Integer[] QSArray, String sortOrder) {

        // basic Quick Sort implies we choose last element as pivot
        int pivotPoint = QSArray[right];
        int exchange = left;

        // if i is < pivot then exchange location and ++ exchange to next element
        for (int i = left; i <= right - 1; i++) {
            if ((QSArray[i] <= pivotPoint && sortOrder.equals("Ascending")) || (QSArray[i] >= pivotPoint && sortOrder.equals("Descending")) ) {
                exchangeElements(exchange, i, QSArray);
                exchange++;
            }
        }
        // exchange pivot with element on other side. Completion of this step is when
        // pivot is in sorted location
        exchangeElements(exchange, right, QSArray);
        return exchange;
    }

    // exchange element
    public static void exchangeElements(int i, int j, Integer[] QSArray) {
        int temp = QSArray[i];
        QSArray[i] = QSArray[j];
        QSArray[j] = temp;
    }
}