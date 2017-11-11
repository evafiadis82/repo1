package GraphsLib;



import java.util.ArrayList;
import java.util.Stack;

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	// A function used by DFS
	void DFSHelper(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])				
				DFSHelper(n, visited);
			else 
			{
			; //this is a cycle
			}
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSHelper(v, visited);
	}
	
	
	 void BFS(int s)
	    {
	        // Mark all the vertices as not visited(By default
	        // set as false)
	        boolean visited[] = new boolean[V];
	 
	        // Create a queue for BFS
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	 
	        // Mark the current node as visited and enqueue it
	        visited[s]=true;
	        queue.add(s);
	 
	        while (queue.size() != 0)
	        {
	            // Dequeue a vertex from queue and print it
	            s = queue.poll();
	            System.out.print(s+" ");
	 
	            // Get all adjacent vertices of the dequeued vertex s
	            // If a adjacent has not been visited, then mark it
	            // visited and enqueue it
	            Iterator<Integer> i = adj[s].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	    }

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		int startingPoint=1;
		
		System.out.println("Following is Depth First Traversal " + "(starting from vertex "+startingPoint+")");

		g.DFS(startingPoint);
		
		System.out.println("\nFollowing is Breadth First Traversal " + "(starting from vertex "+startingPoint+")");
		
		g.BFS(1);
		
	}
}
