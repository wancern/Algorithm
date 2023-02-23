import java.util.*;
import java.io.*;

    public class BOJ_15683 {
        static class CCTV{
            int r, c, type;

            public CCTV(int r, int c, int type) {
                this.r = r;
                this.c = c;
                this.type = type;
            }
        }
        static List<CCTV> al;
        static int N, M;
        static int[][] arr;
        static int[][][] dr = {{{0}, {0}, {1}, {-1}}, {{0, 0}, {-1, 1}},
                {{-1, 0}, {0, -1}, {1, 0}, {1, 0}},
                {{-1, 0, 0}, {0, -1, 1}, {1, 0, 0}, {-1, 1, 0}}, {{0, 0, 1, -1}}};
        static int[][][] dc = {{{1}, {-1}, {0}, {0}}, {{-1, 1}, {0, 0}},
                {{0, 1}, {-1, 0}, {0, 1}, {0, -1}},
                {{0, 1, -1}, {-1, 0, 0}, {0, 1, -1}, {0, 0, 1}}, {{1, -1, 0, 0}}};
        static int answer;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            al = new ArrayList<>();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            answer = N * M;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] % 6 > 0 ) {
                        CCTV cctv = new CCTV(i, j, arr[i][j] - 1);
                        al.add(cctv);
                    }
                }
            }
            dfs(0, copy(arr));
            System.out.println(answer);
        }

        static void dfs(int depth, int[][] arr) {
            if(depth == al.size()) {
                int cnt = 0;
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < M; j++) {
                        if(arr[i][j] == 0)
                            cnt++;
                    }
                }
                answer = Math.min(answer, cnt);
                return;
            }
            CCTV now = al.get(depth);

            for(int i = 0; i < dr[now.type].length; i++){
                check(depth, copy(arr), now, i);
            }
        }

        static void dir(int[][] arr, CCTV now, int dir, int i) {
            int nr = now.r + dr[now.type][dir][i];
            int nc = now.c + dc[now.type][dir][i];

            while(nr < N && nc < M && nr >= 0 && nc >= 0) {
                if(arr[nr][nc] == 0) {
                    arr[nr][nc] = -1;
                }
                if(arr[nr][nc] < 6) {
                    nr = nr + dr[now.type][dir][i];
                    nc = nc + dc[now.type][dir][i];
                    continue;
                }
                break;
            }
        }
        static void check(int depth, int[][] arr, CCTV now, int dir) {
            for(int i = 0; i < dr[now.type][dir].length; i++) {
                dir(arr, now, dir, i);
            }
            dfs(depth + 1, arr);
        }
        static int[][] copy(int[][] arr){
            int[][] clone = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    clone[i][j] = arr[i][j];
                }
            }
            return clone;
        }
    }