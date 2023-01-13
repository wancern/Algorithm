import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SWEA_supplyRoot {
    public static int N;
    public static int answer;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=T; testcase++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i = 0; i < N; i++){
                String str = br.readLine();
                for(int j = 0; j < N; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            answer = bfs(0,0);

            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        int[][] costmap = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                costmap[i][j] = Integer.MAX_VALUE;
            }
        }
        costmap[x][y] = 0;
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= N || nx < 0 || ny >= N || ny < 0 ) continue;

                if(costmap[nx][ny] > costmap[now[0]][now[1]] + arr[nx][ny]){
                    costmap[nx][ny] = costmap[now[0]][now[1]] + arr[nx][ny];

                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return costmap[N-1][N-1];
    }
}