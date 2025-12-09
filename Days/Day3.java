package Days;

import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = Utility.getFileData("Data/Day3");
        int part1Answer = 0;
        long part2Answer = 0;
        for (int i = 0; i < lines.size(); i++) {
            part1Answer += part1(lines.get(i));
            part2Answer += part2(lines.get(i));
        }
        System.out.println("Part 1 answer: " + part1Answer);
        System.out.println("Part 2 answer: " + part2Answer);
       
    }

    public static int part1(String line) {
        int tens = 0;
        int tensPos = -1;
        int ones = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            if (Integer.parseInt(line.substring(i, i + 1)) > tens) {
                tens = Integer.parseInt(line.substring(i, i + 1));
                tensPos = i;
            }
        }
        for (int i = tensPos + 1; i < line.length(); i++) {
            if (Integer.parseInt(line.substring(i, i + 1)) > ones) {
                ones = Integer.parseInt(line.substring(i, i + 1));
            }
        }

        return tens * 10 + ones;
    }

    public static long part2(String line) {
        int[] digits = new int[12];
        int[] posFound = new int[12];

        for (int i = 0; i < line.length() - 11; i++) {
            if (Integer.parseInt(line.substring(i, i + 1)) > digits[0]) {
                digits[0] = Integer.parseInt(line.substring(i, i + 1));
                posFound[0] = i;
            }
        }
        // System.out.println("First digit is: " + digits[0]);

        for (int i = 1; i < digits.length; i++) {
            for (int j = posFound[i - 1] + 1; j < line.length() - digits.length + i + 1; j++) {
                if (Integer.parseInt(line.substring(j, j + 1)) > digits[i]) {
                    digits[i] = Integer.parseInt(line.substring(j, j + 1));
                    posFound[i] = j;
                }
            }
            // System.out.println(i + 1 + "th digit is: " + digits[i]);
        }
        String output = "";
        for (int i = 0; i < digits.length; i++) {
            output += digits[i];
        }

        return Long.parseLong(output);
    } 
}