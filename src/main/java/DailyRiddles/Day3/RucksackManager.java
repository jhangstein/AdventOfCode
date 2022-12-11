package DailyRiddles.Day3;
import java.util.ArrayList;

public class RucksackManager {

    public ArrayList<Rucksack> createListOfRucksacks (ArrayList<String> list) {
        ArrayList<Rucksack> rucksacks = new ArrayList<>();

        for (String s: list) {
            Rucksack rucksack = new Rucksack(s);
            rucksacks.add(rucksack);
        }
        return rucksacks;
    }


    public int getTotalValueOfPriorities(ArrayList<Rucksack> listOfRucksacks){
        int totalValue = 0;
        for (Rucksack rucksack: listOfRucksacks) {
            rucksack.splitContents();
            rucksack.findCommonItem();
            rucksack.determinePriority();
            totalValue += rucksack.priority;
        }
        return totalValue;
    }

    public int getTotalValueOfBadges(ArrayList<Rucksack> listOfRucksacks) {
        int totalValue = 0;
        for (int i = 2; i < listOfRucksacks.size(); i += 3) {
            int singleValue = listOfRucksacks.get(i).badgePriority;
            totalValue += singleValue;
        }
        return totalValue;
    }

    public void setBadgeValue(ArrayList<Rucksack> listOfRucksacks){
        for (int i = 2; i < listOfRucksacks.size(); i += 3) {
            Rucksack rucksack1 = listOfRucksacks.get(i);
            Rucksack rucksack2 = listOfRucksacks.get(i-1);
            Rucksack rucksack3 = listOfRucksacks.get(i-2);
            ArrayList<Character> commons = new ArrayList<>();

            // Compare 1 and 2
            for (int j = 0; j < rucksack1.contents.length(); j++){
                char letterContent1 = rucksack1.contents.charAt(j);
                for (int k = 0; k < rucksack2.contents.length(); k++){
                    char letterContent2 = rucksack2.contents.charAt(k);
                    if (letterContent2 == letterContent1){
                        commons.add(letterContent2);
                        break;
                    }
                }
            }

            //Compare commons with 3
            for (int j = 0; j < rucksack3.contents.length(); j++) {
                char letterContent = rucksack3.contents.charAt(j);
                if (commons.contains(letterContent)) {
                    rucksack1.badge = letterContent;
                    rucksack1.determineBadgePriority();
                    rucksack2.badge = letterContent;
                    rucksack2.determineBadgePriority();
                    rucksack3.badge = letterContent;
                    rucksack3.determineBadgePriority();
                    //System.out.println("Common Badge at list position " + i + ": " + letterContent);
                    break;
                }
            }
        }
    }



}