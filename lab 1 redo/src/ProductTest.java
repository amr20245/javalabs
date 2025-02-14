import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testToCSV() {
        Product p = new Product("001", "Pipeweed", "Long Bottom Leaf", 600.0);
        assertEquals("001,Pipeweed,Long Bottom Leaf,600.0", p.toCSV());
    }

    @Test
    void testToJSON() {
        Product p = new Product("001", "Pipeweed", "Long Bottom Leaf", 600.0);
        String expected = "{\"ID\":\"001\",\"name\":\"Pipeweed\",\"description\":\"Long Bottom Leaf\",\"cost\":600.00}";
        assertEquals(expected, p.toJSON());
    }

    @Test
    void testToXML() {
        Product p = new Product("001", "Pipeweed", "Long Bottom Leaf", 600.0);
        String expected = "<Product><ID>001</ID><Name>Pipeweed</Name><Description>Long Bottom Leaf</Description><Cost>600.00</Cost></Product>";
        assertEquals(expected, p.toXML());
    }

    @Test
    void testSetters() {
        Product p = new Product("001", "Pipeweed", "Leaf", 500.0);
        p.setName("NewPipeweed");
        p.setDescription("Updated Leaf");
        p.setCost(650.0);

        assertEquals("NewPipeweed", p.getName());
        assertEquals("Updated Leaf", p.getDescription());
        assertEquals(650.0, p.getCost());
    }

    @Test
    void testEquals() {
        Product p1 = new Product("001", "Pipeweed", "Leaf", 500.0);
        Product p2 = new Product("001", "AnotherPipeweed", "AnotherLeaf", 600.0);
        Product p3 = new Product("002", "DifferentProduct", "SomethingElse", 700.0);

        assertEquals(p1, p2); // Same ID
        assertNotEquals(p1, p3); // Different IDs
    }
}
