package org.assign7.threads;

import java.util.Random;

public class GenomeSequenceGeneratorThread implements Runnable {

    private static final int GENOME_SEQUENCES_PER_THREAD = 20;
    private static final int THREAD_COUNT = 5;

    private static long WITHOUT_THREAD_TIME;
    private static long WITH_THREAD_TIME;

    // Method to generate a random genome sequence of length 10
    private static String generateRandomGenome() {
        String characters = "ATGC";
        StringBuilder genome = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            genome.append(characters.charAt(index));
        }
        return genome.toString();
    }

    // Generate genome sequences without using threads
    private static void generateWithoutThreads(int totalSequences) {
        long startTime = System.nanoTime();
        for (int i = 0; i < totalSequences; i++) {
            generateRandomGenome();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken without threads: " + (endTime - startTime) + " ns");
        WITHOUT_THREAD_TIME = endTime - startTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < GENOME_SEQUENCES_PER_THREAD; i++) {
            generateRandomGenome();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int totalSequences = GENOME_SEQUENCES_PER_THREAD * THREAD_COUNT;

        // Generating genome sequences without threads
        generateWithoutThreads(totalSequences);

        // Generating genome sequences with threads

        // Create required number of threads.
        Thread[] threads = new Thread[THREAD_COUNT];
        long startTime = System.nanoTime();

        // foreach thread
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new GenomeSequenceGeneratorThread());
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken with threads: " + (endTime - startTime) + " ns");
        WITH_THREAD_TIME = endTime - startTime;

        // Difference in time
        System.out.println("Difference in time: " + (WITHOUT_THREAD_TIME-WITH_THREAD_TIME) + "ns");
    }
}


