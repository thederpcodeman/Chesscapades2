package org.example.Pieces.Pawn;

import org.example.Movements.BishopMove;
import org.example.Piece;

public class Pawn extends Piece {
    public Pawn(String color) {
        super();
        _name = "Pawn";
        _color = color;
        _value = 3.0;
        _type = "Pawn";
        if (color.equals("White")){
            _direction = "Up";
        } else if (color.equals("Black")){
            _direction = "Down";
        }
        addMove(new BishopMove());
    }
}
