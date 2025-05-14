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
public class Manager extends Staff{
    private ArrayList<Staff> teamMembers = new ArrayList<>();
//constractors
    public Manager(String name,String email,String pasword,String phone,String position){
    super(name,email,pasword,phone,position);
    }
    public Manager(String name,String pasword,String phone,String position){
    super(name,pasword,phone,position);
    }
    
   
    public void addTeamMaember(Staff newTeamMember){teamMembers.add(newTeamMember);}
    public String displayTeamMembers(){
    String display="";
    String newline = System.lineSeparator();
    for(int i=0;i<teamMembers.size();i++){
    display+="empolyee"+(1+i)+":"+ teamMembers.get(i).getName()+ newline;
    }
    return display;
    }
    
    @Override
    public void promotion(String position,Staff empolyee){
    empolyee.position=position;
    }
}
