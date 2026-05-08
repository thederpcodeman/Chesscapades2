package org.example.Pieces;

import org.example.Movements.BishopMove;
import org.example.Movements.KnightMove;
import org.example.Piece;

public class Bishop extends Piece {
    public Bishop(String color) {
        super();
        _name = "Bishop";
        _color = color;
        _value = 3.0;
        addMove(new BishopMove());
    }
}
