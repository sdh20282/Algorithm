import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int arr[][];
	static int max = Integer.MAX_VALUE >> 2, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();

			for (int j = 1; j <= n; j++) {
				char ch = str.charAt(j - 1);

				if (ch == 'Y') {
					arr[i][j] = 1;
				} else if (i != j) {
					arr[i][j] = max;
				}
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k || i == k) {
						continue;
					} else if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int tmp = 0;

			for (int j = 1; j <= n; j++) {
				if (i == j) {					
					continue;
				} else if (arr[i][j] <= 2) {					
					tmp++;
				}
			}
			
			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);
	}
}