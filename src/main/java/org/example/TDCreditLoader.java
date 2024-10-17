package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TDCreditLoader {
    private final List<CSVRecord> rows;

    public TDCreditLoader(String filePath) {
        try (FileReader dataReader = new FileReader(filePath)) {
            CSVParser parser = CSVFormat.DEFAULT.builder().build().parse(dataReader);
            rows = parser.getRecords();
        } catch (IOException ex) {
            throw new LogRuntimeException(ex.getMessage());
        }
    }

    public List<CSVRecord> getRows() {
        return rows;
    }
}
