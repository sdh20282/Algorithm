import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N + 1];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken()) + numbers[i - 1];
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
			
			System.out.println(numbers[end] - numbers[start - 1]);
		}
	}
}
