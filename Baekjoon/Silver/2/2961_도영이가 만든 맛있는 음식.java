import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min = Integer.MAX_VALUE;
	static int[] sour;
	static int[] bitter;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		sour = new int[n];
		bitter = new int[n];
		check = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(min);
	}
	
	static void dfs(int cur) {
		if (cur == n) {
			int sour_sum = 1, bitter_sum = 0;
			
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					continue;
				}
				
				sour_sum *= sour[i];
				bitter_sum += bitter[i];
			}
			
			if (sour_sum == 1 && bitter_sum == 0) {
				return;
			}
			
			if ((int)Math.abs(sour_sum - bitter_sum) < min) {
				min = (int)Math.abs(sour_sum - bitter_sum);
			}
			
			return;
		}
		
		check[cur] = true;
		dfs(cur + 1);
		check[cur] = false;
		dfs(cur + 1);
	}
}
