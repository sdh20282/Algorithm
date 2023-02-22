import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int test_case;
	static int N;
	static int R;
	static int[] numbers;
	static int[] combinations;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		combinations = new int [R];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i + 1;
		}
		
		dfs(0, 0);
	}

	static void dfs(int cur, int start) {
		if (cur == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(combinations[i] + " ");
			}
			
			System.out.println();
			
			return;
		}

		for (int i = start; i < N; i++) {
			combinations[cur] = numbers[i];
			dfs(cur + 1, i + 1);
		}
	}
}
