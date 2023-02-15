import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
				R = Integer.parseInt(st.nextToken()), temp;
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				int[][] updown = new int[n][m];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						updown[n - r - 1][c] = arr[r][c];
					}
				}

				arr = updown;
				break;
			case 2:
				int[][] rightleft = new int[n][m];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						rightleft[r][m - c - 1] = arr[r][c];
					}
				}

				arr = rightleft;
				break;
			case 3:
				int[][] rightRotate = new int[m][n];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						rightRotate[c][n - r - 1] = arr[r][c];
					}
				}

				temp = n;
				n = m;
				m = temp;

				arr = rightRotate;
				break;
			case 4:
				int[][] leftRotate = new int[m][n];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						leftRotate[m - c - 1][r] = arr[r][c];
					}
				}

				temp = n;
				n = m;
				m = temp;

				arr = leftRotate;
				break;
			case 5:
				int[][] rotateRight = new int[n][m];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						if (r < n / 2 && c < m / 2) {
							rotateRight[r][c + m / 2] = arr[r][c];
						} else if (r < n / 2 && c >= m / 2) {
							rotateRight[r + n / 2][c] = arr[r][c];
						} else if (r >= n / 2 && c >= m / 2) {
							rotateRight[r][c - m / 2] = arr[r][c];
						} else if (r >= n / 2 && c < m / 2) {
							rotateRight[r - n / 2][c] = arr[r][c];
						}
					}
				}

				arr = rotateRight;
				break;
			case 6:
				int[][] rotateLeft = new int[n][m];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < m; c++) {
						if (r < n / 2 && c < m / 2) {
							rotateLeft[r + n / 2][c] = arr[r][c];
						} else if (r < n / 2 && c >= m / 2) {
							rotateLeft[r][c - m / 2] = arr[r][c];
						} else if (r >= n / 2 && c >= m / 2) {
							rotateLeft[r - n / 2][c] = arr[r][c];
						} else if (r >= n / 2 && c < m / 2) {
							rotateLeft[r][c + m / 2] = arr[r][c];
						}
					}
				}

				arr = rotateLeft;
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(' ');
			}

			sb.append('\n');
		}

		System.out.println(sb);
	}
}
