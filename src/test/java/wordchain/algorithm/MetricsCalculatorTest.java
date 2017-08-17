package wordchain.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ja on 2017-08-14.
 */
public class MetricsCalculatorTest {

    @Test
    public void testEqualLengthWordsAdjacency() {
        String word1 = "dog";
        String word2 = "fog";
        assertTrue(MetricsCalculator.areWordsAdjacent(word1, word2));
    }

    @Test
    public void testEqualLengthWordsNonAdjacency() {
        String word1 = "dog";
        String word2 = "for";
        assertFalse(MetricsCalculator.areWordsAdjacent(word1, word2));
    }

    @Test
    public void testNonEqualLengthWordsAdjacency() {
        String word1 = "cat";
        String word2 = "cats";
        assertTrue(MetricsCalculator.areWordsAdjacent(word1, word2));
    }

    @Test
    public void testNonEqualLengthWordsNonAdjacency() {
        String word1 = "cat";
        String word2 = "cars";
        assertFalse(MetricsCalculator.areWordsAdjacent(word1, word2));
    }

    @Test
    public void testEqualWordsNonAdjacency() {
        String word1 = "cat";
        String word2 = "cat";
        assertFalse(MetricsCalculator.areWordsAdjacent(word1, word2));
    }

}