package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

/**
 * CONTROLLER for login.fxml.
 *
 * Its job is only to READ what the user typed, ASK the model whether it is
 * correct, and then SHOW the answer. It must not decide by itself what a
 * valid password is - that rule lives in StudentDirectory.
 */
public class ProfileController {

    // ------------------------------------------------------------------
    // TODO 9: Declare the three fields the FXML will fill in. Each one needs
    //         the @FXML annotation, and the NAME must match the fx:id you
    //         wrote in login.fxml:
    //
    //           @FXML private TextField studentNoField;
    //           @FXML private PasswordField passwordField;
    //           @FXML private Label messageLabel;
    // ------------------------------------------------------------------


    @FXML private Label initialsLabel;
    @FXML private Label nameLabel;
    @FXML private Label studentNoLabel;
    @FXML private Label courseLabel;
    @FXML private Label emailLabel;

    public void setStudent(Student student) {
        initialsLabel.setText(initialsOf(student.getFullName()));
        nameLabel.setText(student.getFullName());
        studentNoLabel.setText(student.getStudentNo());
        courseLabel.setText(student.getCourseAndYear());
        emailLabel.setText(student.getEmail());
    }

    @FXML
    private void handleLogout() {
        MainApp.showLogin();
    }

    private String initialsOf(String fullName) {
        String[] parts = fullName.split(" ");
        String first = parts[0].substring(0, 1);
        String last = parts[parts.length - 1].substring(0, 1);
        return (first + last).toUpperCase();
    }
}