import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_scale {
    public static int N;
    public static int answer = 0;
    public static int[] arr;
    public static int[] per_arr;
    public static boolean[] isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=T; testcase++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            per_arr = new int[N];
            isCheck = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            permutation(per_arr, 0);

            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void permutation(int[] scale, int depth){
        if(depth  == N){
            position(scale, 0, 0, 0);

            return;
        }
        for(int i = 0; i < N; i++){
            if(!isCheck[i]){
                scale[depth] = arr[i];
                isCheck[i] = true;
                permutation(scale, depth + 1);
                isCheck[i] = false;
            }
        }

    }

    public static void position(int[] scale, int left, int right, int depth){
        if(depth == N){
            answer++;
            return;
        }

        position(scale, left + scale[depth], right, depth + 1);
        if(left >= right + scale[depth]){
            position(scale, left, right + scale[depth], depth + 1);
        }
    }

}