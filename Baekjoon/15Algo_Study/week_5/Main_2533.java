import java.util.*;
import java.io.*;

public class Main_2533 {
    static int N;
    static int[][] dp;
    static List<Node> nodes;
    static class Node{
        List<Integer> list;

        public Node(){
            list = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][2];

        nodes = new ArrayList<>();
        for(int i = 0; i < N; i++){
            nodes.add(new Node());
        }
        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            nodes.get(u).list.add(v);
            nodes.get(v).list.add(u);
        }


        int answer = Math.min(dfs(0, true), dfs(0, false));
        System.out.println(answer);
    }

    static int dfs(int idx, boolean flag){
        Node n = nodes.get(idx);
        if(!flag){
            if(dp[idx][0] > 0){
                return dp[idx][0];
            }
            int answer = 0;
            for(int next : n.list){
                answer += dfs(next, true);
            }
            dp[idx][0] = answer;
            return answer;
        }
        if(dp[idx][1] > 0){
            return dp[idx][1];
        }
        int answer = 0;
        for(int next : n.list){
            answer += Math.min(dfs(next, true), dfs(next, false));
        }
        dp[idx][1] = answer + 1;
        return answer + 1;
    }
}