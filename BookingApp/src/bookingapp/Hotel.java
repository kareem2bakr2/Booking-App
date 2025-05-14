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
public class Hotel {
    private String name;
    private String address;
    private ArrayList<Room> hotelRooms=new ArrayList<Room>();
    private int starRating;
    //constractors
   public Hotel(String name,String address){
   this.name=name;
   this.address=address;
 
   }
    public Hotel(){
    throw new UnsupportedOperationException("invalid user data");
    }
    //setters and getters
    public String getHotelName(){return name;}
    public void editHotelName(String name) {this.name = name;}
    public String getAddress(){return address;}
    public void editAddress(String address) {this.address = address;}
    public ArrayList<Room> getHotelRooms() {return hotelRooms;}
    //public void editHotelRooms(ArrayList<Room> hotelRooms) {this.hotelRooms = hotelRooms;}
    public int getStarRating() {return starRating;}
    public void editStarRating(int starRating) {this.starRating = starRating;}
    
    
    //functions

    public void addRoom(Room room){hotelRooms.add(room);    }       //add new room
    public void removeRoom(int roomNumber)  {                       //remove room
        for (int i =0 ;i<hotelRooms.size();i++)
        if (roomNumber==hotelRooms.get(i).getRoomNumber() )hotelRooms.remove(i);
    }       
    public boolean isAvailable(int roomNumber){
        for (int i =0 ;i<hotelRooms.size();i++){
        if (roomNumber==hotelRooms.get(i).getRoomNumber() ){
            return true;}
        }
        return false;
    }
    
}
