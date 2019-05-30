import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static HomeScreen HS;
	
	public static void main(String[] args) {
		//Registry.createRooms(); //DIMIOURGIA DOMATION
		/*for(Reservation rsv: Registry.reservations) {
			System.out.println(rsv.getClientName());
		}
		
		//System.out.println("asdasd");*/
		
		new FileHandling();
		Registry.RS.addReservationsToTable();
		HS=HomeScreen.getInstance();

		
		
	}
}
