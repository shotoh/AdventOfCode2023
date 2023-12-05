package io.github.shotoh.adventofcode2023.day2;

public class MiniGame {
    private static String[] colors = {"red", "green", "blue"};

    private int red;
    private int green;
    private int blue;

    public MiniGame(String input) {
        String[] cubes = input.split(", ");
        for (String cube : cubes) {
            int length = cube.length();
            for (String color : colors) {
                int startIndex = length - color.length();
                if (!cube.substring(startIndex, length).equals(color)) continue;
                int value = Integer.parseInt(cube.substring(0, startIndex - 1));
                switch (color) {
                    case "red" -> red = value;
                    case "green" -> green = value;
                    case "blue" -> blue = value;
                }
            }
        }
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
