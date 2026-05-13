package org.example;

import java.util.HashMap;

public class Tile
{
    private Piece _piece;
    private String _color;
    private String _prom;
    private HashMap<String, Double> _effects;
    public Tile() {
        _piece = null;
        _color = null;
        _prom = null;
        _effects = new HashMap<>();
    }
    public Tile(String color)
    {
        _piece = null;
        _color = color;
        _prom = null;
        _effects = new HashMap<>();
    }
    public Tile(String color, String prom)
    {
        _piece = null;
        _color = color;
        _prom = prom;

        _effects = new HashMap<>();
    }
    public Tile(Tile tile){
        if (tile._piece == null){
            _piece = null;
        } else {
            _piece = new Piece(tile._piece);
        }
        _color = tile._color;
        _prom = tile._prom;
        _effects = tile._effects;
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
        return _piece != null;
    }

    public boolean isPassable(){
        return !isOccupied();
    }

    public String promotionType(){
        return _prom;
    }

    public void setPromotion(String promotionType){
        _prom = promotionType;
    }

    public boolean hasEffect(String effect)
    {
        return _effects.containsKey(effect);
    }

    public Double getEffect(String effect)
    {
        return _effects.get(effect);
    }

    public void addEffect(String effect, Double value)
    {
        _effects.put(effect, value);
    }
}
