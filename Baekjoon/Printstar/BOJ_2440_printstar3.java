import java.io.*;

public class BOJ_2440_printstar3 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = N; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
