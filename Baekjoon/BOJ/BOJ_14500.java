import java.io.*;
import java.util.*;

public class BOJ_14500 {
    static int N, M, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        answer = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){

                visit[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                woo(i, j);
                visit[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    static void dfs(int r, int c, int depth, int cnt){
        if(depth == 4){
            answer = Math.max(answer, cnt);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]){
                continue;
            }
            visit[nr][nc] = true;
            dfs(nr, nc, depth + 1, cnt + arr[nr][nc]);
            visit[nr][nc] = false;
        }
    }

    static void woo(int r, int c){
        int sum = arr[r][c];
        int min = 1000;
        int cnt = 4;

        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M){
                cnt--;
                continue;
            }

            sum += arr[nr][nc];
            min = Math.min(min,arr[nr][nc]);
        }

        if(cnt == 4){
            answer = Math.max(answer, sum - min);
            return;
        }
        if(cnt == 3){
            answer = Math.max(answer, sum);
        }
    }
}