import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			int[] weights = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weights);

			int left = 0, right = n - 1, max = -1;
			
			while (true) {
				if (left >= right) {
					break;
				}
				
				int now = weights[left] + weights[right];
				
				if (now <= m) {
					left++;
					
					if (now > max) {
						max = now;
					}
				} else {
					right--;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
