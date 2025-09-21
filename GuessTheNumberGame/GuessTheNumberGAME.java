package GuesserGame;

import java.util.*;

class GUESSER{
    int guesserNumber;
    public int guesserNum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Guesser Guess the Number :");
        guesserNumber = scan.nextInt();
        return guesserNumber;                      // To The Umpire...
    }
}

class PLAYER{
    int playerNumber;
    public int PlayerNum(){
        Scanner scan = new Scanner(System.in);
        playerNumber = scan.nextInt();
        return playerNumber;                      // To The Umpire...
    }
}

class UMPIRE{
    int guessedNum;
    int player_s1Num;
    int player_s2Num;
    int player_s3Num;

    public void collectGuesser_sNum(){
        GUESSER gu = new GUESSER();
        guessedNum = gu.guesserNum();

    }

    public void collectPlayer_sNum(){
        System.out.print("Player1 Guess The Number :");
        PLAYER p1 = new PLAYER();
        player_s1Num = p1.PlayerNum();

        System.out.print("Player2 Guess The Number :");
        PLAYER p2 = new PLAYER();
        player_s2Num = p2.PlayerNum();

        System.out.print("Player3 Guess The Number :");
        PLAYER p3 = new PLAYER();
        player_s3Num = p3.PlayerNum();

    }

    public void compare(){

        if(guessedNum == player_s1Num){

            if(guessedNum == player_s2Num && guessedNum == player_s3Num){
                System.out.println("All Players WON The GAME !!!");
            }
            else if(guessedNum == player_s2Num){
                System.out.println("Player 1 and Player 2 WON The GAME !!");
            }
            else if(guessedNum == player_s3Num){
                System.out.println("Player 1 and Player 3 WON The GAME !!");
            }
            else{
                System.out.println("Player 1 WON The GAME !");
            }
        }
        else if(guessedNum == player_s2Num){
            if(guessedNum == player_s3Num){
                System.out.println("Player 2 and Player 3 WON The GAME !!");
            }
            else{
                System.out.println("Player 2 WON The GAME !");
            }
        }
        else if(guessedNum == player_s3Num){
            System.out.println("Player 3 WON The GAME !");
        }
        else {
            System.out.println("GAME OVER : All Players LOST The GAME.");
        }
    }
}


public class GuessTheNumberGAME {

    public static void main(String[] args) {

        System.out.println("-----GAME START-----");
        UMPIRE um = new UMPIRE();
        um.collectGuesser_sNum();
        um.collectPlayer_sNum();
        um.compare();
        System.out.println("-----GAME OVER-----");

    }
}
