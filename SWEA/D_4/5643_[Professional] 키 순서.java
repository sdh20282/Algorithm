import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[][] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				adj[i][0] = -1;
			}

			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");

				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());

				adj[i][j] = 1;
			}

			int answer = 0;

			for (int k = 1; k <= N; k++) {
				if (adj[k][0] == -1) {
					gtDfs(k);
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; ++j) {
					adj[0][j] += adj[i][j];
				}
			}
			
			for (int k = 1; k <= N; k++) {
				if (adj[k][0] + adj[0][k] == N - 1) {
					answer++;					
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int gtDfs(int k) {
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			if (adj[k][i] == 1) {
				if (adj[i][0] == -1) {
					gtDfs(i);					
				}

				if (adj[i][0] > 0) {
					for (int j = 1; j <= N; ++j) {						
						if (adj[i][j] == 1) {							
							adj[k][j] = 1;
						}
					}
				}
			}
		}
		
		for (int j = 1; j <= N; j++) {			
			if (adj[k][j] == 1) {				
				count++;
			}
		}

		return adj[k][0] = count;
	}
}
