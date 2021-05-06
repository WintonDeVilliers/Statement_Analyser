package simpleAnalyser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// The Challenge:
// developing a piece of software that will automate the processing of bank statements so a Client can get better insights into their finances.
/**
 *  This class will load a CSV file as a command-line argument to the application.
 *  The Path class represents a path in our filesystem. Then we use Files.readAllLines() to return a list of lines.
 *  Once we have all the lines from the file, we  parse them one at a time by:
 *  Splitting the columns by commas, Extracting the amount, Parsing the amount to parseDouble
 *  Once we have the amount for a given statement as a double we will add that to the current total.
 */
public class BankStatementAnalyserSimple {
    //    static final String RESOURCES = "src/resources/bank-statement.csv";
    public static void main(String [] args) throws IOException {
        // getting the file from resources package
        final Path path = Paths.get("src/resources/bank-statement.csv");
        // we create a List object holding type String content read from the csv file(using the File.readAllLines() method)
        List<String> linesFromResource = Files.readAllLines(path);
        // initialising totalSumOfTransaction variable , which will hold the eventual output
        double totalSumOfTransactions = 0;
        // loop : for each line in linesFromResource, add the line to String array columns and split on the comma value
        // after splitting the line, we index position [1] in the string array (columns) to find the numeric values in the csv file
        // we parse the amount to Double.parseDouble() to ensure consistent values during calculation and to represent the final amount as a double
        for(final String line : linesFromResource){
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            //Once we have the amount for a given statement as a double we will add that to the current total.
            totalSumOfTransactions += amount;
        }
        System.out.println("Total sum of transactions " + totalSumOfTransactions);
    }
}