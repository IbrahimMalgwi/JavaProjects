public class TicTacToeBoard {

    public static void ticTacToe() {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        System.out.println("X" + board[0][0] + "|" + "0" + board[0][1] + "|" + "X" + board[0][2]);
        System.out.println("0" + board[1][0] + "|" +"X" + board[1][1] + "|"  + "0" + board[1][2]);
        System.out.println("X" + board[2][0] + "|" + "X" + board[2][1] + "|"  + "0" + board[2][2]);
    }

    public static void ticTacToe1(){
        char [][] board = {{'X', '0', 'X'}, {'0', 'X', '0'}, {'X', 'X', '0'}};

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void ticTacToe2(){

    }

    public static void main(String[] args) {
        ticTacToe1();
    }
}
