import java.util.*;
import java.io.*;

public class BOJ_10746 {
    static int N, M, K;
    static int x, y, size, answer;
    static int[][] arr, clone, move;
    static int[] permArr;
    static boolean[] check;
    static boolean[][] visit;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;
        arr = new int[N][M];
        clone = new int[N][M];
        check = new boolean[K];
        move = new int[K][3];
        permArr = new int[K];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                clone[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            move[k][0] = Integer.parseInt(st.nextToken()) - 1;
            move[k][1] = Integer.parseInt(st.nextToken()) - 1;
            move[k][2] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(answer);
    }
    static void perm(int depth) {
        if(depth == K) {
            arr = copy(clone);
            for(int k = 0; k < K; k++) {
                x = move[permArr[k]][0];
                y = move[permArr[k]][1];
                size = move[permArr[k]][2];
                visit = new boolean[N][M];

                for(int i = x-size, j = y-size; i < x; i++, j++) {
                    layer(i, j);
                }
            }
            min();
            return;
        }

        for(int i = 0; i < K; i++) {
            if(!check[i]) {
                check[i] = true;
                permArr[depth] = i;
                perm(depth + 1);
                check[i] = false;
            }
        }
    }

    static void layer(int r, int c) {
        Deque<int[]>dq = new ArrayDeque<>();
        dq.add(new int[] {r, c});
        int dir = 0;
        int last = arr[r][c];

        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            int nr = now[0] + dr[dir];
            int nc = now[1] + dc[dir];

            if(nr < x - size || nc < y - size || nr > x + size || nc > y + size || visit[nr][nc]) {
                if(dir == 3) return;

                dq.offerFirst(now);
                dir++;
                continue;
            }
            int tmp = last;
            last = arr[nr][nc];
            arr[nr][nc] = tmp;
            visit[nr][nc] = true;
            dq.offer(new int[] {nr, nc});
        }
    }

    static int[][] copy(int[][] src) {
        if (src == null) return null;

        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }

        return copy;
    }

    static void min() {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < M; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        answer = Math.min(min,  answer);
    }
}