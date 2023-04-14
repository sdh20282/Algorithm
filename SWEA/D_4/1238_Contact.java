import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] edges = new ArrayList[101];
			boolean[] visited = new boolean[101];
			int[] answer = {0, 0};
			
			for (int i = 1; i < 101; i++) {
				edges[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < l / 2; i++) {
				edges[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {start, 0});
			
			while (!q.isEmpty()) {
				int[] now = q.poll();
				
				if (visited[now[0]]) {
					continue;
				}
				
				visited[now[0]] = true;

				if (answer[1] < now[1]) {
					answer = now;
				} else if (answer[1] == now[1] && answer[0] < now[0]) {
					answer = now;
				}
				
				for (int linked : edges[now[0]]) {
					if (visited[linked]) {
						continue;
					}
					
					q.offer(new int[] {linked, now[1] + 1});
				}
			}
			
			System.out.println("#" + test_case + " " + answer[0]);
		}
	}
}
