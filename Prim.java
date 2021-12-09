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

public class Prim {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Edge>[] nodeArray;

    public static void main(String[] args) throws IOException {

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        nodeArray = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++){
            nodeArray[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeArray[from].add(new Edge(to, cost));
            nodeArray[to].add(new Edge(from, cost));
        }

        int starter = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(starter, 0));

        int result = 0;
        int cnt = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(visited[edge.to]) continue;
            visited[edge.to] = true;
            result += edge.cost;

            for(int i = 0; i < nodeArray[edge.to].size(); i++) {
                Edge tempEdge = nodeArray[edge.to].get(i);
                if(!visited[tempEdge.to]) {
                    pq.add(tempEdge);
                }
            }
            cnt++;
            if(cnt == V) break;
        }
        System.out.println(result);
    }
}