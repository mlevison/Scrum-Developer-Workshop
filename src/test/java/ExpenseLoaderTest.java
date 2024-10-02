import org.example.ExpenseLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseLoaderTest {
    private final String expenseFilePath = "src/test/resources/ExpensifyExpenseExportSample.csv";

    @Test
    void sampleExpensesLoad() {
        ExpenseLoader expenseLoader = new ExpenseLoader(expenseFilePath);
        var rows = expenseLoader.getRows();
        assertEquals(79, rows.size());
    }
}
