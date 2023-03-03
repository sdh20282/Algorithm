import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] drs = {-1, 1, 0, 0};
	static int[] dcs = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		
		int[][] storage = new int[n][m];
		ArrayList<int[]> growns = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				storage[i][j] = Integer.parseInt(st.nextToken());
				
				if (storage[i][j] == 1) {
					growns.add(new int[] {i, j});
				}
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		int count = -1;
		
		for (int[] grown : growns) {
			q.offer(grown);
			visited[grown[0]][grown[1]] = true;
		}
		
		while (!q.isEmpty()) {
			int repeat = q.size();
			
			for (int g = 0; g < repeat; g++) {
				int[] grown = q.poll();
				
				storage[grown[0]][grown[1]] = 1;
				
				for (int i = 0; i < 4; i++) {
					int dr = grown[0] + drs[i], dc = grown[1] + dcs[i];
					
					if (dr < 0 || dr >= n || dc < 0 || dc >= m) {
						continue;
					}
					
					if (storage[dr][dc] != 0) {
						continue;
					}
					
					if (visited[dr][dc]) {
						continue;
					}
					
					q.offer(new int[] {dr, dc});
					visited[dr][dc] = true;
				}
			}
			
			count += 1;
		}
		
		if (isGrown(storage, n, m)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
	
	static boolean isGrown(int[][] storage, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (storage[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
