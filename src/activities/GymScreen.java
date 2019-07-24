package activities;

import controllers.Registry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class GymScreen extends JFrame{

    private static GymScreen INSTANCE = null;
    private JTextField roomNoField;
    private JTextField hoursField;
    private double hours;
    private String roomNo;
    private double charge;
    private boolean personalTrainer;

    private GymScreen(){
        setResizable(false);
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        setVisible(true);
        setTitle("\u0393\u03C5\u03BC\u03BD\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF");
        setBounds(100, 100, 411, 259);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel roomlabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
        roomlabel.setBounds(10, 65, 150, 35);
        roomlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(roomlabel);

        roomNoField = new JTextField();
        roomNoField.addActionListener(e -> {
            String roomNo = roomNoField.getText();
        });
        roomNoField.setBounds(264, 65, 120, 30);
        roomNoField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomNoField.setColumns(10);
        contentPane.add(roomNoField);

        JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2:");
        hourslabel.setBounds(10, 100, 150, 35);
        hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(hourslabel);

        hoursField = new JTextField();
        hoursField.addActionListener(e -> {
            int hours = Integer.parseInt(hoursField.getText());
        });
        hoursField.setBounds(264, 100, 120, 30);
        hoursField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        hoursField.setColumns(10);
        contentPane.add(hoursField);

        JButton okbutton = new JButton("OK");
        okbutton.addActionListener(e -> {
            try{
                if (personalTrainer)
                    charge = Integer.parseInt(hoursField.getText()) * 15;
                else
                    charge = Integer.parseInt(hoursField.getText()) * 10;

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
        okbutton.setBounds(154, 182, 85, 29);
        okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(okbutton);

        JCheckBox chckbxPersonalTrainer = new JCheckBox("Personal Trainer (+10\u20AC/\u03CE\u03C1\u03B1) ");
        chckbxPersonalTrainer.addActionListener(e -> personalTrainer = true);
        chckbxPersonalTrainer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chckbxPersonalTrainer.setBounds(100, 135, 240, 35);
        contentPane.add(chckbxPersonalTrainer);

        JLabel lblNewLabel = new JLabel("\u0393\u03C5\u03BC\u03BD\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(-1, 10, 395, 50);
        contentPane.add(lblNewLabel);
    }

    public static GymScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GymScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

}
