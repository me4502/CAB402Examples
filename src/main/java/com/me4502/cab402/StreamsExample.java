package com.me4502.cab402;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {
        simpleStream();
        flatMapExample();
        lazyStream(true);
        lazyStream(false);
        parallelStream();
    }

    public static void simpleStream() {
        var exampleList = List.of(5, 73, 42, 4101, -1, -255, 330, 0);
        exampleList = exampleList.stream()
                .filter(i -> i > 0)
                .map(i -> i * 2)
                .sorted(Comparator.comparingInt(i -> (int) i).reversed())
                .collect(Collectors.toList());
        System.out.println(exampleList); // [8202, 660, 146, 84, 10]
    }

    public static void flatMapExample() {
        var exampleMap = Map.of("A", List.of(1, 2, 3), "B", List.of(4, 5, 6));
        var outputList = exampleMap.entrySet().stream()
                .flatMap(entry -> entry .getValue().stream())
                .collect(Collectors.toList());
        System.out.println(outputList); // [1, 2, 3, 4, 5, 6]
    }

    public static void lazyStream(boolean allowNegatives) {
        var exampleList = List.of(-10, -5, 0, 5, 10);
        var stream = exampleList.parallelStream()
                .mapToInt(i -> i * 2);
        if (!allowNegatives) {
            stream = stream.filter(i -> i >= 0);
        }
        System.out.println(stream.sum()); // If true, 0. Otherwise, 30
    }

    public static void parallelStream() {
        var exampleList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var sum = exampleList.parallelStream()
                .mapToInt(i -> (int) Math.pow(i, 2))
                .sum();
        System.out.println(sum); // 385
    }
}
