package DailyRiddles.Day1;
import java.util.*;
import java.util.stream.Collectors;

public class CaloriesManager {

    public ArrayList<Integer> createCalorieList(List<String> list) {
        ArrayList<Integer> integerList = new ArrayList<>();
        int totalCalories = 0;
        for (String s: list) {
            if (s.equals("")){
                integerList.add(totalCalories);
                totalCalories = 0;
            } else {
                totalCalories += Integer.parseInt(s);
            }
        }
        return integerList;
    }


    public int getHighestCaloriesDay1(ArrayList<Integer> listOfElves){
        return listOfElves.stream().max(Integer::compare).get();
    }


    public int getThreeHighestCaloriesDay2(ArrayList<Integer> listOfElves){
        int topThreeCalories = 0;
        ArrayList<Integer> currList = (ArrayList<Integer>) listOfElves.stream().sorted().collect(Collectors.toList());
        Collections.reverse(currList);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addAll(currList);
        for (int i = 0; i <= 2; i++){
            topThreeCalories += stack.getFirst();
            stack.pop();
        }
        return topThreeCalories;
    }
}
