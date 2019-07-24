package controllers;

import bar.BarScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class HomeScreen extends JFrame{

    private static HomeScreen INSTANCE = null;
    private LoginScreen LS;
    private BarScreen BS;

    private HomeScreen(){
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){

                FileHandling.saveReservationsToFile();
                FileHandling.saveRoomsToFile();

            }
        });

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ignored){
        }
        initialize();
    }

    public static HomeScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new HomeScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

    private void initialize(){
        setVisible(true);
        setResizable(false);
        setTitle("\u03A3\u03CD\u03C3\u03C4\u03B7\u03BC\u03B1 \u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7\u03C2 \u039E\u03B5\u03BD\u03BF\u03B4\u03BF\u03C7\u03B5\u03AF\u03BF\u03C5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 643, 187);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{206, 196, 204, 0};
        gbl_contentPane.rowHeights = new int[]{72, 62, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton viewBarButton = new JButton("\u0395\u03C3\u03C4\u03B9\u03B1\u03C4\u03CC\u03C1\u03B9\u03BF-\u039C\u03C0\u03B1\u03C1");
        viewBarButton.addActionListener(arg0 -> LoginScreen.getInstance().setVisible(true));

        JButton viewReservationsButton = new JButton("\u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7 \u039A\u03C1\u03B1\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
        viewReservationsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        viewReservationsButton.addActionListener(arg0 -> LoginScreen.getInstance().setVisible(true));

        JButton viewActivitiesButton = new JButton("\u0394\u03C1\u03B1\u03C3\u03C4\u03B7\u03C1\u03B9\u03CC\u03C4\u03B7\u03C4\u03B5\u03C2");
        viewActivitiesButton.addActionListener(e -> LoginScreen.getInstance().setVisible(true));

        JLabel label = new JLabel("\u03A3\u03CD\u03C3\u03C4\u03B7\u03BC\u03B1 \u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7\u03C2 \u039E\u03B5\u03BD\u03BF\u03B4\u03BF\u03C7\u03B5\u03AF\u03BF\u03C5");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 27));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.BOTH;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridwidth = 3;
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
        GridBagConstraints gbc_viewReservationsButton = new GridBagConstraints();
        gbc_viewReservationsButton.fill = GridBagConstraints.BOTH;
        gbc_viewReservationsButton.insets = new Insets(0, 0, 0, 5);
        gbc_viewReservationsButton.gridx = 0;
        gbc_viewReservationsButton.gridy = 1;
        contentPane.add(viewReservationsButton, gbc_viewReservationsButton);
        viewBarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_viewBarButton = new GridBagConstraints();
        gbc_viewBarButton.fill = GridBagConstraints.BOTH;
        gbc_viewBarButton.insets = new Insets(0, 0, 0, 5);
        gbc_viewBarButton.gridx = 1;
        gbc_viewBarButton.gridy = 1;
        contentPane.add(viewBarButton, gbc_viewBarButton);

        viewActivitiesButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_viewActivitiesButton = new GridBagConstraints();
        gbc_viewActivitiesButton.fill = GridBagConstraints.BOTH;
        gbc_viewActivitiesButton.gridx = 2;
        gbc_viewActivitiesButton.gridy = 1;
        contentPane.add(viewActivitiesButton, gbc_viewActivitiesButton);
    }

}
