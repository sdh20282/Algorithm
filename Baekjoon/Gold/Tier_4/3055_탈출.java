import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int[] start = new int[2];
		int[] end = new int[2];
		
		for (int i = 0; i < R; i++) {
			String now = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = now.charAt(j);
				
				if (map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				}
				
				if (map[i][j] == 'D') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.') {
					continue;
				}
				
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k], nc = j + dc[k];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
						continue;
					}
					
					if (map[nr][nc] != '*') {
						continue;
					}
					
					map[i][j] = '!';
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int count = 0;
		boolean reached = false;
		
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		find : while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				
				if (now[0] == end[0] && now[1] == end[1]) {
					reached = true;
					break find;
				}
				
				for (int k = 0; k < 4; k++) {
					int nr = now[0] + dr[k], nc = now[1] + dc[k];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
						continue;
					}
					
					
					if (visited[nr][nc]) {
						continue;
					}
					
					if (map[nr][nc] != '.' && map[nr][nc] != 'D') {
						continue;
					}
					
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '!') {
						map[i][j] = '*';
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != '.') {
						continue;
					}
					
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k], nc = j + dc[k];
						
						if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
							continue;
						}
						
						if (map[nr][nc] != '*') {
							continue;
						}
						
						map[i][j] = '!';
					}
				}
			}
			
			count += 1;
		}
		
		System.out.println(reached ? count : "KAKTUS");
	}
}
