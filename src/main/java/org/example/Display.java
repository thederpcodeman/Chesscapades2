package org.example;

public interface Display {
    void display(Tile[][] tiles, String color);
    void display(Tile[][] tiles, int startX, int startY, int endX, int endY, String color);
    void choice(String[] options, String color);
    int[] getImput(String color);
}
