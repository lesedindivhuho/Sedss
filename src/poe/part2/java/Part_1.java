package poe.part2.java;


import javax.swing.JOptionPane;

public class Part_1 {
    private static String registeredUsername;
    private static String registeredPassword;
    private static String firstName;
    private static String lastName;

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            String choice = (String) JOptionPane.showInputDialog(null, "Choose an option:", "User Manager",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice.equals("Register")) {
                registerUser();
            } else if (choice.equals("Login")) {
                loginUser();
            } else {
                System.exit(0); // Exit the program
            }
        }
    }

    // Checks if the username contains an underscore and is no more than 5 characters long
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Checks if the password is at least 8 characters long, contains a capital letter, a number, and a special character
    public static boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&    // Registers the user by collecting details and validating the username and password

               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public static void registerUser() {
        firstName = JOptionPane.showInputDialog("Enter your first name:");
        lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter a username (contains _ and max 5 characters):");
        String password = JOptionPane.showInputDialog("Enter a password:");

        if (!checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Username successfully captured");

        if (!checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Password successfully captured");

        registeredUsername = username;
        registeredPassword = password;
        JOptionPane.showMessageDialog(null, "User has been registered successfully.");
    }

    // Logs in the user by comparing the entered details with the registered details
    public static void loginUser() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        }
    }
}
