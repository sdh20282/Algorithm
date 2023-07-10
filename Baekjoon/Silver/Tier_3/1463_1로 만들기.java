import java.util.Scanner;

public class Main {
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;

		System.out.print(recur(N));
		sc.close();
	}

	static int recur(int N) {
		if (dp[N] == null) {
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			} else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			} else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			} else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		
		return dp[N];
	}
}
