import java.util.*;
import java.io.*;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < N - 1; i++){
            int now = pq.poll() + pq.poll();
            answer += now;
            pq.add(now);
        }
        System.out.println(answer);
    }
}
