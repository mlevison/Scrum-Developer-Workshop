package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ExpenseLoader {
    List<String[]> expenseRows;

    public ExpenseLoader(String expenseFilePath) {
        try (FileReader expenseDataReader = new FileReader(expenseFilePath)) {
            try (CSVReader csvReader = new CSVReaderBuilder(expenseDataReader).withSkipLines(1).build()) {
                expenseRows = csvReader.readAll();
            }
        } catch (IOException | CsvException ex) {
            throw new LogRuntimeException(ex.getMessage());
        }
    }

    public List<String[]> getRows() {
        return expenseRows;
    }
}
