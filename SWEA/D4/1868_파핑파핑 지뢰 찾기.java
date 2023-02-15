import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		Queue<int[]> q = new LinkedList<>();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				String nowLine = br.readLine();
				
				for (int j = 0; j < n; j++) {
					char now = nowLine.charAt(j);
					
					if (now != '*') {
						continue;
					}
					
					map[i][j] = -1;
					
					for (int[] dir : dirs) {
						if (i + dir[0] < 0 || i + dir[0] >= n || j + dir[1] < 0 || j + dir[1] >= n) {
							continue;
						}
						
						if (map[i + dir[0]][j + dir[1]] == -1) {
							continue;
						}
						
						map[i + dir[0]][j + dir[1]] += 1;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						continue;
					}
					
					if (map[i][j] == 0) {
						visited[i][j] = true;
						count += 1;
						
						for (int[] dir : dirs) {
							if (i + dir[0] < 0 || i + dir[0] >= n || j + dir[1] < 0 || j + dir[1] >= n) {
								continue;
							}
							
							q.offer(new int[] {i + dir[0], j + dir[1]});
						}
						
						while (q.size() > 0) {
							int[] now = q.poll();
							int nowR = now[0], nowC = now[1];
							
							if (visited[nowR][nowC]) {
								continue;
							}
							visited[nowR][nowC] = true;
							
							if (map[nowR][nowC] != 0) {
								continue;
							}
							
							for (int[] dir : dirs) {
								if (nowR + dir[0] < 0 || nowR + dir[0] >= n || nowC + dir[1] < 0 || nowC + dir[1] >= n) {
									continue;
								}
								
								q.offer(new int[] {nowR + dir[0], nowC + dir[1]});
							}
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == -1 || visited[i][j]) {
						continue;
					}
					
					count += 1;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}
}
