package com.example.gitshame.business.gameplay;

import java.time.Duration;
import java.time.Instant;

public class TimeDifference {
    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();

        // Simulating some delay
        Thread.sleep(3000);

        Instant end = Instant.now();

        long secondsDifference = Duration.between(start, end).getSeconds();
        int score = (int)secondsDifference;

        System.out.println("Difference in seconds: " + score);
    }
}
