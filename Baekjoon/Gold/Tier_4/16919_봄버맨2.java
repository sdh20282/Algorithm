import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N;
	static char[][] map;
	static ArrayList<int[]> bombs;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		bombs = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					bombs.add(new int[] {i, j});
				}
			}
		}
		
		for (int t = 2; t <= (N - 2) % 4 + 2; t++) {
			if (t % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						map[i][j] = 'O';
					}
				}
			}
			
			else {
				for (int[] now : bombs) {
					map[now[0]][now[1]] = '.';
					
					for (int i = 0; i < 4; i++) {
						int nr = now[0] + dr[i], nc = now[1] + dc[i];
						
						if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
							continue;
						}
						
						map[nr][nc] = '.';
					}
				}
				
				bombs.clear();
				
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == 'O') {
							bombs.add(new int[] {i, j});
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			
			System.out.println();
		}
	}
}
