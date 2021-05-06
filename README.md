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
 However, we will want to do multiple queries , for this reason and to avoid a "God-Class" ,we will extract parts of the BankStatementAnalyserSimple Class into 
 separate classes with their own responsibilities.
 
 
 
