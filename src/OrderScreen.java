import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Component;
import javax.swing.UIManager;

public class OrderScreen extends JFrame
{	
	private JPanel contentPane;
	private JList list;
	private int Quantity;
	private JList list_1;
	private JTable table;
	private JTextField TotalPrice;
	private JLabel lblNewLabel;
	private Double TotalP = 0.0;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	
	private ArrayList<Product> deserts = new ArrayList<>();
	private ArrayList<Product> drinks = new ArrayList<>();
	private ArrayList<Product> salads = new ArrayList<>();
	private ArrayList<Product> mainCourse = new ArrayList<>();
	private JTextField textField;

	public OrderScreen() {
		try { 
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        SwingUtilities.updateComponentTreeUI(this);
	    } catch(Exception ignored){}
		initialize();
	}
	
	private void initialize() {
		
		try { 
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        SwingUtilities.updateComponentTreeUI(this);
	    } catch(Exception ignored){}
		
		setResizable(false);
		setTitle("Order Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 807, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		deserts.add(new Product("Πανακότα",3));
		deserts.add(new Product("Παγωτό (1 μπάλα)",2));
		deserts.add(new Product("Τάρτα Φρούτων",2.5));
		deserts.add(new Product("Τρίγωνο Πανοράματος",1.5));
		deserts.add(new Product("Καριόκα",1));
		
		drinks.add(new Product ("Coca-Cola", 1.5));
		drinks.add(new Product ("Fanta", 1.5));
		drinks.add(new Product ("Sprite", 1.5));
		drinks.add(new Product ("Χυμός Πορτοκάλι", 2));
		drinks.add(new Product ("Σόδα", 1));
		
		salads.add(new Product ("Ceasar's", 5));
		salads.add(new Product ("Χωριάτικη", 3.5));
		salads.add(new Product ("Ρόκα", 3));
		salads.add(new Product ("Πατατοσαλάτα", 4));
		
		mainCourse.add(new Product ("Μουσακάς", 7));
		mainCourse.add(new Product ("Μακαρόνια με κυμά", 6));
		mainCourse.add(new Product ("Τσιπούρα", 8));
		mainCourse.add(new Product ("Φακές", 7));
		mainCourse.add(new Product ("Μπριζόλα με πατάτες", 9));		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSpinner spinner_deserts = new JSpinner();
		spinner_deserts.setBounds(124, 324, 45, 22);
		panel.add(spinner_deserts);
		
		JSpinner spinner_drinks = new JSpinner();
		spinner_drinks.setBounds(124, 245, 45, 22);
		panel.add(spinner_drinks);
		
		JSpinner spinner_salads = new JSpinner();
		spinner_salads.setBounds(124, 81, 45, 22);
		panel.add(spinner_salads);
		
		JSpinner spinner_mainCourse = new JSpinner();
		spinner_mainCourse.setBounds(124, 167, 45, 22);
		panel.add(spinner_mainCourse);
		
		TotalPrice = new JTextField();
		TotalPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		TotalPrice.setEditable(false);
		TotalPrice.setText("" + TotalP);
		TotalPrice.setBounds(710, 326, 67, 25);
		panel.add(TotalPrice);
		TotalPrice.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(244, 11, 533, 313);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u03A0\u03C1\u03BF\u03CA\u03CC\u03BD", "\u03A0\u03BF\u03C3\u03CC\u03C4\u03B7\u03C4\u03B1", "\u039C\u03B5\u03C1\u03B9\u03BA\u03CC \u03A3\u03CD\u03BD\u03BF\u03BB\u03BF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(146);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		
		lblNewLabel = new JLabel("\u03A3\u03CD\u03BD\u03BF\u03BB\u03BF (\u20AC):");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(608, 325, 99, 26);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE \u0395\u03C0\u03B9\u03BB\u03B5\u03B3\u03BC\u03AD\u03BD\u03BF\u03C5");
		btnNewButton.setForeground(new Color(204, 0, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {

					Object temp= (((DefaultTableModel)table.getModel()).getValueAt(table.getSelectedRow(),2));
					String tempstring=(String)temp;
					double tempPartialCost= Double.parseDouble(tempstring);
					
					TotalP=TotalP-tempPartialCost;
					
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
					TotalPrice.setText(TotalP+"");
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,"Δεν υπάρχει κάποιο προϊόν για να διαγραφεί.");
				}
			}
		});
		
		btnNewButton.setBounds(244, 326, 175, 26);
		panel.add(btnNewButton);
		
