import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int Inf = Integer.MAX_VALUE / 100;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1 << N][N];
		
		for (int i = 0; i < 1 << N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(tsp(1, 0));
	}
	
	public static int tsp(int visited, int city) {
		if (visited == (1 << N) - 1) {
			return (map[city][0] == 0) ? Inf : map[city][0];
		}
		
		if (dp[visited][city] != -1) {
			return dp[visited][city];
		}
		
		dp[visited][city] = Inf;
		
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) {
				continue;
			}
			
			if (map[city][i] == 0) {
				continue;
			}
			
			int res = tsp(visited | (1 << i), i) + map[city][i];
			dp[visited][city] = Math.min(res, dp[visited][city]);
		}
		
		return dp[visited][city];
	}
}
