package wordchain.algorithm;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ja on 2017-08-14.
 */
public class BFSProcessorTest {

    /**
     * The input graph:
     * A------B
     * \      |
     *  \     |
     *   D    |
     *  /     |
     * /      |
     * C------E
     */
    @Test
    public void testFindShortestPath() {
        Map<String, Set<String>> graph = new HashMap<>();
        graph.put("A", new HashSet<>(Arrays.asList("B", "D")));
        graph.put("B", new HashSet<>(Arrays.asList("A", "E")));
        graph.put("C", new HashSet<>(Arrays.asList("D", "E")));
        graph.put("D", new HashSet<>(Arrays.asList("A", "C")));
        graph.put("E", new HashSet<>(Arrays.asList("C", "B")));
        List<String> expectedPath = Arrays.asList("A", "B", "E");

        BFSProcessor bfsProcessor = new BFSProcessor(graph);
        List<String> actualPath = bfsProcessor.findShortestPath("A", "E");

        assertEquals(expectedPath, actualPath);
    }

}