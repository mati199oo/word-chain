package wordchain.algorithm;

import org.junit.Test;
import wordchain.algorithm.WordListReader;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ja on 2017-08-14.
 */
public class WordListReaderTest {

    public static final String WORDLIST_FILE_PATH = "src\\test\\resources\\test_wordlist.txt";

    @Test
    public void testCreateWordList() {
        List<String> expectedWordList = new ArrayList<>();
        expectedWordList.add("dog");
        expectedWordList.add("fog");
        expectedWordList.add("for");
        expectedWordList.add("far");
        expectedWordList.add("car");

        WordListReader wordListReader = new WordListReader();
        List<String> actualWordList = wordListReader.createWordList(WORDLIST_FILE_PATH);

        assertEquals(expectedWordList, actualWordList);
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionOnWrongPathInCreateWordList() {
        WordListReader wordListReader = new WordListReader();
        String wordListPath = WORDLIST_FILE_PATH + "_error";
        wordListReader.createWordList(wordListPath);
    }

}