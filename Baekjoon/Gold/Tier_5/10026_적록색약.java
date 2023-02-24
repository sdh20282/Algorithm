import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), count = 0;
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		String[][] pic = new String[n][];
		Stack<int[]> s = new Stack<>();
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			pic[i] = br.readLine().split("");
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}

				s.add(new int[] { i, j });
				count += 1;

				while (s.size() > 0) {
					int[] now = s.pop();

					if (visited[now[0]][now[1]]) {
						continue;
					}

					visited[now[0]][now[1]] = true;

					for (int[] dir : dirs) {
						int nr = now[0] + dir[0], nc = now[1] + dir[1];

						if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
							continue;
						}

						if (visited[nr][nc] || !pic[now[0]][now[1]].equals(pic[nr][nc])) {
							continue;
						}

						s.add(new int[] { nr, nc });
					}
				}
			}
		}
		
		System.out.print(count + " ");
		
		visited = new boolean[n][n];
		count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				
				boolean isBlue = "B".equals(pic[i][j]);

				s.add(new int[] { i, j });
				count += 1;

				while (s.size() > 0) {
					int[] now = s.pop();

					if (visited[now[0]][now[1]]) {
						continue;
					}

					visited[now[0]][now[1]] = true;

					for (int[] dir : dirs) {
						int nr = now[0] + dir[0], nc = now[1] + dir[1];

						if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
							continue;
						}

						if (visited[nr][nc] || isBlue != "B".equals(pic[nr][nc])) {
							continue;
						}

						s.add(new int[] { nr, nc });
					}
				}
			}
		}

		System.out.println(count);
	}
}
