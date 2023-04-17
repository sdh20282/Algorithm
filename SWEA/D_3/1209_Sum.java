import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int[][] map = new int[100][100];
			int max = 0, sum = 0;
            
            int T;
			T=sc.nextInt();
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 100; i++) {
				sum = 0;
				
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}
				
				if (sum > max) {
					max = sum;
				}
			}
			
			for (int i = 0; i < 100; i++) {
				sum = 0;
				
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				
				if (sum > max) {
					max = sum;
				}
			}
			
			sum = 0;
			
			for (int i = 0; i < 100; i++) {
				sum += map[i][i];
			}
			
			if (sum > max) {
				max = sum;
			}
			
			sum = 0;
			
			for (int i = 0; i < 100; i++) {
				sum += map[99 - i][i];
			}
			
			if (sum > max) {
				max = sum;
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
