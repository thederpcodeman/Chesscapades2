package org.example.Movements;

import org.example.Board;
import org.example.Movement;

public class PawnDoubleMove extends Movement {

    @Override
    public boolean isLegal(int sX, int sY, int dX, int dY, Board board){
        int deltaX = sX - dX;
        int deltaY = sY - dY;
        String direction = board.getTile(sX, sY).getPiece().getDirection();
        int mainDirection;
        int sideDirection;
        if (direction.equals("Up")){
            mainDirection = deltaY;
            sideDirection = Math.abs(deltaX);
        } else if (direction.equals("Down")) {
            mainDirection = deltaX * -1;
            sideDirection = Math.abs(deltaX);
        } else if (direction.equals("Left")) {
            mainDirection = deltaX * -1;
            sideDirection = Math.abs(deltaY);
        } else if (direction.equals("Right")) {
            mainDirection = deltaX;
            sideDirection = Math.abs(deltaY);
        } else {
            return false;
        }

        if (mainDirection == 2 && sideDirection == 0) {
            if (board.getTile(sX, sY).getPiece().getMana() <= 0) {
                if (!board.getTile(dX, dY).isOccupied()) {
                    if (board.getTile(sX + (int) Math.signum(deltaX), sY + (int) Math.signum(deltaY)).isOccupied()) {
                        return false;
                    }
                    return true;
                }
            }
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

    @Override
    public void performMove(int sX, int sY, int dX, int dY, Board board){
        super.performMove(sX, sY, dX, dY, board);
        board.getTile((sX + dX) / 2, (sY + dY) / 2).addEffect("En Route", 2.0);
        board.getTile((sX + dX) / 2, (sY + dY) / 2).addEffect("En Route X", (double) dX);
        board.getTile((sX + dX) / 2, (sY + dY) / 2).addEffect("En Route Y", (double) dY);
    }
}
