package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static void printBoard(char[] board) {
        System.out.println("-----------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " | ");

            if ((i + 1) % 3 == 0) {
                System.out.println("");
                System.out.println("-----------");
            }
        }
    }

    public static boolean makeMove(char[] board, int move, char player) {
        try {
            if (board[move - 1] != 'X' || board[move - 1] != 'O') {
                return false;
            } else {
                board[move - 1] = player;
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter an integer between 1 and 9!");
            return false;
        }
    }

    public static boolean isWinner(char[] board, char player) {
        if (board[0] == player && board[1] == player && board[2] == player
                || board[3] == player && board[4] == player && board[5] == player
                || board[6] == player && board[7] == player && board[8] == player) {
            return true;
        }
        if (board[0] == player && board[3] == player && board[6] == player
                || board[1] == player && board[4] == player && board[7] == player
                || board[2] == player && board[5] == player && board[8] == player) {
            return true;
        }
        if (board[0] == player && board[4] == player && board[8] == player
                || board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Scanner keyboard = new Scanner(System.in);
        char player = 'X';
        int move = 1;

        while (true) {
            printBoard(board);
            System.out.println("Player " + player + ": Make your move! [1-9]");
            try {
                move = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You entered a non-integer");
                keyboard.nextLine();
                continue;
            }
            if (!makeMove(board, move, player)) {
                System.out.println("Player " + player + ": Invalid move!");
                continue;
            }
            if (isWinner(board, player)) {
                System.out.println("Player " + player + ": You won!");
                break;
            }
            player = player == 'X' ? 'O' : 'X';
        }
        printBoard(board);
    }
}
