import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] whiteBoard = makeInitBoard("W");
    static boolean[][] blackBoard = makeInitBoard("B");

    public static void main(String[] args) {

        int height = sc.nextInt();
        int width = sc.nextInt();
        sc.nextLine();

        boolean[][] inputBoard = getInputBoard(width, height);
        int result = 64;
        int endpointX = width - 8;
        int endpointY = height - 8;

        for (int y = 0; y <= endpointY; y++) {
            for (int x = 0; x <= endpointX; x++) {
                result = Math.min(result, getMappingCount(x, y, inputBoard));
            }
        }

        System.out.println(result);
    }

    public static int getMappingCount(int x, int y, boolean[][] inputBoard) {
        int whiteCount = 0;
        int blackCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (whiteBoard[i][j] != inputBoard[y + i][x + j]) {
                    whiteCount += 1;
                }
                if (blackBoard[i][j] != inputBoard[y + i][x + j]) {
                    blackCount += 1;
                }
            }
        }
        return Math.min(whiteCount, blackCount);
    }


    public static boolean[][] getInputBoard(int width, int height) {
        boolean[][] result = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String input = sc.nextLine();

            for (int j = 0; j < width; j++) {
                if (input.charAt(j) == 'W') {
                    result[i][j] = true;
                } else {
                    result[i][j] = false;
                }
            }

        }
        return result;
    }

    public static boolean[][] makeInitBoard(String color) {
        boolean[][] board = new boolean[8][8];
        boolean white = true;

        if (color.equals("W")) {
            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < 8; j++) {
                    board[i][j] = white;
                    white = !white;
                }
                white = !white;
            }
            return board;
        } else {
            for (int i = 0; i < 8; i++) {
                white = !white;
                for (int j = 0; j < 8; j++) {
                    board[i][j] = white;
                    white = !white;
                }
            }
            return board;
        }
    }
}
