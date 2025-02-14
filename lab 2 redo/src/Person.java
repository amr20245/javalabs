import java.util.Calendar;

public class Person {
    private final String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int yearOfBirth;

    public Person(String ID, String firstName, String lastName, String title, int yearOfBirth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    // Getters
    public String getID() { return ID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getTitle() { return title; }
    public int getYearOfBirth() { return yearOfBirth; }

    // Setters (except ID)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    // Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - yearOfBirth;
    }

    public int getAge(int year) {
        return year - yearOfBirth;
    }

    public String toCSV() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + yearOfBirth;
    }

    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"yearOfBirth\":%d}",
                ID, firstName, lastName, title, yearOfBirth);
    }

    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YearOfBirth>%d</YearOfBirth></Person>",
                ID, firstName, lastName, title, yearOfBirth);
    }

    @Override
    public String toString() {
        return formalName() + " (" + yearOfBirth + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return ID.equals(person.ID);
    }
}
