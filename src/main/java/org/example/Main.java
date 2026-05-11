package org.example;

import org.example.Pieces.Advanced.*;
import org.example.Pieces.Basic.*;
import org.example.Pieces.Intermediate.*;
import org.example.Pieces.Pawn.*;
import org.example.Pieces.Royal.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board(8, 8);
        for (int i = 0; i < 8; i++) {
            board.getTile(i, 1).setPiece(new Pawn("Black"));
            board.getTile(i, 6).setPiece(new Pawn("White"));
        }
        board.getTile(0, 0).setPiece(new Rook("Black"));
        board.getTile(1, 0).setPiece(new Knight("Black"));
        board.getTile(2, 0).setPiece(new Bishop("Black"));
        board.getTile(3, 0).setPiece(new Queen("Black"));
        board.getTile(4, 0).setPiece(new King("Black"));
        board.getTile(5, 0).setPiece(new Bishop("Black"));
        board.getTile(6, 0).setPiece(new Knight("Black"));
        board.getTile(7, 0).setPiece(new Rook("Black"));

        board.getTile(0, 7).setPiece(new Rook("White"));
        board.getTile(1, 7).setPiece(new Knight("White"));
        board.getTile(2, 7).setPiece(new Bishop("White"));
        board.getTile(3, 7).setPiece(new Queen("White"));
        board.getTile(4, 7).setPiece(new King("White"));
        board.getTile(5, 7).setPiece(new Bishop("White"));
        board.getTile(6, 7).setPiece(new Knight("White"));
        board.getTile(7, 7).setPiece(new Rook("White"));
        TextDisplay cli = new TextDisplay();
        Game game = new Game();
        game.runGame(board, "Test", cli);
    }
}