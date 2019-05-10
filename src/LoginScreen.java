import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginScreen extends JFrame {

	private static final String USERNAME1="reception";
	private static final String PASSWORD1="hotel2019reception";
	
	private static final String USERNAME2="bar";
	private static final String PASSWORD2="hotel2019bar";
	
	private static final String USERNAME3="activities";
	private static final String PASSWORD3="hotel2019activities";
	
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public LoginScreen() {
		setTitle("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
		setResizable(false);
		setBounds(100, 100, 381, 170);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{89, 200, 64, 0};
		gbl_contentPane.rowHeights = new int[]{36, 23, 25, 39, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		try { 
			  
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
		titleLabel.setBounds(8, 0, 182, 36);
		panel.add(titleLabel);
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setBackground(new Color(255, 140, 0));
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel usernameLabel = new JLabel("\u03A7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2");
		usernameLabel.setForeground(new Color(0, 0, 0));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.fill = GridBagConstraints.BOTH;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 0;
		gbc_usernameLabel.gridy = 1;
		contentPane.add(usernameLabel, gbc_usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.anchor = GridBagConstraints.NORTH;
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.gridwidth = 2;
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 1;
		contentPane.add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2");
		passwordLabel.setForeground(new Color(0, 0, 0));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.fill = GridBagConstraints.BOTH;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 2;
		contentPane.add(passwordLabel, gbc_passwordLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		JButton loginButton = new JButton("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tempUsername = usernameField.getText();
				String tempPassword = 	String.valueOf(passwordField.getPassword());
				if(tempUsername.equals(USERNAME1) && tempPassword.equals(PASSWORD1)) {
					JOptionPane.showMessageDialog(null,"Σύνδεση επιτυχής.");
					ReservationsScreen RS = new ReservationsScreen();
					RS.setReservationsVisible();
					Registry.HS.setVisible(false);
					Registry.LS.setVisible(false);
				}
				else if(tempUsername.equals(USERNAME2) && tempPassword.equals(PASSWORD2)) {
					JOptionPane.showMessageDialog(null,"Σύνδεση επιτυχής.");
					ReservationsScreen RS = new ReservationsScreen();
					RS.setReservationsVisible();						//PROSOXI THELOUN DIORTHOSI OTAN TA SINDESOUME
					Registry.HS.setVisible(false);
					Registry.LS.setVisible(false);

				}
				else if(tempUsername.equals(USERNAME3) && tempPassword.equals(PASSWORD3)) {
					JOptionPane.showMessageDialog(null,"Σύνδεση επιτυχής.");
					ReservationsScreen RS = new ReservationsScreen();   //PROSOXI THELOUN DIORTHOSI OTAN TA SINDESOUME
					RS.setReservationsVisible();
					Registry.HS.setVisible(false);
					Registry.LS.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null,"Λάθος όνομα χρήστη ή κωδικός! Παρακαλώ ξαναπροσπαθήστε.");
			}
		});
		loginButton.setForeground(Color.BLACK);
		loginButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.insets = new Insets(0, 0, 0, 5);
		gbc_loginButton.gridwidth = 2;
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 3;
		contentPane.add(loginButton, gbc_loginButton);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton.doClick();
			}
		});
		JButton helpButton = new JButton("?");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Εάν επιθυμείτε αλλαγή Username ή/και κωδικου, ή εάν αντιμετωπίζετε προβλήματα σύνδεσης, επικοινωνήστε με τον διαχειριστή του συστήματος.");
			}
		});
		
		helpButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_helpButton = new GridBagConstraints();
		gbc_helpButton.fill = GridBagConstraints.BOTH;
		gbc_helpButton.gridx = 2;
		gbc_helpButton.gridy = 3;
		contentPane.add(helpButton, gbc_helpButton);
	}
}