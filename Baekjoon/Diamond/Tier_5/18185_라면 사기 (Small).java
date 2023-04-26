import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] factories = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			factories[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for (int index = 0; index < N; index++) {
			if (factories[index] == 0) {
				continue;
			}
			
			if (index + 1 < N && factories[index + 1] == 0 || index == N - 1) {
				count += 3 * factories[index];
				factories[index] = 0;
			}
			
			else if (index + 2 < N && factories[index + 2] == 0 || index == N - 2) {
				if (factories[index] <= factories[index + 1]) {
					count += 5 * factories[index];
					
					factories[index + 1] -= factories[index];
					factories[index] = 0;
				} else {
					count += 5 * factories[index + 1];
					count += 3 * (factories[index] - factories[index + 1]);
					
					factories[index] = 0;
					factories[index + 1] = 0;
				}
			}
			
			else {
				if (factories[index + 1] > factories[index + 2]) {
					count += 5;
					
					factories[index] -= 1;
					factories[index + 1] -= 1;
				}
				
				else {
					count += 7;
					
					factories[index] -= 1;
					factories[index + 1] -= 1;
					factories[index + 2] -= 1;
				}
				
				index -= 1;
			}
		}
		
		System.out.println(count);
	}
}
