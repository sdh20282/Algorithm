import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] numbers = new int[N + 1][N + 1];
		int x1, y1, x2, y2;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 1; j <= N; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken()) + numbers[i][j - 1];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				numbers[i][j] += numbers[i - 1][j];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken()) - 1;
			y1 = Integer.parseInt(st.nextToken()) - 1;
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(numbers[x2][y2] - numbers[x1][y2] - numbers[x2][y1] + numbers[x1][y1]);
		}
	}
}
