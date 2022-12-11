import DailyRiddles.Day1.CaloriesManager;
import DailyRiddles.Day10.CPU;
import DailyRiddles.Day2.Day2RPS;
import DailyRiddles.Day3.Rucksack;
import DailyRiddles.Day3.RucksackManager;
import DailyRiddles.Day4.Sections;
import DailyRiddles.Day5.Crates;
import DailyRiddles.Day6.PacketSplicer;
import DailyRiddles.Day7.DirectoryTraverser;
import DailyRiddles.Day8.TreeGrid;
import DailyRiddles.Day9.RopeCalculator;
import utils.ParseManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseManager pm = new ParseManager();


        System.out.println("\n------------ Day 1 ------------\n");
        CaloriesManager cm = new CaloriesManager();
        ArrayList<String> list = pm.transformFileToListOfStrings("day1_input.txt");
        ArrayList<Integer> intList = cm.createCalorieList(list);
        System.out.println("Top Calories: " + cm.getHighestCaloriesDay1(intList));
        System.out.println("Top three calories: " + cm.getThreeHighestCaloriesDay2(intList));


        System.out.println("\n------------ Day 2 ------------\n");
        Day2RPS rps = new Day2RPS();
        ArrayList<String> listDay2 = pm.transformFileToListOfStrings("day2_input.txt");
        System.out.println("Score according to own theme: " + rps.calculateTotalScorePart1(listDay2));
        System.out.println("Score according to actual theme: " + rps.calculateTotalScorePart2(listDay2));


        System.out.println("\n------------ Day 3 ------------\n");
         RucksackManager rsm = new RucksackManager();
        ArrayList<String> inputDay3 = pm.transformFileToListOfStrings("day3_input.txt");
        ArrayList<Rucksack> rucksacks = rsm.createListOfRucksacks(inputDay3);
        System.out.println("Value of Priorities: " + rsm.getTotalValueOfPriorities(rucksacks));
        rsm.setBadgeValue(rucksacks);
        System.out.println("Value of badges: " + rsm.getTotalValueOfBadges(rucksacks));


        System.out.println("\n------------ Day 4 ------------\n");
        Sections sections = new Sections();
        ArrayList<String> input = pm.transformFileToListOfStrings("day4_input.txt");
        ArrayList<String[]> listDay3 = sections.splitInput(input);
        System.out.println(sections.compare(listDay3) + " assignments are fully contained.");
        System.out.println(sections.getOverlaps(listDay3) + " assignments overlap.");


        System.out.println("\n------------ Day 5 ------------\n");
        Crates crates = new Crates();
        ArrayList<String> inputDay5 = pm.transformFileToListOfStrings("day5_input.txt");
        ArrayList<int[]> listDay5 = crates.parseInput(inputDay5);
        crates.initStacks();
        crates.doMoves(listDay5);
        System.out.println();
        crates.doMoves9001(listDay5);
        System.out.println();


        System.out.println("\n------------ Day 6 ------------\n");
        PacketSplicer ps = new PacketSplicer();
        String transmission = pm.transformFileToListOfStrings("day6_input.txt").get(0);
        ps.findStartOfTransmission("Part 2: " + transmission, 14); // Part 2


        System.out.println("\n------------ Day 7 ------------\n");
        DirectoryTraverser dt = new DirectoryTraverser();
        ArrayList<String> listDay7 = pm.transformFileToListOfStrings("day7_input.txt");
        dt.traverseList(listDay7);
        dt.getValueOfNode(dt.root);
        System.out.println("Total size of directories with size <=100,000: " + dt.result);
        System.out.println("The best item to delete has the size " + dt.findBestDirectoryToDelete() + ".");
        System.out.println("The size needed is " + dt.NEEDED_SPACE + ", and the deleted directory leaves " + (dt.findBestDirectoryToDelete() - dt.NEEDED_SPACE) + " empty space after update.");


        System.out.println("\n------------ Day 8 ------------\n");
        TreeGrid treeGrid = new TreeGrid(99);
        treeGrid.parseFile();

        // Part1
        treeGrid.getVisibleTrees();
        System.out.println("Visible trees: " + treeGrid.visibleTrees);
        System.out.println("Invisible trees: " + treeGrid.invisibleTrees);

        // Part 2
        treeGrid.determineScenicScore();
        System.out.println("Highest scenic score: " + treeGrid.highestScenicScore);


        /*System.out.println("\n------------ Day 9 ------------\n");
        RopeCalculator ropeCalculator = new RopeCalculator();
        ArrayList<String> movement = pm.transformFileToListOfStrings("day9_input.txt");
        ropeCalculator.init();
        ropeCalculator.movementLoop(movement);
        System.out.println("Here comes the tail grid:");
        ropeCalculator.ropeTail.printGrid();*/


        System.out.println("\n------------ Day 8 ------------\n");
        CPU cpu = new CPU();
        cpu.readInput();
    }
}