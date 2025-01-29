import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", "12345", "Mr.", 1980);
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    void testGetAge() {
        assertEquals(42, person.getAge(2022)); // Assuming the current year is 2022
    }
}
