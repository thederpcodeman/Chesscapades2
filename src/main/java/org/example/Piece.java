package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Piece
{
    private double _value;
    private double _mana;
    private HashMap<String, Double> _effects;
    private ArrayList<Movement> _movement;
    private ImageIcon _image;
    private String _color;
    private String _promotion;

    public Piece()
    {
        _value = 0;
        _mana = 0;
        _image = new ImageIcon("ChessLegacy/src/resources/default.png");

        _effects = new HashMap<>();
        _movement = new ArrayList<>();
        _color = "Grey";
        _promotion = "None";
    }

    public Piece(int value, ArrayList<Movement> movement, HashMap<String, Double> effects)
    {
        _value = value;
        _mana = 0;
        _image = new ImageIcon("ChessLegacy/src/resources/default.png");

        _effects = effects;
        _movement = movement;
        _color = "Grey";
        _promotion = "None";
    }

    public Piece(Piece piece) {
        _value = piece._value;
        _mana = piece._mana;
        _image = piece._image;
        _movement = new ArrayList<>();
        _movement.addAll(piece._movement);
        _effects = new HashMap<>();
        for (String effect : piece._effects.keySet()) {
            _effects.put(effect, piece._effects.get(effect));
        }
        _color = piece._color;
        _promotion = "None";
    }

    public Movement getFirstLegalMove(int sX, int sY, int dX, int dY, Board board)
    {
        for (Movement movement : _movement)
        {
            if (movement.isLegal(sX, sY, dX, dY, board))
            {
                return movement;
            }
        }
        return null;
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

    public ImageIcon getImage()
    {
        return _image;
    }

    public void setImage(ImageIcon image)
    {
        _image = image;
    }

    public void passive(){

    }

    public double getMana(){
        return _mana;
    }

    public void setMana(double mana){
        _mana = mana;
    }

    public String getColor(){
        return _color;
    }

    public void setColor(String color){
        _color = color;
    }

    public String getPromotion(){
        return _promotion;
    }


}
