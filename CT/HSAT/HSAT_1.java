import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[3][1002];
        int[] total = new int[3002];
        int[][] arr = new int[4][N];

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                score[i][arr[i][j]]++;
                arr[3][j] += arr[i][j];
            }
        }
        for(int i = 0; i < N; i++){
            total[arr[3][i]]++;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < N; j++){
                int rank = 1;
                
                for(int k = arr[i][j] + 1; k < 1002; k++){
                    rank += score[i][k];
                }
                sb.append(rank).append(" ");
            }
            sb.append("\n");
        }

        for(int i = 0; i < N; i++){
            int rank = 1;
            for(int j = arr[3][i] + 1; j < 3002; j++){
                rank += total[j];
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString());
    }
}