import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int lenA = sc.nextInt();
			int lenB = sc.nextInt();
			int[] arrA = new int[lenA];
			int[] arrB = new int[lenB];
			int max = 0;
			
			for (int i = 0; i < lenA; i++) {
				arrA[i] = sc.nextInt();
			}
			
			for (int i = 0; i < lenB; i++) {
				arrB[i] = sc.nextInt();
			}
			
			if (lenB > lenA) {
				int lenTemp = lenA;
				lenA = lenB;
				lenB = lenTemp;
				
				int[] temp = arrA.clone();
				arrA = arrB;
				arrB = temp;
			}
			
			for (int i = 0; i <= lenA - lenB; i++) {
				int now = 0;
				
				for (int j = 0; j < lenB; j++) {
					now += arrA[i + j] * arrB[j];
				}
				
				if (now > max) {
					max = now;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
