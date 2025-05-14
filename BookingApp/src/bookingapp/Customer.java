/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author kareem bakr
 */
public class Customer extends User{
    private int loyalityPoints=0;
    private Priceplan myplan ;
    private ArrayList<Room> purchaseHistoryRoom=new ArrayList<>();
    private ArrayList<LocalDate> purchaseHistoryDate=new ArrayList<>();
    //constractor
   public Customer(String name ,String pasword,String phone){super(name, pasword, phone);}
   public  Customer(String name ,String email,String pasword,String phone){super(name, email,pasword, phone);}
 public Customer(){super();}
    
   //setters and getters  
    public int getLoyalityPints(){return loyalityPoints;}
    public Priceplan getPriceplan(){return myplan;};
    public void bookRoom(Room room){
        room.book();
        purchaseHistoryRoom.add(room);
        purchaseHistoryDate.add(LocalDate.now());
        loyalityPoints+=0.1*room.getPrice();
}
    
    public void changePlan(Priceplan newplan){
        myplan=newplan;
}
    
    
    
}
