package wordchain.algorithm;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ja on 2017-08-16.
 */
public class WordConnector {

    private final static Logger logger = Logger.getLogger(WordConnector.class);

    private String wordListPath;
    private boolean shouldFilterWordsByLength;
    private WordListReader wordListReader = new WordListReader();
    private GraphBuilder graphBuilder = new GraphBuilder();

    public WordConnector(String wordListPath, boolean shouldFilterWordsByLength) {
        this.wordListPath = wordListPath;
        this.shouldFilterWordsByLength = shouldFilterWordsByLength;
    }

    public List<String> connectWords(String word1, String word2) {
        List<String> wordList = wordListReader.createWordList(wordListPath);

        if (!wordList.contains(word1) || !wordList.contains(word2)) {
            logger.error("One or both of given words does not exist in wordlist.");
            return Collections.emptyList();
        }

        if (shouldFilterWordsByLength) {
            wordList = filterWordListByLength(wordList, word1.length());
        }

        BFSProcessor bfsProcessor = new BFSProcessor(graphBuilder.buildGraph(wordList));
        return bfsProcessor.findShortestPath(word1, word2);
    }

    private List<String> filterWordListByLength(List<String> wordList, int length) {
        return wordList.stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toList());
    }

}
