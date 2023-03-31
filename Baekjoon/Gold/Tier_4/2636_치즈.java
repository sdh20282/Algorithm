import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.time.LocalDateTime;

public class Main {
	static int n, m;
	static int[][] plate;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		plate = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		int count = 0, cur = 0;
		
		while (cheeseLeft()) {
			cur = 0;
			
			q.offer(new int[] {0, 0});

			boolean[][] visited = new boolean[n][m];
			visited[0][0] = true;
			
			while (!q.isEmpty()) {
				int[] now = q.poll();
				
				plate[now[0]][now[1]] = 2;
				
				for (int i = 0; i < 4; i++) {
					int nr = now[0] + dr[i], nc = now[1] + dc[i];
					
					if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
						continue;
					}
					
					if (visited[nr][nc] || plate[nr][nc] == 1) {
						continue;
					}
					
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (plate[i][j] != 1) {
						continue;
					}
					
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k], nc = j + dc[k];
						
						if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
							continue;
						}
						
						if (plate[nr][nc] == 2) {
							plate[i][j] = 3;
							cur += 1;
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (plate[i][j] == 3) {
						plate[i][j] = 2;
					}
				}
			}

			count += 1;
		}
		
		System.out.println(count);
		System.out.println(cur);
	}
	
	public static boolean cheeseLeft() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (plate[i][j] == 1) {
					return true;
				}
			}
		}
		
		return false;
	}
}
