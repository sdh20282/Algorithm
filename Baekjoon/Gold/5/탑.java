import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine()), now;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			now = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				if (now <= stack.peek()[0]) {
					sb.append(stack.peek()[1]).append(' ');
					break;
				}
				
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				sb.append(0).append(' ');
			}
			
			stack.push(new int[] {now, i});
		}
		
		System.out.println(sb);
	}
}
