import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GymScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textRoomNo;
	private JTextField textHours;
	private double hours;
	private String roomNo;
	private double charge;
	private boolean personalTrainer;

	public GymScreen() {
		try { 
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        SwingUtilities.updateComponentTreeUI(this);
	    } catch(Exception ignored){}
		setVisible(true);
		setTitle("\u0393\u03C5\u03BC\u03BD\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF");
		setBounds(100, 100, 411, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel roomlabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
		roomlabel.setBounds(10, 65, 150, 35);
		roomlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(roomlabel);
		
		textRoomNo = new JTextField();
		textRoomNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo = textRoomNo.getText();
			}
		});
		textRoomNo.setBounds(264, 65, 120, 25);
		textRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textRoomNo.setColumns(10);
		contentPane.add(textRoomNo);
		
		JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2:");
		hourslabel.setBounds(10, 100, 150, 35);
		hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(hourslabel);
		
		textHours = new JTextField();
		textHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hours = Integer.parseInt(textHours.getText());
			}
		});
		textHours.setBounds(264, 100, 120, 25);
		textHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textHours.setColumns(10);
		contentPane.add(textHours);
		
		JButton okbutton = new JButton("OK");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (personalTrainer)
						charge = Integer.parseInt(textHours.getText()) *15;
					else
						charge=Integer.parseInt(textHours.getText())*10;
					
				
					if(Registry.addChargeToReservation(Integer.parseInt(textRoomNo.getText()), charge)==true) {
						JOptionPane.showMessageDialog(null,"Η χρέωση για τη δραστηριότητα έχει καταχωρηθεί επιτυχώς.");
					}
					else {
						JOptionPane.showMessageDialog(null,"Δεν είναι δυνατή η χρέωση σε αυτό το δωμάτιο. Πληκτρολογήστε έναν άλλον αριθμό δωματίου.");
					}
					dispose();
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Εισάγετε ώρες χρήσης.");
				};
			}
		});
		okbutton.setBounds(154, 182, 85, 29);
		okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(okbutton);
		
		JCheckBox chckbxPersonalTrainer = new JCheckBox("Personal Trainer (+10\u20AC/\u03CE\u03C1\u03B1) ");
		chckbxPersonalTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalTrainer = true;
			}
		});
		chckbxPersonalTrainer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxPersonalTrainer.setBounds(100, 135, 240, 35);
		contentPane.add(chckbxPersonalTrainer);
		
		JLabel lblNewLabel = new JLabel("\u0393\u03C5\u03BC\u03BD\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-1, 10, 395, 50);
		contentPane.add(lblNewLabel);
	}

}
