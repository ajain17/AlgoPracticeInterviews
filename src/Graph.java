import java.util.*;

/**
 * Created by ayushij on 12/28/16.
 */
public class Graph {
    private int v;
    static ArrayList<Integer>[] adj;
    Graph(int V) {
        v = V;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int x, int y) {
        adj[x].add(y);
    }

    void dfs(int vertex) {
        System.out.println("Depth first traversal:");
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        stack.add(vertex);
        visited[vertex] = true;
        while(!stack.isEmpty()) {
            int element = stack.pop();
            System.out.println(element);
            for(int neighbor : adj[element]){
               // System.out.println("neighbor: " + neighbor);
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.add(neighbor);
                }
            }
        }
    }

    void bfs(int vertex) {
        System.out.println("Breadth first traversal:");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        boolean[] visited = new boolean[v];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current);
            //visited[current] = true;
            for (int x : adj[current]) {
                if(!visited[x]){
                    visited[x] = true; //do either of the visited true because in case of cycles, it becomes non terminating.
                    queue.add(x);
                }
            }
        }
    }

    void dfsrecursive(int vertex) {
        boolean[] visited = new boolean[v];
        dfsUtil(vertex, visited);
    }

    void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        for(int x: adj[vertex]){
            if(!visited[x])
                dfsUtil(x, visited);
        }

    }
    void testMe(){
        int n = 10, i=0;
        while(true){
            int j=0;
            while( j< n+10 && i<n){
                i++;
                j++;
                System.out.println("i = " + i + " j = " + j);
            }
            System.out.println("out of for loop");
        }
    }



    public static void main(String args[]){
        Graph g = new Graph(7);
        /*g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,4);
        g.addEdge(0,6);
        g.addEdge(6,5);
        g.addEdge(5,2);
        g.addEdge(5,5);
        g.addEdge(3,4);
        g.testMe();
        //g.addEdge();
        g.dfs(0);
        System.out.println("****");
        g.dfsrecursive(0);
    }
}
