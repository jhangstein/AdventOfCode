package DailyRiddles.Day8;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TreeGrid {


    public int[][] treeGrid;
    public int visibleTrees = 0;
    public int invisibleTrees = 0;
    public int size;
    public int highestScenicScore = 1;


    public TreeGrid (int size) {
        this.size = size;
        treeGrid = new int[size][size];
    }


    public void parseFile() {
        Dotenv dotenv = Dotenv.load();
        String path = dotenv.get("FILE_PATH");
        File file = new File(path + "day8_input.txt");
        String st;
        int xIterator = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {

                char[] charArray = st.toCharArray();
                int yIterator = 0;
                for (char tree: charArray) {
                    treeGrid[xIterator][yIterator] = Integer.parseInt(String.valueOf(tree));
                    //System.out.print(treeGrid[xIterator][yIterator]);
                    yIterator++;
                }
                //System.out.println();
                xIterator++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getVisibleTrees() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                isVisible(x, y);
            }
        }
    }


    public void isVisible (int x, int y) {
        int treeHeight = treeGrid[x][y];
        if (x == 0 || x == (size-1) || y == 0 || y == (size-1)) {
            visibleTrees++;
            return;
        }
        if (!lookRight(x, y+1, treeHeight)) {
            if (!lookDown(x+1, y, treeHeight)) {
                if (!lookLeft(x, y-1, treeHeight)) {
                    if (!lookUp(x-1, y, treeHeight)) {
                        invisibleTrees++;
                        //System.out.println("Tree is invisible!");
                        return;
                    }
                }
            }
        }
        visibleTrees++;


    }


    public boolean lookRight (int x, int y, int treeHeight) {
        while (y < size) {
            if (treeGrid[x][y] >= treeHeight){
                return false;
            }
            y++;
        }
        return true;
    }


    public boolean lookDown (int x, int y, int treeHeight) {
        while (x < size) {
            if (treeGrid[x][y] >= treeHeight){
                return false;
            }
            x++;
        }
        return true;
    }


    public boolean lookLeft (int x, int y, int treeHeight) {
        while (y >= 0) {
            if (treeGrid[x][y] >= treeHeight){
                return false;
            }
            y--;
        }
        return true;
    }


    public boolean lookUp (int x, int y, int treeHeight) {
        while (x >= 0) {
            if (treeGrid[x][y] >= treeHeight){
                return false;
            }
            x--;
        }
        return true;
    }











    public void determineScenicScore() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int score = setScore(x, y);
                if (score > highestScenicScore){
                    highestScenicScore = score;
                }
            }
        }
    }



    public int setScore (int x, int y) {
        int treeHeight = treeGrid[x][y];
        // edge trees, always multiply by 0
        if (x == 0 || x == (size-1) || y == 0 || y == (size-1)) {
            return 0;
        }

        return scoreRight(x, y+1, treeHeight) *
                scoreDown(x+1, y, treeHeight) *
                scoreLeft(x, y-1, treeHeight) *
                scoreUp(x-1, y, treeHeight);
    }





    public int scoreRight (int x, int y, int treeHeight) {
        int result = 0;
        while (y < size) {
            if (treeGrid[x][y] < treeHeight){
                result++;
            } else if (treeGrid[x][y] >= treeHeight){
                result++;
                return result;
            }
            y++;
        }
        return result;
    }


    public int scoreDown (int x, int y, int treeHeight) {
        int result = 0;
        while (x < size) {
            if (treeGrid[x][y] < treeHeight){
                result++;
            } else if (treeGrid[x][y] >= treeHeight){
                result++;
                return result;
            }
            x++;
        }
        return result;
    }


    public int scoreLeft (int x, int y, int treeHeight) {
        int result = 0;
        while (y >= 0) {
            if (treeGrid[x][y] < treeHeight){
                result++;
            } else if (treeGrid[x][y] >= treeHeight){
                result++;
                return result;
            }
            y--;
        }
        return result;
    }


    public int scoreUp (int x, int y, int treeHeight) {
        int result = 0;
        while (x >= 0) {
            if (treeGrid[x][y] < treeHeight){
                result++;
            } else if (treeGrid[x][y] >= treeHeight){
                result++;
                return result;
            }
            x--;
        }
        return result;
    }


}
