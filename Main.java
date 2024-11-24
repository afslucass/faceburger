import javax.swing.*;

import view.Home;
import view.Login;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Faceburger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Login login = new Login();  
        // login.makePanel();
        // frame.add(login.getPanel());

        Home home = new Home();
        home.makePanel();
        frame.add(home.getPanel());

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
