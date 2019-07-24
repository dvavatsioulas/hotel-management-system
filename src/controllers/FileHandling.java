package controllers;

import java.io.*;
import java.util.ArrayList;

public class FileHandling{

    public FileHandling(){
    }

    public static void readReservationsFromFile(){
        try{
            File rsv = new File("src/reservations/ReservationsData.db");
            String rsvabs = rsv.getCanonicalPath();
            File file = new File(rsvabs);

            if (file.exists()) System.out.println("iparxei");

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Registry.reservations = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public static void readRoomsFromFile(){
        try{
            File rooms = new File("src/reservations/RoomsData.db");
            String roomsabs = rooms.getCanonicalPath();
            File file = new File(roomsabs);

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Registry.rooms = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public static void saveReservationsToFile(){
        try{
            File rsv = new File("ReservationsData.db");
            rsv.delete();

            FileOutputStream fos = new FileOutputStream("src/reservations/ReservationsData.db");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Registry.reservations);
            oos.close();
            fos.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void saveRoomsToFile(){
        try{

            File rooms = new File("RoomsData.db");
            rooms.delete();

            FileOutputStream fos = new FileOutputStream("src/reservations/RoomsData.db");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Registry.rooms);
            oos.close();
            fos.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}	