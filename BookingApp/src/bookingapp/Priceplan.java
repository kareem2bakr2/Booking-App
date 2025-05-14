/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingapp;
/**
 *
 * @author kareem bakr
 */
public class Priceplan implements Payable{
    private String name ;
    private float  offer;
    private int planPrice;
    //constractors

    public Priceplan(String name,float offer,int planPrice) {
    this.name=name;
    this.offer=offer;
    this.planPrice=planPrice;
    }
    public Priceplan(){
      throw new UnsupportedOperationException("invalid user data");
    }
    
    //setters and getters
    public void setName(String newName){name=newName;}
    public String getPricePlanName(){return name;};
    public void setOffer(float newOffer){offer=newOffer;}
    public float getOffer(){return offer;}
    public void setPlanPrice(int PlanPrice){this.planPrice=PlanPrice;}
    @Override
    public int getPrice(){return planPrice;}

    //functions
    
}
