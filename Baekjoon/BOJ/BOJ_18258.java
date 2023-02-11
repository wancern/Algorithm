import java.io.*;
import java.util.*;

public class BOJ_18258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer>q = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
			}else if (cmd.equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.poll()).append("\n");
					continue;
				}
				sb.append(-1).append("\n");
			}else if (cmd.equals("size")) {
				sb.append(q.size()).append("\n");
			}else if (cmd.equals("empty")) {
				if(!q.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				sb.append(1).append("\n");
			}else if (cmd.equals("front")) {
				if(!q.isEmpty()) {
					sb.append(q.peek()).append("\n");
					continue;
				}
				sb.append(-1).append("\n");
			}else if (cmd.equals("back")) {
				if(!q.isEmpty()) {
					sb.append(q.peekLast()).append("\n");
					continue;
				}
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
