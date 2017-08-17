package wordchain.algorithm;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ja on 2017-08-14.
 */
public class WordListReader {

    private final static Logger logger = Logger.getLogger(WordListReader.class);

    public List<String> createWordList(String wordListPath) {
        try {
            return readWordListFromFile(wordListPath);
        } catch (IOException e) {
            logger.error("Could not read file with given path.\n", e);
            throw new RuntimeException(e);
        }
    }

    private List<String> readWordListFromFile(String wordListPath) throws IOException {
        List<String> wordList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(wordListPath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordList.add(line);
        }
        return wordList;
    }

}