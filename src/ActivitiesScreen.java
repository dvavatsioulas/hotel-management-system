import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class ActivitiesScreen extends JFrame {

    private static ActivitiesScreen INSTANCE = null;

    private ActivitiesScreen(){
        setResizable(false);

        addWindowListener(new WindowAdapter() {
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

        setVisible(true);
        setTitle("\u0394\u03C1\u03B1\u03C3\u03C4\u03B7\u03C1\u03B9\u03CC\u03C4\u03B7\u03C4\u03B5\u03C2");
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 2, 0, 0));
        setLocationRelativeTo(null);

        JButton gymBtn = new JButton("\u0393\u03C5\u03BC\u03BD\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF");
        gymBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                GymScreen.getInstance().setVisible(true);
            }
        });
        gymBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(gymBtn);

        JButton saunaBtn = new JButton("\u03A3\u03AC\u03BF\u03C5\u03BD\u03B1");
        saunaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //new SaunaScreen();
                SaunaScreen.getInstance().setVisible(true);
            }
        });
        saunaBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(saunaBtn);

        JButton golfBtn = new JButton("Mini Golf");
        golfBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                GolfScreen.getInstance().setVisible(true);
            }
        });
        golfBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(golfBtn);

        JButton masazBtn = new JButton("\u039C\u03B1\u03C3\u03AC\u03B6");
        masazBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MasazScreen.getInstance().setVisible(true);
            }
        });
        masazBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(masazBtn);
    }

    public static ActivitiesScreen getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ActivitiesScreen();
        } else
            INSTANCE.setVisible(true);
        return INSTANCE;
    }

}
