package DailyRiddles.Day5;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crates {
    ArrayList<Deque<String>> stacks = new ArrayList<>();
    Deque<String> stack1 = new ArrayDeque<>();
    Deque<String> stack2 = new ArrayDeque<>();
    Deque<String> stack3 = new ArrayDeque<>();
    Deque<String> stack4 = new ArrayDeque<>();
    Deque<String> stack5 = new ArrayDeque<>();
    Deque<String> stack6 = new ArrayDeque<>();
    Deque<String> stack7 = new ArrayDeque<>();
    Deque<String> stack8 = new ArrayDeque<>();
    Deque<String> stack9 = new ArrayDeque<>();

    public ArrayList<int[]> parseInput (ArrayList<String> list) {
        ArrayList<int[]> input = new ArrayList<>();
        for (String s: list) {
            int[] toAdd = new int[3];
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(s);
            for (int i = 0; i <= 2; i++){
                m.find();
                toAdd[i] = Integer.parseInt(m.group());
            }
            input.add(toAdd);
        }
        return input;
    }


    public void initStacks() {
        stack1.addAll(List.of(new String[]{"N", "Q", "L", "S", "C", "Z", "P", "T"}));
        stack2.addAll(List.of(new String[]{"G", "C", "H", "V", "T", "P", "L"}));
        stack3.addAll(List.of(new String[]{"F", "Z", "C", "D"}));
        stack4.addAll(List.of(new String[]{"C", "V", "M", "L", "D", "T", "W", "G"}));
        stack5.addAll(List.of(new String[]{"C", "W", "P"}));
        stack6.addAll(List.of(new String[]{"Z", "S", "T", "C", "D", "J", "F", "P"}));
        stack7.addAll(List.of(new String[]{"D", "B", "G", "W", "V"}));
        stack8.addAll(List.of(new String[]{"W", "H", "Q", "S", "J", "N"}));
        stack9.addAll(List.of(new String[]{"V", "L", "S", "F", "Q", "C", "R"}));
        stacks.addAll(List.of(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9));
    }

    public void doMoves(ArrayList<int[]> actions) {
        for (int[] values: actions) {
            int count = values[0];
            int origin = values [1] - 1;
            int destination = values[2] - 1;

            for (int i = count; i > 0; i--) {
                if (!stacks.get(origin).isEmpty()){
                    String crate = stacks.get(origin).pop();
                    stacks.get(destination).push(crate);
                }
            }

            }
        System.out.print("Crates on top: ");
        for (Deque<String> stack: stacks) {
            System.out.print(stack.peek());
        }
    }


    public void doMoves9001(ArrayList<int[]> actions) {
        for (int[] values: actions) {
            int count = values[0];
            int origin = values [1] - 1;
            int destination = values[2] - 1;
            ArrayList<String> pickedUpCrates = new ArrayList<>();

            for (int i = count; i > 0; i--) {
                if (!stacks.get(origin).isEmpty()){
                    String crate = stacks.get(origin).pop();
                    pickedUpCrates.add(crate);
                }
            }
            Collections.reverse(pickedUpCrates);
            for (String crate: pickedUpCrates){
                stacks.get(destination).push(crate);
            }


        }
        System.out.print("Crates on top with 9001: ");
        for (Deque<String> stack: stacks) {
            System.out.print(stack.peek());
        }
    }
}