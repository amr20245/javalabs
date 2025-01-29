import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", "High-end gaming laptop", "001122", 1499.99);
    }

    @Test
    void testToString() {
        String expected = "Product{name='Laptop', description='High-end gaming laptop', ID='001122', cost=1499.99}";
        assertEquals(expected, product.toString());
    }

    // More tests...
}
