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
public abstract class User implements Notifable{
    private int userID;
    private static int forUserID=123;
    private String phone;
    private String name;
    private String email;
    private String pasword;              //we shouldn't read password
    protected boolean deactivated=false; 
    private boolean log;
    private ArrayList<String> notification = new ArrayList<>();
    //constractors
    
    public User(String name,String email,String pasword,String phone){
    userID=200000+forUserID;
    forUserID++;
    this.name=name;
    this.email=email;
    this.pasword=pasword;
    this.phone=phone;
        System.out.println("user added succscfully");
    }
    public User(String name,String pasword,String phone){
    userID=200000+forUserID;
    forUserID++;
    this.name=name;
    this.pasword=pasword;
    this.phone=phone;
    System.out.println("user added succscfully");

    }
    
    public User(){
       throw new UnsupportedOperationException("invalid user data");
    }
//try catch if user entererd a constractor empty
    //loging
    public void login(){log=true;}
    public void logout(){log=false;}
    //cahnge data
    public void changePhone(String newPhone){phone=newPhone;}
    public void changeName(String newName){name=newName;}
    public void changeEmail(String newEmail){email=newEmail;}
    public String changePassword(String newPassword,String oldPassword){
        if(pasword.equals(oldPassword)){
            pasword=newPassword;
               return " Password  Changed successfully";
                }
        else{
            return "Incorect Old Password ";}
    }

    //print data
    public void printUserData(){
    System.out.println("User_ID : "+userID);
    System.out.println("Name : "+name);
    System.out.println("Phone : "+phone);
    System.out.println("Email : "+email);
    }
    public int getUserID(){return userID;}
    public String getPhone(){return phone;}
    public String getName(){return name;}
    public String getPassword(){return pasword;}

    public String getEmail(){return email;}
    public boolean logStatue(){return log;}
    
    
    @Override
    public void sendNotification(String message,User user){
    user.reciveNotification(message, name);
    }
    @Override
    public void reciveNotification(String message,String name){
    String notification =name+" : "+message;
    this.notification.add(notification);
    };
    @Override
    public void printNotificatiions(){
    for(int i=0;i>notification.size();i++){
        System.out.println(notification.get(i));
    }
    };

    
}
