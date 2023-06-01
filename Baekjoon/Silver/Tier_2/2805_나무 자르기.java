import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), M = sc.nextInt();
		int[] tree = new int[N];
		int min = 0, max = 0;
		
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			
			if (max < tree[i]) {
				max = tree[i];
			}
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			
			for (int treeHeight : tree) {
				if (treeHeight - mid > 0) { 
					sum += (treeHeight - mid);
				}
			}

			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
		sc.close();
	}
}
