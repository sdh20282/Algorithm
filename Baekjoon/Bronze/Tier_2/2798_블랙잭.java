import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int R = 3;
	static int[] numbers;
	static int[] combinations = new int[R];
	static int target;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		
		System.out.println(max);
	}

	static void dfs(int cur, int start) {
		if (cur == R) {
			int sum = 0;
			
			for (int i = 0; i < R; i++) {
				sum += combinations[i];
			}
			
			if (sum <= target && sum > max) {
				max = sum;
			}
			
			return;
		}

		for (int i = start; i < N; i++) {
			combinations[cur] = numbers[i];
			dfs(cur + 1, i + 1);
		}
	}
}
