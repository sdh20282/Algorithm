import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
		int[][] edges = new int[n + 1][n + 1];
		boolean[] visitedQ = new boolean[n + 1];
		boolean[] visitedS = new boolean[n + 1];
		
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			edges[a][b] = edges[b][a] = 1;
		}
		
		s.add(start);
		
		while(s.size() > 0) {
			int now = s.pop();
			
			if (visitedS[now]) {
				continue;
			}
			
			visitedS[now] = true;
			sb.append(now).append(" ");
			
			for (int i = n; i > 0; i--) {
				if (edges[now][i] == 1 && !visitedS[i]) {
					s.add(i);
				}
			}
		}

		sb.append("\n");
		
		q.offer(start);
		
		while(q.size() > 0) {
			int now = q.poll();
			
			if (visitedQ[now]) {
				continue;
			}
			
			visitedQ[now] = true;
			sb.append(now).append(" ");
			
			for (int i = 0; i <= n; i++) {
				if (edges[now][i] == 1 && !visitedQ[i]) {
					q.offer(i);
				}
			}
		}
		
		System.out.println(sb);
	}
}
