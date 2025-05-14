/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bookingapp;

/**
 *
 * @author kareem bakr
 */
public interface Notifable {
   public void sendNotification(String message,User user);
   public void reciveNotification(String message,String name);
   public void printNotificatiions();
}
