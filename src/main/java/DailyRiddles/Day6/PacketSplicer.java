package DailyRiddles.Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class PacketSplicer {
    public String transformFileToString(){
        File file = new File("C:\\Users\\josep\\IdeaProjects\\AdventOfCode\\src\\day6_input.txt");
        String st;
        String transmission = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null){
                transmission = st;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return transmission;
    }


    public void findStartOfTransmission(String transmission, int markerLength){
        for (int i = markerLength-1; i < transmission.length(); i++) {
            HashSet<Character> check = new HashSet<>();
            for (int j = i; j >= i-(markerLength-1); j--){
                char c = transmission.charAt(j);
                check.add(c);
                if (check.size() == markerLength){
                    System.out.println("The message starts at " + (i+1));
                    return;
                }
            }
        }
    }
}