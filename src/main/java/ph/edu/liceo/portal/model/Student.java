package ph.edu.liceo.portal.model;

/**
 * MODEL: one student account.
 *
 * This class must NOT import anything from javafx.scene.
 * It only holds data about a student - no buttons, no labels.
 */
public class Student {
    // ------------------------------------------------------------------
    // TODO 1: Declare six private final fields:
    //         studentNo (String), password (String), fullName (String),
    //         course (String), yearLevel (int), email (String)
    // ------------------------------------------------------------------


    // ------------------------------------------------------------------
    // TODO 2: Write the constructor. It takes the six values above, in the
    //         same order, and copies each one into its field with "this.".
    //
    //         public Student(String studentNo, String password, String fullName,
    //                        String course, int yearLevel, String email) { ... }
    // ------------------------------------------------------------------


    // ------------------------------------------------------------------
    // TODO 3: Write the six getters. The signatures are already here -
    //         you only need to write the return statement inside each one.
    // ------------------------------------------------------------------
    private final String studentNo;
    private final String password;
    private final String fullName;
    private final String course;
    private final int yearLevel;
    private final String email;

    public Student(String studentNo, String password, String fullName,
                   String course, int yearLevel, String email) {
        this.studentNo = studentNo;
        this.password = password;
        this.fullName = fullName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.email = email;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourse() {
        return course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Already written for you.
     */
    public String getCourseAndYear() {
        return getCourse() + "  -  Year " + getYearLevel();
    }
}