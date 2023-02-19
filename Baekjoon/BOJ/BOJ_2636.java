import java.io.*;
import java.util.*;

public class BOJ_2636 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static Queue<int[]> nq;
    static int answer = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        nq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
        System.out.println(time);
        System.out.println(answer);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r, c });
        visit[r][c] = true;

        while (!q.isEmpty()) {
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                        continue;
                    }

                    visit[nr][nc] = true;

                    if (arr[nr][nc] == 1) {
                        cnt++;
                        nq.offer(new int[] {nr, nc});
                        continue;
                    }
                    q.offer(new int[] {nr, nc});
                }
            }
            if(cnt == 0) {
                return;
            }
            time++;
            answer = cnt;
            while(!nq.isEmpty()) q.offer(nq.poll());
        }
    }
}