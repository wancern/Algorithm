import java.util.*;
import java.io.*;

public class BOJ_1707 {
    static int V;
    static int E;
    static boolean[] visit;
    static Node[] list;
    static class Node {
        int part;
        List<Integer> al;
        Node() {
            al = new ArrayList<>();
            part = -1;
        }
        public void setAl(int num) {
            al.add(num);
        }
        public List<Integer> getAl() {
            return al;
        }
        public void setPart(int part){
            this.part = part;
        }
        public int getPart(){
            return part;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < K; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visit = new boolean[V + 1];
            list = new Node[V+1];
            for(int i = 0; i <= V; i++){
                list[i] = new Node();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].setAl(b);
                list[b].setAl(a);
            }

            boolean flag = true;
            for(int i = 0; i <= V; i++) {
                if (!visit[i]) {
                    if (!check(i)) {
                        sb.append("NO\n");
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }

    static boolean check(int num){
        visit[num] = true;
        list[num].setPart(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty()){
            int now = q.poll();
            List<Integer> al = list[now].getAl();
            int n_part = (list[now].getPart() + 1) % 2;

            for(int i : al){
                if(!visit[i]){
                    visit[i] = true;
                    list[i].setPart(n_part);
                    q.offer(i);
                    continue;
                }
                if(list[i].getPart() != n_part){
                    return false;
                }
            }
        }
        return true;
    }
}