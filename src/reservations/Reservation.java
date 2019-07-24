package reservations;

import java.io.Serializable;

public class Reservation implements Serializable{
    private String clientName;
    private Room room;
    private int stayCharge;
    private double totalCharge;

    public Reservation(String name, Room room, int stayCharge, double totalCost) //to stayCharge anaferetai stin xreosi gia ti diamoni. to totalCost einai to SINOLIKO
    //poso pou tha plirosei gia diamoni+bar+drastiriotites
    {
        this.clientName = name;
        this.room = room;
        this.stayCharge = stayCharge;
        this.totalCharge = totalCost;
    }

    public Room getRoom(){
        return room;
    }

    public String getClientName(){
        return clientName;
    }

    public double getTotalCharge(){
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge){
        this.totalCharge = totalCharge;
    }

    public int getStayCharge(){
        return stayCharge;
    }

}