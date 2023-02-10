import java.io.*;
import java.util.*;

public class BOJ_1074 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = X;
		int sum = 0;
		int answer = 1;
		
		for(int i = 0; i < X; i++) {
			sum += arr[i];
		}
		int max = sum;
		while(right < N) {
			sum = sum + arr[right++] - arr[left++];
			
			if(sum > max) {
				max = sum;
				answer = 1;
				continue;
			}
			else if( sum == max ) {
				answer++;
			}
		}
		if(max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(answer);
	}
}