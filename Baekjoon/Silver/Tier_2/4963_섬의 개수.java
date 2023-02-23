import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int[][] map;
		boolean[][] visited;
		int w, h, count;

		while ((w = Integer.parseInt(st.nextToken())) != 0 && (h = Integer.parseInt(st.nextToken())) != 0) {
			map = new int[h][w];
			visited = new boolean[h][w];
			count = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0) {
						continue;
					}

					if (visited[i][j]) {
						continue;
					}
					
					q.offer(new int[] {i, j});
					count += 1;
					
					while (q.size() > 0) {
						int[] now = q.poll();
						
						if (visited[now[0]][now[1]]) {
							continue;
						}
						
						visited[now[0]][now[1]] = true;
						
						for (int[] dir : dirs) {
							int nextR = now[0] + dir[0], nextC = now[1] + dir[1];
							
							if (nextR < 0 || nextR >= h || nextC < 0 || nextC >= w) {
								continue;
							}
							
							if (map[nextR][nextC] == 0) {
								continue;
							}
							
							q.offer(new int[] {nextR, nextC});
						}
					}
				}
			}
			
			System.out.println(count);
			st = new StringTokenizer(br.readLine());
		}
	}
}
