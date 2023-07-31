import java.util.Scanner;

public class Main {
	public static int[][] board;
	public static int GRAY = 0;
	public static int WHITE = 0;
	public static int BLACK = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		partition(0, 0, N);

		System.out.println(GRAY);
		System.out.println(WHITE);
		System.out.println(BLACK);
		sc.close();
	}

	public static void partition(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (board[row][col] == -1) {
				GRAY++;
			} else if (board[row][col] == 0) {
				WHITE++;
			} else {
				BLACK++;
			}

			return;
		}

		int newSize = size / 3;

		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row, col + 2 * newSize, newSize);

		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
		partition(row + newSize, col + 2 * newSize, newSize);

		partition(row + 2 * newSize, col, newSize);
		partition(row + 2 * newSize, col + newSize, newSize);
		partition(row + 2 * newSize, col + 2 * newSize, newSize);

	}

	public static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != board[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
