import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// The Challenge:
// developing a piece of software that will automate the processing of bank statements so a Client can get better insights into their finances.
// This will be a "simple" version of our application , using csv file representing a bankStatement.

/**
 *  This class will load a CSV file as a command-line argument to the application.
 *  The Path class represents a path in our filesystem. Then we use Files.readAllLines() to return a list of lines.
 *  Once we have all the lines from the file, we  parse them one at a time by:
 *  Splitting the columns by commas, Extracting the amount, Parsing the amount to parseDouble
 *  Once we have the amount for a given statement as a double we will add that to the current total.
 */
public class BankStatementAnalyserSimple {
    static final String RESOURCES = "bank-statement.csv";
    public static void main(String [] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        List<String> linesFromResource = Files.readAllLines(path);
        double totalSumOfTransactions = 0 ;
        for(final String line : linesFromResource){
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            totalSumOfTransactions += amount;
        }
        System.out.println("Total sum of transactions " + totalSumOfTransactions);
    }
}
