package DailyRiddles.Day9;

import java.util.ArrayList;

public class RopeCalculator {

    String[][] grid = new String[6][6];
    public RopeHead ropeHead = new RopeHead(5, 0);
    public RopeTail ropeTail = new RopeTail(5, 0);


    public void init() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ".";
            }
        }
    }

    //ToDo: wenn zweimal up, dann tail auf den selben y setzen

    public void movementLoop(ArrayList<String> movement) {
        System.out.println("length: " + movement.size());
        for (String movementStatement: movement) {
            calculatePositionUpdate(movementStatement);
        }
    }


    public void calculatePositionUpdate(String movement) {
        String direction = movement.split("\\s+")[0];
        int length = Integer.parseInt(movement.split("\\s+")[1]);

        switch (direction) {
            case "R" -> {
                for (int i = length; i > 0; i--) {
                    ropeHead.move(ropeHead.x, ropeHead.y+1);
                    ropeTail.evaluatePosition(ropeHead);
                    updateGrid();
                    printGrid();
                    // add thing to remember that it moved right last time
                }
            }
            case "U" -> {
                for (int i = length; i > 0; i--) {
                    ropeHead.move(ropeHead.x-1, ropeHead.y);
                    ropeTail.evaluatePosition(ropeHead);
                    updateGrid();
                    printGrid();
                }
            }
            case "L" -> {
                for (int i = length; i > 0; i--) {
                    ropeHead.move(ropeHead.x, ropeHead.y-1);
                    ropeTail.evaluatePosition(ropeHead);
                    updateGrid();
                    printGrid();
                }
            }
            case "D" -> {
                for (int i = length; i > 0; i--) {
                    ropeHead.move(ropeHead.x+1, ropeHead.y);
                    ropeTail.evaluatePosition(ropeHead);
                    updateGrid();
                    printGrid();
                }
            }
        }
    }

    public void updateGrid() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ropeTail.grid[i][j];
            }
        }

        grid[ropeTail.x][ropeTail.y] = "T";
        grid[ropeHead.x][ropeHead.y] = "H";
    }


    public void printGrid () {
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print(grid[i][j]);
            }
        }
        System.out.println();
        System.out.println("--------------------");
        System.out.println();
    }




}
