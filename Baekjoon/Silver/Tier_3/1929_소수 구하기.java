import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			if (i == 1) {
				continue;
			}
			
			if (check(i)) {
				System.out.println(i);
			}
		}
	}
	
	static boolean check(int num) {
		int until = (int) Math.sqrt(num);
		
		for (int i = 2; i <= until; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
} 
