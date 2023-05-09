import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int n, m;
		int[][] flies;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			flies = new int[n + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 1; j <= n; j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
					
					if (i > 1) {
						flies[i][j] += flies[i - 1][j];
					}
					
					if (j > 1) {
						flies[i][j] += flies[i][j - 1];
					}
					
					if (i > 1 && j > 1) {
						flies[i][j] -= flies[i - 1][j - 1];
					}
				}
			}
			
			int max = 0;
			
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int now = flies[i + m][j + m] - flies[i + m][j] - flies[i][j + m] + flies[i][j];
					
					if (now > max) {
						max = now;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
