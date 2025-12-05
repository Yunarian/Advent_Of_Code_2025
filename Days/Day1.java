package Days;

import java.util.ArrayList;

public class Day1 {
    static int pos = 50;
    static int part1Answer = 0;
    public static void main(String[] args) {
        ArrayList<String> lines = Utility.getFileData("Data/john");
        int p2Answer = 0;

        for (int i = 0; i < lines.size(); i++) {
            p2Answer += part2(lines.get(i));
            
        }
        System.out.println("Part 1 Answer: " + Day1.part1Answer);
        System.out.println("Part 2 Answer: " + p2Answer);
    }
    
    // old function used to find part 1's answer (New way is in part 2)
    public static int part1(String line) {
        int movementAmount = Integer.parseInt(line.substring(1)) % 100;
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

    // returns the amount of times a certain rotation would have the pointer pass over 0
    // Error when starting position is not 0 & ends at 0 (Probably more causing this)
    public static int part2(String line) {
        int movementAmount = Integer.parseInt(line.substring(1));
        String firstChar = line.substring(0, 1);
        
        int timesOn0 = movementAmount / 100; 
        movementAmount %= 100;

        int startPos = pos;

        if (firstChar.equals("R")) {
            //System.out.print("(R) pos is: " + pos + "; ");
            pos += movementAmount;
            //System.out.println("new pos is: " + pos);
            if (pos >= 100) {
                pos -= 100;
                timesOn0++;
            }

        } else if (firstChar.equals("L")) {
            //System.out.print("(L) pos is: " + pos + "; ");
            pos -= movementAmount;
            //System.out.println("new pos is: " + pos);
            if (pos < 0) {
                pos += 100;
                timesOn0++;
            } 
        }

        // the amount added from this is apparently the same as part 1's answer
        if (startPos != 0 && pos == 0) {
            part1Answer++;
        }

        return timesOn0;
    }

    
}