		JComboBox desertsComboBox = new JComboBox();
		desertsComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "\u03A0\u03B1\u03BD\u03B1\u03BA\u03CC\u03C4\u03B1", "\u03A0\u03B1\u03B3\u03C9\u03C4\u03CC (1 \u03BC\u03C0\u03AC\u03BB\u03B1)", "\u03A4\u03AC\u03C1\u03C4\u03B1 \u03A6\u03C1\u03BF\u03CD\u03C4\u03C9\u03BD", "\u03A4\u03C1\u03AF\u03B3\u03C9\u03BD\u03BF \u03A0\u03B1\u03BD\u03BF\u03C1\u03AC\u03BC\u03B1\u03C4\u03BF\u03C2", "\u039A\u03B1\u03C1\u03B9\u03CC\u03BA\u03B1"}));
		desertsComboBox.setBounds(10, 324, 111, 22);
		panel.add(desertsComboBox);
		
		JComboBox drinksComboBox = new JComboBox();
		drinksComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "Coca-Cola", "Fanta", "Sprite", "\u03A7\u03C5\u03BC\u03CC\u03C2 \u03A0\u03BF\u03C1\u03C4\u03BF\u03BA\u03AC\u03BB\u03B9", "\u03A3\u03CC\u03B4\u03B1"}));
		drinksComboBox.setBounds(10, 245, 111, 22);
		panel.add(drinksComboBox);
		
		JComboBox saladsComboBox = new JComboBox();
		saladsComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "Ceasar's", "\u03A7\u03C9\u03C1\u03B9\u03AC\u03C4\u03B9\u03BA\u03B7", "\u03A1\u03CC\u03BA\u03B1", "\u03A0\u03B1\u03C4\u03B1\u03C4\u03BF\u03C3\u03B1\u03BB\u03AC\u03C4\u03B1"}));
		saladsComboBox.setBounds(10, 81, 111, 22);
		panel.add(saladsComboBox);
		
		JComboBox mainCourseComboBox = new JComboBox();
		mainCourseComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "\u039C\u03BF\u03C5\u03C3\u03B1\u03BA\u03AC\u03C2", "\u039C\u03B1\u03BA\u03B1\u03C1\u03CC\u03BD\u03B9\u03B1 \u03BC\u03B5 \u03BA\u03C5\u03BC\u03AC", "\u03A4\u03C3\u03B9\u03C0\u03BF\u03CD\u03C1\u03B1", "\u03A6\u03B1\u03BA\u03AD\u03C2", "\u039C\u03C0\u03C1\u03B9\u03B6\u03CC\u03BB\u03B1 \u03BC\u03B5 \u03C0\u03B1\u03C4\u03AC\u03C4\u03B5\u03C2"}));
		mainCourseComboBox.setBounds(10, 166, 111, 22);
		panel.add(mainCourseComboBox);
		
		JButton drinksButton = new JButton("+");
		drinksButton.setFont(new Font("Dialog", Font.BOLD, 11));
		drinksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempstring = (String)drinksComboBox.getSelectedItem();
				for(Product p: drinks) {
					if(tempstring.equals(p.getName()))
					{
						((DefaultTableModel)table.getModel()).addRow(new Object[] {tempstring,spinner_drinks.getValue(),(p.getPrice()*((Integer)spinner_drinks.getValue()))+""});
						
						TotalP += p.getPrice()*(Integer)spinner_drinks.getValue();
						System.out.println(TotalP);
						TotalPrice.setText("" + TotalP);					
					}
				}
			}
		});
		drinksButton.setBounds(179, 244, 40, 25);
		panel.add(drinksButton);
		
		JButton desertsButton = new JButton("+");
		desertsButton.setFont(new Font("Dialog", Font.BOLD, 11));
		desertsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempstring = (String)desertsComboBox.getSelectedItem();
				for(Product p:deserts) {
					if(tempstring.equals(p.getName())) {
						
					((DefaultTableModel)table.getModel()).addRow(new Object[] {tempstring,spinner_deserts.getValue(),(p.getPrice()*((Integer)spinner_deserts.getValue()))+""});
						
					TotalP += p.getPrice()*(Integer)spinner_deserts.getValue();
					System.out.println(TotalP);
					TotalPrice.setText("" + TotalP);		
					}
				}
			}
		});
		desertsButton.setBounds(179, 323, 40, 25);
		panel.add(desertsButton);		

		JButton saladsButton = new JButton("+");
		saladsButton.setFont(new Font("Dialog", Font.BOLD, 11));
		saladsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempstring = (String)saladsComboBox.getSelectedItem();
				for(Product p:salads) {
					if(tempstring.equals(p.getName())) {
						
					((DefaultTableModel)table.getModel()).addRow(new Object[] {tempstring,spinner_salads.getValue(),(p.getPrice()*((Integer)spinner_salads.getValue()))+""});
						
					TotalP += p.getPrice()*(Integer)spinner_salads.getValue();
					System.out.println(TotalP);
					TotalPrice.setText("" + TotalP);
					}
				}
			}
		});
		saladsButton.setBounds(179, 80, 40, 25);
		panel.add(saladsButton);
		
		JButton mainCourseButton = new JButton("+");
		mainCourseButton.setFont(new Font("Dialog", Font.BOLD, 11));
		mainCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempstring = (String)mainCourseComboBox.getSelectedItem();
				for(Product p:mainCourse) {
					if(tempstring.equals(p.getName())) {
						
					((DefaultTableModel)table.getModel()).addRow(new Object[] {tempstring,spinner_mainCourse.getValue(),(p.getPrice()*((Integer)spinner_mainCourse.getValue()))+""});
						
					TotalP += p.getPrice()*(Integer)spinner_mainCourse.getValue();
					System.out.println(TotalP);
					TotalPrice.setText("" + TotalP);
					}
				}				
			}
		});
		mainCourseButton.setBounds(179, 166, 40, 25);
		panel.add(mainCourseButton);
		
		JLabel label = new JLabel("\u039D\u03AD\u03B1 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(10, 10, 166, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u03A3\u03B1\u03BB\u03AC\u03C4\u03B5\u03C2 - \u039F\u03C1\u03B5\u03BA\u03C4\u03B9\u03BA\u03AC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(31, 47, 198, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u039A\u03C5\u03C1\u03AF\u03C9\u03C2 \u03A0\u03B9\u03AC\u03C4\u03BF");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(31, 134, 198, 22);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("\u03A0\u03BF\u03C4\u03AC - \u0391\u03C8\u03B5\u03C8\u03AE\u03BC\u03B1\u03C4\u03B1");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(31, 212, 198, 22);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u0395\u03C0\u03B9\u03B4\u03CC\u03C1\u03C0\u03B9\u03BF");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(31, 294, 198, 22);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(710, 358, 67, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u0391\u03C1.\u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(608, 362, 95, 14);
		panel.add(label_3);
		
		JButton button = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1\u03C2");
		button.setForeground(new Color(0, 0, 204));
		button.setBounds(421, 326, 175, 26);
		panel.add(button);
	}
}