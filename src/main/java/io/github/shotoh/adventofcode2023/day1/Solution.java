package io.github.shotoh.adventofcode2023.day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static List<String> lines;
    private static Map<String, String> map;

    public static void main(String[] args) {
        try {
            lines = Files.readAllLines(Path.of("src/main/resources/day1/input.txt"));
            map = Map.of("one", "1", "two", "2", "three", "3", "four", "4", "five", "5", "six", "6", "seven", "7", "eight", "8", "nine", "9");
            part1();
            part2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part1() {
        int sum = 0;
        for (String s : lines) {
            sum += getValue(s);
        }
        System.out.println("Part 1: " + sum);
    }

    public static void part2() {
        int sum = 0;
        Map<Integer, String> indexMap = new TreeMap<>();
        for (String s : lines) {
            indexMap.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (s.contains(key)) {
                    indexMap.put(s.indexOf(key), key);
                }
            }
            for (Map.Entry<Integer, String> entry : indexMap.entrySet()) {
                String value = entry.getValue();
                s = s.replace(value, map.get(value) + value);
            }
            sum += getValue(s);
        }
        System.out.println("Part 2: " + sum);
    }

    public static int getValue(String line) {
        int val = 0;
        boolean foundFirst = false;
        boolean foundLast = false;
        char[] arr = line.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char first = arr[i];
            char last = arr[arr.length - i - 1];
            if (!foundFirst && Character.isDigit(first)) {
                val += (first - '0') * 10;
                foundFirst = true;
            }
            if (!foundLast && Character.isDigit(last)) {
                val += last - '0';
                foundLast = true;
            }
            if (foundFirst && foundLast) return val;
        }
        return -1;
    }
}
