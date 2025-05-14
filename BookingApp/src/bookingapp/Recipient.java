/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;

/**
 *
 * @author kareem bakr
 */
public class Recipient extends Staff{
    float debt=0;
    //constractors
    public Recipient(String name,String email,String pasword,String phone,String position){
    super(name,email,pasword,phone,position);
    }
    public Recipient(String name,String pasword,String phone,String position){
    super(name,pasword,phone,position);
    }
    //setters and getters
    
    public float getDebt(){return debt;}
    //functions
    public void assignRoom(Customer customer,Room room){
        debt=debt+(room.getPrice()-customer.getLoyalityPints())*(1-(customer.getPriceplan().getOffer()));
        customer.bookRoom(room);
    }
}
