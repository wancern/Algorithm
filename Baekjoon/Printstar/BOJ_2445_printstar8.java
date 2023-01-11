import java.io.*;

public class BOJ_2445_printstar8 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = N - 1; Math.abs(i) < N; i--) {
			for(int j = 0; j < N - Math.abs(i); j++) {
				sb.append("*");
			}
			for(int j = 0; j < 2 * Math.abs(i); j++) {
				sb.append(" ");
			}
			for(int j = 0; j < N - Math.abs(i); j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}