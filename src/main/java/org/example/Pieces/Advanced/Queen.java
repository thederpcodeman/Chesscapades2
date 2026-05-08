package org.example.Pieces.Advanced;

import org.example.Movements.BishopMove;
import org.example.Movements.RookMove;
import org.example.Piece;

public class Queen extends Piece {
    public Queen(String color) {
        super();
        _name = "Queen";
        _color = color;
        _value = 9.5;
        _type = "Advanced";
        addMove(new BishopMove());
        addMove(new RookMove());
    }
}
