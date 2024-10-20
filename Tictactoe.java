import java.util.Scanner;

class Tictactoe {
    public static void main(String[] args) {
        String[][] board = new String[3][3];

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
               board[row][col] = " ";
            }
        }

        Scanner sc = new Scanner(System.in);
        String playerType = "X";
        boolean gameOver = false;

        while(!gameOver) {
            printBoard(board);

            System.out.println("Player " + playerType + "'s turn. Enter row-column position: ");
            int row = sc.nextInt()-1;
            int col = sc.nextInt()-1;
            System.out.println();

            if (board[row][col].equals(" ")) {
                board[row][col] = playerType;
                gameOver = hasWon(board, playerType);

                if (gameOver) {
                    System.out.println("Player "+playerType+" has won: ");
                } else {
                    playerType = playerType.equals("X") ? "O" : "X";
                }
            } else {
                System.out.println("Invalid position for entry, provide row-column reference");
            }
        }
        printBoard(board);
    }

    public static boolean hasWon(String[][] board, String playerType) {
        for(int row = 0; row < board.length; row++) {
            if (board[row][0].equals(playerType) && board[row][1].equals(playerType) && board[row][2].equals(playerType)) {
                return true;
            }
        }

        for(int col = 0; col < board.length; col++) {
            if (board[0][col].equals(playerType) && board[2][col].equals(playerType) && board[3][col].equals(playerType)) {
                return true;
            }
        }
 
        if(board[0][0].equals(playerType) && board[1][1].equals(playerType) && board[2][2].equals(playerType)) {
            return true;
        }

        if(board[2][0].equals(playerType) && board[1][1].equals(playerType) && board[0][2].equals(playerType)) {
            return true;
        }

        return false;
    }

    public static void printBoard(String[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
               System.out.print("| " + board[row][col] + " | ");
            }
            System.out.println();
        }
    }   
}