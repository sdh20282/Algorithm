import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String now;

		for (int test_case = 1; test_case <= 10; test_case++) {
			boolean isOK = true;
			int n = Integer.parseInt(br.readLine());
			System.out.print("#" + test_case + " ");
			
			innerCase : for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				if (!isOK) continue;
				
				st.nextToken();
				now = st.nextToken();
				
				if (now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/")) {
					try {
						st.nextToken();
						st.nextToken();
					} catch (Exception e) {
						isOK = false;
					}
				} else {
					try {
						st.nextToken();
					} catch (Exception e) {
						continue innerCase;
					}
					
					isOK = false;
				}
			}
			
			System.out.println((isOK) ? 1 : 0);
		}
	}
}
