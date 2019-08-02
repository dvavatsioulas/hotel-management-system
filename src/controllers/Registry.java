package controllers;

import reservations.Reservation;
import reservations.ReservationsScreen;
import reservations.Room;

import java.util.ArrayList;
import java.util.Random;

public abstract class Registry{
    static final int DOMATIA_PROTOU_OROFOU = 10;
    static final int DOMATIA_DEUTEROU_OROFOU = 14;
    static final int DOMATIA_TRITOU_OROFOU = 18;

    public static ArrayList<Reservation> reservations = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static Random random = new Random();

    public static ReservationsScreen RS = new ReservationsScreen();

    public static void createRooms(){ // dimiourgoume tin lista me ta domatia tou ksenodoxeioy. o arithmos ton krevatiwn epilegetai apo ti random gia kathe domatio
        int i;

        for (i = 101; i < 101 + DOMATIA_PROTOU_OROFOU; i++) //PROTOS OROFOS
            rooms.add(new reservations.Room(i, random.nextInt(4) + 1, true));

        for (i = 201; i < 201 + DOMATIA_DEUTEROU_OROFOU; i++) //DEUTEROS OROFOS
            rooms.add(new reservations.Room(i, random.nextInt(4) + 1, true));

        for (i = 301; i < 301 + DOMATIA_TRITOU_OROFOU; i++) //TRITOS OROFOS
            rooms.add(new reservations.Room(i, random.nextInt(4) + 1, true));
    }

    public static ArrayList<Reservation> getReservations(){
        return reservations;
    }

    public static Room returnAvailableRoom(int roomType){ //elegxei an iparxei diathesimo dwmatio toy epithimitoy typou, kai an yparxei epistrefei to dwmatio kai kanei to isFree=false
        Room selectedRoom = null;
        for (Room r : rooms){
            if (roomType == r.getRoomType() && r.isFree()){
                selectedRoom = r;
                //r.setFree(false);
                break;
            }
        }
        return selectedRoom;
    }

    public static boolean addChargeToReservation(int roomNo, double charge){
        for (Reservation r : reservations){
            if (roomNo == r.getRoom().getRoomNumber()){
                double previousCharge = r.getTotalCharge();

                r.setTotalCharge(previousCharge + charge);
                Registry.RS.updateChargeInTable(roomNo);
                return true;
            }
        }
        return false;
    }
}