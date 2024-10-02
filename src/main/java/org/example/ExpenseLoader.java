package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ExpenseLoader {
    List<CSVRecord> expenseRows;

    public ExpenseLoader(String expenseFilePath) {
        try (FileReader expenseDataReader = new FileReader(expenseFilePath)) {
            CSVParser parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(expenseDataReader);
            expenseRows = parser.getRecords();
        } catch (IOException ex) {
            throw new LogRuntimeException(ex.getMessage());
        }
    }

    public List<CSVRecord> getRows() {
        return expenseRows;
    }
}
