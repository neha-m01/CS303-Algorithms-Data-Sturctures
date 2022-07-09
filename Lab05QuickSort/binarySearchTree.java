package Lab08;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class binarySearchTree {
	
	// Driver Program to test methods
	public static void main(String[] args) {
		binarySearchTree tree = new binarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		// print inorder traversal of the BST
		// This method mainly calls InorderRec()
		inorderTraversal(root);

		String file = "UPC.csv";
		String file2 = "inputdat.txt";
		String line = "";
		String Splitsym = ",";

		int count = 0;

		try (Scanner sc = new Scanner(new FileReader(file)))
		{
			while ((line = sc.nextLine()) != null) {
				count = count + 1;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		int Arr[] = new int[count];
		try (Scanner sc = new Scanner(new FileReader(file)))
		{
			for (int i = 0; i < 3; i++)
			{
				line = sc.nextLine();
				String[] input = line.split(Splitsym);
				Arr[i] = Integer.parseInt(input[0]);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try (Scanner sc = new Scanner(new FileReader(file2)))
		{
			while ((line = sc.nextLine()) != null)
			{
				int input = Integer.parseInt(line);
				long beginTime = System.nanoTime();
				System.out.println("k " + input + " Fount at :" + search(root, input));
				long endTime = System.nanoTime();
				long totalTime = endTime - beginTime;
				System.out.println("Time take for search :" + totalTime + " Neno Seconds");
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// Calling insertion
	public void insert(int key) {
		root = insertion(root, key);
	}

	public class Node {
		int key;
		Node left, right;

		Node(int item) {
			key = item;
			left = right = null;
		}
	}

	static // Root of BST
	Node root;

	// Constructor
	binarySearchTree() {
		root = null;
	}


	
	// Inserting a new key in BST 
	public Node insertion(Node root, int key) {
		// If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}
		//If key is greater than root key, go down the tree */
		if (key < root.key)
			root.left = insertion(root.left, key);
		else if (key > root.key)
			root.right = insertion(root.right, key);
		// return the original node */
		return root;
	}

	// In-order traversal of BST (printing nodes in the order)
	public static void inorderTraversal(Node root) {
		if (root ==null) {
			return;
		}
		if (root != null) {
			//start with left child
			inorderTraversal(root.left);
			System.out.println(root.key);
			//then right child
			inorderTraversal(root.right);
		}
	}
	public static Node search(Node root, int key)
	{
	    // Base: If root is NIL or key is at root:
	    if (root==null || root.key==key)
	        return root;
	 
	    // Key is greater than root key
	    if (root.key < key)
	       return search(root.right, key);
	 
	    // Key is less than root key
	    return search(root.left, key);
	}
}
