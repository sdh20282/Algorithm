import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), groups = 0, count = 0;
		int[][] map = new int[n][n];
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String st = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				if (visited[i][j]) {
					continue;
				}
				
				q.offer(new int[] {i, j});
				groups += 1;
				count = 0;
				
				while (q.size() > 0) {
					int[] now = q.poll();
					
					if (visited[now[0]][now[1]]) {
						continue;
					}
					
					visited[now[0]][now[1]] = true;
					count += 1;
					
					for (int[] dir : dirs) {
						int nextR = now[0] + dir[0], nextC = now[1] + dir[1];
						
						if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) {
							continue;
						}
						
						if (map[nextR][nextC] == 0) {
							continue;
						}
						
						q.offer(new int[] {nextR, nextC});
					}
				}
				
				arr.add(count);
			}
		}

		arr.sort((a, b) -> a - b);
		
		System.out.println(groups);
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
