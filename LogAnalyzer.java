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
 * 9.
 * 
 */

public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
