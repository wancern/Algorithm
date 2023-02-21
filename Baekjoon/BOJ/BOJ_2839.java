import java.io.*;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = N / 5;

        for(int i = num; i >= 0; i--) {
            int tmp = N - (i * 5);
            if(tmp % 3 == 0) {
                System.out.println(i + (tmp/3));
                return;
            }
        }
        System.out.println(-1);
    }
}