package controllers;

public class Main{

    public static HomeScreen HS;

    public static void main(String[] args){

        FileHandling.readReservationsFromFile(); //diavasma twn kratisewn apo to arxeio
        FileHandling.readRoomsFromFile();         //diavasma twn dwmatiwn apo to arxeio

        Registry.RS.addReservationsToTable();    //prosthiki twn kratisewn sto JTable

        HS = HomeScreen.getInstance();
    }
}
