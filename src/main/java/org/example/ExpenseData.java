package org.example;

import org.apache.commons.csv.CSVRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenseData {
    private final LocalDate date;
    private final BigDecimal amount;
    private final String store;

    public ExpenseData(CSVRecord record) {
        store = record.get("Merchant");
        String tmpDate = record.get(0);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date = LocalDate.parse(tmpDate, dateTimeFormatter);

        String tmpAmount = record.get("Amount");

        if (tmpAmount.startsWith("(") && tmpAmount.endsWith(")")) {
            tmpAmount = "-" + tmpAmount.substring(1, tmpAmount.length() - 1);
        }
        amount = new BigDecimal(tmpAmount).setScale(2);
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStore() {
        return store;
    }
}
