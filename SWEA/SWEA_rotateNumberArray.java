import java.io.*;
import java.util.*;

class SWEA_rotateNumberArray {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=T; testcase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(testcase).append("\n");
            rotate(arr, N);
        }
        System.out.println(sb);
    }

    public static void rotate(int[][] arr, int n){
        int[][] newArr1 = new int[n][n];
        int[][] newArr2 = new int[n][n];
        int[][] newArr3 = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newArr1[i][j] = arr[n-1-j][i];
                newArr2[i][j] = arr[n-1-i][n-1-j];
                newArr3[i][j] = arr[j][n-1-i];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(newArr1[i][j]);
            }
            sb.append(" ");
            for(int j = 0; j < n; j++){
                sb.append(newArr2[i][j]);
            }
            sb.append(" ");
            for(int j = 0; j < n; j++){
                sb.append(newArr3[i][j]);
            }
            sb.append("\n");
        }
    }




}




