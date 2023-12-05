package io.github.shotoh.adventofcode2023.day2;

import java.util.*;

public class Game {
    private List<MiniGame> miniGamesList;

    public Game(String input) {
        this.miniGamesList = new ArrayList<>();
        input = input.split(": ")[1];
        String[] miniGames = input.split("; ");
        for (String miniGame : miniGames) {
            miniGamesList.add(new MiniGame(miniGame));
        }
    }

    public boolean validate(int r, int g, int b) {
        for (MiniGame miniGame : miniGamesList) {
            if (miniGame.getRed() > r || miniGame.getGreen() > g || miniGame.getBlue() > b) return false;
        }
        return true;
    }

    public int getMaximum() {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;
        for (MiniGame miniGame : miniGamesList) {
            maxRed = Math.max(miniGame.getRed(), maxRed);
            maxGreen = Math.max(miniGame.getGreen(), maxGreen);
            maxBlue = Math.max(miniGame.getBlue(), maxBlue);
        }
        return maxRed * maxGreen * maxBlue;
    }
}
