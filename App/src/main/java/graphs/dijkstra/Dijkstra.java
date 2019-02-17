package graphs.dijkstra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class Dijkstra {

    private static Map<Character, Node> idToNode = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/main/resources/dijkstra-graph"));
        Map<Character, Map<Character, Integer>> costs = new HashMap<>();

        lines.forEach(line -> {
            String[] tokens = line.split("-");
            char parent = tokens[0].charAt(0);
            char nextNode = tokens[1].charAt(0);
            int cost = Integer.valueOf(tokens[2]);

            Map<Character, Integer> childToCost = costs.get(parent);
            if (childToCost != null) {
                if (!childToCost.containsKey(nextNode)) {
                    childToCost.put(nextNode, cost);
                }
            } else {
                childToCost = new HashMap<>();
                childToCost.put(nextNode, cost);
                costs.put(parent, childToCost);
            }
        });

        costs.forEach((parentNodeId, childToCost) -> {
            Node parentNode = idToNode.get(parentNodeId);
            if(parentNode == null) {
                parentNode = new Node(parentNodeId);
                idToNode.put(parentNodeId, parentNode);
            }
            for(Map.Entry<Character, Integer> entry : childToCost.entrySet()) {
                Node childNode = idToNode.get(entry.getKey());
                if(childNode == null) {
                    childNode = new Node(entry.getKey());
                    idToNode.put(entry.getKey(), childNode);
                }
                parentNode.addChild(childNode);
            }
        });

        Node root = idToNode.get('R');
        root.setLowestCost(0);

        dijkstra(root, costs);



        System.out.println("ASD");
    }

    private static void dijkstra(Node root, Map<Character, Map<Character, Integer>> costs ) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node parentNode = nodeQueue.remove();
            for(Node childNode : parentNode.getNextNodes()) {
                int overallCost = parentNode.getLowestCost() + extractCost(costs, parentNode.getId(), childNode.getId());
                if(overallCost < childNode.getLowestCost()) {
                    childNode.setLowestCost(overallCost);
                    childNode.setLowestCostParent(parentNode);
                }
                nodeQueue.add(childNode);
            }
        }

        Node end = idToNode.get('E');

        while (!end.getId().equals('R')) {
            System.out.println(end.getId());
            end = end.getLowestCostParent();
        }
        System.out.println("R");

    }

    private static int extractCost(Map<Character, Map<Character, Integer>> costs, Character parentId, Character childId) {
        return costs.get(parentId).get(childId);
    }

}
