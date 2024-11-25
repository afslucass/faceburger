package view;

import javax.swing.*;

import view.components.Avatar;

import java.awt.*;

public class Post {
    private JPanel panel;

    private JPanel left;
    private JPanel right;

    private JLabel name;
    private JScrollPane scroll;

    public Post() {
        this.panel = new JPanel();

        this.left = new JPanel();
        this.right = new JPanel();

        this.name = new JLabel("Lucas");
        this.scroll = new JScrollPane(this.right);
    }

    private void makeLeftPanel() {
        Avatar pnlCircle = new Avatar(0, 0, 70);
        this.left.setLayout(null);

        pnlCircle.setMinimumSize(new Dimension(70, 70));
        pnlCircle.setMaximumSize(new Dimension(70, 70));
        pnlCircle.setPreferredSize(new Dimension(70, 70));
        pnlCircle.setBounds(25, 25, 70, 70);
        this.name.setBounds(25, 85, 140, 70);
        Font currentFont = this.name.getFont();
        this.name.setFont(currentFont.deriveFont(24f));
        this.left.add(pnlCircle);
        this.left.add(this.name);
    }

    private JPanel createMessageBox() {
        Color backgroudColor = new Color(217, 217, 217);
        JPanel messageBox = new JPanel();
        JPanel header = new JPanel();
        JPanel message = new JPanel();

        messageBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageBox.add(header);
        messageBox.add(message);
        header.setBackground(backgroudColor);
        message.setBackground(backgroudColor);

        message.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));

        messageBox.setMinimumSize(new Dimension(300, 85));
        messageBox.setMaximumSize(new Dimension(300, 200));
        messageBox.setBackground(backgroudColor);

        Avatar pnlCircle = new Avatar(0, 0, 40);
        messageBox.setLayout(new BoxLayout(messageBox, BoxLayout.Y_AXIS));
        header.setLayout(new FlowLayout(FlowLayout.LEFT));
        message.setLayout(new BoxLayout(message, BoxLayout.PAGE_AXIS));

        pnlCircle.setMinimumSize(new Dimension(40, 40));
        pnlCircle.setMaximumSize(new Dimension(40, 40));
        pnlCircle.setPreferredSize(new Dimension(40, 40));

        JLabel messageName = new JLabel("Lucas");
        Font currentFont = messageName.getFont();
        messageName.setFont(currentFont.deriveFont(12f));

        header.add(pnlCircle);
        header.add(Box.createHorizontalStrut(2));
        header.add(messageName);

        JTextArea messageText = new JTextArea("Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio Algum texto aleatorio");
        Font messageTextFont = messageName.getFont();
        messageText.setFont(messageTextFont.deriveFont(10f));
        messageText.setWrapStyleWord(true); // Quebra de palavras completa
        messageText.setLineWrap(true);     // Habilita quebra de linha
        messageText.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));

        message.add(messageText);

        return messageBox;
    }

    private void makeRightPanel() {
        this.right.setLayout(new BoxLayout(this.right, BoxLayout.Y_AXIS));
        this.right.add(Box.createVerticalStrut(120));
        this.right.add(createMessageBox());
        this.right.add(Box.createVerticalStrut(24));
        JButton button = new JButton("Publicar");
        this.right.add(button);
        button.setMinimumSize(new Dimension(120, 60));
        button.setMaximumSize(new Dimension(120, 60));
    }

    public void makePanel() {
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;
        constraints.gridy = 0;

        this.left.setBackground(new Color(235,235,235));
        constraints.weightx = 0.3;
        constraints.gridx = 0;
        panel.add(this.left, constraints);
        
        this.right.setBackground(new Color(255,255,255));
        constraints.weightx = 0.7;
        constraints.gridx = 1;
        this.scroll.setBorder(null);
        panel.add(this.scroll, constraints);

        makeLeftPanel();
        makeRightPanel();
    }

    public JPanel getPanel() {
        return panel;
    }
}
