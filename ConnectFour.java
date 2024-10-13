import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY_SLOT = '.';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    private static char[][] board = new char[ROWS][COLS];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean gameWon = false;
        char currentPlayer = PLAYER_ONE;

        while (!gameWon && !isBoardFull()) {
            int column = getPlayerMove(currentPlayer);
            if (dropDisc(currentPlayer, column)) {
                printBoard();
                if (checkForWin(currentPlayer)) {
                    System.out.println("Player " + (currentPlayer == PLAYER_ONE ? "1" : "2") + " wins!");
                    gameWon = true;
                }
                currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE; // switch turns
            } else {
                System.out.println("Column is full. Try another one.");
            }
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }
    }

    // Initialize the board with empty slots
    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY_SLOT;
            }
        }
    }

    // Print the current state of the board
    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7"); // Column numbers
    }

    // Get the player's move (column choice)
    private static int getPlayerMove(char player) {
        Scanner scanner = new Scanner(System.in);
        int column;
        do {
            System.out.println("Player " + (player == PLAYER_ONE ? "1 (X)" : "2 (O)") + ", choose a column (1-7): ");
            column = scanner.nextInt() - 1; // Subtract 1 to match the array index (0-based)
        } while (column < 0 || column >= COLS);
        return column;
    }

    // Drop the disc into the column
    private static boolean dropDisc(char player, int column) {
        for (int i = ROWS - 1; i >= 0; i--) { // Start from the bottom row
            if (board[i][column] == EMPTY_SLOT) {
                board[i][column] = player;
                return true;
            }
        }
        return false; // Column is full
    }

    // Check if the board is full
    private static boolean isBoardFull() {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }

    // Check if a player has won
    private static boolean checkForWin(char player) {
        return checkVertical(player) || checkHorizontal(player) || checkDiagonal(player);
    }

    // Check for a vertical win
    private static boolean checkVertical(char player) {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] == player &&
                        board[row + 1][col] == player &&
                        board[row + 2][col] == player &&
                        board[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check for a horizontal win
    private static boolean checkHorizontal(char player) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                        board[row][col + 1] == player &&
                        board[row][col + 2] == player &&
                        board[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check for a diagonal win (both directions)
    private static boolean checkDiagonal(char player) {
        // Check downward diagonal (\)
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                        board[row + 1][col + 1] == player &&
                        board[row + 2][col + 2] == player &&
                        board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check upward diagonal (/)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                        board[row - 1][col + 1] == player &&
                        board[row - 2][col + 2] == player &&
                        board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }
}

