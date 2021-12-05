import java.io.*;
import java.util.*;

class DfsBfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Integer>[] nodeArray;

    public static void main(String[] args) throws Exception {
        int V, E;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        nodeArray = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            nodeArray[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeArray[a].add(b);
        }

        DFS(nodeArray, 0);
        BFS(nodeArray, 0);

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(ArrayList<Integer>[] nodeList, int root) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ilist = new ArrayList<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            int target = stack.pop();
            ilist.add(target);
            for(int i = 0; i < nodeList[target].size(); i++) {
                stack.add(nodeList[target].get(i));
            }
        }

        for (Integer integer : ilist) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    static void BFS(ArrayList<Integer>[] nodeList, int root) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ilist = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int target = queue.poll();
            ilist.add(target);
            for (int i = 0; i < nodeList[target].size(); i++) {
                queue.add(nodeList[target].get(i));
            }
        }

        for (Integer integer : ilist) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}