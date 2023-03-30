import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[][] things = new int[n][2];
		int[] dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = k; j >= 0; j--) {
				if (j >= things[i][0]) {
					dp[j] = Math.max(dp[j], dp[j - things[i][0]] + things[i][1]);
				}
			}
		}
		
		System.out.println(dp[k]);
	}
}
