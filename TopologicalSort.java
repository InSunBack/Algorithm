import java.io.*;
import java.util.*;

class TopologicalSort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Integer>[] nodeArray;
    static int[] targetArray;
    static int[] parent;
    static ArrayList<Integer> lesultList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int V, E;
        E = Integer.parseInt(br.readLine());
        nodeArray = new ArrayList[E + 1];
        targetArray = new int[E + 1];
        parent = new int[E + 1];
        for(int i = 0; i <= E; i++) {
            nodeArray[i] = new ArrayList<>();
        }
        for(int i = 0; i <= E; i++) {
            parent[i] = i;
        }
        V = Integer.parseInt(br.readLine());

        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeArray[a].add(b);
            targetArray[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < E; i++) {
            if(targetArray[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            lesultList.add(now);

            for(int i = 0; i < nodeArray[now].size(); i++) {
                targetArray[nodeArray[now].get(i)]--;
                if((targetArray[nodeArray[now].get(i)]) == 0 ) {
                    queue.add(nodeArray[now].get(i));
                }
            }
        }

        for (Integer integer : lesultList) {
            System.out.print(integer + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}