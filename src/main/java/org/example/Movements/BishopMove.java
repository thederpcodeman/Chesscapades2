package org.example.Movements;

import org.example.Board;
import org.example.Movement;

public class BishopMove extends Movement {

    @Override
    public boolean isLegal(int sX, int sY, int dX, int dY, Board board){
        int deltaX = Math.abs(sX - dX);
        int deltaY = Math.abs(sY - dY);
        if (deltaX == deltaY){
            for (int i = 1; i < deltaY; i++){
                if (!(board.getTile((int)(sX + (i * Math.signum(dX - sX))), (int)(sY + (i * Math.signum(dY - sY))))).isPassable()){
                    return false;
                }
            }
            return true;
        }
        return false;
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
