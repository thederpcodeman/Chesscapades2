package org.example.Pieces.Royal;

import org.example.Movements.MannMove;
import org.example.Piece;

public class King extends Piece {
    public King(String color) {
        super();
        _name = "King";
        _color = color;
        _value = 4.0;
        _royal = true;
        _type = "Royal";
        addMove(new MannMove());
    }
}
