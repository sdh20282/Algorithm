import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String now = br.readLine();

			for (int j = 0; j < 9; j++) {
				map[i][j] = now.charAt(j) - '0';
			}
		}

		make(0);
	}

	public static void make(int n) {
		if (n == 81) {
			for (int i = 0; i < 9; i++) {
				String rst = "";
				
				for (int j = 0; j < 9; j++) {
					rst += map[i][j];
				}
				
				System.out.println(rst);
			}

			System.exit(0);
		}
		
		if (map[(int) n / 9][n % 9] != 0) {
			make(n + 1);
		} else {
			for (int k = 1; k < 10; k++) {
				map[(int) n / 9][n % 9] = k;
				
				if (check((int) n / 9, n % 9)) {
					make(n + 1);
				}
				
				map[(int) n / 9][n % 9] = 0;
			}
		}
	}

	public static boolean check(int r, int c) {
		boolean[] checked = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (map[i][c] == 0) {
				continue;
			}

			if (checked[map[i][c]]) {
				return false;
			}

			checked[map[i][c]] = true;
		}

		checked = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (map[r][i] == 0) {
				continue;
			}

			if (checked[map[r][i]]) {
				return false;
			}

			checked[map[r][i]] = true;
		}

		checked = new boolean[10];

		for (int i = ((int) r / 3) * 3; i < ((int) r / 3) * 3 + 3; i++) {
			for (int j = ((int) c / 3) * 3; j < ((int) c / 3) * 3 + 3; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				if (checked[map[i][j]]) {
					return false;
				}

				checked[map[i][j]] = true;
			}
		}

		return true;
	}
}
