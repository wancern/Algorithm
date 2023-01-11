import java.io.*;

public class BOJ_2446_printstar9 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = N - 1; Math.abs(i) < N; i--) {
			for(int j = 0; j < N - Math.abs(i) - 1; j++) {
				sb.append(" ");
			}
			for(int j = 0; j < 2 * Math.abs(i) + 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		
		//교수님 방식
		// y = a ｜x - b｜ + c
		// a = 그래프로 그렸을 때 뒷부분의 기울기
		// b = 값이 변하는 점의 x 좌표
		// c = 값이 변하는 점의 y 좌표
				
		
		System.out.println(sb.toString());
	}
}

