package main;

import java.io.IOException;
import java.sql.SQLOutput;

public class main {
    public static void main(String [] args){
        try{
            final BankStatementAnalyser bankStatementAnalyser = new BankStatementAnalyser();

            final BankStatementParser bankStatementParser = new BankStatementCSVParser();

            bankStatementAnalyser.analyse("bank-statement.csv", bankStatementParser);   
        }catch(IOException e){
            System.out.println("could not locate file called bank-statement.csv");
        }
    }
}
