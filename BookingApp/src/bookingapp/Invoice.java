/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;
import java.time.LocalDate;
import java.util.Random;
/**
 *
 * @author kareem bakr
 */
public class Invoice implements Payable{
    private int InvoiceID;
    private LocalDate issueDate;
    private Customer customer;
    private Room reservedRoom;
    private int invoicePrice;
    final float taxRate=0.14f;

    Random rand = new Random();
    //booking app user
    private static Manager app=new Manager("Booking App", "Booking@YAhoo.com", "nologin", "01123", "APP");
    //constractor
   
        public Invoice(Customer customer,Room reservedRoom){
        InvoiceID=rand.nextInt(100);
        InvoiceID=InvoiceID+(rand.nextInt(100)*100);
        this.InvoiceID=InvoiceID;
        issueDate=LocalDate.now();
        
        this.customer=customer;
        this.reservedRoom=reservedRoom;
        float price=(reservedRoom.getPrice() - customer.getLoyalityPints())*(1-(customer.getPriceplan().getOffer()));
        price+=taxRate*price;
        invoicePrice=(int)price;
        }
        
        
    //setters and getters
    @Override
    public int getPrice(){return invoicePrice;}
     public int getInvoiceID(){return InvoiceID;}
     public LocalDate getInvoiceIssueDate(){return issueDate;}
     public Customer getInvoiceCustomer(){return customer;}
     public Room getInvoiceRoom(){return reservedRoom;}
     
    //functions
    //send email
     public void sendEmail(){
         
         app.sendNotification(printInvoice(), customer);
     }
     
    public String printInvoice(){
    String display="Invoice Number :"+InvoiceID+"\n"
            + "Issue Date :"+issueDate+"\n"
            + "Customer Details : " +"\n"
            +"Customer name : "+customer.getName() +"\n"
            +"Customer Email : "+customer.getEmail() +"\n"
            +"Customer Phone : "+customer.getPhone() +"\n"
            +"Room Details : "+"\n"
            +"Hotel : "+reservedRoom.getHotel().getHotelName()+"\n"
            +"Room Number : "+reservedRoom.getRoomNumber()+"\n"
            +"Room Number : "+reservedRoom.getType()+"\n\n"
            +"Price : "+invoicePrice;

    return display;
    }
            
    
}
