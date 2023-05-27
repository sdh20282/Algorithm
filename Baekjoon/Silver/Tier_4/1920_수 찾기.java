import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		find: for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			int left = 0, right = N - 1;
			
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (arr[mid] == now) {
					System.out.println(1);
					continue find;
				}
				
				if (arr[mid] < now) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
			System.out.println(0);
		}
	}
} 
