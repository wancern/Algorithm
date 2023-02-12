import java.io.*;
import java.util.*;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                if(st.nextToken().equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                    continue;
                }
                if(tm.size() == 0) continue;

                int key = Integer.parseInt(st.nextToken()) == 1 ? tm.lastKey() : tm.firstKey();
                int value = tm.get(key);

                if(value == 1){
                    tm.remove(key);
                    continue;
                }
                tm.put(key, value-1);
            }

            if(tm.size()>0){
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
                continue;
            }
            sb.append("EMPTY\n");
        }
        System.out.print(sb);
    }
}