import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
    @Test
    void testCalculateWeeklyPay() {
        Worker worker = new Worker("001", "John", "Doe", "Mr.", 1980, 20.0);
        assertEquals(800.0, worker.calculateWeeklyPay(40));
        assertEquals(1100.0, worker.calculateWeeklyPay(50));
    }

    @Test
    void testToCSV() {
        Worker worker = new Worker("001", "John", "Doe", "Mr.", 1980, 20.0);
        assertTrue(worker.toCSV().contains("20.0"));
    }
}
