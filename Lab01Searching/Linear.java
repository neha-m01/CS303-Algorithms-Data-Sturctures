package Lab01Searching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Linear {
	// Recursive Java program to search x in array

	public static void main(String[] args) throws IOException {
		
		File file = new File("/Users/nehamoolchandani/Downloads/input_1000.txt");
		
		//int[] intArray = new int[] {};
		int count = 1000;
		int num[] = new int[count];

		Scanner scanner = new Scanner(file);
		try (Scanner s = new Scanner(new FileReader("/Users/nehamoolchandani/Downloads/input_1000.txt"))) {
			for (int i = 0; i < count; i++) 
	        {
	            num[i] = s.nextInt();
	        }
		  }
		    
			/*
			 * System.out.print("Array Elements in Original Order: "); for (int i = 0; i <
			 * count - 1; i++) { System.out.print(num[i] + ", "); }
			 * System.out.print(num[count - 1]);
			 */
		
		//Sorting 
		int temp;
			for (int i = 0; i < count; i++) 
	        {
	            for (int j = i + 1; j < count; j++) { 
	                if (num[i] > num[j]) 
	                {
	                    temp = num[i];
	                    num[i] = num[j];
	                    num[j] = temp;
	                }
	            }
	        }
       
	        System.out.print("Array Elements in Ascending Order: ");
	        for (int i = 0; i < count - 1; i++) 
	        {
	            System.out.print(num[i] + ", ");
	        }
	        System.out.print(num[count - 1]);
		   
	        int n = num.length;
	        
	        //Number Searched for is x:40
	        int x = 40;
	        int y=0;
	        for (int i = 0; i < n; i++)
	        {
	            y=i;
	        	if (num[i] == x)
	               System.out.println("\nThe location of number to be searched is " + (i+1));
	           
	        }
	        if (y == n)
	        System.out.println("Number not found");

	}
}