package Days;

import java.util.ArrayList;

public class Day5 {
    static ArrayList<String> IDranges = Utility.getFileData("Data/Day5Ranges");
    static ArrayList<String> lines = Utility.getFileData("Data/Day5");
    static ArrayList<Long> validIds = new ArrayList<>();

    public static void main(String[] args) {
        int part1Answer = 0;
        long part2Answer = 0;
        for (int i = 0; i < lines.size(); i++) {
            part1Answer += part1(lines.get(i));
            
        }
        part2();
        part2Answer = validIds.size();
        System.out.println("Part 1 answer: " + part1Answer);
        System.out.println("Part 2 answer: " + part2Answer);
       
    }

    public static int part1(String line) {
        long start = 0;
        long end = 0;
        long id = 0;
        for (int ranges = 0; ranges < IDranges.size(); ranges++) {
            start = Long.parseLong(IDranges.get(ranges).substring(0, IDranges.get(ranges).indexOf("-")));
            end = Long.parseLong(IDranges.get(ranges).substring(IDranges.get(ranges).indexOf("-") + 1)); 
            id = Long.parseLong(line);

            if (id >= start && id <= end) {
                return 1;
            }
        }
        return 0;
    }

    public static void part2() {
        long start = 0;
        long end = 0;
        for (int ranges = 0; ranges < IDranges.size(); ranges++) {
            start = Long.parseLong(IDranges.get(ranges).substring(0, IDranges.get(ranges).indexOf("-")));
            end = Long.parseLong(IDranges.get(ranges).substring(IDranges.get(ranges).indexOf("-") + 1)); 
            for (long i = start; i <= end; i++) {
                if (!validIds.contains(i)) {
                    validIds.add(i);
                }
            }
        }
    }
}