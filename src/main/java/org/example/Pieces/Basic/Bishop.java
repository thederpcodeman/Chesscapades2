package org.example.Pieces.Basic;

import org.example.Movements.BishopMove;
import org.example.Piece;

public class Bishop extends Piece {
    public Bishop(String color) {
        super();
        _name = "Bishop";
        _color = color;
        _value = 3.0;
        _type = "Basic";
        addMove(new BishopMove());
    }
}
