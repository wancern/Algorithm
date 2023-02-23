
import java.io.*;
import java.util.*;

public class BOJ_14502 {
    static int[][] arr;
    static boolean[][] visit;
    static int N, M, safetyArea, answer;
    static List<int[]>al, virus;
    static int[][] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        combi = new int[3][2];
        al = new ArrayList<>();
        virus = new ArrayList<>();
        safetyArea = 0;
        answer = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    al.add(new int[] {i, j});
                    safetyArea++;
                    continue;
                }
                if(arr[i][j] == 2){
                    virus.add(new int[] {i, j});
                }
            }
        }
        comb(0, 0);

        System.out.println(answer);
    }

    static void comb(int depth, int last){
        if(depth == 3){
            visit = new boolean[N][M];
            for(int[] now : combi){
                visit[now[0]][now[1]] = true;
            }
            answer = Math.max(answer, safetyArea - bfs());
            return;
        }

        for(int i = last; i < al.size(); i++){
            int[] now = al.get(i);
            safetyArea--;
            combi[depth] = now;
            comb(depth + 1, i + 1);
            safetyArea++;
        }
    }

    static int bfs(){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]>q = new LinkedList<>();
        int cnt = 0;

        for(int[] now : virus){
            visit[now[0]][now[1]] = true;
            q.offer(now);
        }

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || arr[nr][nc] > 0){
                    continue;
                }

                cnt++;
                visit[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
        return cnt;
    }
}