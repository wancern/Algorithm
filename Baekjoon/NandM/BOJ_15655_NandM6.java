import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static boolean[] visit;
	static int[] arr;
	static int[] num;
	
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		arr = new int[M];
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());;
		}
		Arrays.sort(num);
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
			if(!visit[i]) {
				arr[depth] = num[i];
				visit[i] = true;
				perm(depth+1, i);
				visit[i] = false;
			}
		}
	}
}