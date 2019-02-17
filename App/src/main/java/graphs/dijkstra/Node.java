package graphs.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private List<Node> nextNodes;
    private int lowestCost;
    private Node lowestCostParent;
    private Character id;

    Node(Character id) {
        this.id = id;
        this.lowestCost = Integer.MAX_VALUE;
        this.lowestCostParent = null;
        this.nextNodes = new ArrayList<>();
    }

    void addChild(Node node) {
        this.nextNodes.add(node);
    }

    void setLowestCost(int lowestCost) {
        this.lowestCost = lowestCost;
    }

    void setLowestCostParent(Node lowestCostParent) {
        this.lowestCostParent = lowestCostParent;
    }

    List<Node> getNextNodes() {
        return nextNodes;
    }

    int getLowestCost() {
        return lowestCost;
    }

    Node getLowestCostParent() {
        return lowestCostParent;
    }

    Character getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
