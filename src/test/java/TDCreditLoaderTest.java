import org.apache.commons.csv.CSVRecord;
import org.example.TDCreditLoader;
import org.example.TransactionData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDCreditLoaderTest {
    private final static String tdCreditFilePath = "src/test/resources/TDBankSample.csv";
    private final String[] storeList = {"New Store 1",
            "Store 1",
            "Store C",
            "New Store 2",
            "Store C",
            "Store 1",
            "Another",
            "No Better",
            "Store 1",
            "New Store 2",
            "New Store 2",
            "Store C",
            "Another",
            "Store 1",
            "Store C",
            "New Store 2",
            "Store C",
            "New Store 2",
            "Store C",
            "Another",
            "No Better",
            "Store 1",
            "No Better",
            "Another",
            "No Better",
            "Another",
            "Store 1",
            "Store 1",
            "Store C",
            "New Store 2",
            "Store 1",
            "Store C",
            "No Better",
            "Store C",
            "Store 1",
            "Store 1",
            "No Better",
            "Store C",
            "Another",
            "Store 1",
            "No Better",
            "Store C"};

    private final LocalDate[] dateList = {
            LocalDate.of(2024, 6, 26),
            LocalDate.of(2024, 6, 24),
            LocalDate.of(2024, 6, 24),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 22),
            LocalDate.of(2024, 6, 22),
            LocalDate.of(2024, 6, 22),
            LocalDate.of(2024, 6, 21),
            LocalDate.of(2024, 6, 21),
            LocalDate.of(2024, 6, 20),
            LocalDate.of(2024, 6, 19),
            LocalDate.of(2024, 6, 19),
            LocalDate.of(2024, 6, 18),
            LocalDate.of(2024, 6, 18),
            LocalDate.of(2024, 6, 17),
            LocalDate.of(2024, 6, 17),
            LocalDate.of(2024, 6, 17),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 14),
            LocalDate.of(2024, 6, 14),
            LocalDate.of(2024, 6, 14),
            LocalDate.of(2024, 6, 13),
            LocalDate.of(2024, 6, 13),
            LocalDate.of(2024, 6, 13),
            LocalDate.of(2024, 6, 12),
            LocalDate.of(2024, 6, 12),
            LocalDate.of(2024, 6, 11),
            LocalDate.of(2024, 6, 11),
            LocalDate.of(2024, 6, 10),
            LocalDate.of(2024, 6, 10),
            LocalDate.of(2024, 6, 9),
            LocalDate.of(2024, 6, 6),
            LocalDate.of(2024, 6, 6),
            LocalDate.of(2024, 6, 6)
    };

    private final BigDecimal[] amountList = {
            new BigDecimal("-18074").movePointLeft(2),
            new BigDecimal("-172").movePointLeft(2),
            new BigDecimal("-8500").movePointLeft(2),
            new BigDecimal("-3818").movePointLeft(2),
            new BigDecimal("-712").movePointLeft(2),
            new BigDecimal("-735").movePointLeft(2),
            new BigDecimal("-199").movePointLeft(2),
            new BigDecimal("-2731").movePointLeft(2),
            new BigDecimal("-850").movePointLeft(2),
            new BigDecimal("-850").movePointLeft(2),
            new BigDecimal("-3572").movePointLeft(2),
            new BigDecimal("-524").movePointLeft(2),
            new BigDecimal("-1095").movePointLeft(2),
            new BigDecimal("-1920").movePointLeft(2),
            new BigDecimal("-1594").movePointLeft(2),
            new BigDecimal("-2033").movePointLeft(2),
            new BigDecimal("-6183").movePointLeft(2),
            new BigDecimal("-8500").movePointLeft(2),
            new BigDecimal("-2069").movePointLeft(2),
            new BigDecimal("-850").movePointLeft(2),
            new BigDecimal("-1929").movePointLeft(2),
            new BigDecimal("-705").movePointLeft(2),
            new BigDecimal("-18166").movePointLeft(2),
            new BigDecimal("-8975").movePointLeft(2),
            new BigDecimal("-1825").movePointLeft(2),
            new BigDecimal("-1342").movePointLeft(2),
            new BigDecimal("-2343").movePointLeft(2),
            new BigDecimal("-1900").movePointLeft(2),
            new BigDecimal("-5351").movePointLeft(2),
            new BigDecimal("-8000").movePointLeft(2),
            new BigDecimal("-562").movePointLeft(2),
            new BigDecimal("-8769").movePointLeft(2),
            new BigDecimal("-2267").movePointLeft(2),
            new BigDecimal("-4371").movePointLeft(2),
            new BigDecimal("-5129").movePointLeft(2),
            new BigDecimal("2315").movePointLeft(2),
            new BigDecimal("-8919").movePointLeft(2),
            new BigDecimal("-1157").movePointLeft(2),
            new BigDecimal("-2315").movePointLeft(2),
            new BigDecimal("-3171").movePointLeft(2),
            new BigDecimal("-5534").movePointLeft(2),
            new BigDecimal("-2260").movePointLeft(2)
    };

    @Test
    void sampleTDCreditLoad() {
        TDCreditLoader tdCreditLoader = new TDCreditLoader(tdCreditFilePath);
        var rows = tdCreditLoader.getRows();
        assertEquals(dateList.length, rows.size());

        for (CSVRecord row : rows) {
            TransactionData transactionRow = new TransactionData(row);
            int rowNumber = (int) row.getRecordNumber() - 1;
            //           assertThat(transactionRow.getStore()).withFailMessage("Actual Store: " + transactionRow.getStore() + " Expected: " + storeList[rowNumber] + " at row: " + rowNumber).isEqualTo(storeList[rowNumber]);

            assertThat(transactionRow.getDate()).withFailMessage("Actual Date: " + transactionRow.getDate() + " Expected: " + dateList[rowNumber] + " at row: " + rowNumber).isEqualTo(dateList[rowNumber]);

            assertThat(transactionRow.getAmount()).withFailMessage("Actual Amount: " + transactionRow.getAmount() + " Expected: " + amountList[rowNumber] + " at row: " + rowNumber).isEqualTo(amountList[rowNumber]);
        }
    }
}
