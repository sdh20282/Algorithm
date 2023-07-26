import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	static final int mod = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n > 0) {
			System.out.println(1);

		} else if (n < 0) {
			n = -n;
			
			if (n % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		} else {
			System.out.println(0);
		}

		dp = new int[1_000_001];
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
		}

		System.out.println(dp[n]);
	}
}
