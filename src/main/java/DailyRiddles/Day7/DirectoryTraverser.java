package DailyRiddles.Day7;

import java.util.ArrayList;

public class DirectoryTraverser {
    final int DISK_SIZE = 70000000;
    final int UPDATE_SIZE = 30000000;
    final int USED_SPACE = 48518336;
    public final int NEEDED_SPACE = USED_SPACE - (DISK_SIZE - UPDATE_SIZE);

    public int result = 0;
    ArrayList<Integer> eligibleForDelete = new ArrayList<>();
    public Node root = new Node("/", null);


    public void traverseList(ArrayList<String> terminalOutput) {
        Node currentParent = root;

        for (String line : terminalOutput) {

            if (line.startsWith("$ ls") || line.startsWith("$ cd /")){
                continue;
            }
            // append children
            if (!line.startsWith("$ cd")) {
                if (line.startsWith("dir")) {
                    currentParent.addChild(new Node(line.replace("dir ", ""), currentParent));
                } else {
                    int fileSize = Integer.parseInt(line.split("\\s+", 2)[0]);
                    String fileName = line.split("\\s+", 2)[1];
                    currentParent.addChild(new Node(fileSize, fileName, currentParent));
                    continue;
                }
                continue;
            }

            // step back one level
            if (line.contains("..")) {
                currentParent = currentParent.getParent();
                continue;
            }

            // enter sub directory
            for (Node child : currentParent.getChildren()) {
                String dirName = line.replace("$ cd ", "");
                if (child.getPath().equals(dirName)) {
                    currentParent = child;
                }
            }
        }


    }


    public int findBestDirectoryToDelete() {
        return eligibleForDelete.stream().min(Integer::compare).get();
    }


    public int getValueOfNode(Node node) {
        int total = 0;
        // break condition
        if (node.getChildren().isEmpty()) {
            return node.getValue();
        }
        for (Node n : node.getChildren()) {
            total += getValueOfNode(n);
        }
        total += node.getValue();
        // System.out.println("The value of the node " + node.getPath() + " is " + total);
        if (total <= 100000) {
            result += total;
        }
        if (total >= NEEDED_SPACE){
            eligibleForDelete.add(total);
        }
        return total;
    }
}
