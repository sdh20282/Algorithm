import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] matrix23 = { { { 1, 0, 0 }, { 1, 1, 1 } }, { { 0, 1, 0 }, { 1, 1, 1 } }, { { 0, 0, 1 }, { 1, 1, 1 } },
				{ { 1, 1, 1 }, { 1, 0, 0 } }, { { 1, 1, 1 }, { 0, 1, 0 } }, { { 1, 1, 1 }, { 0, 0, 1 } },
				{ { 1, 1, 0 }, { 0, 1, 1 } }, { { 0, 1, 1 }, { 1, 1, 0 } } };
		int[][][] matrix32 = { { { 1, 1 }, { 1, 0 }, { 1, 0 } }, { { 1, 0 }, { 1, 1 }, { 1, 0 } },
				{ { 1, 0 }, { 1, 0 }, { 1, 1 } }, { { 1, 1 }, { 0, 1 }, { 0, 1 } }, { { 0, 1 }, { 1, 1 }, { 0, 1 } },
				{ { 0, 1 }, { 0, 1 }, { 1, 1 } }, { { 1, 0 }, { 1, 1 }, { 0, 1 } }, { { 0, 1 }, { 1, 1 }, { 1, 0 } } };
		int max = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 2 * 2
				if (r + 2 <= N && c + 2 <= M) {
					int nowMax = 0;

					for (int i = r; i < r + 2; i++) {
						for (int j = c; j < c + 2; j++) {
							nowMax += map[i][j];
						}
					}

					max = Math.max(max, nowMax);
				}

				// 4 * 1
				if (r + 4 <= N) {
					int nowMax = 0;

					for (int i = r; i < r + 4; i++) {
						nowMax += map[i][c];
					}

					max = Math.max(max, nowMax);
				}

				// 1 * 4
				if (c + 4 <= M) {
					int nowMax = 0;

					for (int i = c; i < c + 4; i++) {
						nowMax += map[r][i];
					}

					max = Math.max(max, nowMax);
				}

				// 2 * 3
				if (r + 2 <= N && c + 3 <= M) {
					for (int[][] matrix : matrix23) {
						int nowMax = 0;

						for (int i = r; i < r + 2; i++) {
							for (int j = c; j < c + 3; j++) {
								if (matrix[i - r][j - c] == 1) {
									nowMax += map[i][j];
								}
							}
						}

						max = Math.max(max, nowMax);
					}
				}

				// 3 * 2
				if (r + 3 <= N && c + 2 <= M) {
					for (int[][] matrix : matrix32) {
						int nowMax = 0;

						for (int i = r; i < r + 3; i++) {
							for (int j = c; j < c + 2; j++) {
								if (matrix[i - r][j - c] == 1) {
									nowMax += map[i][j];
								}
							}
						}

						max = Math.max(max, nowMax);
					}
				}
			}
		}

		System.out.println(max);
	}
}
