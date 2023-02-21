import java.util.*;
import java.io.*;
public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] score = new int[1001];
        int answer = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for(int[] a : arr){
            int pos = a[0];

            while(score[pos] > 0) pos--;

            if(pos > 0){
                score[pos] = a[1];
                answer += a[1];
            }
        }
        System.out.println(answer);
    }
}