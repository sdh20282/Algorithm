import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] nodes = new int[n+ 2][];
			boolean[] visited = new boolean[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				nodes[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			
			q.offer(nodes[0]);
			visited[0] = true;
			
			while (!q.isEmpty()) {
				int[] now = q.poll();
				
				if (Math.abs(now[0] - nodes[n + 1][0]) + Math.abs(now[1] - nodes[n + 1][1]) <= 1000) {
					visited[n + 1] = true;
					q.clear();
					break;
				}
				
				for (int i = 0; i < n + 1; i++) {
					if (visited[i]) {
						continue;
					}
					
					if (Math.abs(now[0] - nodes[i][0]) + Math.abs(now[1] - nodes[i][1]) > 1000) {
						continue;
					}
					
					visited[i] = true;
					q.offer(nodes[i]);
				}
			}
			
			if (visited[n + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}
