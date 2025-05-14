package bookingapp;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RoomInterfacePane extends Application {
    public static Stage homestage;
    //Public Body Component
    BorderPane header =new BorderPane();
    Label seemyProfile = new Label("My Profile   ");
    Label leftHeaderLabel =new Label("   Welcome "+SignInterfacePane.logedINUser.getName());

    public VBox allHotelsPrint(){
      VBox scrollContent = new VBox(10);
      for(int i=0;i<Project.hotels.size();i++){
            scrollContent.getChildren().add(printAllhotelRooms(Project.hotels.get(i)));
      }
        return scrollContent;
    }
    
    public VBox printVBoxRoom(int index,ArrayList<Room> rooms){
        VBox roomDetails =new VBox();
        //Room Styling 
            roomDetails.setAlignment(Pos.CENTER);
            Image roomimg=new Image("file:///D:\\00-spring 2025\\project\\advanced\\room.jpeg",170,100,false,false);
            ImageView roomImgView = new ImageView(roomimg);
            Label roomPrice=new Label("Price :"+String.valueOf(rooms.get(index).getPrice())+"$");
            roomPrice.setStyle("-fx-text-fill: red;");
            roomDetails.setStyle("-fx-background-color: white;");
            roomDetails.setOnMouseExited(e->{roomDetails.setStyle("-fx-background-color: white;");});
            roomDetails.setOnMouseEntered(e->{roomDetails.setStyle("-fx-background-color: LightYellow;");});
        //labels    
            Label roomnum =new Label("Room Number : "+String.valueOf(rooms.get(index).getRoomNumber()));
            Label type =new Label("Type : " + rooms.get(index).getType());
        //add room items to Vbox
        roomDetails.getChildren().addAll(roomImgView,type,roomnum,roomPrice);
        //onclick on one room handle
            roomDetails.setOnMouseClicked(e->{
            bookRoomInterfacePane.roomToBook= rooms.get(index);
            new bookRoomInterfacePane().start(new Stage());
            homestage.hide();
            });
        return roomDetails;
    }
  
    public VBox printAllhotelRooms(Hotel hotel){
        VBox roomPrint =new VBox(10);
        VBox hotelNameVBox=new VBox();
        Label hotelName= new Label(hotel.getHotelName()+" Hotel");
        hotelNameVBox.setStyle("-fx-font-size: 18px; -fx-background-color: LightGoldenrodYellow; -fx-text-fill: black;");
        hotelNameVBox.getChildren().add(hotelName);
        roomPrint.getChildren().add(hotelNameVBox);
        roomPrint.setPadding(new Insets(10));

        //printing  all rooms
        ArrayList<Room> hotelRooms=hotel.getHotelRooms();        

        for (int i=0;i<(hotelRooms.size()/4);i++){
            HBox threeOnOneLine=new HBox(10);
            for(int j=0;j<4;j++){
              int index= 4*i+j;
              threeOnOneLine.getChildren().add(printVBoxRoom(index,hotelRooms));
           }
        roomPrint.getChildren().add(threeOnOneLine);
        }
        
        HBox lastLine=new HBox(10);
        
        for (int i=0;i<(hotelRooms.size()%4);i++){
            int index= 4*(hotelRooms.size()/4)+i;
            lastLine.getChildren().add(printVBoxRoom(index,hotelRooms));
        }
         
        roomPrint.getChildren().add(lastLine);
        VBox roomScroll =new VBox(roomPrint);
        
    return roomScroll;

}
    
    public void MyProfileHandle(){
          seemyProfile.setOnMouseClicked(e -> {
            MyProfileInterfacePane showmyprofile=new MyProfileInterfacePane();
            showmyprofile.start(new Stage());
            homestage.hide();
        });
    
    }
    
    public void CSS(){
        header.setStyle("-fx-background-color: khaki; -fx-font-size:20;");
        header.setLeft(leftHeaderLabel);
        header.setRight(seemyProfile);
        seemyProfile.setOnMouseEntered(e->{seemyProfile.setTextFill(Color.WHITE);});
        seemyProfile.setOnMouseExited(e->{seemyProfile.setTextFill(Color.BLACK);});
    }
    
    @Override
    public void start(Stage stage) {
        homestage=stage;
        //CSS
        CSS();
        //Handle my profile 
        MyProfileHandle();
        //show stage
        VBox pane = new VBox();
        ScrollPane body =new ScrollPane( allHotelsPrint());      
        pane.getChildren().addAll(header,body);
        pane.setStyle("-fx-font-size: 16px;");
        Scene scene = new Scene(pane, 800, 650);
        stage.setTitle("Second View");
        stage.setScene(scene);
        stage.show();
    }


    
}