package reservations;

import com.toedter.calendar.JDateChooser;
import controllers.Main;
import controllers.Registry;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class ReservationsScreen extends JFrame{

    static final int CHARGE_PER_NIGHT_1B = 35; //XREOSI ANA VRADI GIA x BEDS
    static final int CHARGE_PER_NIGHT_2B = 70;
    static final int CHARGE_PER_NIGHT_3B = 100;
    static final int CHARGE_PER_NIGHT_4B = 120;
    private static JTable reservationsTable;
    private JTextField nameField;
    private Reservation reservation;
    private JTextField roomNoField;
    private int nightStays;
    private int tempType = 0;
    private int tempCostForLabel = 0;

    /**
     * Create the application.
     */

    public ReservationsScreen(){

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

    private void initialize(){

        setVisible(false);
        setTitle("\u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7 \u039A\u03C1\u03B1\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
        setResizable(false);
        setBounds(100, 100, 996, 503);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        nameField = new JTextField();
        nameField.setBounds(125, 61, 200, 30);
        panel.add(nameField);
        nameField.setColumns(10);

        JButton bookRoomBtn = new JButton("\u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7 \u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5");
        bookRoomBtn.setForeground(new Color(0, 0, 0));
        bookRoomBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bookRoomBtn.setBounds(76, 410, 203, 46);
        panel.add(bookRoomBtn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(335, 17, 640, 400);
        panel.add(scrollPane);

        reservationsTable = new JTable();
        reservationsTable.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        reservationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reservationsTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"\u0391\u03C1.\u0394\u03C9\u03BC.", "\u039F\u03BD\u03BF\u03BC\u03B1\u03C4\u03B5\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF", "\u03A4\u03CD\u03C0\u03BF\u03C2 \u0394\u03C9\u03BC.", "\u039A\u03CC\u03C3\u03C4\u03BF\u03C2 \u0394\u03B9\u03B1\u03BC\u03BF\u03BD\u03AE\u03C2 (\u20AC)", "\u03A3\u03C5\u03BD. \u03A7\u03C1\u03AD\u03C9\u03C3\u03B7 (\u20AC)"}){
            Class[] columnTypes = new Class[]{Integer.class, Object.class, Object.class, Object.class, Object.class};

            public Class getColumnClass(int columnIndex){
                return columnTypes[columnIndex];
            }
        });
        reservationsTable.getColumnModel().getColumn(0).setResizable(false);
        reservationsTable.getColumnModel().getColumn(0).setPreferredWidth(53);
        reservationsTable.getColumnModel().getColumn(1).setResizable(false);
        reservationsTable.getColumnModel().getColumn(1).setPreferredWidth(222);
        reservationsTable.getColumnModel().getColumn(2).setResizable(false);
        reservationsTable.getColumnModel().getColumn(2).setPreferredWidth(89);
        reservationsTable.getColumnModel().getColumn(3).setResizable(false);
        reservationsTable.getColumnModel().getColumn(3).setPreferredWidth(130);
        reservationsTable.getColumnModel().getColumn(4).setResizable(false);
        reservationsTable.getColumnModel().getColumn(4).setPreferredWidth(104);

        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentShown(ComponentEvent e){
                ((DefaultTableModel) reservationsTable.getModel()).fireTableDataChanged();
            }
        });
        scrollPane.setViewportView(reservationsTable);

        JLabel nameLabel = new JLabel("\u039F\u03BD\u03BF\u03BC\u03B1\u03C4\u03B5\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameLabel.setBounds(20, 69, 95, 14);
        panel.add(nameLabel);

        JRadioButton oneBed = new JRadioButton("\u039C\u03BF\u03BD\u03CC\u03BA\u03BB\u03B9\u03BD\u03BF (35\u20AC/\u03B2\u03C1\u03AC\u03B4\u03C5)");
        oneBed.setFont(new Font("SansSerif", Font.BOLD, 12));
        oneBed.addItemListener(arg0 -> {
        });

        oneBed.setActionCommand("\u039C\u03BF\u03BD\u03CC\u03BA\u03BB\u03B9\u03BD\u03BF (35\u20AC/\u039D\u03CD\u03C7\u03C4\u03B1)");
        oneBed.setBounds(125, 117, 180, 23);
        panel.add(oneBed);

        JRadioButton twoBeds = new JRadioButton("\u0394\u03AF\u03BA\u03BB\u03B9\u03BD\u03BF(70\u20AC/\u03B2\u03C1\u03AC\u03B4\u03C5)");
        twoBeds.setFont(new Font("SansSerif", Font.BOLD, 12));
        twoBeds.addItemListener(arg0 -> {
        });
        twoBeds.setBounds(125, 143, 180, 23);
        panel.add(twoBeds);

        JRadioButton threeBeds = new JRadioButton("\u03A4\u03C1\u03AF\u03BA\u03BB\u03B9\u03BD\u03BF (100\u20AC/\u03B2\u03C1\u03AC\u03B4\u03C5)");
        threeBeds.setFont(new Font("SansSerif", Font.BOLD, 12));
        threeBeds.addItemListener(arg0 -> {
        });
        threeBeds.setBounds(125, 169, 180, 23);
        panel.add(threeBeds);

        JRadioButton fourBeds = new JRadioButton("\u03A4\u03B5\u03C4\u03C1\u03AC\u03BA\u03BB\u03B9\u03BD\u03BF (120\u20AC/\u03B2\u03C1\u03AC\u03B4\u03C5)");
        fourBeds.setFont(new Font("SansSerif", Font.BOLD, 12));
        fourBeds.setBounds(125, 195, 180, 23);
        panel.add(fourBeds);

        JLabel roomTypeLabel = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u0394\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5");
        roomTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        roomTypeLabel.setBounds(20, 121, 95, 14);
        panel.add(roomTypeLabel);

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(oneBed);
        radioButtonGroup.add(twoBeds);
        radioButtonGroup.add(threeBeds);
        radioButtonGroup.add(fourBeds);

        JLabel label_1 = new JLabel("\u0394\u03B9\u03B1\u03BC\u03BF\u03BD\u03AE (\u03B2\u03C1\u03AC\u03B4\u03B9\u03B1):");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(83, 299, 114, 23);
        panel.add(label_1);

        JLabel label_2 = new JLabel("\u0391\u03C0\u03CC:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        label_2.setBounds(76, 240, 46, 14);
        panel.add(label_2);

        JLabel lblNewLabel = new JLabel("\u039C\u03AD\u03C7\u03C1\u03B9:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(76, 270, 46, 14);
        panel.add(lblNewLabel);

        JLabel staysLabel = new JLabel("--");
        staysLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        staysLabel.setBounds(207, 303, 46, 14);
        panel.add(staysLabel);

        JLabel label = new JLabel("\u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7 \u039A\u03C1\u03B1\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
        label.setFont(new Font("Tahoma", Font.BOLD, 23));
        label.setBounds(10, 11, 295, 30);
        panel.add(label);

        JButton DeleteClient = new JButton("\u03A4\u03AD\u03BB\u03BF\u03C2 \u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7\u03C2");
        DeleteClient.setForeground(new Color(128, 0, 0));
        DeleteClient.setBounds(679, 424, 296, 30);
        panel.add(DeleteClient);

        JLabel lblNewLabel_1 = new JLabel("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03CC \u03BA\u03CC\u03C3\u03C4\u03BF\u03C2 \u03B4\u03B9\u03B1\u03BC\u03BF\u03BD\u03AE\u03C2 (\u20AC):");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(76, 341, 203, 30);
        panel.add(lblNewLabel_1);

        JLabel costLabel = new JLabel("-- ");
        costLabel.setForeground(new Color(85, 107, 47));
        costLabel.setHorizontalAlignment(SwingConstants.CENTER);
        costLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        costLabel.setBounds(76, 369, 203, 35);
        panel.add(costLabel);

        roomNoField = new JTextField();

        roomNoField.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent arg0){
                roomNoField.setText(null);
            }
        });
        roomNoField.setText("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03C0\u03B5\u03BB\u03AC\u03C4\u03B7/\u03B1\u03C1.\u03B4\u03C9\u03BC\u03B1\u03C4\u03AF\u03BF\u03C5...");

        roomNoField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent arg0){
                if (roomNoField.getText() != null){
                    DefaultTableModel tableModel = (DefaultTableModel) reservationsTable.getModel();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
                    String search = roomNoField.getText().toUpperCase();

                    reservationsTable.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
                }
            }
        });
        roomNoField.setBounds(335, 424, 334, 32);
        panel.add(roomNoField);
        roomNoField.setColumns(10);

        reservationsTable.getTableHeader().setReorderingAllowed(false);

        JDateChooser fromDate = new JDateChooser();
        JDateChooser toDate = new JDateChooser();
        toDate.getCalendarButton().addActionListener(arg0 -> {
        });

        oneBed.addActionListener(arg0 -> {
            tempType = 1;
            costLabel.setText((Integer.toString(tempCostForLabel)));
            fromDate.updateUI();
        });
        twoBeds.addActionListener(arg0 -> {
            tempType = 2;
            costLabel.setText((Integer.toString(tempCostForLabel)));
            fromDate.updateUI();
        });
        threeBeds.addActionListener(arg0 -> {
            tempType = 3;
            costLabel.setText((Integer.toString(tempCostForLabel)));
            fromDate.updateUI();
        });
        fourBeds.addActionListener(arg0 -> {
            tempType = 4;
            costLabel.setText((Integer.toString(tempCostForLabel)));
            fromDate.updateUI();
        });

        reservationsTable.setDefaultEditor(Object.class, null);

        fromDate.addPropertyChangeListener(arg0 -> {
            try{
                LocalDate from = LocalDate.fromDateFields(fromDate.getDate());
                LocalDate to = LocalDate.fromDateFields(toDate.getDate());
                nightStays = Days.daysBetween(from, to).getDays();

                if (nightStays > 0){
                    int tempCost = 0;
                    if (tempType == 1)
                        tempCost = CHARGE_PER_NIGHT_1B * nightStays;
                    else if (tempType == 2)
                        tempCost = CHARGE_PER_NIGHT_2B * nightStays;
                    else if (tempType == 3)
                        tempCost = CHARGE_PER_NIGHT_3B * nightStays;
                    else
                        tempCost = CHARGE_PER_NIGHT_4B * nightStays;
                    tempCostForLabel = tempCost;

                    staysLabel.setText(Integer.toString(nightStays));
                    costLabel.setText((Integer.toString(tempCost)));
                } else{
                    staysLabel.setText("--");
                    costLabel.setText("-- ");
                    JOptionPane.showMessageDialog(null, "Επιλέξτε ημερομηνία check-out μεταγενέστερη της ημερομηνίας check-in.");
                }
            } catch (IllegalArgumentException e){
            }
        });

        fromDate.setBounds(120, 237, 146, 25);
        panel.add(fromDate);

        toDate.addPropertyChangeListener(evt -> {

            try{
                LocalDate from = LocalDate.fromDateFields(fromDate.getDate());
                LocalDate to = LocalDate.fromDateFields(toDate.getDate());
                nightStays = Days.daysBetween(from, to).getDays();

                if (nightStays > 0){
                    int tempCost = 0;
                    if (tempType == 1)
                        tempCost = CHARGE_PER_NIGHT_1B * nightStays;
                    else if (tempType == 2)
                        tempCost = CHARGE_PER_NIGHT_2B * nightStays;
                    else if (tempType == 3)
                        tempCost = CHARGE_PER_NIGHT_3B * nightStays;
                    else if (tempType == 4)
                        tempCost = CHARGE_PER_NIGHT_4B * nightStays;

                    staysLabel.setText(Integer.toString(nightStays));
                    costLabel.setText((Integer.toString(tempCost)));
                } else{
                    staysLabel.setText("--");
                    costLabel.setText("-- ");
                    JOptionPane.showMessageDialog(null, "Επιλέξτε ημερομηνία check-out μεταγενέστερη της ημερομηνίας check-in.");
                }
            } catch (IllegalArgumentException e){
            }
        });
        toDate.setBounds(120, 265, 146, 25);
        panel.add(toDate);

        DeleteClient.addActionListener(arg0 -> {
            if (reservationsTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Δεν έχει επιλεχθεί κράτηση.");
            } else{
                Integer selectedRoomNumber = (Integer) reservationsTable.getModel().getValueAt(reservationsTable.getSelectedRow(), 0);

                for (Reservation rsv : Registry.reservations){

                    if (rsv.getRoom().getRoomNumber() == selectedRoomNumber){

                        Registry.reservations.remove(rsv);
                        ((DefaultTableModel) reservationsTable.getModel()).removeRow(reservationsTable.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Η κράτηση του δωματίου " + selectedRoomNumber + " διαγράφηκε επιτυχώς.");
                        break;
                    }

                }

                for (Room room : Registry.rooms){
                    if (room.getRoomNumber() == selectedRoomNumber){
                        room.setFree(true);
                        break;
                    }
                }

                roomNoField.setText(" ");  // adeiazo to textfield, kai pleon den efarmozetai kanena filtro sto jtable

                try{
                    roomNoField.requestFocus();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                } catch (Exception exp){
                    exp.printStackTrace();
                }
            }
        });

        bookRoomBtn.addActionListener(arg0 -> {
            String tempName = nameField.getText();
            boolean isEverythingFilled = true;

            if (tempName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Παρακαλώ εισάγετε ονοματεπώνυμο");
                isEverythingFilled = false;
            }

            if (radioButtonGroup.getSelection() == null){
                JOptionPane.showMessageDialog(panel, "Παρακαλώ επιλέξτε τύπο δωματίου!");
                isEverythingFilled = false;
            }

            if (isEverythingFilled){ //an exoun simplirothei ta aparaitita stoixeia sto gui tote

                Room availableRoom = Registry.returnAvailableRoom(tempType);//psakse an iparxei diathesimo dwmatio tou epithimitoy typou, an nai epestrepse to

                if (availableRoom != null){ //an iparxei domatio tote kane tin kratisi kai valtin sti lista

                    availableRoom.setFree(false);
                    int tempRoomNumber = availableRoom.getRoomNumber();

                    try{
                        reservation = new Reservation(tempName, availableRoom, Integer.parseInt(costLabel.getText()), Double.parseDouble(costLabel.getText()));
                        Registry.reservations.add(reservation);

                        JOptionPane.showMessageDialog(null, "Η κράτηση έγινε επιτυχώς!" + "\n" + "Στοιχεία: " + "\n" + "Αριθμός δωματίου:" + tempRoomNumber + "\n" + "Όνοματεπώνυμο: " + tempName + "\n" + "Τύπος δωματίου: " + tempType + "κλινο\n");

                        ((DefaultTableModel) reservationsTable.getModel()).addRow(new Object[]{tempRoomNumber, tempName, tempType + "κλινο", Integer.parseInt(costLabel.getText()), Double.parseDouble(costLabel.getText())});
                        staysLabel.setText("--");
                        costLabel.setText("-- ");
                        fromDate.setCalendar(null);
                        toDate.setCalendar(null);
                        nameField.setText(null);
                        radioButtonGroup.clearSelection();
                    } catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Παρακαλώ επιλέξτε ημερομηνίες check-in και check-out.");
                    }
                } else
                    JOptionPane.showMessageDialog(null, "Δεν υπάρχει διαθέσιμο δωμάτιο του επιλεγμένου τύπου."); //an den iparxei domatio emfanise minima
            }

            for (Reservation r : Registry.reservations){
                System.out.println(r.getClientName());
            }
        });
    }

    public void updateChargeInTable(int roomNo){
        double tempCharge = 0;
        for (Reservation r : Registry.reservations){
            if (roomNo == r.getRoom().getRoomNumber()){
                tempCharge = r.getTotalCharge();
            }

            for (int i = 0; i < reservationsTable.getRowCount(); i++){
                if (reservationsTable.getModel().getValueAt(i, 0).equals(roomNo)){
                    reservationsTable.getModel().setValueAt(tempCharge, i, 4);
                }
            }
        }
    }

    public void addReservationsToTable(){
        for (Reservation rsv : Registry.reservations){
            ((DefaultTableModel) reservationsTable.getModel()).addRow(new Object[]{rsv.getRoom().getRoomNumber(), rsv.getClientName(), rsv.getRoom().getRoomType() + "κλινο", rsv.getStayCharge(), rsv.getTotalCharge()});
        }
    }

}