# Statement_Analyser
 The Challenge:
 developing a piece of software that will automate the processing of bank statements, so a Client can get better insights into their finances.
 This will be a "simple" version of our application , using csv file representing a bankStatement.
 
 The BankStatementAnalyserSimple Class(path:src/simpleAnalyser/):
 
 *  This class will load a CSV file as a command-line argument to the application.
 *  The Path class represents a path in our filesystem. Then we use Files.readAllLines() to return a list of lines.
 *  Once we have all the lines from the file, we  parse them one at a time by:
 *  Splitting the columns by commas, Extracting the amount, Parsing the amount to parseDouble
 *  Once we have the amount for a given statement as a double we will add that to the current total.
 
 In so doing , the class will find  the sum for all "transactions".
 However, we will want to do multiple queries . 
 For this reason and to avoid a "God-Class" scenario ,we will extract parts of the BankStatementAnalyserSimple Class into 
 separate classes with their own responsibilities.
 
 # Second iteration (Single Responsibility Principle)
 As stated before there is a need to extract parts of the BankStatementAnalyserSimple Class into separate classes with 
 their own responsibilities.
 
The Classes created as a result :

BankStatementAnalyser Class
 * This class will be responsible for providing information about transactions, through its analyse method.
 * The BankStatementAnalyser class analyse method,  will take in a String as a File name as well as a BankStatementParser variable 
 * as its arguments, it will then read all the lines in the csv file and store the lines in variable linesFromResource.
 * next we create a List of type BankTransaction ,to assign transactions to this list we make use of the parseLinesFrom method
 * accessed through the second argument ie.BankStatementParser.
 * after which we create a BankStatementProcessor object and parse bankTransaction list to it upon instantiation.
 * next, a call to the collectSummary() method 
 

BankStatementParser Interface

* This interface is introduced to create low coupling between the BankStatementAnalyser class and 
BankStatementCSVParser class 

BankStatementCSVParser Class
* This class is will handle all the parsing logic , allowing us to possibly reuse this class for different processing queries.

BankStatementProcessor
 * This class will be responsible for handling calculation operations
 * extracting this logic out of the BankStatementAnalyserSimple Class allows:
 * method signatures (as they relate to processing) to become simpler to reason about, and have the class be more cohesive.
 * the methods of BankStatementProcessor can be reused by other parts of the application.
 * BankTransactionProcessor is simply a class that lets you perform statistical operations on bank transactions.
     

BankTransaction

* The BankTransaction class is useful so that different parts of our application share the same common understanding of what a bank statement is.
* it attempts to do this by outlining or creating a mold for what a transaction looks like


 
 
 
 
