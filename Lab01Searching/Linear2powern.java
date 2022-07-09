package Lab01Searching;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Linear2powern{
	public static void main(String[] args) throws IOException{
		
		//Insert n number for array size (test cases from 16,32,...,2^25)
			int n = 16;
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
		    
		        int count2=1000;
				
				try (Scanner sc = new Scanner(new FileReader("input_100.txt"))) {
					
					for (int i = 0; i < count2; i++) 
			        {
						//Number Searched for is x:40
				        int x = sc.nextInt();
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