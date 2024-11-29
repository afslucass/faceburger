import javax.swing.*;

import view.Home;
import view.Login;
import view.Post;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Faceburger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        Login login = new Login();  
        login.makePanel();

        Home home = new Home();
        home.makePanel();

        Post post = new Post();
        post.makePanel();

        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(home.getPanel(), "home");
        mainPanel.add(post.getPanel(), "post");

        login.getContinueButton().addActionListener(e -> cardLayout.show(mainPanel, "home"));
        home.getNewButton().addActionListener(e -> cardLayout.show(mainPanel, "post"));
        post.getPostButton().addActionListener(e -> cardLayout.show(mainPanel, "home"));
        
        frame.add(mainPanel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
