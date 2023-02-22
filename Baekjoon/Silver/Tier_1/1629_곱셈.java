import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());
		
		System.out.println(mul(a, b, c) % c);
	}
	
	static long mul(long a, long b, long c) {
		if (b == 1) return a;
		
		long y = mul(a, b / 2, c);
		
		return (b % 2 == 0) ? (y % c) * y % c : (y % c) * y % c * a % c;
	}
}
