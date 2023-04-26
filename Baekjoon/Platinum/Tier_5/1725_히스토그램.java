import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] histogram = new int[N];

		for (int i = 0; i < N; i++) {
			histogram[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> s = new Stack<>();
		long max = 0;

		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && histogram[i] <= histogram[s.peek()]) {
				max = Math.max(max, (long) histogram[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1));
			}

			s.push(i);
		}

		while (!s.isEmpty()) {
			max = Math.max(max, (long) histogram[s.pop()] * (s.isEmpty() ? N : N - s.peek() - 1));
		}

		System.out.println(max);
	}
}
