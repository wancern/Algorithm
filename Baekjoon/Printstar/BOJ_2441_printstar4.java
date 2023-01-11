import java.io.*;

public class BOJ_2441_printstar4 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				sb.append(" ");
			}
			for(int j = N; j > i; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}