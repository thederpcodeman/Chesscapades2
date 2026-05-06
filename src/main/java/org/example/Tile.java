package org.example;

import java.util.HashMap;

public class Tile
{
    private Piece _piece;
    private String _color;
    private String _prom;
    private HashMap<String, Double> effects;
    public Tile() {
        _piece = null;
        _color = null;
        _prom = null;
    }
    public Tile(String color)
    {
        _piece = null;
        _color = color;
        _prom = null;
    }
    public Tile(String color, String prom)
    {
        _piece = null;
        _color = color;
        _prom = prom;
    }
    public Tile(Tile tile){
        _piece = new Piece(tile._piece);
        _color = tile._color;
        _prom = tile._prom;
    }

    public Movement isLegalMove(int sX, int sY, int dX, int dY, Board b)
    {
        return _piece.getFirstLegalMove(sX, sY, dX, dY, b);
    }

    public Piece getPiece()
    {
        return _piece;
    }

    public void setPiece(Piece newPiece)
    {
        _piece = newPiece;
    }

    public boolean isOccupied()
    {
        return _prom != null;
    }

    public boolean isPassable(){
        return isOccupied();
    }
}
