import java.util.*;
import java.io.*;

public class KakaoMobility_2_2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


    }

    class Solution {
        public int solution(int n, int[][] edges, int[] users, int d, int limit) {
            int answer = 0;

            int[][] map = new int[n][n];

            for(int i = 0; i<edges.length; i++){
                for(int j = 0; j<edges[0].length; j++){
                    map[edges[i][0] - 1][edges[i][1] - 1] = edges[i][2];
                    map[edges[i][1] - 1][edges[i][0] - 1] = edges[i][2];
                }
            }

            for(int k = 0; k < n; k++){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(k == j || map[k][i] == 0 || map[i][j] == 0){
                            continue;
                        }
                        if(map[k][j] == 0){
                            map[k][j] = map[k][i] + map[i][j];
                            map[j][k] = map[k][j];
                        }
                        else{
                            map[k][j] = Math.min(map[k][j], map[k][i] + map[i][j]);
                            map[j][k] = map[k][j];
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++){
                int[]       first = new int[n];
                for(int k = 0; k < n; k++){
                    if(map[i][k] <= d){
                        first[k] = users[k];
                    }
                }

                for(int j = i + 1; j < n; j++){
                    int[] second = new int[n];
                    for(int k = 0; k < n; k++){
                        if(map[j][k] <= d){
                            second[k] = users[k];
                        }
                    }

                    int a = 0;
                    int b = 0;
                    int both = 0;
                    int res = 0;
                    for(int k = 0; k < n; k++){
                        if(first[k] > 0){
                            if(second[k] > 0){
                                both += first[k];
                                continue;
                            }
                            a += first[k];
                            continue;
                        }
                        b += second[k];
                    }

                    res += Math.min(a, limit);
                    res += Math.min(b, limit);
                    if(res < limit * 2){
                        res = Math.min(limit * 2, res + both);
                    }
                    answer = Math.max(answer, res);
                }
            }
            return answer;
        }
    }
}