package Days;

import java.util.ArrayList;

public class Day1 {
    static int pos = 50;
    public static void main(String[] args) {
        ArrayList<String> lines = Utility.getFileData("Data/Day1");
        int p2Answer = 0;
        int part1Answer = 0;
        for (int i = 0; i < lines.size(); i++) {
            part1Answer += part1(lines.get(i));
        }
        Day1.pos = 50;

        for (int i = 0; i < lines.size(); i++) {
            p2Answer += part2(lines.get(i));
        }
        System.out.println("Part 1 Answer: " + part1Answer);
        System.out.println("Part 2 Answer: " + p2Answer);
    }
    
    // old function used to find part 1's answer (New way is in part 2)
    public static int part1(String line) {
        int movementAmount = Integer.parseInt(line.substring(1)) % 100;
        return helper(line, movementAmount);
    }

    // returns the amount of times a certain rotation would have the pointer pass over 0
    // Error when starting position is not 0 & ends at 0 (Probably more causing this)
    public static int part2(String line) {
        int movementAmount = Integer.parseInt(line.substring(1));
        int timesOn0 = 0; 

        for (int i = 0; i < movementAmount; i++) {
            timesOn0 += helper(line, 1);
        }

        return timesOn0;
    }

    public static int helper(String line, int movementAmount) {
        String firstChar = line.substring(0, 1);

        if (firstChar.equals("R")) {
            pos += movementAmount;
            if (pos >= 100) {
                pos %= 100;
            } 

        } else if (firstChar.equals("L")) {
            pos -= movementAmount;
            if (pos < 0) {
                pos = (pos % 100) + 100;
            }
        }
        if (pos == 0) {
            return 1;
        }
        return 0;
    }
}