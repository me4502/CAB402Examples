package com.me4502.cab402;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ParallelStreamSpeeds {

    public static void main(String[] args) {
        // Pre-load collection.
        getTestCollection();

        // Warm-up the JIT
        for (int i = 0; i < 10; i++) {
            testIteration();
            testStream();
            testParallel();
        }

        // Actually benchmark the code
        timer("Iteration", ParallelStreamSpeeds::testIteration);
        timer("Stream", ParallelStreamSpeeds::testStream);
        timer("Parallel", ParallelStreamSpeeds::testParallel);
    }

    public static void timer(String name, Supplier<Long> function) {
        var timeSum = 0L;
        var iterations = 10.0;
        var result = 0L;
        for (var i = 0L; i < iterations; i++) {
            var time = System.currentTimeMillis();
            result = function.get();
            timeSum += (System.currentTimeMillis() - time);
        }
        System.out.println("Got " + result + " in " + (timeSum / iterations) + "ms on " + name);
    }

    private static List<Long> testCollection;

    private static List<Long> getTestCollection() {
        if (testCollection == null) {
            testCollection = new ArrayList<>();
            for (var i = 0L; i < 100000000L; i++) {
                testCollection.add(i);
            }
        }

        return testCollection;
    }

    public static long testIteration() {
        long sqrtSum = 0;
        for (long val : getTestCollection()) {
            sqrtSum += (long) Math.sqrt(val);
        }
        return sqrtSum;
    }

    public static long testStream() {
        return getTestCollection().stream()
                .mapToLong(i -> (long) Math.sqrt(i))
                .sum();
    }

    public static long testParallel() {
        return getTestCollection().parallelStream()
                .mapToLong(i -> (long) Math.sqrt(i))
                .sum();
    }
}
