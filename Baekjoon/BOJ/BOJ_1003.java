import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[41][2];
        int max = 1;
        arr[0] = new int[] {1, 0};
        arr[1] = new int[] {0, 1};

        for(int testcase = 0; testcase < T; testcase++){
            int N = Integer.parseInt(br.readLine());
            if(N > max){
                for(int i = max + 1; i <= N; i++){
                    arr[i][0] = arr[i-1][0] + arr[i-2][0];
                    arr[i][1] = arr[i-1][1] + arr[i-2][1];
                }
                max = N;
            }
            sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
        }

        System.out.print(sb);
    }
}
