import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int answer = 0;

        if(R <= H){
            System.out.print(answer);
            return;
        }

        int num = (int)Math.pow(2, H);
        List<Queue<Integer>> li = new ArrayList<>();

        for(int i = 0; i < num; i++){
            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < K; j++){
                q.offer(Integer.parseInt(st.nextToken()));
            }

            li.add(q);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        dq.offer(0);
        int n = 1;
        boolean flag = true;
        for(int i = 2; i <= H; i++){
            n *= 2;
            flag = !flag;
            dq = makeDq(dq, n, flag);
        }

        while(R-- > H){
            int location = dq.poll();
            if(li.get(location).size() == 0){
                break;
            }
            answer += li.get(location).poll();
            dq.offer(location);
        }

        System.out.println(answer);
    }
    public static Deque<Integer> makeDq (Deque<Integer>dq, int n, boolean flag){
        Deque<Integer> newDq = new ArrayDeque<>();
        int first = 0;
        int second = 0;

        if(flag){
            first = n;
        }
        else{
            second = n;
        }

        while(!dq.isEmpty()){
            int tmp = dq.poll();
            newDq.offer(tmp + first);
            newDq.offer(tmp + second);
        }
        return newDq;
    }
}