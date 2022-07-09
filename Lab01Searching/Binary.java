package Lab01Searching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Binary{
	public static void main(String[] args) throws IOException{
		
		
				
		//int[] intArray = new int[] {};
		
		int n = 1048;
		int inputArray[] = new int[n];
		Random rand = new Random();
				
		for (int i = 0; i < n; i++) 
	        {
	         inputArray[i] = rand.nextInt(n);
	        }
			  
				
		int temp;
 
		for (int i = 0; i < n; i++) 
			{
				for (int j = i + 1; j < n; j++) { 
	                if (inputArray[i] > inputArray[j]) 
		                {
	                    temp = inputArray[i];
	                    inputArray[i] = inputArray[j];
	                    inputArray[j] = temp;
		                }
		            }
	        }
			       
        System.out.print("Array Elements in Ascending Order: ");
        
		for (int i = 0; i < n - 1; i++) 
		{
		    System.out.print(inputArray[i] + ", ");
		}
		System.out.print(inputArray[n - 1]); 
		
		File file = new File("input_1000.txt");
		int count2=1000;
		
		Scanner scanner = new Scanner(file);
		
		try (Scanner s = new Scanner(new FileReader("input_1000.txt"))) {
			
			for (int i = 0; i < count2; i++) 
		    {
				//Number Searched for is x:40
		        int x = s.nextInt();
		        int y=0;
		        for (int k = 0; k < n; k++)
		        {
		            y=k;
		        	if (inputArray[k] == x)
		               System.out.println("\nThe location of number to be searched is " + (k+1));
		           
		        }
		        if (y == n)
		        System.out.println("Number not found");
		    }
		}
		
	}
}

		class BinarySearch {
			
		    // Returns index of x if it is present in arr[start..end], else return -1
		    int binarySearch(int arr[], int start, int end, int indexX)
		    {
		        if (end >= start) {
		            int mid = start + (end - start) / 2;
		  
		            // If the element is present at the
		            // middle itself
		            if (arr[mid] == indexX)
		                return mid;
		  
		            // If element is smaller than mid, then
		            // it can only be present in left subarray
		            if (arr[mid] > indexX)
		                return binarySearch(arr, start, mid - 1, indexX);
		  
		            // Else the element can only be present
		            // in right subarray
		            return binarySearch(arr, mid + 1, end, indexX);
		        }
		  
		        // We reach here when element is not present
		        // in array
		        return -1;
		    }
		  
		    // Driver method to test above
		    {
		        BinarySearch ob = new BinarySearch();
		        int arr[] = { 2, 3, 4, 10, 40 };
		        int n = arr.length;
		        int x = 10;
		        int result = ob.binarySearch(arr, 0, n - 1, x);
		        if (result == -1)
		            System.out.println("Element not present");
		        else
		            System.out.println("Element found at index " + result);
		    }
		}
	
