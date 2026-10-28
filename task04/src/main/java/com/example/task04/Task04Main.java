package com.example.task04;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        String result = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{N}]+")
                .tokens()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("\n"));

        System.out.print(result);
    }

}