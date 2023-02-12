import java.util.*;
import java.io.*;

public class BOJ_2615 {
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[21][21];

        for(int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer (br.readLine());
            for(int j = 1; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < 20; i++) {
            for(int j = 1; j < 20; j++) {
                if(arr[i][j] > 0) {
                    if(checkDir(i, j)) {
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean checkDir(int r, int c) {
        for(int i = 0; i < 4; i++) {
            int pr = r - dx[i];
            int pc = c - dy[i];

            if(arr[r][c] != arr[pr][pc]) {
                if(checkLength(r, c, i)) return true;
            }
        }
        return false;
    }
    static boolean checkLength (int r, int c, int dir) {
        int depth = 1;
        for(int i = 1; i < 6; i++) {
            int nr = r + i * dx[dir];
            int nc = c + i * dy[dir];

            if(nr > 19 || nc > 19 || arr[nr][nc] != arr[r][c]) break;
            depth++;
        }
        if(depth == 5) {
            sb.append(arr[r][c]).append("\n");
            sb.append(r).append(" ").append(c);
            return true;
        }
        return false;
    }
}