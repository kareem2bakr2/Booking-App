/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;
import java.util.ArrayList;
/**
 *
 * @author kareem bakr
 */
public class Room implements Payable{
    private int roomPrice;
    private int roomNumber;
    private Hotel roomhotel;
    private String type;
    private boolean statue=true;
    private ArrayList<String>roomAmenities=new ArrayList<>();
    //constractor
    public Room(int price ,int roomNumber,Hotel hotel,String type){
    roomPrice=price;
    this.roomNumber=roomNumber;
    roomhotel=hotel;
    hotel.addRoom(this);
    this.type=type;
    };
    //setters and getters
    public boolean isAvailable(){return statue;}
    public void setRoomAvailable(boolean available){statue=available;}
    public void addAmenity(String newamenity){roomAmenities.add(newamenity);}
    public void removeAmenity(String removedamenity){
        for(int i=0;i<roomAmenities.size();i++){
        if (roomAmenities.get(i) == removedamenity){roomAmenities.remove(i);}}
    }
    public String getAmenities(){
    String displayAmenties="";
        for(int i=0;i<roomAmenities.size();i++){
        displayAmenties+=roomAmenities.get(i);
        }    
 
    return displayAmenties;
    }
    public String getType(){return type;}
    public Hotel getHotel(){return roomhotel;}
    public int getRoomNumber(){return roomNumber;}
    public void editRoomNumber(int roomNumber){this.roomNumber=roomNumber;
    if(roomNumber<1)statue=false;}
    public int getPrice(){return roomPrice;};
    public void editRoomPrice(int roomPrice){this.roomPrice=roomPrice;}

    //functions
    public void book(){
            roomNumber--;
            if(roomNumber<1)statue=false;
    
    }

    }

