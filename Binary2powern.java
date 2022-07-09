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

public class Binary2powern{
	public static void main(String[] args) throws IOException{
	
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

			        //the number to be searched

			        File file = new File("/Users/nehamoolchandani/Downloads/input_1000.txt");
			        int count2=1000;

					Scanner scanner = new Scanner(file);
					
					try (Scanner s = new Scanner(new FileReader("/Users/nehamoolchandani/Downloads/input_1000.txt"))) {
						
						for (int i = 0; i < count2; i++) 
				        {
					        int numSearch = s.nextInt();
					        System.out.println("\nThe number to be searched=" + numSearch);
					        //set first to first index
					        int first = 0;
					        //set last to last elements in array
					        int last=inputArray.length-1;
					        //calculating mid of the array
					        int mid = (first + last)/2;  
					        //while first and last do not overlap
					        while( first <= last ){  
					            //if the mid < numSearch, then numSearch to be searched is in the first half of array
					            if ( inputArray[mid] < numSearch ){  
					                first = mid + 1;    
					            }else if ( inputArray[mid] == numSearch ){
					                //if key = element at mid, then print the location
					                System.out.println("Number to be searched is found at index: " + mid);  
					                break;  
					            }else{  
					                //the key is to be searched in the second half of the array
					                last = mid - 1;  
					            }  
					            mid = (first + last)/2;  
					       }  
					       //if first and last overlap, then key is not present in the array
					       if ( first > last ){  
					          System.out.println("Number to be searched is not found!");  
					     }      
				      } 
					}
				}
}
	