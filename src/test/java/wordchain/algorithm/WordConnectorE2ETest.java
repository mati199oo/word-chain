package wordchain.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Ja on 2017-08-14.
 */
public class WordConnectorE2ETest {
    private static final String FULL_LIST = "src\\test\\resources\\test_wordliste2e.txt";
    private static final String TRIMMED_LIST = "src\\test\\resources\\test_wordliste2e_trimmed.txt";

    @Test
    public void testConnectSameLengthWords() {
        WordConnector wordConnector = new WordConnector(FULL_LIST, true);

        assertEquals(Arrays.asList("gold", "goad", "load", "lead"), wordConnector.connectWords("gold", "lead"));
        assertEquals(Arrays.asList("cat", "cay", "cry"), wordConnector.connectWords("cat", "cry"));
        assertEquals(Arrays.asList("boat", "beat", "bead", "lead"), wordConnector.connectWords("boat", "lead"));
        assertEquals(Arrays.asList("cloud", "clous", "clows", "crows", "brows", "brown"), wordConnector.connectWords("cloud", "brown"));
    }

    @Test
    public void testConnectVariedLengthWords() {
        WordConnector wordConnector = new WordConnector(TRIMMED_LIST, false);
        assertEquals(Arrays.asList("dog", "dogs", "fogs", "fors", "for", "far", "car"), wordConnector.connectWords("dog", "car"));
    }


}