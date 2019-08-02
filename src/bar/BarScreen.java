package bar;

import controllers.Main;
import controllers.Registry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public final class BarScreen extends JFrame{
    private static BarScreen INSTANCE = null;
    private JList list;
    private int Quantity;
    private JList list_1;
    private JTable table;
    private JTextField orderChargeField;
    private Double barCharge = 0.0;
    private ArrayList<Product> deserts = new ArrayList<>();
    private ArrayList<Product> drinks = new ArrayList<>();
    private ArrayList<Product> salads = new ArrayList<>();
    private ArrayList<Product> mainCourse = new ArrayList<>();
    private JTextField roomNoField;

    private BarScreen(){
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                setVisible(false);
                Main.HS.setVisible(true);
            }
        });

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        initialize();
    }

    public static BarScreen getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BarScreen();
        else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

    private void initialize(){

        setVisible(true);
        setResizable(false);
        setTitle("Εστιατόριο-Μπαρ");
        setBounds(0, 0, 807, 429);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        setLocationRelativeTo(null);

        deserts.add(new Product("Πανακότα", 3));
        deserts.add(new Product("Παγωτό (1 μπάλα)", 2));
        deserts.add(new Product("Τάρτα Φρούτων", 2.5));
        deserts.add(new Product("Τρίγωνο Πανοράματος", 1.5));
        deserts.add(new Product("Καριόκα", 1));

        drinks.add(new Product("Coca-Cola", 1.5));
        drinks.add(new Product("Fanta", 1.5));
        drinks.add(new Product("Sprite", 1.5));
        drinks.add(new Product("Χυμός Πορτοκάλι", 2));
        drinks.add(new Product("Σόδα", 1));

        salads.add(new Product("Ceasar's", 5));
        salads.add(new Product("Χωριάτικη", 3.5));
        salads.add(new Product("Ρόκα", 3));
        salads.add(new Product("Πατατοσαλάτα", 4));

        mainCourse.add(new Product("Μουσακάς", 7));
        mainCourse.add(new Product("Μακαρόνια με κυμά", 6));
        mainCourse.add(new Product("Τσιπούρα", 8));
        mainCourse.add(new Product("Φακές", 7));
        mainCourse.add(new Product("Μπριζόλα με πατάτες", 9));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JSpinner spinner_deserts = new JSpinner();
        spinner_deserts.setModel(new SpinnerNumberModel(1, 1, null, new Integer(1)));
        spinner_deserts.setBounds(138, 324, 45, 22);
        panel.add(spinner_deserts);

        JSpinner spinner_drinks = new JSpinner();
        spinner_drinks.setModel(new SpinnerNumberModel(1, 1, null, new Integer(1)));
        spinner_drinks.setBounds(138, 245, 45, 22);
        panel.add(spinner_drinks);

        JSpinner spinner_salads = new JSpinner();
        spinner_salads.setModel(new SpinnerNumberModel(1, 1, null, new Integer(1)));
        spinner_salads.setBounds(138, 81, 45, 22);
        panel.add(spinner_salads);

        JSpinner spinner_mainCourse = new JSpinner();
        spinner_mainCourse.setModel(new SpinnerNumberModel(1, 1, null, new Integer(1)));
        spinner_mainCourse.setBounds(138, 167, 45, 22);
        panel.add(spinner_mainCourse);

        orderChargeField = new JTextField();
        orderChargeField.setFont(new Font("Tahoma", Font.BOLD, 16));
        orderChargeField.setEditable(false);
        orderChargeField.setText("" + barCharge);
        orderChargeField.setBounds(710, 326, 67, 25);
        panel.add(orderChargeField);
        orderChargeField.setColumns(10);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(244, 11, 533, 313);
        panel.add(scrollPane_1);

        table = new JTable();
        scrollPane_1.setViewportView(table);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"\u03A0\u03C1\u03BF\u03CA\u03CC\u03BD", "\u03A0\u03BF\u03C3\u03CC\u03C4\u03B7\u03C4\u03B1", "\u039C\u03B5\u03C1\u03B9\u03BA\u03CC \u03A3\u03CD\u03BD\u03BF\u03BB\u03BF"}){
            boolean[] columnEditables = new boolean[]{false, false, false};

            public boolean isCellEditable(int row, int column){
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(103);
        table.getColumnModel().getColumn(1).setPreferredWidth(146);
        table.getColumnModel().getColumn(2).setPreferredWidth(132);

        JLabel chargeLabel = new JLabel("\u03A3\u03CD\u03BD\u03BF\u03BB\u03BF (\u20AC):");
        chargeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        chargeLabel.setBounds(608, 325, 99, 26);
        panel.add(chargeLabel);

        JButton deleteButton = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE \u0395\u03C0\u03B9\u03BB\u03B5\u03B3\u03BC\u03AD\u03BD\u03BF\u03C5");
        deleteButton.setForeground(new Color(204, 0, 51));
        deleteButton.addActionListener(arg0 -> {
            try{

                Object temp = (table.getModel().getValueAt(table.getSelectedRow(), 2));
                String tempstring = (String) temp;
                double tempPartialCost = Double.parseDouble(tempstring);

                barCharge = barCharge - tempPartialCost;

                ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
                orderChargeField.setText(barCharge + "");
            } catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "Δεν υπάρχει κάποιο προϊόν για να διαγραφεί.");
            }
        });

        deleteButton.setBounds(244, 326, 175, 26);
        panel.add(deleteButton);

        JComboBox desertsComboBox = new JComboBox();
        desertsComboBox.setModel(new DefaultComboBoxModel(new String[]{"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "\u03A0\u03B1\u03BD\u03B1\u03BA\u03CC\u03C4\u03B1", "\u03A0\u03B1\u03B3\u03C9\u03C4\u03CC (1 \u03BC\u03C0\u03AC\u03BB\u03B1)", "\u03A4\u03AC\u03C1\u03C4\u03B1 \u03A6\u03C1\u03BF\u03CD\u03C4\u03C9\u03BD", "\u03A4\u03C1\u03AF\u03B3\u03C9\u03BD\u03BF \u03A0\u03B1\u03BD\u03BF\u03C1\u03AC\u03BC\u03B1\u03C4\u03BF\u03C2", "\u039A\u03B1\u03C1\u03B9\u03CC\u03BA\u03B1"}));
        desertsComboBox.setBounds(10, 324, 124, 22);
        panel.add(desertsComboBox);

        JComboBox drinksComboBox = new JComboBox();
        drinksComboBox.setModel(new DefaultComboBoxModel(new String[]{"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "Coca-Cola", "Fanta", "Sprite", "\u03A7\u03C5\u03BC\u03CC\u03C2 \u03A0\u03BF\u03C1\u03C4\u03BF\u03BA\u03AC\u03BB\u03B9", "\u03A3\u03CC\u03B4\u03B1"}));
        drinksComboBox.setBounds(10, 245, 124, 22);
        panel.add(drinksComboBox);

        JComboBox saladsComboBox = new JComboBox();
        saladsComboBox.setModel(new DefaultComboBoxModel(new String[]{"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "Ceasar's", "\u03A7\u03C9\u03C1\u03B9\u03AC\u03C4\u03B9\u03BA\u03B7", "\u03A1\u03CC\u03BA\u03B1", "\u03A0\u03B1\u03C4\u03B1\u03C4\u03BF\u03C3\u03B1\u03BB\u03AC\u03C4\u03B1"}));
        saladsComboBox.setBounds(10, 81, 124, 22);
        panel.add(saladsComboBox);

        JComboBox mainCourseComboBox = new JComboBox();
        mainCourseComboBox.setModel(new DefaultComboBoxModel(new String[]{"\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5", "\u039C\u03BF\u03C5\u03C3\u03B1\u03BA\u03AC\u03C2", "\u039C\u03B1\u03BA\u03B1\u03C1\u03CC\u03BD\u03B9\u03B1 \u03BC\u03B5 \u03BA\u03C5\u03BC\u03AC", "\u03A4\u03C3\u03B9\u03C0\u03BF\u03CD\u03C1\u03B1", "\u03A6\u03B1\u03BA\u03AD\u03C2", "\u039C\u03C0\u03C1\u03B9\u03B6\u03CC\u03BB\u03B1 \u03BC\u03B5 \u03C0\u03B1\u03C4\u03AC\u03C4\u03B5\u03C2"}));
        mainCourseComboBox.setBounds(10, 166, 124, 22);
        panel.add(mainCourseComboBox);

        JButton drinksButton = new JButton("+");
        drinksButton.setFont(new Font("Dialog", Font.BOLD, 11));
        drinksButton.addActionListener(e -> {
            String tempstring = (String) drinksComboBox.getSelectedItem();
            for (Product p : drinks){
                if (tempstring.equals(p.getName())){
                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{tempstring, spinner_drinks.getValue(), (p.getPrice() * ((Integer) spinner_drinks.getValue())) + ""});

                    barCharge += p.getPrice() * (Integer) spinner_drinks.getValue();
                    orderChargeField.setText("" + barCharge);
                }
            }
        });
        drinksButton.setBounds(189, 245, 40, 25);
        panel.add(drinksButton);

        JButton desertsButton = new JButton("+");
        desertsButton.setFont(new Font("Dialog", Font.BOLD, 11));
        desertsButton.addActionListener(e -> {
            String tempstring = (String) desertsComboBox.getSelectedItem();
            for (Product p : deserts){
                if (tempstring.equals(p.getName())){

                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{tempstring, spinner_deserts.getValue(), (p.getPrice() * ((Integer) spinner_deserts.getValue())) + ""});

                    barCharge += p.getPrice() * (Integer) spinner_deserts.getValue();
                    orderChargeField.setText("" + barCharge);
                }
            }
        });
        desertsButton.setBounds(189, 324, 40, 25);
        panel.add(desertsButton);

        JButton saladsButton = new JButton("+");
        saladsButton.setFont(new Font("Dialog", Font.BOLD, 11));
        saladsButton.addActionListener(e -> {
            String tempstring = (String) saladsComboBox.getSelectedItem();
            for (Product p : salads){
                if (tempstring.equals(p.getName())){

                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{tempstring, spinner_salads.getValue(), (p.getPrice() * ((Integer) spinner_salads.getValue())) + ""});

                    barCharge += p.getPrice() * (Integer) spinner_salads.getValue();
                    orderChargeField.setText("" + barCharge);
                }
            }
        });
        saladsButton.setBounds(189, 81, 40, 25);
        panel.add(saladsButton);

        JButton mainCourseButton = new JButton("+");
        mainCourseButton.setFont(new Font("Dialog", Font.BOLD, 11));
        mainCourseButton.addActionListener(e -> {
            String tempstring = (String) mainCourseComboBox.getSelectedItem();
            for (Product p : mainCourse){
                if (tempstring.equals(p.getName())){

                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{tempstring, spinner_mainCourse.getValue(), (p.getPrice() * ((Integer) spinner_mainCourse.getValue())) + ""});

                    barCharge += p.getPrice() * (Integer) spinner_mainCourse.getValue();
                    orderChargeField.setText("" + barCharge);
                }
            }
        });
        mainCourseButton.setBounds(189, 167, 40, 25);
        panel.add(mainCourseButton);

        JLabel newOrderLabel = new JLabel("\u039D\u03AD\u03B1 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1");
        newOrderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        newOrderLabel.setBounds(10, 10, 166, 25);
        panel.add(newOrderLabel);

        JLabel saladsLabel = new JLabel("\u03A3\u03B1\u03BB\u03AC\u03C4\u03B5\u03C2 - \u039F\u03C1\u03B5\u03BA\u03C4\u03B9\u03BA\u03AC");
        saladsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        saladsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        saladsLabel.setBounds(31, 47, 198, 22);
        panel.add(saladsLabel);

        JLabel mainCourseLabel = new JLabel("\u039A\u03C5\u03C1\u03AF\u03C9\u03C2 \u03A0\u03B9\u03AC\u03C4\u03BF");
        mainCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainCourseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        mainCourseLabel.setBounds(31, 134, 198, 22);
        panel.add(mainCourseLabel);

        JLabel drinksLabel = new JLabel("\u03A0\u03BF\u03C4\u03AC - \u0391\u03C6\u03B5\u03C8\u03AE\u03BC\u03B1\u03C4\u03B1");
        drinksLabel.setHorizontalAlignment(SwingConstants.CENTER);
        drinksLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        drinksLabel.setBounds(31, 212, 198, 22);
        panel.add(drinksLabel);

        JLabel desertsLabel = new JLabel("\u0395\u03C0\u03B9\u03B4\u03CC\u03C1\u03C0\u03B9\u03BF");
        desertsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        desertsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        desertsLabel.setBounds(31, 294, 198, 22);
        panel.add(desertsLabel);

        roomNoField = new JTextField();
        roomNoField.setBounds(710, 358, 67, 22);
        panel.add(roomNoField);
        roomNoField.setColumns(10);

        JLabel roomNoLabel = new JLabel("\u0391\u03C1.\u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5:");
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        roomNoLabel.setBounds(608, 362, 95, 14);
        panel.add(roomNoLabel);

        JButton sendOrderButton = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1\u03C2");
        sendOrderButton.addActionListener(e -> {

            try{
                if (table.getModel().getRowCount() == 0){
                    JOptionPane.showMessageDialog(null, "Δεν έχει προστεθεί κάποιο προϊόν");
                } else{
                    if (Registry.addChargeToReservation(Integer.parseInt(roomNoField.getText()), barCharge)){
                        JOptionPane.showMessageDialog(null, "Η παραγγελία έχει καταχωρηθεί επιτυχώς.");
                    } else{
                        JOptionPane.showMessageDialog(null, "Δεν είναι δυνατή η παραγγελία για αυτό το δωμάτιο. Πληκτρολογήστε έναν άλλον αριθμό δωματίου.");
                    }
                }
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Συμπληρώστε έγκυρο αριθμό δωματίου.");
            }

        });
        sendOrderButton.setForeground(new Color(0, 0, 204));
        sendOrderButton.setBounds(421, 326, 175, 26);
        panel.add(sendOrderButton);
    }

}