import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EnterPassword extends JFrame {
    JTextField passwordField;
    JTextField confirmField;
    JButton submitButton;
    JButton clearButton;
    int attempts;

    public EnterPassword() {
        setTitle("Password Entry");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        getContentPane().setBackground(Color.PINK);

        attempts = 3;

        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        clearButton = new JButton("Clear");

        add(new JLabel("Enter New Password:"));
        add(passwordField);
        add(new JLabel("Confirm Password:"));
        add(confirmField);
        add(submitButton);
        add(clearButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validatePassword();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearField();
            }
        });
    }

    public void validatePassword() {
        String password = passwordField.getText();
        String confirmPassword = confirmField.getText();

        if (attempts > 0) {
            if (!password.equals(confirmPassword)) {
                attempts--;
                String message = "Passwords do not match. Attempts left: " + attempts;
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
                if (attempts == 0) {
                    JOptionPane.showMessageDialog(this, "No attempts left. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                attempts = 3;
            }
        }
    }

    public void clearField() {
        passwordField.setText("");
        confirmField.setText("");
        attempts = 3;  
    }

    public static void main(String[] args) {
            EnterPassword app = new EnterPassword();
            app.setVisible(true);
        };
    }
