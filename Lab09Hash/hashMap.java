package Lab09;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

class transactions {
	BigInteger UPCKey;
	String description;

	public transactions(BigInteger UPCKey, String description) {
		this.UPCKey = UPCKey;
		this.description = description;
	}
}

public class hashMap {

	// Blank array of HashElement objects
	private HashElement map[];

	// Count of elements
	private int count;

	// Creating constructor
	public hashMap(int length) {

		// initialize array of 100 HashElements
		map = new HashElement[length];

		// initially empty
		count = 0;
	}

	// Now lets add a key-value pair at appropriate position if Hashmap is not full
	public String put(BigInteger key, String value, String probing) {

		// finding hash key
		int counter = 0;
		int hash = hash(key);
		String result = "";

		// if Hashmap position is blank, adding new HashElement

		if (map[hash] == null) {
			map[hash] = new HashElement(key, value);
			count++; // updating count
			result = "Inserted";
		}

		// if Hashmap position is not blank, validating if keys are same
		else if (map[hash].key == key) {
			map[hash].value = value; // updating value
			result = "Updated";
		} else {

			// now validating if Hashmap is full
			if (count == map.length) {
				System.out.println("The hashmap is full");
				result = "Not Inserted";
				return result;
			}
			// Function Probing
			if (probing.equalsIgnoreCase("F")) {
				// implementing logic with secondary hash to remove collisions using standard
				// function
				hash = hash2(hash);
			}
			// Linear Probing
			else if (probing.equalsIgnoreCase("L")) {
				// implementing logic with secondary hash to remove collisions using standard
				// function
				counter++;
				hash = hashLinear((hash), counter);
			} else if (probing.equalsIgnoreCase("Q")) {
				// implementing logic with secondary hash to remove collisions using standard
				// function
				counter++;
				hash = hashQuadratic((hash), counter);
			}
			// looping as long as position hash is not empty
			while (map[hash] != null) {

				// validating if position contains the same key
				if (map[hash].key == key) {
					map[hash].value = value; // updating value and returning
					result = "Inserted";
				}

				// another hashing with old hash
				if (probing.equalsIgnoreCase("F")) {
					hash = hash2(hash);
					
				} else if (probing.equalsIgnoreCase("L")) {
					hash = hashLinear((hash), counter);
				}
				if (probing.equalsIgnoreCase("F")) {
					hash = hashQuadratic((hash), counter);
				}
			}

			// by this time we will find an empty slot. So adding a new key value pair

			// Adding HashElements and updating count
			map[hash] = new HashElement(key, value);
			count++;

		}

		return result;
	}

	// Method to find hash for given key
	private int hash(BigInteger key) {
		// return key % map.length;
		return (key.mod(BigInteger.valueOf(map.length))).intValue();
	}

	// method for hashing the hash to remove collisions using given function
	private int hash2(int hash1) {
		return (7 * hash1 + 1) % map.length;

	}

	// method for hashing the hash to remove collisions using given function
	private int hashLinear(int hash1, int counter) {
		return (hash1 + counter) % map.length;

	}

	// method for hashing the hash to quadratic collisions using given function
	private int hashQuadratic(int hash1, int counter) {
		return (hash1 + (counter * counter)) % map.length;

	}

	// a method that returns all elements in hashmap as a String
	public String toOutput() {
		String data = "[";
		int c = 0;
		// appending all elements to data separated by comma
		for (int i = 0; i < map.length; i++) {
			if (map[i] != null) {
				data += map[i];
				c++;
				// if there are more values, appending a comma and space
				if (c != count) {

					data += ", ";
				}
			}
		}
		data += "]";
		return data;
	}

	public void get(BigInteger key) {
		int hash = hash(key);
		if (map[hash] == null || map[hash].value == null) {
			System.out.println("Either Hashmap is Null or there is no value for the key");
		} else if (map[hash].key.equals(key)) {
			System.out.println("The value for the key " + key + " is: " + map[hash].value); // Extracting value
		}

	}

