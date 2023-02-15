import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int count, sum;
		char now;
		String str;

		for (int test_case = 1; test_case <= T; test_case++) {
			str = br.readLine();
			count = 0; sum = 0;
			
			for (int i = 0; i < str.length(); i++) {
				now = str.charAt(i);
				count += 1;
				
				if (now == ')') {
					count -= 2;
					sum += (str.charAt(i - 1) == '(') ? count : 1;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
