package main;

import java.time.LocalDate;
import java.util.Objects;

// The BankTransaction class is useful so that different parts of our application share the same common understanding of what a bank statement is.
// it attempts to do this by outlining or createing a mold for what a transaction looks like

public class BankTransaction {
        private final LocalDate date;
        private final double amount;
        private final String description;

        public BankTransaction(final LocalDate date, final double amount, final String description){
            this.date = date;
            this.amount = amount;
            this.description = description;
        }
        public LocalDate getDate(){
            return date;
        }

        public double getAmount() {
            return amount;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString(){
            return "BankTransaction{" +
                    "date = " + date +
                    ", amount = " + amount +
                    ", description = " + description + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o ){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BankTransaction that = (BankTransaction) o;
            return Double.compare(that.amount, amount) == 0 &&
                    date.equals(that.date) &&
                    description.equals(that.description);
        }
        @Override
        public int hashCode(){
            return Objects.hash(date, amount, description);
        }
    }

