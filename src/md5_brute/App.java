package md5_brute;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class App {
    private static long start = System.currentTimeMillis();
    private static long mainStart = System.currentTimeMillis();
    //private final static char[] CH = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    //private final static char[] CH = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    // private final static char[] CH = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final static char[] CH = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!№;%:?*()_-+=~`.,/".toCharArray();
    //private final static char[] CH = "abcdefghijklmnopqrstuvwxyz0123456789!№;%:?*()_-+=~`.,/".toCharArray();
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static long count = 0;
    private static final long PRINT_PERIOD = 10_000_000;
    private static int minLength = 1;
    private static int maxLength = 14;
    private static long size = estimateCombinations(maxLength);
    private static ArrayBlockingQueue<String> generatedWords = new ArrayBlockingQueue<>(NUMBER_OF_CORES * 8_000_000);
    public static AtomicBoolean isRunning = new AtomicBoolean(true);
    public static AtomicBoolean isProduced = new AtomicBoolean(false);
    public static AtomicBoolean noResults = new AtomicBoolean(false);
    public static ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
    public static ExecutorService consumerExecutorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //String md5 = "f016441d00c16c9b912d05e9d81d894d";
        //String md5 = "5ebe2294ecd0e0f08eab7690d2a6ee69";
        //String md5 = "13d70e09909669272b19647c2a55dacb";
        String md5 = "5f50dfa5385e66ce46ad8d08a9c9be68";
        System.out.println("Number of possible combinations: " + size);

        Runnable producer = () -> {
            System.out.println("Producer: " + Thread.currentThread().getName());
            generateWords(CH, minLength, maxLength, generatedWords);
            isProduced.set(true);
            Thread.currentThread().interrupt();
        };
        producerExecutorService.execute(producer);

        for (int i = 0; i < (NUMBER_OF_CORES * 8); i++) {
            consumerExecutorService.execute(() -> {
                String testWord = null;
                String result = null;
                while (isRunning.get()) {
                    try {
                        testWord = generatedWords.take();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    result = hash(testWord);

                    if (result.equals(md5)) {
                        long totalTime = System.currentTimeMillis() - mainStart;
                        System.out.println("Consumer: " + Thread.currentThread().getName() +
                                "; Result found in: " + totalTime + " ms. Password is: " + testWord + ", hash: " + result);
                        isRunning.set(false);
                        producerExecutorService.shutdownNow();
                        consumerExecutorService.shutdownNow();

                    } else if (isProduced.get() && generatedWords.isEmpty() && !noResults.get()) {
                        isRunning.set(false);
                        noResults.set(true);
                        System.out.println("Consumer: " + Thread.currentThread().getName() + ": no matches.");
                        producerExecutorService.shutdownNow();
                        consumerExecutorService.shutdownNow();
                    }

                }

            });

        }

        producerExecutorService.shutdown();
        try {
            producerExecutorService.awaitTermination(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumerExecutorService.shutdown();
        try {
            consumerExecutorService.awaitTermination(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void generateWords(char[] input, int minLength, int maxLength, ArrayBlockingQueue<String> queue) {

        char[] result = new char[input.length];
        int[] index = new int[maxLength];
        Arrays.fill(result, 0, result.length, input[0]);
        Arrays.fill(index, 0, index.length, 0);

        for (int length = minLength; length <= maxLength; length++) {
            int updateIndex = 0;
            do {

                try {
                    queue.put(new String(result, 0, length));
                    printStatus();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                for (updateIndex = (length - 1); (updateIndex != -1) && ++index[updateIndex] == input.length;
                     result[updateIndex] = input[0], index[updateIndex] = 0, updateIndex--)
                    ;
                if (updateIndex != -1) result[updateIndex] = input[index[updateIndex]];
            }
            while (updateIndex != -1);
        }

    }


    private static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder();
            hashText.append(number.toString(16));
            while (hashText.length() < 32)
                hashText.append("0");
            return hashText.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printStatus() {
        count++;
        if (count % PRINT_PERIOD == 0) {
            long duration = System.currentTimeMillis() - start;
            long speed = (PRINT_PERIOD / duration) * 1000;
            long remainingDays = size / speed / 3600 / 24;

            System.out.println(count + " items processed in "
                    + duration + " ms. Speed: "
                    + speed + " p/s. Est. time remaining "
                    + remainingDays + " days");
            start = System.currentTimeMillis();
            System.out.println("current queue size: " + generatedWords.size());
        }
    }

    private static long estimateCombinations(int length) {
        long result = 0;
        for (int i = minLength; i <= length; i++)
            result += Math.pow(CH.length, i);
        return result;
    }

}



