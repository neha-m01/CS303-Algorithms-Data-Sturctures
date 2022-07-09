package Lab11and12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

  //Creating an adjacent linked list using Nodes. Used for index of element of vertices.
class nodeList {
    private int indexofElements;
    private nodeList next;

    public nodeList(int itemIndex) {
        indexofElements = itemIndex;
        next = null;
    }
   //Creating getters and setters to be called in main method more easily
    public nodeList getNext() {
        return next;
    }

    public void setNext(nodeList n) {
        next = n;
    }

    public int getIndexofElements() {
        return indexofElements;
    }
} 

  // Class Node to keep elements - contains the head (not tail) of the adjacency list and the designated colors.
class Node {
    public enum Color {
        White,
        Black,
        Gray
    }
    //Creating the variables
    private int data;
    private Color color;
    private nodeList head;

    //Creating the starter variables
    public Node(int d) {
        data = d;
        head = null;
        color = Color.Gray;
    }

    //getter and setters for Node Class
    public int getData() {
        return data;
    }

    public nodeList getHead() {
        return head;
    }

    public void setHead(nodeList n) {
        head = n;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }
}

// Class Graph created to store number of vertices and array containing all the nodes of vertices.
class undirectedGraph {
    private int numberOfVertices;
    private Node[] heads;


    public undirectedGraph(int numVertices) {
        numberOfVertices = numVertices;
        heads = new Node[numberOfVertices];

        //making elements of all head null and next elements null until last element
        for(int i=0; i<numberOfVertices; i++) {
            //z is pointer of node
            Node z = new Node(-1); 
            //z is the value
            heads[i] = z; 
        }
    }

    public Node[] getHeads() {
        return heads;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    // method to add new node to graph
    public void addNodeToGraph(int data) {
        Node z = new Node(data);
        // node added to heads array of graph
        for(int i=0; i<numberOfVertices; i++) {
            if(heads[i].getData() < 0) {
                heads[i] = z;
                break;
            }
        }
    }

    // function to check of the data is in the head array of graph or not
    public boolean headList(int data) {
        for(int i=0; i<numberOfVertices; i++) {
            if(heads[i].getData() == data)
                return true;
        }
        return false;
    }

    // function to add edge into graph
    public void addEdge(int edge, int location) { 
        //if edge is not in graph, include it
        if(!headList(edge)) {
            addNodeToGraph(edge); 
        }
        if(!headList(location)) {
            addNodeToGraph(location);
        }
        // iterating over heads to find edge node
        for(int i=0; i<numberOfVertices; i++) {
            if(heads[i].getData() == edge) { //edge node found

                int indexLocation=0;

                // iterating over heads array to find node containing location element
                for(int j=0; j<numberOfVertices; j++) {
                    //location found
                    if(heads[j].getData() == location) {
                        indexLocation = j;
                        break;
                    }
                }
                nodeList n = new nodeList(indexLocation);
                if(heads[i].getHead() == null) {
                    heads[i].setHead(n);
                }
                else {
                    nodeList temp;
                    temp = heads[i].getHead();

                    // iterating over adjaceny list to insert new list_node at last
                    while(temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(n);
                }
                break;
            }
        }
    }
}

//Creating a class for Queue and its getters and setters
class QueueNode {
    private Node n;
    private QueueNode next;

    public QueueNode(Node node) {
        n = node;
        next = null;
    }

    public void setNext(QueueNode n) {
        next = n;
    }

    public QueueNode getNext() {
        return next;
    }

    public Node getNode() {
        return n;
    }
}

class Queue {
    private int count;
    private QueueNode start;
    private QueueNode end;

    public Queue() {
        count = 0;
        end = null;
        start = null;
    }

    public boolean Empty() { 
        if(count == 0)
            return true;
        return false;
    }

    public void enqueue(Node n) {
        QueueNode newQueueNode = new QueueNode(n);

        if(!Empty()) {
            end.setNext(newQueueNode);
            end = newQueueNode;
        }
        else {
            start = end = newQueueNode;
        }
        count++;
    }

    public QueueNode dequeue() {
        QueueNode temp;
        temp = start;
        start = start.getNext();
        count--;
        return temp;
    }
}
public class BFS {
    //Method implemented from PseudoCode provided in Assignment Lab 11

    public static void bfs(undirectedGraph g) {
        //using first node as edge
        Node s = g.getHeads()[0];

        for(int i=0; i<g.getNumberOfVertices(); i++) {
            g.getHeads()[i].setColor(Node.Color.White);
        }
        s.setColor(Node.Color.Gray);

        Queue q = new Queue();
        q.enqueue(s);

        List<Integer> inputList = new ArrayList<>();
        while(!q.Empty()) {
            QueueNode u = q.dequeue();
            nodeList temp;

            temp = u.getNode().getHead();
            while(temp != null) {
                if(g.getHeads()[temp.getIndexofElements()].getColor() == Node.Color.White) {
                    g.getHeads()[temp.getIndexofElements()].setColor(Node.Color.Gray);
                    q.enqueue(g.getHeads()[temp.getIndexofElements()]);
                }
                temp = temp.getNext();
            }
            u.getNode().setColor(Node.Color.Black);
            inputList.add(u.getNode().getData());
        }

        System.out.print(inputList.get(0) + ":");
        for (int m=1; m<inputList.size(); m++) {
            System.out.print(inputList.get(m) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader("mediumG.txt"));
        int vertices = 0;
        int edges = 0;
        String nextLine;
        nextLine = buffer.readLine();
        vertices = Integer.parseInt(nextLine);
        nextLine = buffer.readLine();
        edges = Integer.parseInt(nextLine);

        undirectedGraph g = new undirectedGraph(vertices);
        while ((nextLine = buffer.readLine()) != null) {
            int tempV1, tempV2;
            String[] transactionDetail = nextLine.split(" ",2);
            tempV1 = Integer.parseInt(transactionDetail[0]);
            tempV2 = Integer.parseInt(transactionDetail[1]);
            g.addEdge(tempV1, tempV2);
        }
        long beginTime = System.currentTimeMillis();
        bfs(g);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - beginTime;
        System.out.println("\n" + "The total time taken for Breadth-First Search " + "is " + totalTime + " milliseconds");
    }
}