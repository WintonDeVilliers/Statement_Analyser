package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * This class is created to handle all the parsing logic , allowing us to possibly reuse this class for different processing queries.
 */
public class BankStatementCSVParser implements BankStatementParser {

        private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        public BankTransaction parseFrom(final String line){
            final String [] columns = line.split(",");

            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            final double amount = Double.parseDouble(columns[1]);


            return new BankTransaction(date, amount ,columns[2]);
        }

        public List<BankTransaction> parseLinesFrom(final List<String> lines){
            return lines.stream().map(this::parseFrom).collect(toList());
        }
    }


