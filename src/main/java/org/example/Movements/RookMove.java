package org.example.Movements;

import org.example.Board;
import org.example.Movement;

public class RookMove extends Movement {

    @Override
    public boolean isLegal(int sX, int sY, int dX, int dY, Board board){
        int deltaX = Math.abs(sX - dX);
        int deltaY = Math.abs(sY - dY);
        if (deltaY == 0) {
            for (int i = 1; i < Math.abs(deltaX); i++) {
                if (!board.getTile((int) (sX + (i * Math.signum(deltaX))), sY).isPassable()) {
                    return false;
                }
            }
            return true;
        } else if (deltaX == 0) {
            for (int i = 1; i < Math.abs(deltaY); i++) {
                if (!board.getTile(sX, (int) (sY + (i * Math.signum(deltaY)))).isPassable()) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
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
