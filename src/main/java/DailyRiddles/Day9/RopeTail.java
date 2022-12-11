package DailyRiddles.Day9;

public class RopeTail {
    public int x;
    public int y;

    public String[][] grid = new String[6][6];

    public RopeTail(int x, int y) {
        this.x = x;
        this.y = y;

        init();

    }

    private void init() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                this.grid[i][j] = ".";
            }
        }
    }


    public void printGrid () {
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print(this.grid[i][j]);
            }
        }
        System.out.println();
        System.out.println("--------------------");
        System.out.println();
    }

    public void evaluatePosition(RopeHead ropeHead) {
        // zu weit unten
        if (ropeHead.x - this.x > 1) {
            grid[x][y] = "#";
            this.x += 1;
        }
        // zu weit oben
        else if (this.x - ropeHead.x > 1) {
            grid[x][y] = "#";
            this.x -= 1;
        }
        // zu weit rechts
        else if (this.y - ropeHead.y > 1) {
            grid[x][y] = "#";
             this.y -= 1;
        }
        // zu weit links
        else if (ropeHead.y - this.y > 1) {
            grid[x][y] = "#";
            this.y += 1;
        }
    }
}
