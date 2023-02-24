import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, max = 0;
	static int[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };;
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			String now = br.readLine();

			for (int j = 0; j < c; j++) {
				map[i][j] = now.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		
		System.out.println(max);
	}

	static void dfs(int row, int col, int count) {
		if (visited[map[row][col]]) {
			max = Math.max(max, count);
			return;
		}

		visited[map[row][col]] = true;

		for (int[] dir : dirs) {
			int nr = row + dir[0], nc = col + dir[1];
			
			if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
				continue;
			}
			
			dfs(nr, nc, count + 1);
		}
		
		visited[map[row][col]] = false;
	}
}
