package Lab03MergeSort;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mergeSortLab03 {

    //Read and Scan Files
    public static void main(String args []) throws IOException {



        //Driver Code Implementing the Sorting
        Integer[] inputArray1 = scanFile();
        System.out.println("\nInput Array before Ascending Merge Sort: ");
        System.out.println(Arrays.toString(inputArray1));
        int[] tempArray1 = new int[inputArray1.length];  // Temp array to store split results.
        long startTime1 = System.currentTimeMillis();
        //System.out.println("\nSorting Process Started at " + startTime);
        mergeSort(inputArray1, tempArray1, 0 , inputArray1.length-1, "Ascending");
        long endTime1 = System.currentTimeMillis();
        //System.out.println("\nSorting Process Ended at " + endTime);
        System.out.println("\nInput Array After Ascending Merge Sort: ");
        System.out.println(Arrays.toString(inputArray1));
        System.out.println("It took " + (endTime1 - startTime1)  + " milliseconds");


        //Driver Code Implementing the Reverse Sorting
        Integer[] inputArray2 = scanFile();
        System.out.println("\nInput Array before Descending Merge Sort: ");
        System.out.println(Arrays.toString(inputArray2));
        int[] tempArray2 = new int[inputArray2.length];  // Temp array to store split results.
        long startTime2 = System.currentTimeMillis();
        //System.out.println("\nSorting Process Started at " + startTime);
        mergeSort(inputArray2, tempArray2, 0 , inputArray2.length-1, "Descending");
        long endTime2 = System.currentTimeMillis();
        //System.out.println("\nSorting Process Ended at " + endTime);
        System.out.println("\nInput Array After Descending Merge Sort: ");
        System.out.println(Arrays.toString(inputArray2));
        System.out.println("It took " + (endTime2 - startTime2)  + " milliseconds");

    }
    // Merges two subarrays of arr[].

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

    private static void mergeSort(Integer[] A, int[] temp, int p, int r, String SortOrder){

        if(p < r) {

            // Midpoint of array
            int q = (p + r) / 2;

            //Splitting until one element is remaining
            mergeSort(A, temp, p, q, SortOrder);
            mergeSort(A, temp,q + 1, r, SortOrder);

            //Sort and split
            merge(A,temp,p,r,q, SortOrder);
        }
    }

    private static void merge(Integer[] A, int[] temp, int p, int r, int q, String SortOrder){

        // Copying into temp array
        for(int i =p ; i<= r ; i++){
            temp[i] = A[i];
        }
        int i = p; //Left
        int j = q+1;  //Right copied
        int k = i; //Sort and Merge


        //Iterate through the temp array.Compare the right and left half , copy the smallest element from the 2 array to original

        while(i <=q && j <= r){
            if((temp[i] <temp[j] && SortOrder.equals("Ascending")) || (temp[i] >=temp[j] && SortOrder.equals("Descending"))){
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

//copy left side of array to temp array
        int l= q-i;
        for (int m = 0 ; m<= l; m++){
            A[k+m] = temp[i+m];
        }
    }
}
