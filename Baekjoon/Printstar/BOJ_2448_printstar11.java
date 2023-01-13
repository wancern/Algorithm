import java.io.*;

public class Main_2448 {
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int size = 2 * N - 1;
		arr = new int[N][size];
		
		makeStar(0, size / 2, size);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < size; j++) {
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
		if(n == 5) {
			for(int i = y - 2; i <= y+2; i++) {
				arr[x+2][i] = 1;
			}
			arr[x][y] = 1;
			arr[x+1][y-1] = 1;
			arr[x+1][y+1] = 1;
			
			return;
		}
		
		makeStar(x, y, n/2);
		makeStar(x + ((n + 1)/2)/2, y - (n/2)/2 - 1, n/2);
		makeStar(x + ((n + 1)/2)/2 ,y + (n/2)/2 + 1, n/2);
	}
}
