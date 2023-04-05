import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		int[] dishes = new int[N], kinds = new int[D + 1];
		
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		kinds[C] += 1;
		int count = 1;
		
		for (int i = 0; i < K; i++) {
			if (kinds[dishes[i]] == 0) {
				count += 1;
			}
			
			kinds[dishes[i]] += 1;
		}
		
		int maxKinds = count;
		
		for (int i = 0; i < N - K; i++) {
			kinds[dishes[i]] -= 1;
			
			if (kinds[dishes[i]] == 0) {
				count -= 1;
			}
			
			kinds[dishes[i + K]] += 1;
			
			if (kinds[dishes[i + K]] == 1) {
				count += 1;
			}
			
			if (count > maxKinds) {
				maxKinds = count;
			}
		}
		
		int index = 0;
		
		for (int i = N - K; i < N; i++) {
			kinds[dishes[i]] -= 1;
			
			if (kinds[dishes[i]] == 0) {
				count -= 1;
			}
			
			kinds[dishes[index]] += 1;
			
			if (kinds[dishes[index]] == 1) {
				count += 1;
			}
			
			if (count > maxKinds) {
				maxKinds = count;
			}
			
			index += 1;
		}	

		System.out.println(maxKinds);
	}
}
