import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int now = Integer.parseInt(st.nextToken());

				if (now == 0) {
					map[i][j] = now;
				} else {
					map[i][j] = -1;
				}
			}
		}

		int count = 1;
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					continue;
				}

				map[i][j] = count;
				q.offer(new int[] { i, j });

				while (!q.isEmpty()) {
					int[] now = q.poll();

					for (int k = 0; k < 4; k++) {
						int nr = now[0] + dr[k], nc = now[1] + dc[k];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							continue;
						}

						if (map[nr][nc] != -1) {
							continue;
						}

						map[nr][nc] = count;
						q.offer(new int[] { nr, nc });
					}
				}

				count += 1;
			}
		}

		ArrayList<int[]> edges = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					continue;
				}

				int len = 1, l = 0, u = 0;
				int m = i - 1;

				while (m >= 0 && map[m][j] == 0) {
					len += 1;
					m -= 1;
				}
				
				if (m >= 0) {
					l = map[m][j];
				}

				m = i + 1;

				while (m < N && map[m][j] == 0) {
					len += 1;
					m += 1;
				}
				
				if (m < N) {
					u = map[m][j];
				}
				
				if (len != 1 && l != 0 && u != 0) {
					edges.add(new int[] {len, l, u});
				}
				
				len = 1;
				l = 0;
				u = 0;
				m = j - 1;

				while (m >= 0 && map[i][m] == 0) {
					len += 1;
					m -= 1;
				}
				
				if (m >= 0) {
					l = map[i][m];
				}

				m = j + 1;

				while (m < M && map[i][m] == 0) {
					len += 1;
					m += 1;
				}
				
				if (m < M) {
					u = map[i][m];
				}
				
				if (len != 1 && l != 0 && u != 0) {
					edges.add(new int[] {len, l, u});
				}
			}
		}
		
		edges.sort((a, b) -> a[0] - b[0]);

		int check = 1, n = edges.size(), rst = 0;
		int[] kruskal = new int[count];
		
		for (int i = 0; i < count; i++) {
			kruskal[i] = -1;
		}
		
		for (int i = 0; i < n; i++) {
			if (check == count - 1) {
				break;
			}
			
			int[] now = edges.get(i);
			int a = now[1], b = now[2];
			
			while (kruskal[a] != -1) {
				a = kruskal[a];
			}
			
			while (kruskal[b] != -1) {
				b = kruskal[b];
			}
			
			if (a == b && a != -1) {
				continue;
			}
			
			kruskal[b] = a;
			check += 1;
			rst += now[0];
		}
		
		System.out.println((rst == 0 || check != count - 1) ? -1 : rst);
	}
}
