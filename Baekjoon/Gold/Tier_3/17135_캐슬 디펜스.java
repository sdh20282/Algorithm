import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, m, range, maxKill;
	static int[][] enemies;
	static int[] combinations;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        maxKill = 0;
        
        enemies = new int[n][m];
        combinations = new int[3];
        visited = new boolean[m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
			for (int j = 0; j < m; j++) {
				enemies[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        getComb(0, 0);
        
        System.out.println(maxKill);
	}
	
	static void getComb(int cur, int start) {
		if (cur == 3) {
			startSimulation();
			return;
		}
		
		for (int i = start; i < m; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			combinations[cur] = i;
			
			getComb(cur + 1, i + 1);
			
			visited[i] = false;
		}
	}
	
	static void startSimulation() {
		int[][] map = new int[n][m];
		HashSet<String> target;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = enemies[i][j];
			}
		}
		
		for (int line = n - 1; line >= 0; line--) {
			target = new HashSet<>();
			
			for (int archer : combinations) {
				int[] enemy = {-1, -1, 10000};
				
				for (int i = archer - range + 1; i < archer + range; i++) {
					for (int j = line; j > line - (range - Math.abs(archer - i)); j--) {
						if (i < 0 || i >= m || j < 0) {
							continue;
						}
						
						if (map[j][i] == 1) {
							int length = Math.abs(j - line) + Math.abs(i - archer);
							
							if (length < enemy[2]) {
								enemy = new int[] {j, i, length};
							}
						}
					}
				}
				
				if (enemy[0] != -1) {					
					target.add("" + enemy[0] + "-" + enemy[1]);
				}
			}
			
			for (String string : target) {
				String[] now = string.split("-");
				map[Integer.parseInt(now[0])][Integer.parseInt(now[1])] = 0;
				count += 1;
			}
		}
		
		if (count > maxKill) {
			maxKill = count;
		}
	}
}
