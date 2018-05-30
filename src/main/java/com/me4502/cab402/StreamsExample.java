package com.me4502.cab402;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {
        var exampleList = List.of(5, 73, 42, 4101, -1, -255, 330, 0);
        exampleList = exampleList.stream()
                .filter(i -> i > 0)
                .map(i -> i * 2)
                .sorted(Comparator.comparingInt(i -> (int) i).reversed())
                .collect(Collectors.toList());
        System.out.println(exampleList); // [8202, 660, 146, 84, 10]
    }
}
