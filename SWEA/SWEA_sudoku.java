import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_sudoku {
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase<=T; testcase++) {
            arr = new int[9][9];
            int answer = 1;

            for(int i = 0; i < 9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 9; i++){
                if(!rowCheck(i) || !colCheck(i)){
                    answer = 0;
                    break;
                }
            }

            for(int i = 0; i < 9; i+=3){
                for(int j = 0; j < 9; j+=3){
                    if(!squareCheck(i, j)){
                        answer = 0;
                    }
                }
            }

            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean rowCheck(int row){
        boolean[] check = new boolean[9];

        for(int i = 0; i < 9; i++){
            if(check[arr[row][i] - 1]) return false;
            check[arr[row][i] - 1] = true;
        }
        return true;
    }

    public static boolean colCheck(int col){
        boolean[] check = new boolean[9];

        for(int i = 0; i < 9; i++){
            if(check[arr[i][col] - 1]) return false;
            check[arr[i][col] - 1] = true;
        }
        return true;
    }

    public static boolean squareCheck(int row, int col){
        boolean[] check = new boolean[9];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(check[arr[row + i][col + j] - 1]) return false;
                check[arr[row + i][col + j] - 1] = true;
            }
        }
        return true;
    }
}




