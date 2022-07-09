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

public class Linear2powern{
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
			        
			        File file = new File("/Users/nehamoolchandani/Downloads/input_1000.txt");
			        int count2=1000;

					Scanner scanner = new Scanner(file);
					
					try (Scanner s = new Scanner(new FileReader("/Users/nehamoolchandani/Downloads/input_1000.txt"))) {
						
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