	public static void main(String[] args) {
		// int length1 = 10;
		hashMap map = new hashMap(100);
		// System.out.println("this is map output: "+ map.toOutput());
		Scanner scan = new Scanner(System.in);
		String aKey = "";
		String aValue = "";
		String q = "";
		String additionalInput = "";
		String action = "";
		String filename = "";
		String probing = "";
		System.out.print(
				"Do you want to put values in Hashmap or Get Values in Hashmap: Enter G for 'Get' or P for 'Put' or any other key to Exit: ");
		q = scan.nextLine();
		// System.out.println("You entered: " + q);
		while (q != null || q.equalsIgnoreCase("Y")) {
			if (q.equalsIgnoreCase("P")) {
				System.out.println(
						"Do you want Manual data entry or via Data File. Enter M Manual or F for Filename or any other key to Exit ");
				filename = scan.nextLine();
				additionalInput = "";
				// while (additionalInput.equalsIgnoreCase("Y") ||
				// additionalInput.equalsIgnoreCase("")) {
				if (filename.equalsIgnoreCase("M")) {
					int length1 = 10;
					map = new hashMap(length1);
					while (additionalInput.equalsIgnoreCase("Y") || additionalInput.equalsIgnoreCase("")) {
						// System.out.println("this is map output: "+ map.toOutput());
						System.out.print("Enter Key Now: ");
						aKey = scan.nextLine();
						System.out.print("Enter Value Now: ");
						aValue = scan.nextLine();
						BigInteger Key = new BigInteger(String.valueOf(aKey));

						// Beginning Time to insert data
						long beginTime = System.nanoTime();

						action = map.put(Key, aValue, "F");

						// Ending Time to insert data
						long endTime = System.nanoTime();
						long totalTime = endTime - beginTime;
						System.out.println(
								"Time taken to insert data using: " + probing + " is " + totalTime + " nano seconds");

						if (action.equalsIgnoreCase("INSERTED") || action.equalsIgnoreCase("UPDATED")) {
							System.out.print("Key and Value Entered or Updated");
							System.out.print("\nDo you want to PUT additional values? Enter 'Y' or 'N' Only: ");
							additionalInput = scan.nextLine();
						} else {
							System.out.print("Key and Value NOT Entered because Hashmap is full");
							break;
						}
					}

					System.out.println("\nHere is the Final Hash map:");
					System.out.println(map.toOutput());
				} else if (filename.equalsIgnoreCase("F")) {
					// Now reading data file
					filename = probing = "";
					System.out.println("Enter Data filename ");
					String dataFile = scan.nextLine();
					System.out
							.println("Enter Probing Method: Enter F for Function or L for Linear or Q for Quadratic: ");
					probing = scan.nextLine();

					// put in file path location (not the data file name)
					dataFile = "" + dataFile;
					transactions[] arrayData = getData(dataFile);
					int length1 = arrayData.length;
					map = new hashMap(length1);
					int sizeofarray = arrayData.length;
					// System.out.println("The length of array is " + sizeofarray);
					int a = 0;
					// Beginning Time to insert data
					long beginTime = System.nanoTime();
					while (a < arrayData.length) {
						// BigInteger UPCKey = new BigInteger(String.valueOf(UPCKey));
						action = map.put(arrayData[a].UPCKey, arrayData[a].description, probing);

						if (action.equalsIgnoreCase("INSERTED") || action.equalsIgnoreCase("UPDATED")) {
							// System.out.print("Key and Value Entered or Updated");
							a++;

						} else {
							// System.out.print("Key and Value NOT Entered because Hashmap is full");
							break;
						}

					}
					// Ending Time to insert data
					long endTime = System.nanoTime();
					long totalTime = endTime - beginTime;
					System.out.println(
							"Time taken to insert data using: " + probing + " is " + totalTime + " nano seconds");

					System.out.println("\nHere is the Final Hash map:");
					System.out.println(map.toOutput());

				} else {
					System.out.println("Exiting...");
					break;
				}
			}

			// End of IF Statement
			else if (q.equalsIgnoreCase("G")) {
				System.out.println(
						"Do you want Search Manually or Search File. Enter M for Manual or F for Filename or any other key to Exit ");
				filename = scan.nextLine();
				additionalInput = "";
				if (filename.equalsIgnoreCase("M")) {
					while (additionalInput.equalsIgnoreCase("Y") || additionalInput.equalsIgnoreCase("")) {
						System.out.println("Enter Key to search values ");
						aKey = scan.nextLine();
						BigInteger Key = new BigInteger(String.valueOf(aKey));
						map.get(Key);
						System.out.print("\nDo you want to GET additional values? Enter 'Y' or 'N' Only: ");
						additionalInput = scan.nextLine();
					}
				} else if (filename.equalsIgnoreCase("F")) {
					// Now reading data file
					filename = probing = "";
					System.out.println("Enter Search Input filename ");
					String dataFile = scan.nextLine();
					System.out
							.println("Enter Probing Method: Enter F for Function or L for Linear or Q for Quadratic: ");
					probing = scan.nextLine();
					if (probing.equalsIgnoreCase("F") || probing.equalsIgnoreCase("L")
							|| probing.equalsIgnoreCase("Q")) {
						dataFile = "/Users/nehamoolchandani/Desktop/Coding/CS303/CS303AlgorithmsDataStructures/P" + dataFile;
						transactions[] arrayData = getData(dataFile);
						int length1 = arrayData.length;
						int a = 0;
						while (a < arrayData.length) {
							// BigInteger UPCKey = new BigInteger(String.valueOf(UPCKey));
							map.get(arrayData[a].UPCKey);
							a++;
						}
					} else {
						System.out.println("Exiting..");
						break;
					}
				} else {
					System.out.println("Exiting..");
					break;

				}
			}

			// End of If Statement
			else {
				System.out.println("Exiting..");
				break;
			}
			System.out.print(
					"Do you want to put values in NEW Hashmap or Get Values From Existing Hashmap: Enter 'Get' or 'Put' or any other key to Exit: ");
			q = scan.nextLine();
		}
		scan.close();
		System.out.println("Good Bye");
	}

// HashElement class

