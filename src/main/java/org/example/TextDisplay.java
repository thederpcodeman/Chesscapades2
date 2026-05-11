package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TextDisplay implements Display {
    public void display(Tile[][] tiles, String color){
        System.out.println("-----");
        System.out.println(color + "'s turn");
        System.out.println("-----");
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                Piece piece = tile.getPiece();
                if (piece != null) {
                    System.out.print(piece.getColor().substring(0, 4) + ", " + piece.getName().substring(0, 3) + "| ");
                } else {
                    System.out.print(" ___, ___| ");
                }

            }
            System.out.println();
        }
    }

    public void display(Tile[][] tiles, int startX, int startY, int endX, int endY, String color){
        this.display(tiles, color);
    }

    public void choice(String[] options, String color){
        System.out.println("-----");
        System.out.println(color + "'s turn");
        System.out.println("Promotion options:");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public int[] getImput(String color){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----");
        System.out.println(color + "'s turn");
        int imput = 0;
        ArrayList<Integer> imputs = new ArrayList<>();
        while (imput >= 0) {
            imput = scanner.nextInt();
            if (imput >= 0) {
                imputs.add(imput);
            }
        }
        return imputs.stream().mapToInt(i -> i).toArray();
    }

}
