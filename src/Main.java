void main() {
    Scanner input = new Scanner(System.in);


    int[] studentId = new int[10];
    String[] fullName = new String[10];
    int[] age = new int[10];
    String[] course = new String[10];
    double[] grade = new double[10];
    boolean[] isEnrolled = new boolean[10];

    int count = 0;
    int menuSelection;


    while (true) {
        IO.println("\n===== STUDENT INFORMATION SYSTEM =====");
        IO.println("[1] Add Student");
        IO.println("[2] View All Students");
        IO.println("[3] Search Student by ID");
        IO.println("[4] View Statistics");
        IO.println("[5] Exit");
        IO.print("Enter choice: ");


        if (input.hasNextInt()) {
            menuSelection = input.nextInt();
        } else {
            IO.println("Invalid input. Please enter a number.");
            input.next();
            continue;
        }


        switch (menuSelection) {
            case 1:
                if (count >= studentId.length) {
                    IO.println("Student list is already full!");
                } else {
                    IO.print("Enter Student ID: ");
                    int id = input.nextInt();
                    if (id <= 0) {
                        IO.println("Invalid Student ID! ID must be greater than 0.");
                        break;
                    }

                    input.nextLine();

                    IO.print("Enter Full Name: ");
                    String name = input.nextLine();
                    if (name.trim().isEmpty()) {
                        IO.println("Name cannot be empty.");
                        break;
                    }

                    IO.print("Enter Age: ");
                    int studentAge = input.nextInt();
                    if (studentAge <= 0) {
                        IO.println("Invalid age! Age must be greater than 0.");
                        break;
                    }

                    input.nextLine();

                    IO.print("Enter Course: ");
                    String studentCourse = input.nextLine();
                    if (studentCourse.trim().isEmpty()) {
                        IO.println("Course cannot be empty.");
                        break;
                    }

                    IO.print("Enter Grade / Score: ");
                    double studentGrade = input.nextDouble();
                    if (studentGrade < 0 || studentGrade > 100) {
                        IO.println("Invalid grade! Grade must be between 0 and 100.");
                        break;
                    }

                    IO.print("Is Enrolled? (true/false): ");
                    boolean enrolled = input.nextBoolean();


                    studentId[count] = id;
                    fullName[count] = name;
                    age[count] = studentAge;
                    course[count] = studentCourse;
                    grade[count] = studentGrade;
                    isEnrolled[count] = enrolled;

                    count++;

                    IO.println("\nStudent successfully added!");
                    IO.println("--- Student Details ---");
                    IO.println("ID: " + id);
                    IO.println("Name: " + name);
                    IO.println("Age: " + studentAge);
                    IO.println("Course: " + studentCourse);
                    IO.println("Grade: " + studentGrade);
                    IO.println("Enrolled: " + enrolled);
                }
                break;

            case 2:
                if (count == 0) {
                    IO.println("No students to display.");
                } else {
                    for (int i = 0; i < count; i++) {
                        IO.println("\n--- Student Record " + (i + 1) + " ---");
                        IO.println("ID: " + studentId[i]);
                        IO.println("Name: " + fullName[i]);
                        IO.println("Age: " + age[i]);
                        IO.println("Course: " + course[i]);
                        IO.println("Grade: " + grade[i]);
                        IO.println("Enrolled: " + isEnrolled[i]);

                        if (grade[i] >= 90) {
                            IO.println("Standing: Dean's Lister");
                        } else if (grade[i] >= 75) {
                            IO.println("Standing: Passed");
                        } else {
                            IO.println("Standing: Failed");
                        }
                    }
                }
                break;

            case 3:
                if (count == 0) {
                    IO.println("No students to search.");
                } else {
                    IO.print("Enter Student ID: ");
                    int searchId = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (studentId[i] == searchId) {
                            IO.println("\nStudent Found:");
                            IO.println("Name: " + fullName[i]);
                            IO.println("Course: " + course[i]);
                            IO.println("Grade: " + grade[i]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        IO.println("Student not found.");
                    }
                }
                break;

            case 4:
                if (count == 0) {
                    IO.println("No students have been added yet.");
                } else {
                    double total = 0;
                    double highest = grade[0];
                    String topStudent = fullName[0];

                    for (int i = 0; i < count; i++) {
                        total += grade[i];

                        if (grade[i] > highest) {
                            highest = grade[i];
                            topStudent = fullName[i];
                        }
                    }

                    double average = total / count;

                    IO.println("\n--- Class Statistics ---");
                    IO.println("Total Students: " + count);
                    IO.println("Average Grade: " + average);
                    IO.println("Top Student: " + topStudent);
                    IO.println("Highest Grade: " + highest);
                }
                break;

            case 5:
                IO.println("Goodbye!");
                input.close();
                return;

            default:
                IO.println("Invalid option. Please choose 1-5.");
                break;
        }
    }
}