/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;

/**
 *
 * @author kareem bakr
 */
public abstract class Staff extends User {
    protected String position;

   //constractors
    public Staff(String name,String email,String pasword,String phone,String position){
    super(name,email,pasword,phone);
    this.position=position;
    }
    public Staff(String name,String pasword,String phone,String position){
    super(name,pasword,phone);
    this.position=position;
    }
    public Staff(){
    super();
    }
    
   //set and get position
   public void promotion(String position,Staff empolyee){}//overriden by manger only can change the position
   public String getPosition(){return position;}
}
