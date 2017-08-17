package wordchain.algorithm;

import java.util.*;

/**
 * Created by Ja on 2017-08-14.
 */
public class BFSProcessor {

    private Map<String, Set<String>> graph;
    private Queue<List<String>> queue = new LinkedList<>();
    private Set<String> visitedNodes = new HashSet<>();

    public BFSProcessor(Map<String, Set<String>> graph) {
        this.graph = graph;
    }

    public List<String> findShortestPath(String start, String end) {
        queue = new LinkedList<>();
        visitedNodes = new HashSet<>();
        addNewPathToQueue(new LinkedList<>(), start);
        List<String> path;
        while (!queue.isEmpty()) {
            path = queue.remove();
            String node = path.get(path.size() - 1);
            if (node.equals(end)) {
                return path;
            }
            visitedNodes.add(node);
            addNewPathsToQueue(path, node);
        }
        return new LinkedList<>();
    }

    private void addNewPathsToQueue(List<String> path, String node) {
        for (String adjacent : graph.get(node)) {
            if (!visitedNodes.contains(adjacent)) {
                addNewPathToQueue(path, adjacent);
            }
        }
    }

    private void addNewPathToQueue(List<String> path, String adjacent) {
        List<String> newPath = new LinkedList<>(path);
        newPath.add(adjacent);
        queue.add(newPath);
    }

}