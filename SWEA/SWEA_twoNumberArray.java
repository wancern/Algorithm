import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class SWEA_twoNumberArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            if(N>=M){
                answer = slide(arr1, arr2);
            }
            else{
                answer = slide(arr2, arr1);
            }

            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int slide(int[] long_arr, int[] short_arr){
        int max = Integer.MIN_VALUE;
        for(int i = short_arr.length; i <= long_arr.length; i++){
            int tmp = multiplication(long_arr, short_arr, i - short_arr.length);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static int multiplication(int[] long_arr, int[] short_arr, int pos){
        int sum = 0;
        for(int i = 0; i < short_arr.length; i++){
            sum += short_arr[i] * long_arr[i + pos];
        }

        return sum;
    }
}




