/** 
 * @author Jeancy Tshibemba Mukendi
 * @version 1
 * @since 2018 
 */
package diamond;

import java.util.Scanner;

//Implementing the tic tac toe game to be played on the console.
public class TicTacToe {
	// A private method or class can only be accessed from within the class it was created, trying to call a private method or class out side its class will result in 
	// compilation error
	private static int count = 0; // You can call this static variavle like this: TicTacToe.count or just count within the same class.
	private static boolean play = true;
	private static int  row ;
	private static int col ;
	private static Scanner sc = new Scanner(System.in);
	//The method that prints the board every time a player has played
	public static void printBoard(String[][] board) {
		int l = board.length ; // the length property of an array gives it size or the number of element in the array
		for (int i = 0; i < l; i++) { // post increment i++ means we use the initial value of i then we increment
			System.out.println("-------------");
			for (int j = 0; j < l ; j++) {
				if (board[i][j] == null) {
					board[i][j] = " ";
				}
				System.out.print("| "+ board[i][j] + " " );
			}
			System.out.println("|");
			if (i ==  l-1) {
				System.out.println("-------------");
			}
		}
		
	}
	// Method that defines how playerX should play the game
	public static void playX(String[][] board) {
		count++;
		if(count > 9) {
			System.out.println("Game finished with a draw:");
			play =false;
			System.exit(0);
		}
		System.out.println("PlayerX enter row: ");
		row = sc.nextInt();
		while((row < 0) || (row > 2)) {
			System.out.println("Sorry man, enter 0 or 1 or 2");
			row = sc.nextInt();
		}
		System.out.println("PlayerX enter column: ");
		col = sc.nextInt();
		while((col < 0) || (col > 2)) {
			System.out.println("Sorry man, enter 0 or 1 or 2");
			col = sc.nextInt();
		}
		while ((board[row][col] == "x") || (board[row][col] == "o"))  {
			System.out.println("position occupied please enter a diffent row or column:");
			System.out.println("PlayerX enter row: ");
			row = sc.nextInt();
			System.out.println("PlayerX enter col: ");
			col = sc.nextInt();
		}
		board[row][col] = "x";
		TicTacToe.printBoard(board);
		for (int i = 0; i < board.length; i++) {
		    if ((board[i][0].equals("x")) && (board[i][1].equals("x")) && (board[i][2].equals("x"))) {
				System.out.println("Game over: PlayerX won!");
				play = false;
				System.exit(0);
		     }
		}
		for (int j = 0; j < board.length; j++) {
			if ((board[0][j].equals("x")) && (board[1][j].equals("x")) && (board[2][j].equals("x"))) {
			     System.out.println("Game over: PlayerX won!");
			     play = false;
			     System.exit(0);
		     }
		}
		if ((board[0][0].equals("x")) && (board[1][1].equals("x")) && board[2][2].equals("x")) {
			System.out.println("Game over: PlayerX won!");
			play = false;
			System.exit(0);
		    
		}
		if ((board[2][0].equals("x")) && (board[1][1].equals("x")) && board[0][2].equals("x")) {
			System.out.println("Game over: PlayerX won!");
			play = false;
			System.exit(0);
		    
		}
	}	
    
	// Define the method that tells playerO how to play
	public static void playO(String[][] board) {
		count++;
		if(count > 9) {
			System.out.println("Game finished with a draw:");
			play = false;
			System.exit(0);
		}
		System.out.println("PlayerO enter row: ");
		row = sc.nextInt();
		while((row < 0) || (row > 2)) {
			System.out.println("Sorry man, Enter 0 or 1 or 2");
			row = sc.nextInt();
		}
		System.out.println("PlayerO enter column: ");
		col = sc.nextInt();
		while((col < 0) || (col > 2)) {
			System.out.println("Sorry man, Enter 0 or 1 or 2");
			col = sc.nextInt();
		}
		while ((board[row][col] == "x") || (board[row][col] == "o"))  {
			System.out.println("position or cell occupied please enter a diffent row or column:");
			System.out.println("PlayerO enter row: ");
			row = sc.nextInt();
			System.out.println("PlayerO enter col: ");
			col = sc.nextInt();
		}
		board[row][col] = "o";
		TicTacToe.printBoard(board);
	    for (int i = 0; i < board.length; i++) {
			if ((board[i][0].equals("o")) && (board[i][1].equals("o")) && board[i][2].equals("o")) {
				System.out.println("Game over: PlayerO won!");
				play = false;
				System.exit(0);
			    
			}
			if ((board[0][0].equals("o")) && (board[1][1].equals("o")) && board[2][2].equals("o")) {
				System.out.println("Game over: PlayerO won!");
				play = false;
				System.exit(0);
			    
			}
			if ((board[2][0].equals("o")) && (board[1][1].equals("o")) && board[0][2].equals("o")) {
				System.out.println("Game over: PlayerO won!");
				play = false;
				System.exit(0);
			 }
		}
	    for (int j = 0; j < board.length; j++) {
			if ((board[0][j].equals("o")) && (board[1][j].equals("o")) && (board[2][j].equals("o"))) {
				System.out.println("Game over: PlayerO won!");
				play = false;
				System.exit(0);
			}
		}	
	}
	public static void main(String[] args) {
		String[][] myBoard = new String[3][3]; 
		TicTacToe.printBoard(myBoard);
		while (play ) {
			TicTacToe.playX(myBoard);
			TicTacToe.playO(myBoard);	
	        } 	
	 }
}
