import java.io.*;

public class BOJ_2444_printstar7 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//절댓값 이용 풀이
		for(int i = N - 1; Math.abs(i) < N; i--) {
			for(int j = 0; j < Math.abs(i); j++) {
				sb.append(" ");
			}
			for(int j = 0; j < 2 * (N - Math.abs(i) - 1) + 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		// 위아래 나눠서 풀이
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N - (i + 1); j++) {
//				sb.append(" ");
//			}
//			for(int j = 0; j < 2 * i + 1; j++) {
//				sb.append("*");
//			}
//			sb.append("\n");
//		}
//		
//		for(int i = 1; i < N; i++) {
//			for(int j = 0; j < i; j++) {
//				sb.append(" ");
//			}
//			for(int j = 0; j < 2 * (N-i) - 1; j++) {
//				sb.append("*");
//			}
//			sb.append("\n");
//		}
		System.out.println(sb);
	}
}