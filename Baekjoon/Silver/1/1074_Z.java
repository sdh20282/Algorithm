import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		
		find((int)Math.pow(2, n), r, c);
		System.out.println(count);
	}

	static void find(int size, int r, int c) {
		if (size == 1) return;
		
		int half = size / 2;
		
		if (r < half && c < half) {
			find(half, r, c);
		} else if (r < half && c >= half) {
			find(half, r, c - half);
			count += size * size / 4;
		} else if (r >= half && c < half) {
			find(half, r - half, c);
			count += size * size / 4 * 2;
		} else {
			find(half, r - half, c - half);
			count += size * size / 4 * 3;
		}
	}
}
