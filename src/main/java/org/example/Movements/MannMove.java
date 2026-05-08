package org.example.Movements;

import org.example.Board;
import org.example.Movement;

public class MannMove extends Movement {

    @Override
    public boolean isLegal(int sX, int sY, int dX, int dY, Board board){
        int deltaX = Math.abs(sX - dX);
        int deltaY = Math.abs(sY - dY);
        return deltaX <= 1 && deltaY <= 1;
    }

    @Override
    public boolean isSpell(){
        return false;
    }

    @Override
    public double manaCost() {
        return 0;
    }
}
