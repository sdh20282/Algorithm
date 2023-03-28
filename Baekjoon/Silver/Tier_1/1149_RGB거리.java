import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력을 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 집의 개수
		int n = Integer.parseInt(br.readLine());
		// 비용을 저장하기 위한 배열
		int[][] costs = new int[n][3];
		// dp를 위한 배열, 각각의 인덱스가 현재 집에서 r, g, b를 선택했을 경우를 의미
		int[][] dp = new int[n][3];
		
		// 입력 받은 비용을 배열에 저장
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번째 집에서 r, g, b를 선택했을 때의 비용을 설정
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		
		// 첫번째 집 이후의 집들에 대해
		for (int i = 1; i < n; i++) {
			// 각각의 r, g, b의 경우에서
			for (int j = 0; j < 3; j++) {
				// 현재의 색을 선택했을 때, 이전 집에서 현재 색과 겹치지 않는 색을 선택했을 때의 두 경우 중 최소값을 선택
				dp[i][j] = Math.min(dp[i - 1][(j + 1) %3] + costs[i][j], dp[i - 1][(j + 2) %3] + costs[i][j]);
			}
		}
		
		// 마지막 집에서의 결과를 정렬, 오름차순
		Arrays.sort(dp[n - 1]);
		// 최소값 출력
		System.out.println(dp[n - 1][0]);
	}
}
