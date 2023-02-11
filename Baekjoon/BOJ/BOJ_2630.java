import java.io.*;
import java.util.*;

public class BOJ_2630 {
	static int N;
	static int[][] arr;
	static int[] color;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		color = new int[3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		color[divide(0, 0, N)]++;
		System.out.println(color[0]);
		System.out.println(color[1]);
	}
	
	static int divide(int r, int c, int n) {
		if(n == 1) {
			return arr[r][c];
		}
		
		int num1 = divide(r, c, n/2);
		int num2 = divide(r + n/2, c, n/2);
		int num3 = divide(r, c + n/2, n/2);
		int num4 = divide(r + n/2, c + n/2, n/2);
		if(num1 == num2 && num3 == num4 && num1 == num3) {
			return num1;
		}
		
		color[num1]++;
		color[num2]++;
		color[num3]++;
		color[num4]++;
		
		return 2;
	}
}