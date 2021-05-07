package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * This class will be responsible for providing information about transactions, through its analyse method.
 * The BankStatementAnalyser class analyse method,  will take in a String as a File name as well as a BankStatementParser variable
 * as its arguments, it will then read all the lines in the csv file and store the lines in variable linesFromResource.
 * next we create a List of type BankTransaction ,to assign transactions to this list we make use of the parseLinesFrom method
 * accessed through the second argument ie.BankStatementParser.
 * after which we create a BankStatementProcessor object and parse bankTransaction list to it upon instantiation.
 * finally a call to the collectSummary() method is made
 */

public class BankStatementAnalyser {
//    private static final String  fileResource = "src/resources/bank-statement.csv";
//    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void analyse(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(fileName);
        List<String> linesFromResource = Files.readAllLines(path);
//        double totalSumOfTransactions = 0;

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(linesFromResource);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
