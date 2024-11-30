import javax.swing.*;

import controller.MessageActions;
import controller.UserActions;
import model.Message;
import model.User;
import view.Home;
import view.Login;
import view.Post;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Faceburger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User currentUser = new User();

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
        
        UserActions user = new UserActions();
        MessageActions messages = new MessageActions();

        login.getContinueButton().addActionListener(e -> {
            ArrayList<Message> mensagens = messages.getAllMessages();

            currentUser.setNick(login.getNameInputText());
            currentUser.setId(user.adicionaUser(currentUser).getId());
            home.updateCurrentUser(currentUser);
            home.setMessages(mensagens);
            
            post.updateCurrentUser(currentUser);

            cardLayout.show(mainPanel, "home");
        });
        home.getNewButton().addActionListener(e -> cardLayout.show(mainPanel, "post"));
        post.getPostButton().addActionListener(e -> {
            ArrayList<Message> mensagens = messages.getAllMessages();

            home.setMessages(mensagens);
            cardLayout.show(mainPanel, "home");
        });
        
        
        frame.add(mainPanel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
