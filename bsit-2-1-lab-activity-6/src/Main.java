import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ONE list holds Cars AND Motorcycles,
        // because both ARE Vehicles (inheritance).
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("===== VEHICLE MANAGER =====");
            System.out.println("1 - Add Car");
            System.out.println("2 - Add Motorcycle");
            System.out.println("3 - Remove a Vehicle");
            System.out.println("4 - Display All Vehicles");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                System.out.println(">> Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }

            if (choice == 1) {
                System.out.print("Brand: ");
                String brand = input.nextLine();

                System.out.print("Year: ");
                int year = input.nextInt();

                System.out.print("Number of doors: ");
                int doors = input.nextInt();
                input.nextLine();
                // TODO 7: make a Car and add it to the list:

                vehicles.add(new Car(brand, year, doors));

                System.out.println(">> Car added!");
            }

            else if (choice == 2) {
                System.out.print("Brand: ");
                String brand = input.nextLine();

                System.out.print("Year: ");
                int year = input.nextInt();

                System.out.print("Has sidecar? (true/false): ");
                boolean sidecar = input.nextBoolean();
                input.nextLine();
                // TODO 8: make a Motorcycle and add it to the list

                vehicles.add(new Motorcycle(brand, year, sidecar));

                System.out.println(">> Motorcycle added!");
            }

            else if (choice == 3) {
                System.out.print("Enter the number to remove: ");
                int number = input.nextInt();
                input.nextLine();
                // TODO 9: if the number is valid, remove that vehicle:

                if (number >= 1 && number <= vehicles.size()) {
                    vehicles.remove(number - 1);
                    System.out.println(">> Removed!");
                } else {
                    System.out.println(">> Invalid number.");
                }
            }

            else if (choice == 4) {
                System.out.println("--- All Vehicles ---");

                if (vehicles.isEmpty()) {
                    System.out.println("(none yet)");
                }
                // TODO 10: loop the list and show each vehicle:
                for (int i = 0; i < vehicles.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    vehicles.get(i).displayInfo();
                }
            }

            else if (choice != 5) {
                System.out.println(">> Invalid option.");
            }
        }

        System.out.println("Goodbye!");
        input.close();
    }
}