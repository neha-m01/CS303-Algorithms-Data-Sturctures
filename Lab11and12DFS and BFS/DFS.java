package Lab11and12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

// Creating an undirected graph
class dfsUndirectedGraph {
	// initializing vertices and edges in the graph
	public int V;
	public int E;
	// adj list to store the elements
	public LinkedList<Integer>[] adjacencyList;

	public dfsUndirectedGraph() {
		V = 0;
		E = 0;
	}

	// Buffering from File to read in the input
	public dfsUndirectedGraph(BufferedReader filReader) throws IOException {
		String line;
		line = filReader.readLine();
		V = Integer.parseInt(line);
		line = filReader.readLine();
		E = Integer.parseInt(line);
		adjacencyList = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adjacencyList[v] = new LinkedList<Integer>();
		}

		while ((line = filReader.readLine()) != null) {
			int tempV1, tempV2;
			String[] lineDetail = line.split(" ", 2);
			tempV1 = Integer.parseInt(lineDetail[0]);
			tempV2 = Integer.parseInt(lineDetail[1]);
			addEdge(tempV1, tempV2);
		}
	}

	// method to add edges from graph
	public void addEdge(int v, int w) {
		this.adjacencyList[v].add(w);
	}

	// implementing the graph into a string using the adj list
	// Iterating through graph to put vertices and edges in a string format
	public String toString() {
		String outputString = new String();
		outputString = "There are " + V + " Vertices and " + E + " Edges in the given file\n";
		for (int i = 0; i < V; i++) {
			outputString = outputString + i + ": ";
			for (int j = 0; j < adjacencyList[i].size(); j++) {
				outputString = outputString + adjacencyList[i].get(j) + " ";
			}
			outputString = outputString + "\n";
		}
		return outputString;
	}

}

public class DFS {
	// White, Gray, Black Color
	static String vertexColor[];
	// Marking vertices according to process stage: Not processed, processing, processed
	static String visitedVertex = "";
	// the final destination
	static boolean reachedDestination = false;

	public static void GRAPH(LinkedList<Integer> G[], int destination) {
		// num of vertices
		int size = G.length;
		vertexColor = new String[size];

		// color of vertex is white for not processed stage
		for (int i = 0; i < size; i++) {
			vertexColor[i] = "WHITE";
		}

		System.out.println(
				"Below is the list of vertices traversed from source vertex 0 to destination vertex " + destination);

		DFSVisit(G, 0, destination);
		if (!reachedDestination)
			System.out.println(" \nNo path found from source 0 to destination " + destination);
		else
			System.out.print("0 to \'" + destination + "\' : " + visitedVertex);
	}

	public static void DFSVisit(LinkedList<Integer> G[], int vertex, int destination) {

		// if visited vertex is the same as destination then return without further implementation
		if (vertex == destination) {
			visitedVertex = visitedVertex.concat(vertex + ",");
			reachedDestination = true;
			return;
		}
		// Color is gray for processing stage
		vertexColor[vertex] = "GRAY";
		visitedVertex = visitedVertex.concat(vertex + ",");

		// going through the DFS for adj vertices
		LinkedList<Integer> list = G[vertex];
		for (int v : list) {
			if (vertexColor[v].equals("WHITE")) {
				DFSVisit(G, v, destination);
			}
		}
		// color is black after it has been visited
		vertexColor[vertex] = "BLACK";
		//topologicalsort();

	}
	/*
	 * // Method to perform topological sort using DFS public static void
	 * topologicalsort() { // Print the vertices in topological order for (int i =
	 * 0; i<list.size(); i++ { { if (visitedVertex[i] != -1) {
	 * System.out.print(visitedVertex[i] + " "); } }
	 */

	public static void main(String args[]) throws Exception {
		// reading data from TinyDG.txt
		BufferedReader br = new BufferedReader(new FileReader("mediumG.txt"));

		// traversing the vertex from source 0 till etc.
		long beginTime = System.currentTimeMillis();
		dfsUndirectedGraph graphObject = new dfsUndirectedGraph(br);
		//Adjust destination here after the comma
		GRAPH(graphObject.adjacencyList, 100);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - beginTime;
		System.out.println(graphObject.toString());
        System.out.println("\n" + "The total time taken for Depth-First Search " + "is " + totalTime + " milliseconds");
    
	}
}