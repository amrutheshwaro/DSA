import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    private LinkedList<Integer>[] adj;

    public BFS(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int node1, int node2) {
        adj[node1].add(node2);
        adj[node2].add(node1);
    }

    public int shortestDistance(int source, int destination) {
        boolean visited[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == destination)
                break;
            for (int neighbour : adj[cur]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    parent[neighbour] = cur;
                }
            }
        }
        int cur = destination;
        int distance = 0;
        while(parent[cur] != -1) {
            System.out.print(cur + " --> ");
            cur = parent[cur];
            distance++;
        }
        System.out.println(source);
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges.");
        int v = sc.nextInt();
        int e = sc.nextInt();
        BFS bfs = new BFS(v);
        System.out.println("Enter " + e + " edges");
        for(int i = 0; i < e; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            bfs.addEdge(node1, node2);
        }
        System.out.println("Enter the source and destination for traversal");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println("The minimum distance is " + bfs.shortestDistance(source, destination));
        sc.close();
    }
}
