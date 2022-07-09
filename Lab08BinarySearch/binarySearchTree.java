package Lab08;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class transactions {
	String key, description;

	public transactions(String key, String description) {
		this.key = key;
		this.description = description;
	}
}

// A class to store a BST node
class Node {
	String key, description;
	Node left, right;

	// Function to create a new binary tree node having a given key
	public Node(String key, String description) {
		this.key = key;
		this.description = description;
		left = right = null; 
	}
}

public class binarySearchTree {
	// Main Driver
	public static void main(String[] args) throws IOException {
		String dataFile = "Data3.csv";
		transactions[] arrayData = getData(dataFile);
		Node root = createBST(arrayData);
		// System.out.println("The sorted BST is as follows: \n");
		inorder(root);

		String searchFile = "input.dat";
		transactions[] arrayInput = getData(searchFile);
		int q = 0;
		while (q < arrayInput.length) {
			// Searching for all the UPC Key in input.dat file

			// Time it took to search the input
			long beginTime = System.nanoTime();
			search(root, arrayInput[q].key);
			long endTime = System.nanoTime();
			long totalTime = endTime - beginTime;
			System.out.println("Time take for search: " + totalTime + " nano Seconds");
			q++;
		}

	}

	// Reading data from input files for data and search keys//
	private static transactions[] getData(String fileName) throws IOException {
		ArrayList<transactions> transactionsLog = new ArrayList<transactions>();
		try {
			Scanner sc = new Scanner(new FileReader(fileName));
			String currentLine = "";
			String key = "";
			String description = "";
			int size = 0;

			while (sc.hasNext()) {
				currentLine = sc.nextLine();
				if (currentLine != null) {
					// If there is blank line between two logs, skip
					size = size + 1;
					// spliting each line into two strings one for key and one for description
					String[] transactionDetail = currentLine.split(",", 2); 														
					//checking if data is null or contains information
					if (transactionDetail[0] == null || transactionDetail[0].equals("")) 
					{ 											
						key = "None";
					} else {
						key = transactionDetail[0]; // parsing UPCKey from the current line
					}
					if (transactionDetail[1] == null || transactionDetail[1].equals("")) 
					{ // Checking for if there is a
																							// data or null
						description = "None";
                    }
                    else if (transactionDetail[1].charAt(0) != ',') {
                        description = transactionDetail[1]; //parsing Description from the current line
                    }
                    else {
                        description = transactionDetail[1].substring(1); //parsing Description from the current line and removing comma if there is one in the begining

                    }
                    transactionsLog.add(new transactions(key, description));  // Adding to ArrayList
                }
            }
			sc.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Creating Array of 2D (key, descriptions)
		transactions[] arraytransactions = new transactions[transactionsLog.size()];
		int n = 0;
		while (n < transactionsLog.size()) {
			// Initializing Array
			arraytransactions[n] = new transactions("", "");
			// storing key
			arraytransactions[n].key = transactionsLog.get(n).key;
			// Storing description
			arraytransactions[n].description = transactionsLog.get(n).description;
			n++;
		}
		return arraytransactions;
	}

	public static void inorder(Node root) {
		// If the tree is empty, return Node
		if (root == null) {
			return;
		}
		// If key is greater than root key, go down the tree
		inorder(root.left);
		// System.out.print(root.key + "-" + root.description + " ");
		inorder(root.right);
	}

	// Recursive function to search key in the data and get description//
	public static Node search(Node root, String key) {
		// System.out.println("In search function " + root.key);
		if (root == null || root.key.compareTo(key) == 0) {
            if ((root != null ? root.key : null) != null) {
                System.out.println("\nThe description for Search Key " + key + " is " + root.description);
            }
            else {
                System.out.println("\nThe description for Search Key " + key + " doesn't exist");
            }
            return (root);
        }
        else if (root.key.compareTo(key) > 0){
             return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

	// Recursive function to insert a key into a BST//
	public static Node insert(Node root, String key, String description) {
		// if the root is null, create a new node and return it
		// System.out.println("In the insert function" + key + "-" + description);
		if (root == null) {
			return new Node(key, description);
		}
		// if the given key is less than the root node,
		// recursion for the left subtree
		if (key.compareTo(root.key) < 1) {
			root.left = insert(root.left, key, description);
		}
		// otherwise, recursion for the right subtree
		else {
			// key >= root.data
			root.right = insert(root.right, key, description);
		}
		return root;
	}
 
	// Function to construct a BST from given keys
	public static Node createBST(transactions[] arrayTransactions) {
		Node root = null;
		int p = 0;
		while (p < arrayTransactions.length) {
			root = insert(root, arrayTransactions[p].key, arrayTransactions[p].description);
			p++;
		}
		return root;
	}

}