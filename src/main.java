import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;

public class main{
    public static void main(String[]args){
        Scanner userChoice = new Scanner(System.in);
        Gameboard board = new Gameboard();
        board.printBoard();
        AIPlayer player = new AIPlayer();
       do {
           if(board.getCurrentPlayerMark() == 'o'){
           System.out.println("Current board layout:");
           board.printBoard();
           int row;
           int col;
           do {
               System.out.println(" Human player , enter an empty row and column to place your mark!");
               row = userChoice.nextInt() - 1;
               col = userChoice.nextInt() - 1;


           }
           while (!board.placeMark(row, col));
           }

           else{
               System.out.println("Senor Robot, its your turn. ");
               AIPlayer.Move bestMove= player.findMove(board);
               board.placeMark(bestMove.row,bestMove.col);


           }
           board.changePlayer();


       }

       while(!board.isBoardFull() && !board.isWon());

           if(board.isBoardFull() && !board.isWon()){
               System.out.println("The game is a tie.");

           }
           else{
               System.out.println("Current board layout:");
               board.printBoard();
               board.changePlayer();
               if (board.getCurrentPlayerMark() == 'x'){
                   System.out.println("You lost puny human.");
               }
               else{
                   System.out.println("You Win!");
               }


           }






        }}
