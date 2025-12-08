package Days;

import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> line = Utility.getFileData("Data/Day2");
        String remaining = line.get(0);
        // part1(remaining);
        System.out.println(part2(remaining));
    }


    // part 1 solution
    public static long part1(String remaining) {
        long start = -1;
        long end = -1;
        long sum = 0;

        while (remaining.length() > 0) {
            // sets the start and end of the nested for loop
            if (remaining.substring(0,1).equals(",")) {
                remaining = remaining.substring(1);
            }
            start = Long.parseLong(remaining.substring(0, remaining.indexOf("-")));
            if (remaining.indexOf(",") != -1) {
                end = Long.parseLong(remaining.substring(remaining.indexOf("-") + 1, remaining.indexOf(",")));
            } else {
                end = Long.parseLong(remaining.substring(remaining.indexOf("-") + 1));
            }
            

            for (long i = start; i <= end; i++) {
                String Stringi = "" + i;
                int digits = Stringi.length();
                String firstHalf = Stringi.substring(0, digits / 2);
                String lasthalf = Stringi.substring(digits / 2);
                if (digits % 2 != 1 && firstHalf.equals(lasthalf)) {
                    sum += i;
                }

            }

            if (remaining.indexOf(",") != -1) {
                remaining = remaining.substring(remaining.indexOf(","));
            } else {
                break;
            }
        }

        return sum;
    }


    public static long part2(String remaining) {
        long start = -1;
        long end = -1;
        long sum = 0;

        // for each range
        while (remaining.length() > 0) {
            // sets the start and end of the nested for loop
            if (remaining.substring(0,1).equals(",")) {
                remaining = remaining.substring(1);
            }
            start = Long.parseLong(remaining.substring(0, remaining.indexOf("-")));
            if (remaining.indexOf(",") != -1) {
                end = Long.parseLong(remaining.substring(remaining.indexOf("-") + 1, remaining.indexOf(",")));
            } else {
                end = Long.parseLong(remaining.substring(remaining.indexOf("-") + 1));
            }

            // for every integer between the range of the start and end, inclusive
            for (long i = start; i <= end; i++) {
                sum += part2InvalidId("" + i);
            }

            if (remaining.indexOf(",") != -1) {
                remaining = remaining.substring(remaining.indexOf(","));
            } else {
                break;
            }   
        }
        return sum;
    }

    //calculates if a given input is an invalid id as per day 2's criteria
    public static long part2InvalidId(String input) {
        //This for loop checks if the string is entirely made up of:
        //the first digit repeated, 
        //the first and second digit repeated,
        //the first, second, and third digit repeated,
        //etc.
        for (int i = 1; i < input.length() / 2 + 1; i++) {       
            String inputCopy = input;
            String comparison = input.substring(0, i);
            
            while (inputCopy.length() >= i  && inputCopy.substring(0, i).equals(comparison)) {
                inputCopy = inputCopy.substring(i);
            }

            if (inputCopy.length() == 0) {
                return Long.parseLong(input);
            }
        }

        return 0;
    }
}
