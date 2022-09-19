import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        printGameBoard(gameBoard);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your board selection (1- 9)");
            int playerPos = input.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("position taken! Enter Correct position");
                playerPos = input.nextInt();
            }

            placeGamePiece(gameBoard, playerPos, "player");
            String result = checkWinner();
            result = checkWinner();
            if (result.length() >0 ){
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPositions)) {
                cpuPos = random.nextInt(9) + 1;
            }

            placeGamePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);
            result = checkWinner();
            if (result.length() >0 ){
                System.out.println(result);
                break;
            }
        }

    }

    private static void placeGamePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")){
            symbol = 'x';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'o';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning){
            if (playerPositions.containsAll(l)){
                return "Congratulation you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "Sorry CPU wins :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT";
            }
        }
        return "";
    }

    private static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


}
