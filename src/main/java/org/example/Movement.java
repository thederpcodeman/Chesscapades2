package org.example;

abstract public class Movement
{
    abstract public boolean isLegal(int sX, int sY, int dX, int dY, Board board);

    public void performMove(int sX, int sY, int dX, int dY, Board board){
        Piece piece = board.getTile(sX, sY).getPiece();
        Tile dest = board.getTile(dX, dY);
        Tile origin = board.getTile(sX, sY);
        if (isSpell()){
            piece.setMana(piece.getMana() - manaCost());
        } else {
            if (dest.isOccupied()) {
                piece.setMana(piece.getMana() + dest.getPiece().getMana() + 2.0);
            } else {
                piece.setMana(piece.getMana() + 1.0);
            }
        }
        dest.setPiece(piece);
        origin.setPiece(null);
    }

    abstract public boolean isSpell();

    abstract public double manaCost();
}
