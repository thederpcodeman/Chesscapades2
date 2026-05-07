package org.example;

public class Game {

    // Returns -1 = error, 1 tie, 2 White won, 3 Black won.
    public int runGame(Board board, String Mode, Display disp) {
        String turn = "White";
        while (true) {
            board = new Board(board);
            // Promotions
            passiveUpdate(board, turn);
            // check for endgame conditions
            if (checkWin(board) != 0) {
                return checkWin(board);
            }

            // display
            disp.display(board.getTiles(), turn);
            board = new Board(board);
            makeMove(board, turn, disp);
            if (turn.equals("White")) {
                if (board.getRule("White Bonus Turns") > 0) {
                    board.incrementRule("White Bonus Turns", -1);
                } else {
                    turn = "Black";
                }
            } else if (turn.equals("Black")) {
                if (board.getRule("Black Bonus Turns") > 0) {
                    board.incrementRule("Black Bonus Turns", -1);
                } else {
                    turn = "White";
                }
            } else {
                return -1;
            }

            // second display
            disp.display(board.getTiles(), turn);
        }

    }

    public void makeMove(Board board, String color, Display disp) {
        while (true) {
            int[] choices = disp.getImput(color);
            if (choices.length == 4){

            }
        }
    }
    public void passiveUpdate(Board board, String color) {}
    public int checkWin(Board board) {
        return 0;
    }
}
