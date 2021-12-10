import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E;
    static ArrayList<Edge>[] nodeArray;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        nodeArray = new ArrayList[V];
        for(int i = 0; i < V; i++){
            nodeArray[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeArray[from].add(new Edge(to, cost));
            nodeArray[to].add(new Edge(from, cost));
        }

        distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visited = new boolean[V];

        int Start = Integer.parseInt(br.readLine());
        dijkstra(Start);

        for(int i = 0; i < V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(distance[i] + " ");
            }
        }
    }

    static void dijkstra(int Start) {
        distance[Start] = 0;
        visited[Start] = true;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(Start, 0));
        while(!pq.isEmpty()) {
            int minIndex = -1;

            Edge edge = pq.poll();
            minIndex = edge.to;
            visited[minIndex] = true;

            for (int i = 0; i < nodeArray[minIndex].size(); i++) {
                Edge currentEdge = nodeArray[minIndex].get(i);
                int to = currentEdge.to;
                int cost = currentEdge.cost;
                if (!visited[to] && distance[to] > distance[minIndex] + cost) {
                    distance[to] = distance[minIndex] + cost;
                    pq.add(new Edge(to, cost));
                }
            }
        }
    }
}