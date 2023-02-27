import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), count = 0;
		// 좌표 선언
		int[][] cor = new int[101][101];
		// 다음 방향
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			
			// 입력 받은 부분들을 검은색으로 변경
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					cor[i][j] = 1;
				}
			}
		}

		// 흰색 영역을 기준으로 상하좌우 검은색 영역이 있으면 count 증가
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (cor[i][j] == 1) {
					continue;
				}
				
				for (int[] dir : dirs) {
					int nr = i + dir[0], nc = j + dir[1];
					
					if (nr < 0 || nr > 100 || nc < 0 || nc > 100) {
						continue;
					}
					
					if (cor[nr][nc] == 1) {
						count += 1;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
