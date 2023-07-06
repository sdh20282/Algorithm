import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
	
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int year = x;
			int last = LCM(N, M);

			while (true) {
				if (year > last) {
					System.out.println(-1);
					
					break;
				} else if (((year % N) == 0 ? N : year % N) == y) {
					System.out.println(year);
					
					break;
				}
				
				year += M;
			}
		}
	}

	public static int LCM(int A, int B) {
		return A * B / GCD(A, B);
	}

	public static int GCD(int A, int B) {
		int temp = 0;
		
		while (B > 0) {
			temp = A % B;
			A = B;
			B = temp;
		}
		
		return A;
	}
}
