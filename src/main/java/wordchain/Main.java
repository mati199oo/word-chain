package wordchain;

import wordchain.algorithm.WordConnector;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Ja on 2017-08-14.
 */
public class Main {

    private static final String DEFAULT_FILE = "wordlist.txt";
    private static final String NON_FILTER_PARAM = "non_filter";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first word.");
        String word1 = scanner.nextLine();
        System.out.println("Please enter second word.");
        String word2 = scanner.nextLine();

        Long startTime = System.currentTimeMillis();

        String wordListPath = DEFAULT_FILE;
        if (args.length > 0) {
            wordListPath = args[0];
        }
        boolean shouldFilterWordsByLength = args.length < 2 || !args[1].equals(NON_FILTER_PARAM);

        WordConnector wordConnector = new WordConnector(wordListPath, shouldFilterWordsByLength);

        List<String> path = wordConnector.connectWords(word1, word2);

        printResult(path, startTime);
    }

    private static void printResult(List<String> path, Long startTime) {
        System.out.println();
        if (!path.isEmpty()) {
            path.forEach(System.out::println);
        } else {
            System.out.println("No connection between given words");
        }
        System.out.println("\nExecuting time: ");
        System.out.println((System.currentTimeMillis() - startTime) + " ms");
    }

}