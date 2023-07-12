import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if (N <= 5) {
				if (N <= 3) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
				
				continue;
			}
			
			long[] dp = new long[N];
			
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;
			dp[4] = 2;
			
			for (int i = 5; i < N; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}

			System.out.println(dp[N - 1]);
		}
	}
}

