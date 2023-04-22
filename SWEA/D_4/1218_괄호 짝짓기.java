import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		int n, match;
		String str;
		char now, prev;
		
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		map.put('>', '<');

		for (int test_case = 1; test_case <= 10; test_case++) {
			n = Integer.parseInt(br.readLine());
			str = br.readLine();
			match = 1;
			
			if (n != str.length()) {
				continue;
			}
			
			for (int i = 0; i < n; i++) {
				now = str.charAt(i);
				
				if (now == '{' || now == '[' || now == '(' || now == '<') {
					stack.push(now);
				}
				
				if (now == '}' || now == ']' || now == ')' || now == '>') {
					prev = stack.pop();
					
					if (prev != map.get(now)) {
						match = 0;
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + match);
		}
	}
}
