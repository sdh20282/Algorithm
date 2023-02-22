import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, operations;
	static int[] permutation;
	static boolean[] visited;
	static int n, m, k, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		arr = new int[n + 1][m + 1];
		operations = new int[k][];
		permutation = new int[k];
		visited = new boolean[k];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			operations[t] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		
		dfs(0);
		
		System.out.println(min);
	}
	
	static void dfs(int cur) {
		if (cur == k) {
			rotate();
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			permutation[cur] = i;
			dfs(cur + 1);
			permutation[cur] = 0;
			visited[i] = false;
		}
	}
	
	static void rotate() {
		int[][] target = new int [n + 1][m + 1];
		
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				target[i][j] = arr[i][j];
			}
		}
		
		for (int o = 0; o < k; o++) {
			int[] operation = operations[permutation[o]];
			int r = operation[0], c = operation[1], s = operation[2];
			
			for (int i = 0; i < s; i++) {
				int temp = target[r - s  + i][c - s + i];
				
				for (int j = r - s + i; j < r + s - i; j++) {
					target[j][c - s + i] = target[j + 1][c - s + i];
				}
				
				for (int j = c - s + i; j < c + s - i; j++) {
					target[r + s - i][j] = target[r + s - i][j + 1];
				}
				
				for (int j = r + s - i; j > r - s + i; j--) {
					target[j][c + s - i] = target[j - 1][c + s - i];
				}
				
				for (int j = c + s - i; j > c - s + i; j--) {
					target[r - s + i][j] = target[r - s + i][j - 1];
				}
				
				target[r - s + i][c - s + i + 1] = temp;
			}
		}
		
		calc(target);
	}
	
	static void calc(int[][] target) {
		for (int i = 1; i <= n; i++) {
			int row = 0;
			
			for (int j = 1; j <= m; j++) {
				row += target[i][j];
			}
			
			if (row < min) {
				min = row;
			}
		}
	}
}
