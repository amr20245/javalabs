import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {
    @Test
    void testCalculateWeeklyPay() {
        SalaryWorker worker = new SalaryWorker("001", "Alice", "Smith", "Ms.", 1985, 25.0, 52000);
        assertEquals(1000.0, worker.calculateWeeklyPay(40));
        assertEquals(1000.0, worker.calculateWeeklyPay(50)); // Hours don't matter
    }
}
