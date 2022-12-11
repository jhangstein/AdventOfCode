package DailyRiddles.Day2;
import java.util.ArrayList;

public class Day2RPS {

    final int WIN_SCORE = 6;
    final int LOSS_SCORE = 0;
    final int DRAW_SCORE = 3;
    final int ROCK = 1;
    final int PAPER = 2;
    final int SCISSORS = 3;


    public int calculateMatchScore(String enemyInput, String myInput){
        int score = 0;
        switch (myInput) {
            case "X" -> {
                score += ROCK;
                switch (enemyInput) {
                    case "A"     -> score += DRAW_SCORE;
                    case "B"    -> score += LOSS_SCORE;
                    case "C" -> score += WIN_SCORE;
                }
            }
            case "Y" -> {
                score += PAPER;
                switch (enemyInput) {
                    case "A"     -> score += WIN_SCORE;
                    case "B"    -> score += DRAW_SCORE;
                    case "C" -> score += LOSS_SCORE;
                }
            }
            case "Z" -> {
                score += SCISSORS;
                switch (enemyInput) {
                    case "A"     -> score += LOSS_SCORE;
                    case "B"    -> score += WIN_SCORE;
                    case "C" -> score += DRAW_SCORE;
                }
            }
        }
        return score;
    }

    public int calculateTotalScorePart1(ArrayList<String> list){
        int totalScore = 0;
        for (String string: list) {
            String[] letters = string.split("\\s+");
            totalScore += calculateMatchScore(letters[0], letters[1]);
        }
        return totalScore;
    }


    public int calculateTotalScorePart2(ArrayList<String> list){
        int totalScore = 0;
        for (String string: list) {
            String playerInput = "";
            String[] letters = string.split("\\s+");
            switch (letters[1]){
                //loss
                case "X" -> {
                    switch (letters[0]){
                        case "A" -> playerInput = "Z";
                        case "B" -> playerInput = "X";
                        case "C" -> playerInput = "Y";
                    }
                }
                case "Y" -> {
                    switch (letters[0]){
                        case "A" -> playerInput = "X";
                        case "B" -> playerInput = "Y";
                        case "C" -> playerInput = "Z";
                    }
                }
                case "Z" -> {
                    switch (letters[0]){
                        case "A" -> playerInput = "Y";
                        case "B" -> playerInput = "Z";
                        case "C" -> playerInput = "X";
                    }
                }
            }
            totalScore += calculateMatchScore(letters[0], playerInput);
        }
        return totalScore;
    }
}
