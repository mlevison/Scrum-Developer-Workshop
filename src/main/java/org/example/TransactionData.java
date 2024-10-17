package org.example;

import org.apache.commons.csv.CSVRecord;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionData {
    private final String store;
    private final LocalDate date;
    private final BigDecimal amount;
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public TransactionData(CSVRecord record) {
        store = record.get(1);
        date = LocalDate.parse(record.get(0), dateTimeFormatter);

        String tmpAmount = record.get(2);

        if (tmpAmount.isEmpty()) {
            tmpAmount = "-" + record.get(3);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        decimalFormat.setParseBigDecimal(true);
        try {
            amount = ((BigDecimal) decimalFormat.parse(tmpAmount)).setScale(2).negate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStore() {
        return store;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

