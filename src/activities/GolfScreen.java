package activities;

import controllers.Registry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class GolfScreen extends JFrame{

    private static GolfScreen INSTANCE = null;
    private JTextField roomNoField;
    private JTextField hoursField;
    private JTextField extraBastouniaField;
    private int extraBastounia;
    private double hours;
    private String roomNo;
    private double charge;

    private GolfScreen(){
        setResizable(false);
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        setVisible(true);
        setTitle("Mini Golf");
        setBounds(100, 100, 450, 261);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel roomlabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
        roomlabel.setVerticalAlignment(SwingConstants.TOP);
        roomlabel.setBounds(10, 65, 150, 35);
        roomlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(roomlabel);

        roomNoField = new JTextField();
        roomNoField.addActionListener(e -> roomNo = roomNoField.getText());
        roomNoField.setBounds(264, 65, 160, 30);
        roomNoField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomNoField.setColumns(10);
        contentPane.add(roomNoField);

        JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2:");
        hourslabel.setBounds(10, 100, 150, 35);
        hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(hourslabel);

        hoursField = new JTextField();
        hoursField.addActionListener(e -> hours = Integer.parseInt(hoursField.getText()));
        hoursField.setBounds(264, 100, 160, 30);
        hoursField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        hoursField.setColumns(10);
        contentPane.add(hoursField);

        JLabel bastounialabel = new JLabel("\u0395\u03C0\u03B9\u03C0\u03BB\u03AD\u03BF\u03BD \u03BC\u03C0\u03B1\u03C3\u03C4\u03BF\u03CD\u03BD\u03B9\u03B1 (+5\u20AC \u03C4\u03BF \u03AD\u03BD\u03B1):");
        bastounialabel.setBounds(10, 135, 240, 35);
        bastounialabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(bastounialabel);

        extraBastouniaField = new JTextField();
        extraBastouniaField.addActionListener(e -> extraBastounia = Integer.parseInt(extraBastouniaField.getText()));
        extraBastouniaField.setBounds(264, 135, 160, 30);
        extraBastouniaField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        extraBastouniaField.setColumns(10);
        contentPane.add(extraBastouniaField);

        JButton okbutton = new JButton("OK");
        okbutton.addActionListener(e -> {
            try{
                charge = Integer.parseInt(hoursField.getText()) * 10 + Integer.parseInt(extraBastouniaField.getText()) * 5;
                if (Registry.addChargeToReservation(Integer.parseInt(roomNoField.getText()), charge)){
                    JOptionPane.showMessageDialog(null, "Η χρέωση για τη δραστηριότητα έχει καταχωρηθεί επιτυχώς.");
                } else{
                    JOptionPane.showMessageDialog(null, "Δεν είναι δυνατή η χρέωση σε αυτό το δωμάτιο. Πληκτρολογήστε έναν άλλον αριθμό δωματίου.");
                }
                dispose();
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Συμπληρώστε όλα τα πεδία.");
            }
        });
        okbutton.setBounds(179, 182, 85, 29);
        okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(okbutton);

        JLabel lblMiniGolf = new JLabel("Mini Golf");
        lblMiniGolf.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiniGolf.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblMiniGolf.setBounds(10, 10, 416, 50);
        contentPane.add(lblMiniGolf);

    }

    public static GolfScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GolfScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }
}
