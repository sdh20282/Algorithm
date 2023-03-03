import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] drs = {-1, 0, 0, 1};
	static int[] dcs = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), count = 0;
		int[][] space = new int[n][n];
		int[] babyshark = new int[4];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				
				if (space[i][j] == 9) {
					babyshark = new int[] {i, j, 2, 0};
				}
			}
		}
		
		while (findFish(space, n, babyshark[2])) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			int[] target = {-1, -1, 10000};
			
			q.offer(new int[] {babyshark[0], babyshark[1], 0});
			visited[babyshark[0]][babyshark[1]] = true;
			
			while (!q.isEmpty()) {
				int repeat = q.size();
				
				for (int r = 0; r < repeat; r++) {
					int[] now = q.poll();
					
					if (space[now[0]][now[1]] != 0 && space[now[0]][now[1]] < babyshark[2]) {
						if (now[2] < target[2] || (now[2] == target[2] && now[0] < target[0]) || (now[2] == target[2] && now[0] == target[0] && now[1] < target[1])) {
							target = now;
						}
						
						continue;
					}
					
					if (now[2] >= target[2]) {
						continue;
					}
					
					for (int i = 0; i < 4; i++) {
						int dr = now[0] + drs[i], dc = now[1] + dcs[i];
						
						if (dr < 0 || dr >= n || dc < 0 || dc >= n) {
							continue;
						}
						
						if (visited[dr][dc]) {
							continue;
						}
						
						if (space[dr][dc] > babyshark[2]) {
							continue;
						}
						
						q.offer(new int[] {dr, dc, now[2] + 1});
						visited[dr][dc] = true;
					}
				}
			}
			
			if (target[0] == -1) {
				break;
			}
			
			space[babyshark[0]][babyshark[1]] = 0;
			space[target[0]][target[1]] = Math.max(babyshark[2], 9);
			
			babyshark[0] = target[0];
			babyshark[1] = target[1];
			babyshark[3] += 1;
			
			if (babyshark[2] == babyshark[3]) {
				babyshark[2] += 1;
				babyshark[3] = 0;
			}
			
			count += target[2];
		}
		
		System.out.println(count);
	}
	
	static boolean findFish(int[][] space, int n, int size) {
		boolean exist = false;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (space[i][j] != 0 && space[i][j] < size) {
					exist = true;
				}
			}
		}
		
		return exist;
	}
}
