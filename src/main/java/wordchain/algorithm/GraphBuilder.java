package wordchain.algorithm;

import java.util.*;

/**
 * Created by Ja on 2017-08-14.
 */
public class GraphBuilder {

    private Map<String, Set<String>> graph;

    public Map<String, Set<String>> buildGraph(List<String> wordList) {
        graph = new HashMap<>();
        int wordListSize = wordList.size();
        for (int i = 0; i < wordListSize - 1; i++) {
            for (int j = i + 1; j < wordListSize; j++) {
                addAdjacentWords(wordList, i, j);
            }
        }
        return graph;
    }

    private void addAdjacentWords(List<String> wordList, int i, int j) {
        String word1 = wordList.get(i);
        String word2 = wordList.get(j);
        if (MetricsCalculator.areWordsAdjacent(word1, word2)) {
            addWordToGraph(word1, word2);
            addWordToGraph(word2, word1);
        }
    }

    private void addWordToGraph(String word1, String word2) {
        if (!graph.containsKey(word1)) {
            graph.put(word1, new HashSet<>());
        }
        graph.get(word1).add(word2);
    }

}