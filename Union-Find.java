import java.io.*;
import java.util.*;

class PAD {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int parent[];

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        /*
        for(int i = 0; i < N; i++) {
            parent[i] = -1;
        }
        */

        br.close();
        bw.flush();
        bw.close();
    }

    static void union(int i, int j) {
        int ni = find(i);
        int nj = find(j);

        if(ni == nj) return;
        
        if(ni < nj) {
            parent[j] = i;
        } else {
            parent[i] = j;
        }
    }

    // weighting rule union
    static void union2(int i, int j) {

        int temp = parent[i] + parent[j];
        if( parent[i] > parent[j]) {
            parent[i] = j;
            parent[j] = temp;
        } else {
            parent[j] = i;
            parent[i] = temp;
        }
    }

    static int find(int i) {
        if(parent[i] == i) return parent[i];
        else return find(parent[i]);
    }

    // collapsing find
    static int find2(int i) {
        int root, trail, lead;
        for(root = i; parent[root] >= 0; root = parent[root]);
        // vertex collapsing
        for(trail = i; trail != root; trail = lead) {
            lead = parent[trail];
            parent[trail] = root;
        }
        return root;
    }

    static void Printer() {
        for(int i = 0; i < parent.length; i++) {
            System.out.println(i + " : " + parent[i]);
        }
        System.out.println();
    }
}