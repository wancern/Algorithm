import java.io.*;
import java.util.*;

public class BOJ_7569 {
    static int N, M, H, tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dh = {-1, 1};
    static int[][][] arr;
    static boolean[][][] visit;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        visit = new boolean[H][N][M];
        tomato = 0;

        for(int k = 0; k < H; k++){
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());

                    if(arr[k][i][j] == 1){
                        q.offer(new int[] {k, i, j, 0});
                        visit[k][i][j] = true;
                        continue;
                    }
                    if(arr[k][i][j] == 0){
                        tomato++;
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        int res = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            res = now[3] + 1;

            for(int i = 0; i < 2; i++){
                int nh = now[0] + dh[i];

                if(nh >= H || nh < 0 || visit[nh][now[1]][now[2]] || arr[nh][now[1]][now[2]] == -1){
                    continue;
                }
                tomato--;
                visit[nh][now[1]][now[2]] = true;
                q.offer(new int[] {nh, now[1], now[2], res});
            }

            for(int i = 0; i < 4; i++){
                int nr = now[1] + dx[i];
                int nc = now[2] + dy[i];

                if(nr >= N || nr < 0 || nc >= M || nc < 0 || visit[now[0]][nr][nc] || arr[now[0]][nr][nc] == -1){
                    continue;
                }
                tomato--;
                visit[now[0]][nr][nc] = true;
                q.offer(new int[] {now[0], nr, nc, res});
            }
        }
        if(tomato > 0) return -1;
        return res - 1;
    }
}