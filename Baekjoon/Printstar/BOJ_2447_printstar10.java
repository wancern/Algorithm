import java.io.*;

public class BOJ_2447_printstar10 {
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		makeStar(0, 0, N);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void makeStar(int x, int y, int n) {		
		if(n == 3) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == 1 && j == 1) continue;
					arr[x + i][y + j] = 1;
				}
			}
			return;
		}
		
		int cnt = 0;		
		
		for(int i = x; i < x + n; i += n/3){
			for(int j = y; j < y + n; j+= n/3) {
				if(cnt++ != 4) {
					makeStar(i, j, n/3);
				}
			}
		}
	}
}
