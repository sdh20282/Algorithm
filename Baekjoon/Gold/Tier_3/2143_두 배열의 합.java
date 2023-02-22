import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long T;
	static int A;
	static int B;
	static int[] arrA;
	static int[] arrB;

	public static void main(String[] args) throws IOException {
		init();
		run();
	}
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Long.parseLong(br.readLine());

		A = Integer.parseInt(br.readLine());
		arrA = new int[A];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < A; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		B = Integer.parseInt(br.readLine());
		arrB = new int[B];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < B; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void run() {
		int sizeA = A * (A + 1) / 2;
		int sizeB = B * (B + 1) / 2;
		long[] sumA = new long[sizeA];
		long[] sumB = new long[sizeB];
		int index = 0;
		
		for (int i = 0; i < A; i++) {
			long sum = 0;
			
			for (int j = i; j < A; j++) {
				sum += arrA[j];
				sumA[index++] = sum;
			}
		}
		
		index = 0;
		
		for (int i = 0; i < B; i++) {
			long sum = 0;
			
			for (int j = i; j < B; j++) {
				sum += arrB[j];
				sumB[index++] = sum;
			}
		}
		
		Arrays.sort(sumA);
		Arrays.sort(sumB);
		
		int left = 0;
		int right = sumB.length - 1;
		long count = 0;
		
		while (left < sizeA && right > -1) {
			long leftValue = sumA[left];
			long rightValue = sumB[right];
			long sum = leftValue + rightValue;
			
			if (sum > T) {
				right -= 1;
			} else if (sum < T) {
				left += 1;
			} else if (sum == T) {
				long leftCount = 0, rightCount = 0;
				
				while(left < sizeA && sumA[left] == leftValue) {
					leftCount += 1;
					left += 1;
				}
				
				while(right > -1 && sumB[right] == rightValue) {
					rightCount += 1;
					right -= 1;
				}
				
				count += leftCount * rightCount;
			}
		}
		
		System.out.println(count);
	}
}
