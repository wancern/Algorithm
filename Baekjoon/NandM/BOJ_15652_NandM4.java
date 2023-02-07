import java.util.*;
import java.io.*;

public class BOJ_15652_NandM4 {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int depth, int last) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = last; i < N; i++) {
			arr[depth] = i + 1;
			perm(depth+1, i);
		}
	}
}