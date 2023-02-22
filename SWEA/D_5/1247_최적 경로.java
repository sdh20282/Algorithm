import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, min;
	static int[] company, home, permutation;
	static int[][] customers;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			customers = new int[n][2];
			permutation = new int[n];
			visited = new boolean[n];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			per(0, 0, company, 0);
			
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void per(int cur, int index, int[] prev, int len) {
		if (cur == n) {
			int now = len + Math.abs(prev[0] - home[0]) + Math.abs(prev[1] - home[1]);
			min = Math.min(min, now);
			
			return;
		}
		
		if (len > min) {
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			permutation[index] = i;
			per(cur + 1, index + 1, customers[i], len + Math.abs(prev[0] - customers[i][0]) + Math.abs(prev[1] - customers[i][1]));
			visited[i] = false;
		}
	}
}
