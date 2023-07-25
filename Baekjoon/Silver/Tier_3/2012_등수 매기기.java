import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		long sum = 0;
		
		for(int i=0; i<arr.length; i++) {			
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			sum += Math.abs(arr[i] - (i+1));			
		}
		
		System.out.println(sum);
		sc.close();
	}
}
