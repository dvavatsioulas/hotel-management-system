package controllers;

import activities.ActivitiesScreen;
import bar.BarScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class LoginScreen extends JFrame{

    private static final String USERNAME1 = "rec";
    private static final String PASSWORD1 = "rec";

    private static final String USERNAME2 = "bar";
    private static final String PASSWORD2 = "bar";

    private static final String USERNAME3 = "act";
    private static final String PASSWORD3 = "act";
    private static LoginScreen INSTANCE = null;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private LoginScreen(){
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        initialize();
    }

    public static LoginScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LoginScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

    private void initialize(){

        setVisible(true);
        setTitle("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
        setResizable(false);
        setBounds(100, 100, 394, 192);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
        label.setBounds(6, 6, 369, 25);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBackground(new Color(255, 140, 0));
        contentPane.add(label);

        JLabel usernameLabel = new JLabel("\u03A7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2");
        usernameLabel.setBounds(5, 42, 90, 29);
        usernameLabel.setForeground(new Color(0, 0, 0));
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 42, 270, 29);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2");
        passwordLabel.setBounds(5, 76, 90, 28);
        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 76, 270, 28);
        contentPane.add(passwordField);

        JButton loginButton = new JButton("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2");
        loginButton.setBounds(5, 110, 290, 34);
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginButton.addActionListener(arg0 -> {
            String tempUsername = usernameField.getText();
            String tempPassword = String.valueOf(passwordField.getPassword());
            if (tempUsername.equals(USERNAME1) && tempPassword.equals(PASSWORD1)){
                JOptionPane.showMessageDialog(null, "Σύνδεση επιτυχής.");
                Registry.RS.setVisible(true);
                Main.HS.setVisible(false);
                setVisible(false);
            } else if (tempUsername.equals(USERNAME2) && tempPassword.equals(PASSWORD2)){
                JOptionPane.showMessageDialog(null, "Σύνδεση επιτυχής.");
                BarScreen.getInstance();
                Main.HS.setVisible(false);
                setVisible(false);

            } else if (tempUsername.equals(USERNAME3) && tempPassword.equals(PASSWORD3)){
                JOptionPane.showMessageDialog(null, "Σύνδεση επιτυχής.");
                ActivitiesScreen.getInstance();
                Main.HS.setVisible(false);
                setVisible(false);
            } else{
                JOptionPane.showMessageDialog(null, "Λάθος όνομα χρήστη ή κωδικός! Παρακαλώ ξαναπροσπαθήστε.");
            }
            usernameField.setText(null);
            passwordField.setText(null);
            usernameField.requestFocus();
        });
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(Color.WHITE);
        contentPane.add(loginButton);
        passwordField.addActionListener(e -> loginButton.doClick());
        JButton helpButton = new JButton("?");
        helpButton.setBounds(300, 110, 70, 34);
        helpButton.addActionListener(arg0 -> JOptionPane.showMessageDialog(null, "Εάν επιθυμείτε αλλαγή Username ή/και κωδικου, ή εάν αντιμετωπίζετε προβλήματα σύνδεσης, επικοινωνήστε με τον διαχειριστή του συστήματος."));

        helpButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(helpButton);
    }

}