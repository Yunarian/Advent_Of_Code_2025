package Days;

import java.util.ArrayList;

public class Day4 {
    static ArrayList<String> lines = Utility.getFileData("Data/Day4");
    // the +2 to both dimensions are for the "." padding on all sides of it.
    static String[][] grid = new String[lines.size() + 2][lines.get(0).length() + 2];
    static boolean removableRolls = false;

    public static void main(String[] args) {
        int part1Answer = 0;
        int part2Answer = 0;

        // fills the buffer with periods
        for (int column = 0; column < grid.length; column++) {
            grid[0][column] = ".";
            grid[grid.length - 1][column] = ".";

        } for (int row = 0; row < grid.length; row++) {
            grid[row][0] = ".";
            grid[row][grid.length - 1] = ".";

        }

        // fills in the inside with the contents of the file
        for (int rows = 0; rows < lines.size(); rows++) {
            for (int columns = 0; columns < lines.get(rows).length(); columns++) {
                grid[rows + 1][columns + 1] = lines.get(rows).substring(columns, columns + 1);
            }
        }

        for (int row = 0; row < lines.size(); row++) {
            for (int column = 0; column < lines.get(row).length(); column++) {
                part1Answer += part1(column + 1, row + 1);
            }
        }

        part2Answer = part1Answer;
        for (int i = 0; i < 1000; i ++){
            // for (int rows = 0; rows < grid.length; rows++) {
            //     for (int columns = 0; columns < grid[0].length; columns++) {
            //         System.out.print(grid[rows][columns]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            part2();
            for (int row = 0; row < lines.size(); row++) {
                for (int column = 0; column < lines.get(row).length(); column++) {
                    part2Answer += part1(column + 1, row + 1);
                }
            }

        }    

        // // printing out the 2d array
        // for (int rows = 0; rows < grid.length; rows++) {
        //     for (int columns = 0; columns < grid[0].length; columns++) {
        //         System.out.print(grid[rows][columns]);
        //     }
        //     System.out.println();
        // }

        System.out.println("Part 1 answer: " + part1Answer);
        System.out.println("Part 2 answer: " + part2Answer);


    }

    // returns 1 if the roll is valid to be moved
    // returns a 0 otherwise
    public static int part1(int x, int y) {
        if (!(grid[x][y].equals("@"))) {
            return 0;
        }
        // starts at -1 as the nested for loop will count itself
        int surroundingRolls = -1;
        for (int row = y - 1; row <= y + 1; row++) {
            for (int column = x - 1; column <= x + 1; column++) {
                if (!grid[column][row].equals(".")) {
                    surroundingRolls++;
                    if (surroundingRolls >= 4) {
                        removableRolls = false;
                        return 0;
                    }
                }
            }
        }
        grid[x][y] = "X";
        removableRolls = true;
        return 1;
    }

    public static void part2() {
        for (int rows = 0; rows < lines.size(); rows++) {
            for (int columns = 0; columns < lines.get(rows).length(); columns++) {
                if (grid[rows + 1][columns + 1].equals("X")) {
                    grid[rows + 1][columns + 1] = ".";
                }
            }
        }
    }
}
