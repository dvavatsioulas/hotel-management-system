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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MasazScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textRoomNo;
	private JTextField textHours;
	private double hours;
	private String roomNo;
	private double charge;
	private JLabel label;

	public MasazScreen() {
		try { 
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        SwingUtilities.updateComponentTreeUI(this);
	    } catch(Exception ignored){}
		setVisible(true);
		setTitle("\u039C\u03B1\u03C3\u03AC\u03B6");
		setBounds(100, 100, 450, 233);
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
				roomNo = textRoomNo.getText();
			}
		});
		textRoomNo.setBounds(264, 65, 160, 25);
		textRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textRoomNo.setColumns(10);
		contentPane.add(textRoomNo);
		
		JLabel hourslabel = new JLabel("\u038F\u03C1\u03B5\u03C2 \u03C7\u03C1\u03AE\u03C3\u03B7\u03C2:");
		hourslabel.setBounds(10, 112, 240, 35);
		hourslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(hourslabel);
		
		textHours = new JTextField();
		textHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 hours = Integer.parseInt(textHours.getText());
			}
		});
		textHours.setBounds(264, 112, 160, 25);
		textHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textHours.setColumns(10);
		contentPane.add(textHours);
		
		JButton okbutton = new JButton("OK");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					charge = hours*10;
					charge = Integer.parseInt(textHours.getText())*10;
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
		okbutton.setBounds(178, 159, 85, 29);
		okbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(okbutton);
		
		label = new JLabel("\u039C\u03B1\u03C3\u03AC\u03B6");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(10, 10, 416, 50);
		contentPane.add(label);
	}

}
