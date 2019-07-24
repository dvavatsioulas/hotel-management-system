package activities;

import controllers.Registry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class MasazScreen extends JFrame{

    private static MasazScreen INSTANCE = null;
    private JTextField roomNoField;
    private JTextField hoursField;
    private double hours;
    private String roomNo;
    private double charge;

    public MasazScreen(){
        setResizable(false);
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        setVisible(true);
        setTitle("\u039C\u03B1\u03C3\u03AC\u03B6");
        setBounds(100, 100, 450, 233);
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
        roomNoField.addActionListener(e -> roomNo = roomNoField.getText());
        roomNoField.setBounds(264, 65, 160, 30);
        roomNoField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomNoField.setColumns(10);
        contentPane.add(roomNoField);

        JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2:");
        hourslabel.setBounds(10, 112, 240, 35);
        hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(hourslabel);

        hoursField = new JTextField();
        hoursField.addActionListener(e -> hours = Integer.parseInt(hoursField.getText()));
        hoursField.setBounds(264, 112, 160, 30);
        hoursField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        hoursField.setColumns(10);
        contentPane.add(hoursField);

        JButton okbutton = new JButton("OK");
        okbutton.addActionListener(e -> {
            try{
                charge = hours * 10;
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
        okbutton.setBounds(178, 159, 85, 29);
        okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(okbutton);

        JLabel label = new JLabel("\u039C\u03B1\u03C3\u03AC\u03B6");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 26));
        label.setBounds(10, 10, 416, 50);
        contentPane.add(label);
    }

    public static MasazScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MasazScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

}
