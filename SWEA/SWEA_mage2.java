import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SWEA_mage2 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=10; testcase++) {

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++){
                String str = br.readLine();
                for(int j = 0; j < 100; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int answer = bfs(arr, 1, 1);

            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int[][] arr, int x, int y){
        Queue<int[]>q = new LinkedList<>();
        boolean[][] visit = new boolean[100][100];
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 100 || nx < 0 || ny >= 100 || ny < 0 || arr[nx][ny] == 1 || visit[nx][ny]) continue;

                if(arr[nx][ny] == 3){
                    return 1;
                }
                visit[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
        return 0;
    }
}