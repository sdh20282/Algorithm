import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	static void dfs(int number, int count) {
		if (count == n) {
			System.out.println(number);
			return;
		}
		
		for (int i = 1; i < 10; i += 2) {
			int next = Integer.parseInt("" + number + i);
			
			if (isPrimary(next)) {
				dfs(next, count + 1);
			}
		}
	}
	
	static boolean isPrimary(int number) {
		int scope = (int)Math.sqrt(number);
		
		for (int i = 3; i <= scope; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
