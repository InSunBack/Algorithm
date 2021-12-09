import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Kruskal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;

    public static void main(String[] args) throws IOException{

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        parent = new int[V + 1];
        for(int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(from, to, cost));
        }

        int COST = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(!isSameParent(edge.from, edge.to)) {
                union(edge.from, edge.to);
                COST += edge.cost;
            } else {
                System.out.println(edge.from + " " + edge.to + " is cycle");
            }
        }

        System.out.println(COST);
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A == B) return;
        if(A > B) {
            parent[A] = B;
        } else {
            parent[B] = A;
        }
    }

    static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }

    static void printer(Edge edge) {
        System.out.println(edge.from + " " + edge.to + " " + edge.cost);
    }
}