	class HashElement {
		BigInteger key;
		String value;

		public HashElement(BigInteger key, String value) {
			this.key = key;
			this.value = value;
		}

		// returns a string in (key=k, value=v) format
		public String toString() {
			return "(key=" + key + ", value=" + value + ")";
		}
	}

	public static transactions[] getData(String fileName) {
		ArrayList<transactions> transactionsLog = new ArrayList<transactions>();
		try {
			Scanner s = new Scanner(new FileReader(fileName));
			String currentLine = "";
			String UPCKey = "";
			String description = "";
			int size = 0;
			while (s.hasNext()) {
				currentLine = s.nextLine();
				if (currentLine != null) { // If there is blank line between two logs, skip
					size = size + 1;
					String[] transactionDetail = currentLine.split(",", 2); // spliting each line into two strings one
																			// for Key and rest for description.
					if (transactionDetail[0] == null || transactionDetail[0].equals("")) { // Checking if there is a
																							// data or null
						UPCKey = "None";
					} else {
						UPCKey = transactionDetail[0]; // parsing UPCKey from the current line
					}
					if (transactionDetail[1] == null || transactionDetail[1].equals("")) { // Checking for if there is a
																							// data or null
						description = "None";
					} else if (transactionDetail[1].charAt(0) != ',') {
						description = transactionDetail[1]; // parsing Description from the current line
					} else {
						description = transactionDetail[1].substring(1); // parsing Description from the current line
																			// and removing comma if there is one in the
																			// begining

					}
					transactionsLog.add(new transactions(BigInteger.valueOf(Long.parseLong(UPCKey)), description)); // Adding
																													// to
																													// ArrayList
				}
			}
			s.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// Creating Array of 2D (UPCKey, descriptions)
		transactions[] arraytransactions = new transactions[transactionsLog.size()];
		int n = 0;
		while (n < transactionsLog.size()) {
			arraytransactions[n] = new transactions(BigInteger.valueOf(0), ""); // Initializing Array
			arraytransactions[n].UPCKey = transactionsLog.get(n).UPCKey; // storing UPCKey
			arraytransactions[n].description = transactionsLog.get(n).description; // Storing description
			n++;
		}
		return arraytransactions;
	}
}