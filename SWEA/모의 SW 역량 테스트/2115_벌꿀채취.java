import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			int[][] beehive = new int[n][n];
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					beehive[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int ra = 0; ra < n; ra++) {
				for (int ca = 0; ca <= n - m; ca++) {
					int count = 0;
					int[] fa = new int[c + 1];
					
					for (int i = ca; i < ca + m; i++) {
						for (int j = c; j >= 1; j--) {
							if (j >= beehive[ra][i]) {
								fa[j] = Math.max(fa[j - beehive[ra][i]] + beehive[ra][i] * beehive[ra][i], fa[j]);
							}
						}
					}
					
					count += fa[c];
					
					for (int rb = ra; rb < n; rb++) {
						for (int cb = 0; cb <= n - m; cb++) {
							if (ra == rb && cb == 0) {
								cb = ca + m - 1;
								continue;
							}
							
							int[] fb = new int[c + 1];
							
							for (int i = cb; i < cb + m; i++) {
								for (int j = c; j >= 1; j--) {
									if (j >= beehive[rb][i]) {
										fb[j] = Math.max(fb[j - beehive[rb][i]] + beehive[rb][i] * beehive[rb][i], fb[j]);
									}
								}
							}
							
							count += fb[c];
							
							if (count > max) {
								max = count;
							}
							
							count -= fb[c];
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
