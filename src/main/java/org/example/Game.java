package org.example;

public class Game {

    // Returns -1 = error, 1 tie, 2 White won, 3 Black won.
    public int runGame(Board board, String Mode, Display disp) {
        String turn = "White";
        while (true) {
            board = new Board(board);
            // Promotions
            board = promotePieces(board);

            // check for endgame conditions
            if (checkWin(board) != 0) {
                return checkWin(board);
            }

            // display
            disp.display(board.getTiles(), turn);
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

            // Time passes
            passiveUpdate(board, turn);

            // second display
            disp.display(board.getTiles(), turn);
        }

    }

    public void makeMove(Board board, String color, Display disp) {
        while (true) {
            int[] choices = disp.getImput(color);
            if (choices.length == 4){
                if (choices[0] >= 0 && choices[1] >= 0 && choices[2] >= 0 && choices[3] >= 0 &&
                choices[0] < board.getX() && choices[1] < board.getY() && choices[2] < board.getY() &&
                choices[3] < board.getY()) {
                    Movement move = board.getTile(choices[0], choices[1]).isLegalMove(choices[0], choices[1], choices[2], choices[3], board);
                    if (move != null) {
                        move.performMove(choices[0], choices[1], choices[2], choices[3], board);
                        return;
                    }
                }
            }
        }
    }
    public void passiveUpdate(Board board, String color) {}
    public int checkWin(Board board) {
        return 0;
    }

    public Board promotePieces(Board board) {
        for (int y = 0; y < board.getY(); y++){
            for (int x = 0; x < board.getX(); x++){
                Tile t = board.getTile(x, y);
                if (t.isOccupied()){
                    if (t.getPiece().getColor().equals(t.promotionType())){
                        if (t.getPiece().getPromotion().equals("Default")){
                            board = new Board(board);
                            board = defaultPromotion(x, y, board);
                        }
                    }
                }
            }
        }
        return board;
    }

    public Board defaultPromotion(int x, int y, Board board) {
        return board;
    }
}
