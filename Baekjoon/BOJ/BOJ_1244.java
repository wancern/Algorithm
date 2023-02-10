import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    static boolean[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            if(Integer.parseInt(st.nextToken()) == 1){
                arr[i] = true;
            }
        }

        int student = Integer.parseInt(br.readLine());

        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if(gender == 1){
                man(pos);
                continue;
            }
            woman(pos -1);
        }

        for(int i = 0; i < N; i++){
            sb.append(arr[i] ? 1 : 0);

            if((i + 1) % 20 == 0){
                sb.append("\n");
                continue;
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static void man(int pos){
        for(int i = pos; i <= N; i += pos){
            arr[i - 1] = !arr[i - 1];
        }
    }

    static void woman(int pos){
        arr[pos] = !arr[pos];
        int cnt = 1;

        while(pos - cnt >= 0 && pos + cnt < N){
            if(arr[pos - cnt] == arr[pos + cnt]){
                arr[pos - cnt] = !arr[pos - cnt];
                arr[pos + cnt] = !arr[pos + cnt];
                cnt++;
                continue;
            }
            break;
        }
    }
}
