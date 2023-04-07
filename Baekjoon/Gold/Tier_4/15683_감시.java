import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] cctv;
	static int[][] duplicated;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new int[8][];
		duplicated = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv[K] = new int[] { i, j };
					K += 1;
				}
			}
		}

		dfs(0);

		System.out.println(min);
	}

	public static void dfs(int cur) {
		if (cur == K) {
			int count = countBlank();

			if (count < min) {
				min = count;
			}

			return;
		}

		int[] target = cctv[cur];

		if (map[target[0]][target[1]] == 1) {
			for (int i = 0; i < 4; i++) {
				int nr = target[0] + dr[i], nc = target[1] + dc[i];

				while (true) {
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						break;
					}

					if (map[nr][nc] == 6) {
						break;
					}

					if (map[nr][nc] != 0 && map[nr][nc] != -1) {
						nr += dr[i];
						nc += dc[i];
						continue;
					}

					map[nr][nc] = -1;
					duplicated[nr][nc] += 1;

					nr += dr[i];
					nc += dc[i];
				}
				
				dfs(cur + 1);

				nr = target[0] + dr[i];
				nc = target[1] + dc[i];

				while (true) {
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						break;
					}

					if (map[nr][nc] == 6) {
						break;
					}

					if (map[nr][nc] != -1) {
						nr += dr[i];
						nc += dc[i];
						continue;
					}

					duplicated[nr][nc] -= 1;

					if (duplicated[nr][nc] == 0) {
						map[nr][nc] = 0;
					}

					nr += dr[i];
					nc += dc[i];
				}
			}
		}

		else if (map[target[0]][target[1]] == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					int index = i;

					if (j == 1) {
						index += 2;
					}

					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != 0 && map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						map[nr][nc] = -1;
						duplicated[nr][nc] += 1;

						nr += dr[index];
						nc += dc[index];
					}
				}
				
				dfs(cur + 1);

				for (int j = 0; j < 2; j++) {
					int index = i;

					if (j == 1) {
						index += 2;
					}

					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						duplicated[nr][nc] -= 1;

						if (duplicated[nr][nc] == 0) {
							map[nr][nc] = 0;
						}

						nr += dr[index];
						nc += dc[index];
					}
				}
			}
		}

		else if (map[target[0]][target[1]] == 3) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					int index = (i + j) % 4;
					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != 0 && map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						map[nr][nc] = -1;
						duplicated[nr][nc] += 1;

						nr += dr[index];
						nc += dc[index];
					}
				}
				
				dfs(cur + 1);

				for (int j = 0; j < 2; j++) {
					int index = (i + j) % 4;
					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						duplicated[nr][nc] -= 1;

						if (duplicated[nr][nc] == 0) {
							map[nr][nc] = 0;
						}

						nr += dr[index];
						nc += dc[index];
					}
				}
			}
		}

		else if (map[target[0]][target[1]] == 4) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					int index = (i + j) % 4;
					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != 0 && map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						map[nr][nc] = -1;
						duplicated[nr][nc] += 1;

						nr += dr[index];
						nc += dc[index];
					}
				}

				dfs(cur + 1);

				for (int j = 0; j < 3; j++) {
					int index = (i + j) % 4;
					int nr = target[0] + dr[index], nc = target[1] + dc[index];

					while (true) {
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							break;
						}

						if (map[nr][nc] == 6) {
							break;
						}

						if (map[nr][nc] != -1) {
							nr += dr[index];
							nc += dc[index];
							continue;
						}

						duplicated[nr][nc] -= 1;

						if (duplicated[nr][nc] == 0) {
							map[nr][nc] = 0;
						}

						nr += dr[index];
						nc += dc[index];
					}
				}
			}
		}

		else {
			for (int i = 0; i < 4; i++) {
				int nr = target[0] + dr[i], nc = target[1] + dc[i];

				while (true) {
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						break;
					}

					if (map[nr][nc] == 6) {
						break;
					}

					if (map[nr][nc] != 0 && map[nr][nc] != -1) {
						nr += dr[i];
						nc += dc[i];
						continue;
					}

					map[nr][nc] = -1;
					duplicated[nr][nc] += 1;

					nr += dr[i];
					nc += dc[i];
				}
			}

			dfs(cur + 1);

			for (int i = 0; i < 4; i++) {
				int nr = target[0] + dr[i], nc = target[1] + dc[i];

				while (true) {
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						break;
					}

					if (map[nr][nc] == 6) {
						break;
					}

					if (map[nr][nc] != -1) {
						nr += dr[i];
						nc += dc[i];
						continue;
					}

					duplicated[nr][nc] -= 1;

					if (duplicated[nr][nc] == 0) {
						map[nr][nc] = 0;
					}

					nr += dr[i];
					nc += dc[i];
				}
			}
		}
	}

	public static int countBlank() {
		int rst = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					continue;
				}

				rst += 1;
			}
		}

		return rst;
	}
}
