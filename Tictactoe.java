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

            System.out.println("Player" + playerType + "'s turn. Enter row-column position: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if (board[row][col] == " ") {
                board[row][col] = playerType;
                gameOver = hasWon(board, playerType);

                if (gameOver) {
                    System.out.println("Player "+playerType+" has won: ");
                } else {
                    playerType = playerType.equals("X") ? "O" : "X";
                    System.out.println("Player" + playerType + "'s turn. Enter row-column position: ");
                }
            } else {
                System.out.println("Invalid position for entry, provide row-column reference");
            }



        }

    }

    
}