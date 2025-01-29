public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYOB() { return YOB; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    // Additional methods
    public String fullName() { return firstName + " " + lastName; }
    public String formalName() { return title + " " + fullName(); }
    public int getAge(int currentYear) { return currentYear - YOB; }

    // Data format conversions
    public String toCSV() { return firstName + "," + lastName + "," + ID + "," + title + "," + YOB; }
    public String toJSON() { return "{\"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName + "\", \"ID\":\"" + ID + "\", \"title\":\"" + title + "\", \"YOB\":" + YOB + "}"; }
    public String toXML() { return "<Person><FirstName>" + firstName + "</FirstName><LastName>" + lastName + "</LastName><ID>" + ID + "</ID><Title>" + title + "</Title><YOB>" + YOB + "</YOB></Person>"; }

    // toString method
    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", ID='" + ID + '\'' + ", title='" + title + '\'' + ", YOB=" + YOB + '}';
    }
}
