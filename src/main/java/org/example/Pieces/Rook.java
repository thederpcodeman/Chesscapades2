package org.example.Pieces;

import org.example.Movements.KnightMove;
import org.example.Movements.RookMove;
import org.example.Piece;

public class Rook extends Piece {
    public Rook(String color) {
        super();
        _name = "Rook";
        _color = color;
        _value = 5.0;
        addMove(new RookMove());
    }
}
