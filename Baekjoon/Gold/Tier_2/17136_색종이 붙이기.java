import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 10, min = Integer.MAX_VALUE;
	static int[][] map;
	static int sizes[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		sizes = new int[6];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs();
		
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}

	public static void dfs() {
		find : for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					for (int k = 5; k >= 1; k--) {
						if (check(i, j, k)) {
							if (sizes[k] >= 5) {
								continue;
							}
							
							if (getCount() > min) {
								continue;
							}
												
							fill(i, j, k, 0);
							sizes[k] += 1;

							dfs();
							
							fill(i, j, k, 1);
							sizes[k] -= 1;
						}
					}
					
					break find;
				}
			}
		}
	
		if (empty()) {
			min = Math.min(min, getCount());
		}
	}

	public static boolean check(int r, int c, int size) {
		if (r + size > N || c + size > N) {
			return false;
		}

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}
	
	public static boolean empty() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void fill(int r, int c, int size, int target) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = target;
			}
		}
	}

	public static int getCount() {
		int rst = 0;

		for (int count : sizes) {
			rst += count;
		}
		
		return rst;
	}
}
