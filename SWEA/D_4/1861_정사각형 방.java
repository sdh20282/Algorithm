import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<int[]> q = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] rooms = new int[n][n];
			int maxVal = Integer.MAX_VALUE, maxMove = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					q.offer(new int[] {i, j, 1});
					
					while (q.size() > 0) {
						int[] now = q.poll();
						int row = now[0], col = now[1], count = now[2];
						
						if (count > maxMove) {
							maxMove = count;
							maxVal = rooms[i][j];
						} else if (count == maxMove && maxVal > rooms[i][j]) {
							maxVal = rooms[i][j];
						}
						
						for (int [] dir : dirs) {
							if (row + dir[0] < 0 || row + dir[0] >= n || col + dir[1] < 0 || col + dir[1] >= n) {
								continue;
							}
							
							if (rooms[row][col] + 1 == rooms[row + dir[0]][col + dir[1]]) {
								q.add(new int[] {row + dir[0], col + dir[1], count + 1});
							}
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + maxVal + " " + maxMove);
		}
	}
}
