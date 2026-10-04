package ph.edu.liceo.portal.model;

import java.util.ArrayList;

/**
 * MODEL: the list of accounts, and the rule that decides whether a
 * student number and a password belong together.
 *
 * Like Student, this class must NOT import anything from javafx.scene.
 * A console program should be able to use it unchanged.
 */
public class StudentDirectory {

    // ------------------------------------------------------------------
    // TODO 4: Declare a private final ArrayList<Student> called students
    //         and create it here (new ArrayList<>()).
    // ------------------------------------------------------------------

    private final ArrayList<Student> students = new ArrayList<>();

    public StudentDirectory() {
        // --------------------------------------------------------------
        // TODO 5: Add these three accounts to the list. Copy them exactly -
        //         the screenshots you submit must use these values.
        //
        //   "2026-00123", "liceo123", "Ana Marie Dela Cruz",
        //                 "BS Information Technology", 3, "ana.delacruz@liceo.edu.ph"
        //
        //   "2026-00456", "gcash456", "Jerome Bacaltos",
        //                 "BS Computer Science",       2, "jerome.bacaltos@liceo.edu.ph"
        //
        //   "2026-00789", "maya789",  "Liza Manalo",
        //                 "BS Information Systems",    4, "liza.manalo@liceo.edu.ph"
        //
        //   Example of one line:
        //   students.add(new Student("2026-00123", "liceo123", "Ana Marie Dela Cruz",
        //           "BS Information Technology", 3, "ana.delacruz@liceo.edu.ph"));
        // --------------------------------------------------------------

        students.add(new Student(
                "2026-00123",
                "liceo123",
                "Ana Marie Dela Cruz",
                "BS Information Technology",
                3,
                "ana.delacruz@liceo.edu.ph"
        ));

        students.add(new Student(
                "2026-00456",
                "gcash456",
                "Jerome Bacaltos",
                "BS Computer Science",
                2,
                "jerome.bacaltos@liceo.edu.ph"
        ));

        students.add(new Student(
                "2026-00789",
                "maya789",
                "Liza Manalo",
                "BS Information Systems",
                4,
                "liza.manalo@liceo.edu.ph"
        ));
    }

    /**
     * THE LOGIN RULE.
     *
     *  TODO 6: Loop through the list. If a student's number equals studentNo
     *         AND that student's password equals password, return that student.
     *         If the loop finishes without a match, return null.
     *
     *         Remember: compare Strings with .equals(), never with ==.
     *
     * @return the matching Student, or null when there is no match
     */
    public Student login(String studentNo, String password) {
        for (Student s : students) {
            if (s.getStudentNo().equals(studentNo)
                    && s.getPassword().equals(password)) {
                return s;
            }
        }

        return null;
    }

    /** Already written for you. */
    public int count() {
        return students.size();
    }
}