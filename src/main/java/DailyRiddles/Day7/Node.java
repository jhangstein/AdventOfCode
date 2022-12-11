package DailyRiddles.Day7;

import java.util.ArrayList;

public class Node {
    private String path;
    private int value;
    private final ArrayList<Node> children;

    private Node parent;


    public Node(int value, String name, Node parent) {
        this.path = name;
        this.value = value;
        this.children = new ArrayList<>();
        this.parent = parent;
    }

    public Node(String name, Node parent) {
        this.path = name;
        this.value = 0;
        this.children = new ArrayList<>();
        this.parent = parent;
    }


    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }


    public int getValue() {
        return this.value;
    }

    public String getPath() {
        return path;
    }


    public Node getParent() {
        return parent;
    }
}
