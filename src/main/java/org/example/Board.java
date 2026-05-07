package org.example;

import java.util.HashMap;
import java.util.Random;

public class Board
{
    private int _x;
    private int _y;
    private Tile[][] _tiles;
    private Random _random;
    private long _nextSeed;
    private HashMap<String, Double> _rules;

    public Board(int x, int y){
        _x = x;
        _y = y;
        _tiles = new Tile[_y][_x];
        boolean color = false;
        for (int i = 0; i < _y; i++) {
            color = i % 2 == 0;
            for (int j = 0; j < _x; j++) {
                if (color) {
                    _tiles[i][j] = new Tile("White");
                    color = false;
                } else {
                    _tiles[i][j] = new Tile("Black");
                    color = true;
                }

            }
        }
        _random = new Random();
        _nextSeed = System.currentTimeMillis();
        _rules = new HashMap<>();
    }

    public Board (Board board){
        _x = board._x;
        _y = board._y;
        _tiles = new Tile[_y][_x];
        for (int i = 0; i < _y; i++) {
            for (int j = 0; j < _x; j++) {
                _tiles[i][j] = new Tile(board._tiles[i][j]);
            }
        }
        _random = new Random(board._nextSeed);
        _nextSeed = _random.nextLong();
        _rules = new HashMap<>();
        for (String rule : board._rules.keySet()) {
            _rules.put(rule, board._rules.get(rule));
        }
    }

    public Tile getTile(int x, int y){
        return _tiles[y][x];
    }

    public Tile[][] getTiles(){
        return _tiles;
    }

    public boolean hasRule(String rule){
        if (_rules.containsKey(rule)){
            if (_rules.get(rule) > 0){
                return true;
            }
        }
        return false;
    }

    public double getRule(String rule){
        return _rules.getOrDefault(rule, 0.0);
    }

    public void setRule(String rule, double value){
        _rules.put(rule, value);
    }
    public void incrementRule(String rule, double value){
        _rules.put(rule, _rules.getOrDefault(rule, 0.0) + value);
    }
}

