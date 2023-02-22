import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = now.charAt(j) - '0';
			}
		}
		
		System.out.println(count(0, 0, n));
	}
	
	static String count(int r, int c, int size) {
		if (size == 1) {
			return "" + map[r][c];
		}
		
		if (canCompress(r, c, size)) {
			return "" + map[r][c];
		}
		
		String now = "(";
		int half = size / 2;
		
		now += count(r, c, half);
		now += count(r, c + half, half);
		now += count(r + half, c, half);
		now += count(r + half, c + half, half);
		
		return now + ")";
	}
	
	static boolean canCompress(int r, int c, int size) {
		int res = 0;
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				res += map[i][j];
			}
		}
		
		if (res == 0 || res == size * size) {
			return true;
		} else {
			return false;
		}
	}
}
