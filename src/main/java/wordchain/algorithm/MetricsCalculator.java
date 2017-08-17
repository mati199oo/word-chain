package wordchain.algorithm;

/**
 * Created by Ja on 2017-08-14.
 */
public class MetricsCalculator {

    public static boolean areWordsAdjacent(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        if (word1Length == word2Length) {
            return checkEqualLengthWords(word1, word2);
        }
        if (Math.abs(word1Length - word2Length) == 1) {
            return word1Length < word2Length ? checkNonEqualLengthWords(word1, word2) : checkNonEqualLengthWords(word2, word1);
        }
        return false;
    }

    private static boolean checkEqualLengthWords(String word1, String word2) {
        int mistakesCounter = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                mistakesCounter++;
            }
        }
        return mistakesCounter == 1;
    }

    private static boolean checkNonEqualLengthWords(String shorter, String longer) {
        int mistakesCounter = 0;
        int i = 0;
        while (i < shorter.length()) {
            if (shorter.charAt(i) != longer.charAt(i + mistakesCounter)) {
                mistakesCounter++;
            } else {
                i++;
            }
            if (mistakesCounter == 2) {
                return false;
            }
        }
        return true;
    }

}