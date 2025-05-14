/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;

/**
 *
 * @author kareem bakr
 */
public class Admin extends User{
   //constractors
    public Admin(String name,String email,String pasword,String phone){
    super(name,email,pasword,phone);
    }
    public Admin(String name,String pasword,String phone){
    super(name,pasword,phone);
    }    
    public Admin(){super();}


//functions
    public void activate(User user){user.deactivated=false;}
    public void deactivate(User user){user.deactivated=true;}

}
