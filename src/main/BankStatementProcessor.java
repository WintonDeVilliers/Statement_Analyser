package main;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    /**
     * This class will be responsible for handling calculation operations
     * extracting this logic out of the BankStatementAnalyserSimple Class allows:
     * method signatures (as they relate to processing) simpler to reason about, and have the class be more cohesive.
     * the methods of BankStatementProcessor can be reused by other parts of your application.
     * BankTransactionProcessor is simply a class that lets you perform statistical operations on bank transactions.
     */
        private final List<BankTransaction> bankTransactions;

        public BankStatementProcessor(final List<BankTransaction> bankTransactions){
            this.bankTransactions = bankTransactions;
        }

//        public double summariseTransactions(final BankTransactionSummariser bankTransactionSummariser) {
//            return result;
//            double result = 0;
//            for (final BankTransaction bankTransaction : bankTransactions) {
//                result = bankTransactionSummariser.summarise(result, bankTransaction);
//            }
//        }

        public double calculateTotalAmount(){
            double total = 0 ;
            for(final BankTransaction bankTransaction: bankTransactions){
                total += bankTransaction.getAmount();
            }
            return total;
        }

        public double calculateTotalInMonth(final Month month){
            double total = 0;
            for(final BankTransaction bankTransaction: bankTransactions){
                if(bankTransaction.getDate().getMonth() == month){
                    total += bankTransaction.getAmount();
                }
            }
            return total;
        }

//        public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
//            final List<BankTransaction> result =  new ArrayList<>();
//            for(final BankTransaction bankTransaction: bankTransactions){
//                if(bankTransactionFilter.test(bankTransaction)){
//                }
//            }
//            return bankTransactions;
//        }
        public double calculateTotalForCategory(final String category){
            double total = 0;
            for(final BankTransaction bankTransaction : bankTransactions){
                if(bankTransaction.getDescription().equals(category)){
                    total += bankTransaction.getAmount();
                }
            }
            return total;
        }

    }
