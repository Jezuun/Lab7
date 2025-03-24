/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 * 
 * 
 * Non code based questions :
 * Need to do part 1-3 up to q35
 * 1. The busieset times of the day are 10am(227), 2pm(227), 6pm(237)
 * 
 * 2. Person[] people;
 * 
 * 3. boolean[] vacant;
 * 
 * 4. There are 4 square brackets;
 * 
 * 5.int[] counts;// Corrected declaration for an integer array
 * boolean[] occupied = new boolean[5000];
 * // Corrected declaration and initialization for a boolean array
 * 
 * 6.
 * a)readings = new double[60];
 * b)urls = new String[90];
 * c)machines = new TicketMachine[5];
 * 
 * 7. 20
 * 
 * 8. Corrected version : double[] prices = new double[50];
 * 
 * 9. When trying to call the method with a wrongly written loop,
 * I got sent straight to the line of code.
 * 
 * 
 * 11. Corrected Ver
 * public void printGreater(double[] marks, double mean) {
 *   for (int index = 0; index < marks.length; index++) {  
 *       if (marks[index] > mean) {
 *           System.out.println(marks[index]);
 *       }
 *   }
 * }
 *
 *15. a for loop is better
 * 
 */

public class LogAnalyzer {
    private int[] hourCounts;
    private LogfileReader reader;

    public LogAnalyzer(String logFilename) { 
        hourCounts = new int[24];
        reader = new LogfileReader(logFilename);  
    }

    public void analyzeHourlyData() {
        while (reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Find the hour with the most accesses.
     * If multiple hours have the same max count, returns the first.
     * @return The busiest hour.
     */
    public int busiestHour() {
        int maxHour = 0;
        int maxCount = hourCounts[0];

        for (int hour = 1; hour < hourCounts.length; hour++) {  
            if (hourCounts[hour] > maxCount) {
                maxCount = hourCounts[hour];
                maxHour = hour;
            }
        }
        return maxHour;
    }

    /**
     * Find the hour with the least accesses.
     * If multiple hours have the same min count, returns the first.
     * @return The quietest hour.
     */
    public int quietestHour() {
        int minHour = 0;
        int minCount = Integer.MAX_VALUE; // Large initial value

        for (int hour = 0; hour < hourCounts.length; hour++) {  
            if (hourCounts[hour] > 0 && hourCounts[hour] < minCount) { // Avoid zero if necessary
                minCount = hourCounts[hour];
                minHour = hour;
            }
        }
        return minHour;
    }

    /**
     * Find the busiest two-hour period.
     * @return The starting hour of the busiest period.
     */
    public int busiestTwoHourPeriod() {
        int maxStartHour = 0;
        int maxCount = 0;

        for (int hour = 0; hour < hourCounts.length - 1; hour++) {  
            int sum = hourCounts[hour] + hourCounts[hour + 1];
            if (sum > maxCount) {
                maxCount = sum;
                maxStartHour = hour;
            }
        }
        return maxStartHour;
    }

    /**
     * Print the busiest hour and its count.
     */
    public void printBusiestHour() {
        int busiest = busiestHour();
        System.out.println("Busiest hour: " + busiest + " with " + hourCounts[busiest] + " accesses.");
    }

    /**
     * Print the quietest hour and its count.
     */
    public void printQuietestHour() {
        int quietest = quietestHour();
        System.out.println("Quietest hour: " + quietest + " with " + hourCounts[quietest] + " accesses.");
    }

    /**
     * Print the busiest two-hour period.
     */
    public void printBusiestTwoHourPeriod() {
        int busiestPeriod = busiestTwoHourPeriod();
        System.out.println("Busiest two-hour period starts at " + busiestPeriod + 
            " with " + (hourCounts[busiestPeriod] + hourCounts[busiestPeriod + 1]) + " accesses.");
    }

    /**
     * Print the hourly counts.
     */
    public void printHourlyCounts() {
        System.out.println("Hr: Count");
        for (int hour = 0; hour < hourCounts.length; hour++) {  
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Print the total number of accesses.
     */
    public void printTotalAccesses() {
        System.out.println("Total number of accesses: " + numberOfAccesses());
    }

    /**
     * Count the total number of accesses.
     * @return The total number of accesses.
     */
    public int numberOfAccesses() {
        int total = 0;
        for (int count : hourCounts) {
            total += count;
        }
        return total;
    }

    /**
     * Print the log file data.
     */
    public void printData() {
        reader.printData();
    }
}



