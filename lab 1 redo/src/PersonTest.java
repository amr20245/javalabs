import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testFullName() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        assertEquals("John Doe", p.fullName());
    }

    @Test
    void testFormalName() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        assertEquals("Mr. John Doe", p.formalName());
    }

    @Test
    void testGetAge() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 2000);
        assertEquals(24, p.getAge(2024));
    }

    @Test
    void testGetAgeCurrentYear() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 2000);
        int expectedAge = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - 2000;
        assertEquals(expectedAge, p.getAge());
    }

    @Test
    void testToCSV() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        assertEquals("0001,John,Doe,Mr.,1985", p.toCSV());
    }

    @Test
    void testToJSON() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        String expected = "{\"ID\":\"0001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Mr.\",\"yearOfBirth\":1985}";
        assertEquals(expected, p.toJSON());
    }

    @Test
    void testToXML() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        String expected = "<Person><ID>0001</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Mr.</Title><YearOfBirth>1985</YearOfBirth></Person>";
        assertEquals(expected, p.toXML());
    }

    @Test
    void testEquals() {
        Person p1 = new Person("0001", "John", "Doe", "Mr.", 1985);
        Person p2 = new Person("0001", "Jane", "Smith", "Mrs.", 1990);
        Person p3 = new Person("0002", "John", "Doe", "Mr.", 1985);

        assertEquals(p1, p2); // IDs are the same, so they should be equal
        assertNotEquals(p1, p3); // Different IDs, so not equal
    }

    @Test
    void testSetters() {
        Person p = new Person("0001", "John", "Doe", "Mr.", 1985);
        p.setFirstName("Michael");
        p.setLastName("Smith");
        p.setTitle("Dr.");
        p.setYearOfBirth(1990);

        assertEquals("Michael", p.getFirstName());
        assertEquals("Smith", p.getLastName());
        assertEquals("Dr.", p.getTitle());
        assertEquals(1990, p.getYearOfBirth());
    }
}
