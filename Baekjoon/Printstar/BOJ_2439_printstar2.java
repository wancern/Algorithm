import java.io.*;

public class BOJ_2439_printstar2 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//static에서 non-static 메소드를 호출하는 방법 -> 객체 생성
		Main_2439 mm = new Main_2439();
		mm.showStar(N);
	}
	
	public void showStar(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = n-1; j > i; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
