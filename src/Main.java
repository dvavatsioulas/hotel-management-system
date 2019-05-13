import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static HomeScreen HS;
	
	public static void main(String[] args) {
		Registry.createRooms(); //DIMIOURGIA DOMATION

		HS = new HomeScreen();

	}
}
