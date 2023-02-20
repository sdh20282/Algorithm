import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		divide(0, 0, n);

		System.out.println(white);
		System.out.println(blue);
	}

	static void divide(int r, int c, int size) {
		int count = 0;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) count += map[i][j];
		}

		if (count == size * size) {
			blue++;
		} else if (count == 0) {
			white++;
		} else {
			int half = size / 2;

			divide(r, c, half);
			divide(r + half, c, half);
			divide(r, c + half, half);
			divide(r + half, c + half, half);
		}
	}
}
