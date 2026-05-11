package org.example;

import org.example.Pieces.Advanced.Queen;
import org.example.Pieces.Basic.Bishop;
import org.example.Pieces.Basic.Knight;
import org.example.Pieces.Intermediate.Rook;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    // Returns -1 = error, 1 tie, 2 White won, 3 Black won.
    public int runGame(Board board, String Mode, Display disp) {
        String turn = "White";
        while (true) {
            board = new Board(board);
            // Promotions
            board = promotePieces(board, disp);

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

    public Board promotePieces(Board board, Display disp) {
        System.out.println("Promoting...");
        for (int y = 0; y < board.getY(); y++){
            for (int x = 0; x < board.getX(); x++){
                Tile t = board.getTile(x, y);
                if (t.isOccupied()){
                    System.out.println(x + "," + y);
                    if (t.getPiece().getColor().equals(t.promotionType())){
                        System.out.println("On PromotionSquare!" + x + "," + y);
                        if (t.getPiece().getPromotion().equals("Default")){
                            System.out.println("Promotion!" + x + "," + y);
                            board = new Board(board);
                            board = defaultPromotion(x, y, board, disp, t.getPiece().getColor());
                        } else{
                            System.out.println(t.getPiece().getPromotion() + "," + t.getPiece().getName());
                        }
                    }
                }
            }
        }
        return board;
    }

    public Board defaultPromotion(int x, int y, Board board, Display disp, String color) {
        Tile tile = board.getTile(x, y);
        double power = tile.getPiece().getMana();
        ArrayList<String> Choices = new ArrayList<>();
        ArrayList<String> Basic = new ArrayList<>(Arrays.asList("Bishop", "Knight", "Bishop", "Knight"));
        ArrayList<String> Intermediate = new ArrayList<>(Arrays.asList("Rook", "Rook", "Rook"));
        ArrayList<String> Advanced = new ArrayList<>(Arrays.asList("Queen", "Queen", "Queen"));
        ArrayList<String> Super = new ArrayList<>(Arrays.asList("Queen", "Queen", "Queen"));
        ArrayList<String> Royal = new ArrayList<>(Arrays.asList("King", "King", "King"));


        if (power <= 0){
            Choices.add("Turn Around");
        } else if (power <= 2){
            Choices.add("Turn Around");
            addOption(Choices, Basic, board);
        } else if (power <= 5){
            Choices.add("Turn Around");
            addOption(Choices, Basic, board);
            addOption(Choices, Basic, board);
        } else if (power <= 6){
            addOption(Choices, Basic, board);
            addOption(Choices, Basic, board);
            addOption(Choices, Basic, board);
        } else if (power <= 7){
            addOption(Choices, Intermediate, board);
            addOption(Choices, Basic, board);
            addOption(Choices, Basic, board);
        } else if (power <= 8){
            addOption(Choices, Intermediate, board);
            addOption(Choices, Intermediate, board);
            addOption(Choices, Basic, board);
        } else if (power <= 9){
            addOption(Choices, Advanced, board);
            addOption(Choices, Intermediate, board);
            addOption(Choices, Basic, board);
        } else if (power <= 10){
            addOption(Choices, Advanced, board);
            addOption(Choices, Intermediate, board);
            addOption(Choices, Intermediate, board);
        } else if (power <= 11){
            addOption(Choices, Advanced, board);
            addOption(Choices, Advanced, board);
            addOption(Choices, Intermediate, board);
        } else if (power <= 15){
            addOption(Choices, Advanced, board);
            addOption(Choices, Advanced, board);
            addOption(Choices, Advanced, board);
        } else if (power <= 20){
            addOption(Choices, Super, board);
            addOption(Choices, Advanced, board);
            addOption(Choices, Advanced, board);
        } else if (power <= 25){
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Advanced, board);
        } else if (power <= 30){
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
        } else if (power <= 50){
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Royal, board);
        } else if (power < 100){
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Advanced, board);
            addOption(Choices, Royal, board);
        } else {
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Super, board);
            addOption(Choices, Royal, board);
        }

        int Chosen = -1;
        while (!(Chosen >= 0 && Chosen < Choices.size())){
            disp.choice(Choices.toArray(String[]::new), color);
            int[] imput = disp.getImput(color);
            if (imput.length == 1){
                Chosen = imput[0];
            }
        }
        tile.setPiece(getPieceFromName(Choices.get(Chosen), tile.getPiece().getColor(), tile.getPiece()));
        return board;
    }

    public void addOption(ArrayList<String> Choices, ArrayList<String> possibilities, Board board){
        int rNum = board.getBoardRandom().nextInt(possibilities.size());
        Choices.add(possibilities.get(rNum));
        possibilities.remove(rNum);
    }

    public Piece getPieceFromName(String name, String color, Piece piece){
        // Pawn
        if (name.equals("Turn Around")){
            String direction = piece._direction;
            piece = new Piece(piece);
            if (direction.equals("Up")) {
                piece._direction = "Down";
            } else if (direction.equals("Down")) {
                piece._direction = "Up";
            } else if (direction.equals("Left")) {
                piece._direction = "Right";
            } else if (direction.equals("Right")) {
                piece._direction = "Light";
            }
            return piece;
        }

        // Basic
        if (name.equals("Bishop")){
            return new Bishop(color);
        }
        if (name.equals("Knight")){
            return new Knight(color);
        }
        if (name.equals("Queen")){
            return new Queen(color);
        }
        if (name.equals("Rook")){
            return new Rook(color);
        }
        return new Piece(piece);
    }
}
