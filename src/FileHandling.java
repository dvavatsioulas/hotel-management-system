import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandling {

	public FileHandling() {
	
		ArrayList<Reservation> rsv = new ArrayList<>(); 
		rsv.clear();
		
		try
	    {
	        FileInputStream fis = new FileInputStream("RoomsData.db");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	
	        Registry.rooms = (ArrayList) ois.readObject();
	
	        ois.close();
	        fis.close();
	    }
	    catch (IOException ioe)
	    {
	        ioe.printStackTrace();
	        return;
	    }
	    catch (ClassNotFoundException c)
	    {
	        System.out.println("Class not found");
	        c.printStackTrace();
	        return;
	    }
		
		//************************************************
		
		try
	    {
	        FileInputStream fis = new FileInputStream("ReservationsData.db");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	
	        Registry.reservations = (ArrayList) ois.readObject();
	
	        ois.close();
	        fis.close();
	    }
	    catch (IOException ioe)
	    {
	        ioe.printStackTrace();
	        return;
	    }
	    catch (ClassNotFoundException c)
	    {
	        System.out.println("Class not found");
	        c.printStackTrace();
	        return;
	    }
		
		
		
		
		
		/*try
        {
            FileOutputStream fos = new FileOutputStream("ReservationsData.db");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(rsv);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }*/
		
		
		
		
		
		
	}
	
}
	/*private ArrayList<Room> r = new ArrayList<>();
	
	public FileHandling() {
		
		r.add(new Room(101,1,true));
		r.add(new Room(102,2,true));
		r.add(new Room(103,1,true));
		r.add(new Room(104,3,true));
		r.add(new Room(105,2,true));
		r.add(new Room(106,4,true));
		
		r.add(new Room(201,3,true));
		r.add(new Room(202,1,true));
		r.add(new Room(203,1,true));
		r.add(new Room(204,3,true));
		r.add(new Room(205,2,true));
		r.add(new Room(206,2,true));
		r.add(new Room(207,4,true));
		r.add(new Room(208,3,true));
		
		try
        {
            FileOutputStream fos = new FileOutputStream("RoomData.db");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(r);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
		
	}*/
	

	
	
	

