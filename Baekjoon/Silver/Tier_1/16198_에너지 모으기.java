import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> weights;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		weights = new ArrayList<>();
		max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			weights.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0);
		System.out.println(max);
	}
	
	static void dfs(int sum) {
		if (weights.size() == 2) {
			if (sum > max) {
				max = sum;
			}
			
			return;
		}
		
		for (int i = 1; i < weights.size() - 1; i++) {
			int now = weights.get(i);
			int energy = weights.get(i - 1) * weights.get(i + 1);
			
			weights.remove(i);
			dfs(sum + energy);
			weights.add(i, now);
		}
	}
}
