import java.util.*;
import java.io.*;

public class BOJ_16927 {
    static int N, M, R;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Deque<Integer> dq = new ArrayDeque<>();
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        int end = Math.min(N, M)/2;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < end; i++) {
            visit[i][i] = true;
            dq.offer(arr[i][i]);
            q.offer(new int[] {i, i});
            cycle(i, i, 0);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void cycle(int r, int c, int dir) {

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
            if(dir == 3) {
                rotate();
                change();
                return;
            }
            cycle(r, c, dir + 1);
            return;
        }

        visit[nr][nc] = true;
        dq.offer(arr[nr][nc]);
        q.offer(new int[] {nr, nc});
        cycle(nr, nc, dir);
    }

    static void rotate() {
        int cnt = R % dq.size();
        for(int i = 0; i < cnt; i++) {
            dq.offer(dq.poll());
        }
    }

    static void change() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            arr[now[0]][now[1]] = dq.poll();
        }
    }
}