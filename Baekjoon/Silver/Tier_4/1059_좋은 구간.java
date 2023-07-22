import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		int[] data = new int[l];
		
		String[] strings = br.readLine().split(" ");
		
		for (int i = 0; i < strings.length; i++) {
			data[i] = Integer.parseInt(strings[i]);
		}
		
		data = Arrays.stream(data).sorted().toArray();

		int n = Integer.parseInt(br.readLine());
		int startPoint = -1, endPoint = 10000;
		
		for (int number : data) {
			if (number < n) {
				startPoint = number;
			} else if (number > n) {
				if (endPoint > number) {
					endPoint = number;
				}
			} else {
				System.out.println(0);
				
				return;
			}

			if (startPoint != -1 && endPoint != 10000) {
				break;
			}
		}

		if (startPoint == -1) {
			startPoint = 0;
		}
		
		if (endPoint == -1) {
			endPoint = 1001;
		}

		int answer = 0;
		
		for (int i = startPoint + 1; i < endPoint; i++) {
			if (i > n) {
				break;
			}

			for (int j = n; j < endPoint; j++) {
				if (i == j) {
					continue;
				}
				
				answer++;
			}
		}

		System.out.println(answer);
	}
}
