package view;

import javax.swing.*;


import java.awt.*;
import java.sql.SQLException;

public class Login {
    private JPanel panel;

    private JLabel nameLabel;
    private JLabel dbUrlLabel;
    private JLabel dbPasswordLabel;

    private JTextField name;
    private JTextField dbUrl;
    private JTextField dbPassword;

    private JButton continueButton;

    public Login() {
        this.panel = new JPanel();

        this.nameLabel = new JLabel("Nome");
        this.dbUrlLabel = new JLabel("URL do banco de dados");
        this.dbPasswordLabel = new JLabel("Senha do banco de dados");

        this.name = new JTextField();
        this.dbUrl = new JTextField();
        this.dbPassword = new JTextField();

        this.continueButton = new JButton("Entrar");
    }

    public void makePanel() throws SQLException {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(Box.createVerticalGlue());

        this.nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(this.nameLabel);
        this.name.setPreferredSize(new Dimension(180, 32));
        this.name.setMaximumSize(new Dimension(180, 32));
        panel.add(this.name);

        this.dbUrlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(this.dbUrlLabel);
        this.dbUrl.setPreferredSize(new Dimension(180, 32));
        this.dbUrl.setMaximumSize(new Dimension(180, 32));
        panel.add(this.dbUrl);

        this.dbPasswordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(this.dbPasswordLabel);
        this.dbPassword.setPreferredSize(new Dimension(180, 32));
        this.dbPassword.setMaximumSize(new Dimension(180, 32));
        panel.add(this.dbPassword);

        panel.add(Box.createVerticalStrut(12));

        this.continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.continueButton.setPreferredSize(new Dimension(180, 32));
        this.continueButton.setMaximumSize(new Dimension(180, 32));

        panel.add(this.continueButton);

        panel.add(Box.createVerticalGlue());
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getNameInputText() {
        return this.name.getText();
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
