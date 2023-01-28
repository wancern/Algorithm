import java.util.*;
import java.io.*;

public class KM_2_1 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


    }

    class Solution {
        public int min_bike = Integer.MAX_VALUE;
        public int min_public = Integer.MAX_VALUE;

        public int solution(int[][] infos, int m) {
            int answer = 0;
            int car_time = 0;
            int bike_time = 0;
            int public_time = 0;
            int bike_walking_time = 0;
            int public_walking_time = 0;
            Queue<Integer> bike_q = new LinkedList<>();
            Queue<Integer> public_q = new LinkedList<>();

            for (int i = 0; i < infos.length; i++) {
                car_time += infos[i][0];
                if (infos[i][1] > infos[i][3]) {
                    bike_q.offer(i);
                } else {
                    bike_time += infos[i][1];
                }

                if (infos[i][2] > infos[i][3] || infos[i][2] == -1) {
                    public_q.offer(i);
                } else {
                    public_time += infos[i][2];
                }
            }

            int start = bike_q.peek();

            while (!bike_q.isEmpty()) {
                int idx = bike_q.poll();
                bike_walking_time += infos[idx][3];

                if (!bike_q.isEmpty()) {
                    if (idx + 1 == bike_q.peek()) {
                        continue;
                    }
                    if (bike_walking_time <= m) {
                        bike_time += bike_walking_time;
                        bike_walking_time = 0;
                        start = bike_q.peek();
                        continue;
                    }
                    bike_dfs(start, idx, infos, m, 0, 0);
                    bike_time += min_bike;
                    bike_walking_time = 0;
                    start = bike_q.peek();
                    continue;
                }
                if (bike_walking_time <= m) {
                    bike_time += bike_walking_time;
                    continue;
                }
                bike_dfs(start, idx, infos, m, 0, 0);
                bike_time += min_bike;
            }

            start = public_q.peek();

            while (!public_q.isEmpty()) {
                int idx = public_q.poll();
                public_walking_time += infos[idx][3];

                if (!public_q.isEmpty()) {
                    if (idx + 1 == public_q.peek()) {
                        continue;
                    }
                    if (public_walking_time <= m) {
                        public_time += public_walking_time;
                        public_walking_time = 0;
                        start = public_q.peek();
                        continue;
                    }
                    public_dfs(start, idx, infos, m, 0, 0);
                    public_time += min_public;
                    public_walking_time = 0;
                    start = public_q.peek();
                    continue;
                }
                if (public_walking_time <= m) {
                    public_time += public_walking_time;
                    continue;
                }
                public_dfs(start, idx, infos, m, 0, 0);
                if (min_public < Integer.MAX_VALUE) {
                    public_time += min_public;
                } else {
                    public_time = Integer.MAX_VALUE;
                    break;
                }
            }
            answer = Math.min(car_time, Math.min(bike_time, public_time));
            return answer;
        }

        public void bike_dfs(int start, int end, int[][] infos, int m, int walking, int result) {
            if (walking > m) {
                return;
            }
            if (start > end) {
                min_bike = Math.min(min_bike, result);
                return;
            }

            bike_dfs(start + 1, end, infos, m, walking + infos[start][3], result + infos[start][3]);
            bike_dfs(start + 1, end, infos, m, walking, result + infos[start][1]);
        }

        public void public_dfs(int start, int end, int[][] infos, int m, int walking, int result) {
            if (walking > m) {
                return;
            }
            if (start > end) {
                min_public = Math.min(min_public, result);
                return;
            }
            if (infos[start][2] != -1) {
                public_dfs(start + 1, end, infos, m, walking, result + infos[start][2]);
            }
            public_dfs(start + 1, end, infos, m, walking + infos[start][3], result + infos[start][3]);
        }
    }
}
/*
    class Solution {
        public int min_walking_time = Integer.MAX_VALUE;
        public int solution(int[][] infos, int m) {
            int answer = 0;
            int car_time = 0;
            int bike_time = 0;
            int public_time = 0;
            Queue<Integer> bike_q = new LinkedList<>();
            Queue<Integer> public_q = new LinkedList<>();

            for(int i = 0; i < infos.length; i++){
                car_time += infos[i][0];
                if(infos[i][1] > infos[i][3]){
                    bike_q.offer(i);
                }
                else{
                    bike_time += infos[i][1];
                }

                if(infos[i][2] > infos[i][3] || infos[i][2] == -1){
                    public_q.offer(i);
                }
                else{
                    public_time += infos[i][2];
                }
            }

            bike_time += walkingTime(infos, m, bike_q, 2);
            min_walking_time = Integer.MAX_VALUE;
            public_time += walkingTime(infos, m, public_q, 3);

            answer = Math.min(car_time, Math.min(bike_time, public_time));
            return answer;
        }

        private int walkingTime(int[][] infos, int m, Queue<Integer> q, int bikeOrPublic) {
            int start = q.peek();
            int walking_time = 0;
            while(!q.isEmpty()){
                int idx = q.poll();
                walking_time += infos[idx][bikeOrPublic];

                if(!q.isEmpty()){
                    if(idx+1 == q.peek()){
                        continue;
                    }
                    if(walking_time <= m){
                        walking_time += walking_time;
                        walking_time = 0;
                        start = q.peek();
                        continue;
                    }
                    dfs(start, idx, infos, m, 0, 0, bikeOrPublic);
                    walking_time += min_walking_time;
                    walking_time = 0;
                    start = q.peek();
                    continue;
                }
                if(walking_time <= m){
                    walking_time += walking_time;
                    continue;
                }

                dfs(start, idx, infos, m, 0, 0, bikeOrPublic);
                if(min_walking_time < Integer.MAX_VALUE){
                    walking_time += min_walking_time;
                }
                else{
                    walking_time = Integer.MAX_VALUE;
                    break;
                }
            }
            return walking_time;
        }

        public void dfs(int start, int end, int[][] infos, int m, int walking, int result, int bikeOrPublic){
            if(walking > m){
                return;
            }
            if(start > end){
                min_walking_time = Math.min(min_walking_time, result);
                return;
            }
            if(infos[start][bikeOrPublic] != -1){
                dfs(start + 1, end, infos, m, walking, result + infos[start][bikeOrPublic], bikeOrPublic);
            }
            dfs(start + 1, end, infos, m, walking + infos[start][3], result + infos[start][3], bikeOrPublic);
        }
    }
}
*/

