package io.github.shotoh.adventofcode2023.day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static List<String> lines;
    private static List<Game> games;

    public static void main(String[] args) {
        try {
            lines = Files.readAllLines(Path.of("src/main/resources/day2/input.txt"));
            games = new ArrayList<>();
            part1();
            part2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part1() {
        int sum = 0;
        int index = 1;
        for (String s : lines) {
            Game game = new Game(s);
            if (game.validate(12, 13, 14)) sum += index;
            index++;
        }
        System.out.println("Part 1: " + sum);
    }

    public static void part2() {
        int sum = 0;
        for (String s : lines) {
            Game game = new Game(s);
            sum += game.getMaximum();
        }
        System.out.println("Part 2: " + sum);
    }
}
