import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class DFS {

    private LinkedList<Integer>[] adj;

    public DFS(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int node1, int node2) {
        adj[node1].add(node2);
        adj[node2].add(node1);
    }

    private boolean recursiveUtil(int source, int destination, boolean visited[]) {
        if (source == destination)
            return true;
        for (int neighbour : adj[source]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                boolean isConnected = recursiveUtil(neighbour, destination, visited);
                if (isConnected)
                    return true;
            }
        }
        return false;
    }

    public boolean recursive(int source, int destination) {
        boolean visited[] = new boolean[adj.length];
        visited[source] = true;
        return recursiveUtil(source, destination, visited);
    }

    public boolean iterative(int source, int destination) {
        boolean visited[] = new boolean[adj.length];
        visited[source] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == destination)
                return true;
            for (int neighbour: adj[cur]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges.");
        int v = sc.nextInt();
        int e = sc.nextInt();
        DFS DFS = new DFS(v);
        System.out.println("Enter " + e + " edges");
        for(int i = 0; i < e; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            DFS.addEdge(node1, node2);
        }
        System.out.println("Enter the source and destination for traversal");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println("Traversal possible through recursive? " + (DFS.recursive(source, destination) ? "Yes" : "No"));
        System.out.println("Traversal possible through iterative? " + (DFS.iterative(source, destination) ? "Yes" : "No"));
        sc.close();
    }
}
