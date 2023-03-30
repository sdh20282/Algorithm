import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), max = 0;
		int[][] map = new int[n][m];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n * m; i++) {
			if (map[(int) i / m][i % m] != 0) {
				continue;
			}
			
			map[(int) i / m][i % m] = 1;
			
			for (int j = i + 1; j < n * m; j++) {
				if (map[(int) j / m][j % m] != 0) {
					continue;
				}
				
				map[(int) j / m][j % m] = 1;
				
				for (int k = j + 1; k < n * m; k++) {
					if (map[(int) k / m][k % m] != 0) {
						continue;
					}
					
					map[(int) k / m][k % m] = 1;
					
					int[][] copyMap = new int[n][m];
					int count = 0;
					
					for (int r = 0; r < n; r++) {
						for (int c = 0; c < m; c++) {
							copyMap[r][c] = map[r][c];
						}
					}
					
					for (int r = 0; r < n; r++) {
						for (int c = 0; c < m; c++) {
							if (copyMap[r][c] != 2) {
								continue;
							}
							
							q.offer(new int[] {r, c});
							
							while (!q.isEmpty()) {
								int[] now = q.poll();
								
								for (int l = 0; l < 4; l++) {
									int nr = now[0] + dr[l];
									int nc = now[1] + dc[l];
									
									if (nr < 0 || nr >= n || nc <  0 || nc >= m) {
										continue;
									}
									
									if (copyMap[nr][nc] != 0) {
										continue;
									}
									
									copyMap[nr][nc] = 2;
									
									q.offer(new int[] {nr, nc});
								}
							}
						}
					}

					for (int r = 0; r < n; r++) {
						for (int c = 0; c < m; c++) {
							if (copyMap[r][c] != 0) {
								continue;
							}
							
							copyMap[r][c] = 1;
							count += 1;
							q.offer(new int[] {r, c});
							
							while (!q.isEmpty()) {
								int[] now = q.poll();
								
								for (int l = 0; l < 4; l++) {
									int nr = now[0] + dr[l];
									int nc = now[1] + dc[l];
									
									if (nr < 0 || nr >= n || nc <  0 || nc >= m) {
										continue;
									}
									
									if (copyMap[nr][nc] != 0) {
										continue;
									}
									
									copyMap[nr][nc] = 1;
									count += 1;
									q.offer(new int[] {nr, nc});
								}
							}
						}
					}
					
					if (max < count) {
						max = count;
					}
					
					map[(int) k / m][k % m] = 0;
				}
				
				map[(int) j / m][j % m] = 0;
			}
			
			map[(int) i / m][i % m] = 0;
		}
		
		System.out.println(max);
	}
}
