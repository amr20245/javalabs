public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int yearOfBirth, double hourlyPayRate, double annualSalary) {
        super(ID, firstName, lastName, title, yearOfBirth, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.printf("%s has a weekly salary of $%.2f (Annual: $%.2f)%n", fullName(), calculateWeeklyPay(hoursWorked), annualSalary);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ", \"annualSalary\":" + annualSalary + "}");
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "<AnnualSalary>" + annualSalary + "</AnnualSalary></Person>");
    }
}
