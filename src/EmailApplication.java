import controller.MailController;
import controller.UserController;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.responses.RegisterResponse;

import javax.swing.*;

public class EmailApplication {
    public static void main(String[] args) {
        UserController userController = new UserController();

        MailController emailController = new MailController();

        JOptionPane.showMessageDialog(null, "hello, whats up who de zuzu i welcome u to ur mail application");

        int choice = JOptionPane.showOptionDialog(null, "Do you want to register or login?", "Email Application \uD83D\uDCE7", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Register", "Login"}, null);
        if (choice == JOptionPane.YES_OPTION) {
            String firstName = JOptionPane.showInputDialog(null, "Enter ur firstName", JOptionPane.INFORMATION_MESSAGE);
            String lastName = JOptionPane.showInputDialog(null, "Enter ur lastName", JOptionPane.INFORMATION_MESSAGE);
            String dOB = JOptionPane.showInputDialog(null, "Enter ur date of birth(dd-mm-yyyy):", JOptionPane.INFORMATION_MESSAGE);
            String username = JOptionPane.showInputDialog(null, JOptionPane.PLAIN_MESSAGE, "enter userName", JOptionPane.OK_CANCEL_OPTION);
            JPasswordField passwordField = new JPasswordField();
            JOptionPane.showConfirmDialog(null, passwordField, "create password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            char[] passwordChar = passwordField.getPassword();
            String password = new String(passwordChar);
            RegisterRequest registerRequest = new RegisterRequest(firstName, lastName, dOB, username, password);
            RegisterResponse registerResponse = (RegisterResponse) userController.registerUser(registerRequest);
            JOptionPane.showMessageDialog(null, registerResponse.getMessage());
            LoginRequest loginRequest = new LoginRequest(username,password);
            showMainMenu();
            login(userController, emailController);
        } else login(userController, emailController);
    }

    private static void showMainMenu() {
        String mainMenu = input("""
                ========================================================================
                make una calm down i neva finish am watch out for part 2 
                micheal no go ask me question make we no get problem thanks 4 viewing 
                mr femi i sight u normally i suppose carry u trabaye
                but as u resemble pastor 4 dis dominion city 
                na wetin make me de consider but if u give me go ahead no wahala
                mr chibuzo u to much
                happy birthday to Mr Sam Immanuel AKA CHIEF 
                CEO semicolon money
                thank u 4 all d loan sir.
                location 4 birthday undisclosed
                All bills paid by the trabaye team.
                Yinka gat u covered.
                ==========================================================================
                """);
    }

    private static void login(UserController userController, MailController emailController) {

    }
     private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
     }
} 