package TicTacToeGame;

import java.sql.SQLOutput;
import java.util.Scanner;


public class TicTacToe{

    private final char[][] board;
    private char currentPlayer;
    private int xWins;
    private int oWins;
    private int xoDraws;

    //CONSTRUCTOR
    public TicTacToe(){
        board = new char[3][3];
        xWins = 0;
        oWins = 0;
        xoDraws = 0;
    }

    // CREATING EMPTY BOARD
    public void creatingBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = '-';
            }
        }
    }

    //PRINT BOARD
    public void printBoard(){
        System.out.println();
        System.out.println("~BOARD~");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    //SET X/O WHEN MAKE A MOVE
    public boolean makeMove(int row, int colmn){
        if(row>=0 && row<3 && colmn>=0 && colmn<3 && board[row][colmn]=='-'){
            board[row][colmn] = currentPlayer;
            return true;
        }
        return false;
    }

    //CHECK WINNING CONDITION
    public boolean checkWin(){

        //CHECK ROWS
        for(int i=0;i<3;i++){
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer){
                return true;
            }
        }

        //CHECK COLUMNS
        for(int i=0;i<3;i++){
            if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer){
                return true;
            }
        }

        //CHECK DIAGONALS
        if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer){
            return true;
        }

        if(board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer){
            return true;
        }

        return false;

    }

    //CHECK DRAW
    public boolean checkDraw(){

        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-')
                    return false;
            }
        }


        return true;
    }

    //SWITCH PLAYER
    public void switchPlayer(){
        currentPlayer = (currentPlayer=='X') ? 'O' : 'X';
    }

    //PRINT SCOREBOARD
    public void printScoreboard(){
        System.out.println("   ~~~SCOREBOARD~~~   ");
        System.out.println("Player 'X' Wins -> "+xWins);
        System.out.println("Player 'O' Wins -> "+oWins);
        System.out.println("'X' & 'O' Game Draw -> "+xoDraws);
        System.out.println();
    }

    //START GAME
    public void startGame(){
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        while(playAgain){

            //LOAD BOARD FOR NEW ROUND
            creatingBoard();

            //LET PLAYERS CHOOSE SIDE ('X' or 'O')
            System.out.print("First Player Choose Between 'X' Or 'O' - ");
            char xOrO = sc.next().toUpperCase().charAt(0);

            if(xOrO == 'X'){
                currentPlayer = 'X';
                System.out.println("Second Player Get 'O'");
            }
            else if(xOrO == 'O'){
                currentPlayer = 'O';
                System.out.println("Second Player Get 'X'");
            }
            else{
                System.out.println("Invalid Choice : Defaulting 'X' To The Current Player");
                currentPlayer = 'X';
                System.out.println("Second Player Get 'O'");
            }

            boolean gameEnd = false;

            while(!gameEnd){
                printBoard();
                System.out.println("Player '"+currentPlayer+"' - Enter Co-Ordinates [ROW,COLUMN] :");

                int row = sc.nextInt() ;
                int col = sc.nextInt() ;

                if(makeMove(row,col)){
                    if(checkWin()){
                        printBoard();
                        System.out.println();
                        System.out.println("Player '"+currentPlayer+"' WINS !");
                        System.out.println();
                        if(currentPlayer=='X') xWins++;
                        else oWins++;

                        gameEnd = true;
                    }
                    else if(checkDraw()){
                        printBoard();
                        System.out.println();
                        System.out.println("GAME OVER – It's a Draw! NOBODY Wins!");
                        xoDraws++;

                        gameEnd = true;

                    }
                    else{
                        switchPlayer();
                    }
                }
                else{
                    System.out.println("Invalid Move : TRY AGAIN!");
                }
            }

            //SHOW SCORE BOARD
            printScoreboard();

            //ASK TO PLAY AGAIN
            System.out.print("Do You Want To Play Again (yes/no): ");
            String ans = sc.next().toLowerCase();
            playAgain = ans.equals("yes");

        }

        //FINAL SCORE BOARD
        System.out.println();
        System.out.println("~~~FINAL SCOREBOARD~~~");
        System.out.println();
        printScoreboard();
        System.out.println();
        System.out.println("Thanks For Playing!");
        sc.close();

    }
    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}
