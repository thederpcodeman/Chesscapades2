package org.example.Movements;

import org.example.Board;
import org.example.Movement;

public class PawnEnPessant extends Movement {

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



    }

    @Override
    public void performMove(int sX, int sY, int dX, int dY, Board board){

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
