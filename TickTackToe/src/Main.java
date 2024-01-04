import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of player 1" );
        String p1 = scanner.nextLine();
        System.out.print("Name of player 2" );
        String p2 = scanner.nextLine();
        boolean turn = true;
        char[][] board = new char[3][3];
        //turn = false means 1st player, turn = true means 2nd player
        boolean end = false;
        for(int i = 0; i < 3; i++){
            for(int j =0; j<3;j++){
                board[i][j] = '-';
            }
        }
        while(!end){
            if(turn){
                System.out.println("PLayer:" + p1 + " is moving!");
            }else{
                System.out.println("PLayer: " + p2 + " is moving!");
            }
            String numbers = scanner.nextLine();
            if(checkBoard(board,numbers)){
                char symbol = turn ? 'o' : 'x';
                updateBoard(board,numbers,symbol);
                turn = !turn;
            }else{
                System.out.println("Incorrect!");
                char symbol = turn ? 'o' : 'x';
                updateBoard(board,numbers,symbol);
            }

            if(checkGameStatus(board)){
                end = true;
            }
        }
        scanner.close();
    }
    private static boolean checkBoard(char[][] board, String input) {
        int row = Character.getNumericValue(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        // Check if the move is within the board boundaries and the cell is empty
        return row >= 1 && row <= 3 && column >= 1 && column <= 3 && board[row - 1][column - 1] == '-';
    }
    private static boolean checkGameStatus(char[][] board){
        if(board != null){
            //rows
            for(int i =0; i < 3; i++){
                if(board[i][0] == 'x' && board[i][1] == 'x'&& board[i][2] == 'x'){
                    System.out.println("Player 2  wins!");
                    return true;
                }else if(board[i][0]== 'o'&& board[i][1]== 'o'&& board[i][2]== 'o'){
                    System.out.println("Player 1  wins!");
                    return true;
                }
            }
            //columns
            for(int j =0; j < 3; j++){
                if(board[0][j] == 'x' && board[1][j] == 'x'&& board[2][j] == 'x'){
                    System.out.println("Player 2  wins!");
                    return true;
                }else if(board[0][j]== 'o'&& board[1][j]== 'o'&& board[2][j]== 'o'){
                    System.out.println("Player 1  wins!");
                    return true;
                }
            }
            //diagonal
            if(board[0][0] =='x' && board[1][1] =='x' && board[2][2] =='x' ||
            board[0][2] =='x' && board[0][0] =='x' && board[2][0] =='x'){
                System.out.println("Player 2  wins!");
                return true;
            }else if(board[0][0] =='o' && board[1][1] =='o' && board[2][2] =='o' ||
                    board[0][2] =='o' && board[0][0] =='o' && board[2][0] =='o'){
                System.out.println("Player 1  wins!");
                return true;
            }
        }
        return false;
    }
    public static void updateBoard(char[][] board, String input, char symbol){
        int row = Character.getNumericValue(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        int numRows = board.length;
        int numColumns = board[0].length;
        //because users will input 1 to 3 not 0 to 2
        row -=1;
        column-=1;

        if(row >= 0 && row < numRows && column >= 0 && column < numColumns){
            if(board[row][column] == '-'){
                board[row][column] = symbol;
            }
        }
        for (char[] chars : board) {//i = row
            for (int j = 0; j < numColumns; j++) {//j = column
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}