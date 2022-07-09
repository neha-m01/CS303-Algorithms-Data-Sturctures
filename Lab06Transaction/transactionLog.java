package Lab06;

import java.io.*;
import java.util.*;

class transactions {
	String city, time;

	// create a this to reference the object of city and time within this class
	public transactions(String city, String time) {
		this.city = city;
		this.time = time;
	}
}

public class transactionLog {
	// Driver Code
	public static void main(String[] args) throws IOException {

		// Creating ArrayList of all Logs from Transaction Log file using Scanner
		ArrayList<transactions> transactionsLog = new ArrayList<transactions>();
		try {
			Scanner sc = new Scanner(new FileReader("NovelSortInput.txt"));
			String currentLine = "";
			String city = "";
			String time = "";
			int size = 0;
			
			// while (currentLine != null) then do this:
			while (sc.hasNext()) {
				currentLine = sc.nextLine();
				// If there is blank line between two logs, skip this and go back to start of while loop
				if (currentLine != "") {
					size = size + 1;
					String[] transactionDetail = currentLine.split(" ");
					city = transactionDetail[0];
					time = transactionDetail[1];
					//create new object from city and time
					transactionsLog.add(new transactions(city, time));
				}
			}
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		transactionSort(transactionsLog, transactionsLog.size());
	}

	// create an ArrayList called transactionsLogArray
	public static void transactionSort(ArrayList<transactions> transactionsLog, int size) {
		transactions[] transactionsLogArray = new transactions[size];

		// n is the counter and looping through size for city and time
		int counter = 0;
		while (counter < size) {
			// Initializing Array one for city and one for time
			transactionsLogArray[counter] = new transactions("", "");
			// Store the City in the array
			transactionsLogArray[counter].city = transactionsLog.get(counter).city;
			// Store the time in the array
			transactionsLogArray[counter].time = transactionsLog.get(counter).time;
			// increment n by 1 until = size
			counter++;
		}
		// Insertion Sort: If the key element is smaller than its predecessor, compare
		// it to the elements before. Move the larger elements one position forward for
		// space within swapped element.
		for (int j = 1; j < size; j++) {
			transactions key = transactionsLogArray[j];
			int i = j - 1;
			// comparing string to string city 
			while (i >= 0 && transactionsLogArray[i].city.compareTo(key.city) > 0) {
				transactionsLogArray[i + 1] = transactionsLogArray[i];
				i = i - 1;
			}
			transactionsLogArray[i + 1] = key; 
		}

		// Insertion Sort: If the key element is smaller than its predecessor, compare
		// it to the elements before. Move the larger elements one position forward for
		// space within swapped element.
		for (int j = 1; j < size; j++) {
			transactions key = transactionsLogArray[j];
			int i = j - 1;
			// comparing string to string times if next array elements have same city
			while (i >= 0 && transactionsLogArray[i].city.compareTo(key.city) == 0
					&& transactionsLogArray[i].time.compareTo(key.time) > 0) {
				transactionsLogArray[i + 1] = transactionsLogArray[i];
				i = i - 1;
			}
			transactionsLogArray[i + 1] = key;
		}

		// Now writing output...
		//Using PrintWriter
		File outputFile = new File("Sorted Transaction Log:" + "NovelSortOutput.txt"); 
		PrintWriter Output = null;
		try { 
			Output = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// following statement write the sorted log records into output
		for (int i = 0; i < size; i++) {
			Output.print(transactionsLogArray[i].city);
			Output.print(" ");
			Output.print(transactionsLogArray[i].time);
			Output.println();
			// System.out.println(""+arraytransactions[i].city+"
			// "+arraytransactions[i].time);
		}
		Output.close();
	}

}