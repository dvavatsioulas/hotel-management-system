import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GolfScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textRoomNo;
	private JTextField textHours;
	private JTextField textExtraBastounia;
	private int extraBastounia;
	private double hours;
	private String roomNo;
	private double charge;

	public GolfScreen() {
		try { 
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        SwingUtilities.updateComponentTreeUI(this);
	    } catch(Exception ignored){}
		setVisible(true);
		setTitle("Mini Golf");
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel roomlabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
		roomlabel.setVerticalAlignment(SwingConstants.TOP);
		roomlabel.setBounds(10, 65, 150, 35);
		roomlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(roomlabel);
		
		textRoomNo = new JTextField();
		textRoomNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomNo = textRoomNo.getText();
			}
		});
		textRoomNo.setBounds(264, 65, 160, 25);
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
				hours = Integer.parseInt(textHours.getText());
			}
		});
		textHours.setBounds(264, 100, 160, 25);
		textHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textHours.setColumns(10);
		contentPane.add(textHours);
		
		JLabel bastounialabel = new JLabel("\u0395\u03C0\u03B9\u03C0\u03BB\u03AD\u03BF\u03BD \u03BC\u03C0\u03B1\u03C3\u03C4\u03BF\u03CD\u03BD\u03B9\u03B1 (+5\u20AC \u03C4\u03BF \u03AD\u03BD\u03B1):");
		bastounialabel.setBounds(10, 135, 240, 35);
		bastounialabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(bastounialabel);
		
		textExtraBastounia = new JTextField();
		textExtraBastounia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extraBastounia = Integer.parseInt(textExtraBastounia.getText());
			}
		});
		textExtraBastounia.setBounds(264, 135, 160, 25);
		textExtraBastounia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textExtraBastounia.setColumns(10);
		contentPane.add(textExtraBastounia);
		
		JButton okbutton = new JButton("OK");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					charge = Integer.parseInt(textHours.getText())*10 + Integer.parseInt(textExtraBastounia.getText())*5;
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
		okbutton.setBounds(179, 182, 85, 29);
		okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(okbutton);
		
		JLabel lblMiniGolf = new JLabel("Mini Golf");
		lblMiniGolf.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiniGolf.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMiniGolf.setBounds(10, 10, 416, 50);
		contentPane.add(lblMiniGolf);
		
		
		
	}
}
