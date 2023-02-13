import java.io.*;
import java.util.*;

public class BOJ_16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] move = new int[100];

        for(int i = 0; i < 100; i++){
            move[i] = i;
        }
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()) - 1;
        }
        System.out.println(bfs(move));
    }

    static int bfs(int[] move){
        Queue<int[]>q = new LinkedList<>();
        boolean[] visit = new boolean[100];

        q.offer(new int[] {0, 0});
        visit[0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 1; i <= 6; i++){
                int npos = now[0] + i;
                int cnt = now[1] + 1;

                if(npos > 100 || visit[move[npos]]){
                    continue;
                }
                if(npos == 99){
                    return cnt;
                }

                visit[move[npos]] = true;
                q.offer(new int[] {move[npos], cnt});
            }
        }
        return -1;
    }
}