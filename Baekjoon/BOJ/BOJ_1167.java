import java.io.*;
import java.util.*;

public class BOJ_1167 {
    static boolean[] visit;
    static List<Node> tree;
    static int max, index;
    static class Node{
        List<int[]> al = new ArrayList<>();

        void setAl (int n, int d){
            al.add(new int[] {n, d});
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i = 0; i < V; i++){
            Node n = new Node();
            tree.add(n);
        }

        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken()) - 1;
            Node n = tree.get(now);
            int target = Integer.parseInt(st.nextToken());
            while(target > 0){
                int d = Integer.parseInt(st.nextToken());
                n.setAl(target - 1, d);
                target = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        index = -1;
        visit = new boolean[V];
        dfs(0, 0);

        max = 0;
        visit = new boolean[V];
        dfs(index, 0);

        System.out.println(max);
    }

    static void dfs(int n, int cost){
        visit[n] = true;

        if(cost > max){
            max = cost;
            index = n;
        }

        Node node = tree.get(n);

        for(int[] arr : node.al){
            if(!visit[arr[0]]){
                dfs(arr[0], cost + arr[1]);
            }
        }
    }
}