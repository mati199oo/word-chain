package wordchain.algorithm;

import org.junit.Test;
import wordchain.algorithm.GraphBuilder;

import java.util.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ja on 2017-08-14.
 */
public class GraphBuilderTest {

    @Test
    public void testBuildGraph() {
        Map<String, Set<String>> expectedGraph = new HashMap<>();
        expectedGraph.put("dog", new HashSet<>(Collections.singletonList("fog")));
        expectedGraph.put("fog", new HashSet<>(Arrays.asList("dog", "for")));
        expectedGraph.put("for", new HashSet<>(Arrays.asList("fog", "far")));
        expectedGraph.put("far", new HashSet<>(Arrays.asList("for", "car")));
        expectedGraph.put("car", new HashSet<>(Collections.singletonList("far")));

        GraphBuilder graphBuilder = new GraphBuilder();
        List<String> wordList = Arrays.asList("dog", "fog", "for", "far", "car");
        Map<String, Set<String>> actualGraph = graphBuilder.buildGraph(wordList);

        assertEquals(expectedGraph, actualGraph);
    }

}