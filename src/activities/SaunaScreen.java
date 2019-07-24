package activities;

import controllers.Registry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class SaunaScreen extends JFrame{

    private static SaunaScreen INSTANCE = null;
    private JTextField textRoomNo;
    private JTextField textHours;
    private double hours;
    private String roomNo;
    private double charge;

    private SaunaScreen(){
        setResizable(false);
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        setVisible(true);
        setTitle("\u03A3\u03AC\u03BF\u03C5\u03BD\u03B1");
        setBounds(100, 100, 450, 240);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel roomlabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
        roomlabel.setBounds(10, 65, 150, 35);
        roomlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(roomlabel);

        textRoomNo = new JTextField();
        textRoomNo.addActionListener(e -> roomNo = textRoomNo.getText());
        textRoomNo.setBounds(264, 65, 160, 30);
        textRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textRoomNo.setColumns(10);
        contentPane.add(textRoomNo);

        JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2 (\u03BC\u03AD\u03C7\u03C1\u03B9 2 \u03CE\u03C1\u03B5\u03C2/\u03AC\u03C4\u03BF\u03BC\u03BF):");
        hourslabel.setBounds(10, 112, 240, 35);
        hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(hourslabel);

        textHours = new JTextField();
        textHours.addActionListener(e -> hours = Integer.parseInt(textHours.getText()));
        textHours.setBounds(264, 112, 160, 30);
        textHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textHours.setColumns(10);
        contentPane.add(textHours);

        JButton okbutton = new JButton("OK");
        okbutton.addActionListener(e -> {
            try{
                if (hours > 2)
                    JOptionPane.showMessageDialog(null, "Only 2 hours/person !");
                else
                    charge = hours * 10;
                charge = Integer.parseInt(textHours.getText()) * 10;
                if (Registry.addChargeToReservation(Integer.parseInt(textRoomNo.getText()), charge)){
                    JOptionPane.showMessageDialog(null, "Η χρέωση για τη δραστηριότητα έχει καταχωρηθεί επιτυχώς.");
                } else{
                    JOptionPane.showMessageDialog(null, "Δεν είναι δυνατή η χρέωση σε αυτό το δωμάτιο. Πληκτρολογήστε έναν άλλον αριθμό δωματίου.");
                }
                dispose();
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Συμπληρώστε όλα τα πεδία.");
            }

        });
        okbutton.setBounds(176, 159, 85, 29);
        okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(okbutton);

        JLabel label = new JLabel("\u03A3\u03AC\u03BF\u03C5\u03BD\u03B1");
        label.setFont(new Font("Tahoma", Font.BOLD, 26));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(10, 10, 416, 50);
        contentPane.add(label);
    }

    public static SaunaScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SaunaScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

}
