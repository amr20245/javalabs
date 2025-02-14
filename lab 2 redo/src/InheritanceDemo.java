import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("001", "John", "Doe", "Mr.", 1980, 20.0));
        workers.add(new Worker("002", "Jane", "Doe", "Ms.", 1985, 18.5));
        workers.add(new Worker("003", "Bob", "Smith", "Mr.", 1975, 22.0));

        workers.add(new SalaryWorker("004", "Alice", "Johnson", "Dr.", 1970, 0, 52000));
        workers.add(new SalaryWorker("005", "Charlie", "Brown", "Mr.", 1988, 0, 78000));
        workers.add(new SalaryWorker("006", "Emily", "White", "Ms.", 1992, 0, 60000));

        for (int week = 1; week <= 3; week++) {
            System.out.println("\nWeek " + week + " Pay:");
            double hoursWorked = (week == 2) ? 50 : 40;

            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked);
            }
        }
    }
}

