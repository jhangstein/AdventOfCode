package DailyRiddles.Day10;

import utils.ParseManager;

import java.util.ArrayList;

public class CPU {

    private int registerValue = 1;

    private int cycleCount = 0;

    private int signalStrength = 0;

    ParseManager pm = new ParseManager();
    private final ArrayList<String> inputList = pm.transformFileToListOfStrings("day10_input.txt");

    public void noOperation() {
        increaseCounter();
    }

    public void addToRegister(int numberToAdd) {
        increaseCounter();
        increaseCounter();
        registerValue += numberToAdd;
    }


    public void increaseCounter() {
        cycleCount++;
        if ((cycleCount + 20) % 40 == 0) {
            signalStrength += cycleCount * registerValue;
            System.out.println("Cycle " + cycleCount + ": Value in register is " + registerValue + ". Signal strength: " + (cycleCount * registerValue));
        }
    }


    public void readInput() {
        for (String line: inputList) {
            if (line.startsWith("noop")) {
                noOperation();
            } else {
                int valueToAdd = Integer.parseInt(line.split("\\s+")[1]);
                addToRegister(valueToAdd);

            }
        }
        System.out.println("The sum of the signal strengths is " + signalStrength);
    }
}
