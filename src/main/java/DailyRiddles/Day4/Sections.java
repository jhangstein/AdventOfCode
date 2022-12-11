package DailyRiddles.Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sections {

    public ArrayList<String[]> splitInput (ArrayList<String> input) {
        ArrayList<String[]> assignments = new ArrayList<>();

        for (String s: input) {
            String[] split = s.split(",");
            assignments.add(split);
        }
        return assignments;
    }

    public int compare(ArrayList<String[]> assignments) {
        int redundantAssignments = 0;
        for (String[] array: assignments){
            String[] firstElf = array[0].split("-");
            String[] secondElf = array[1].split("-");

            if (Integer.parseInt(firstElf[0]) >= Integer.parseInt(secondElf[0]) && Integer.parseInt(firstElf[1]) <= Integer.parseInt(secondElf[1])) {
                // System.out.println(array[0] + " is contained in " + array[1]);
                redundantAssignments++;
            } else if (Integer.parseInt(secondElf[0]) >= Integer.parseInt(firstElf[0]) && Integer.parseInt(secondElf[1]) <= Integer.parseInt(firstElf[1])){
                // System.out.println("Other way around! " + array[1] + " is contained in " + array[0]);
                redundantAssignments++;
            }
        }
        return redundantAssignments;
    }


    public int getOverlaps(ArrayList<String[]> assignments) {
        int overlaps = 0;
        for (String[] array: assignments){
            String[] firstElf = array[0].split("-");
            String[] secondElf = array[1].split("-");

            if (Integer.parseInt(firstElf[1]) >= Integer.parseInt(secondElf[0]) && Integer.parseInt(firstElf[1]) <= Integer.parseInt(secondElf[1])) {
                // System.out.println(array[0] + " overlaps with " + array[1] + " on the upper boundary!");
                overlaps++;
            } else if (Integer.parseInt(secondElf[1]) >= Integer.parseInt(firstElf[0]) && Integer.parseInt(secondElf[1]) <= Integer.parseInt(firstElf[1])){
                // System.out.println("Other way around! " + array[1] + " overlaps with " + array[0] + " on the upper boundary!");
                overlaps++;
            }
        }
        return overlaps;
    }
}
