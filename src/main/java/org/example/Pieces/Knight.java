package org.example.Pieces;

import org.example.Movements.KnightMove;
import org.example.Piece;

public class Knight extends Piece {
    public Knight(String color) {
        super();
        _name = "Knight";
        _color = color;
        _value = 3.0;
        addMove(new KnightMove());
    }
}
