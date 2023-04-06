import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] min = new int[N][M];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = now.charAt(j) - '0';
				min[i][j] = 10000;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});
		min[0][0] = 0;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i], nc = now[1] + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}
				
				if (min[nr][nc] <= now[2] + map[nr][nc]) {
					continue;
				}
				
				q.offer(new int[] {nr, nc, now[2] + map[nr][nc]});
				min[nr][nc] = now[2] + map[nr][nc];
			}
		}
		
		System.out.println(min[N - 1][M - 1]);
	}
}
