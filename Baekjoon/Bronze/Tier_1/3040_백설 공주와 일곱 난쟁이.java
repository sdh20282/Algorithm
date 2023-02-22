import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N = 9;
	static int R = 7;
	static int[] numbers;
	static int[] combinations;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[N];
		combinations = new int [R];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0);
	}

	static void dfs(int cur, int start) {
		if (cur == R) {
			int sum = 0;
			
			for (int i = 0; i < R; i++) {
				sum += combinations[i];
			}
			
			if (sum != 100) {
				return;
			}
			
			for (int i = 0; i < R; i++) {
				System.out.println(combinations[i]);
			}
			
			return;
		}

		for (int i = start; i < N; i++) {
			combinations[cur] = numbers[i];
			dfs(cur + 1, i + 1);
		}
	}
}
