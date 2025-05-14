package bookingapp;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class bookRoomInterfacePane extends Application{
    public static User LogedINUser;
    public static Room roomToBook;
    public static Stage bookRoom;
    public static Customer bookinguser; 
    public void initBookinUser(){
        if(LogedINUser instanceof Customer)bookinguser=(Customer)LogedINUser;
    }
    //public body component
    HBox goToHomeHBox =new HBox(10);
        VBox body =new VBox(5);
        Label roomTypeLabel=new Label("Room Type : ");    
        TextField roomTypeField=new TextField();
        Label roomPriceLabel=new Label("Room Price : ");
        TextField roomPriceField=new TextField();
        Label roomHotelLabel=new Label("Hotel Name");
        TextField roomHotelField=new TextField();
        Label roomNumberLabel=new Label("Room Number : ");
        TextField roomNumberField=new TextField();
        Label roomAmenitiesLabel=new Label(" Room Amenities : ");
        TextField roomAmenitiesField=new TextField();
        Label customerNameLabel=new Label("Customer Name : ");
        TextField customerNameField=new TextField();
        Label customerEmailLabel=new Label("Customer Email : ");
        TextField customerEmailField=new TextField();
        Label bookSuccess=new Label("Successfully Booked"); 
        Button bookbtn=new Button("Book Room"); 
        HBox bookbtnVBox=new HBox(bookbtn);
        //for staff only 
           Label selectHotelLabel=new Label("Select Hotel : "); 
           Label selectRoomNumberlabel=new Label("Select Room Numberl : "); 
           ComboBox<String> hotelsComboBox = new ComboBox<>();
           ComboBox<String> roomsComboBox = new ComboBox<>();

    public VBox Header(){
        Label headerLabel = new Label("Book Room");
        headerLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: Olive;");
        VBox header = new VBox(headerLabel);
        header.setAlignment(Pos.CENTER);
        header.setStyle("-fx-background-color: Moccasin;");
    return header;
    }
   
    public VBox RoomDetailsLabel(){
        Label roomDetailsLabel=new Label("Room Details");
        roomDetailsLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: Coral ;");
        VBox roomDetailsLabelVBox=new VBox(roomDetailsLabel);
        roomDetailsLabelVBox.setStyle("-fx-background-color:Beige;");
    return roomDetailsLabelVBox;
    }
    
    public VBox CustomerDetailsLabel(){
         Label customerDetailsLabel=new Label("Customer Details");
        customerDetailsLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: Coral ;");
        VBox customerDetailsLabelVBox=new VBox(customerDetailsLabel);
        customerDetailsLabelVBox.setStyle("-fx-background-color:Beige;");
    return customerDetailsLabelVBox;
    }
   
    public void DisableTextField(){
           roomAmenitiesField.setDisable(true);
           roomNumberField.setDisable(true);
           roomTypeField.setDisable(true);
           roomHotelField.setDisable(true);
           roomPriceField.setDisable(true);
           customerNameField.setDisable(true);
    }
    
    public void AddHotelBoxItems(){
    hotelsComboBox.setValue("Select Hotel");
        for (int i=0;i<Project.hotels.size();i++){ 
           hotelsComboBox.getItems().add(Project.hotels.get(i).getHotelName());
        }
        body.getChildren().add(1,selectHotelLabel);
        body.getChildren().add(2,hotelsComboBox);
    }
    
    public Hotel selectedhotel(){
        for (int i=0;i<Project.hotels.size();i++){
         if(Project.hotels.get(i).getHotelName().equals(hotelsComboBox.getValue())){
             return Project.hotels.get(i);   
        }
         }
    return Project.hotels.get(0);  // if for loop ended and no one is selected (can't be occured)
    }
    
    public void AddRoomsBoxItems(){
            Hotel hotel=selectedhotel();
            for (int j=0;j<hotel.getHotelRooms().size();j++){ 
                roomsComboBox.getItems().add(String.valueOf(hotel.getHotelRooms().get(j).getRoomNumber()));
            }
            roomsComboBox.setValue("select Room Number");
            body.getChildren().add(3,selectRoomNumberlabel);
            body.getChildren().add(4,roomsComboBox);
    }
    
    public void HotelBoxHandle(){
        hotelsComboBox.setOnAction(e->{
            body.getChildren().remove(bookSuccess);
            if(hotelsComboBox!=null){
                body.getChildren().removeAll(roomsComboBox,selectRoomNumberlabel);
                roomsComboBox.getItems().clear();
                AddRoomsBoxItems();
                roomsBoxHandle();
            }
        });
    }
        
    public void roomsBoxHandle(){
          roomsComboBox.setOnAction(e2->{
            Room selectedRoom=Project.rooms.get(0) ;
            Hotel hotelinroom=Project.hotels.get(0);
            for (int i=0;i<Project.hotels.size();i++){
                if(Project.hotels.get(i).getHotelName().equals(hotelsComboBox.getValue())){
                    hotelinroom=Project.hotels.get(i);
                }
            for (int j=0;j<hotelinroom.getHotelRooms().size();j++){ 
               if(String.valueOf(hotelinroom.getHotelRooms().get(j).getRoomNumber()).equals(roomsComboBox.getValue())){
                    selectedRoom=hotelinroom.getHotelRooms().get(j);
                }
            }
            }
            printRoomData(selectedRoom);
            });
    }
    
    public void printRoomData(Room room){
           roomAmenitiesField.setText(room.getAmenities());
           roomNumberField.setText(String.valueOf(room.getRoomNumber()));
           roomTypeField.setText(room.getType());
           roomHotelField.setText(room.getHotel().getHotelName());
           roomPriceField.setText(String.valueOf(room.getPrice()));
    }
    
    public void SearchUseerButton(){
      bookbtn.setDisable(true);
      Button searchuser=new Button("search user");
      goToHomeHBox.getChildren().add(searchuser);
      searchuser.setOnAction(e->{
        for(int i=0;i<Project.users.size();i++){
           if(Project.users.get(i).getEmail().equals(customerEmailField.getText())){
            customerNameField.setText(Project.users.get(i).getName());
            bookbtn.setDisable(false);
           }
        }
      });  
    }
    
    public void bookBtnStaff(){
        bookbtn.setOnAction(e->{
            body.getChildren().remove(bookSuccess);
            Room bookedRoom =Project.rooms.get(0);
            for(int i=0;i<Project.users.size();i++){
                if(Project.users.get(i).getEmail().equals(customerEmailField.getText())){
                   bookinguser=(Customer)Project.users.get(i);
               }
            }
            for(int i=0;i<Project.hotels.size();i++){
                Hotel hotel=Project.hotels.get(i);
                ArrayList<Room> roomsOfHotel =hotel.getHotelRooms();
                for(int j=0;j<roomsOfHotel.size();j++){
                    if(String.valueOf(roomsOfHotel.get(j)).equals(roomNumberField)){
                        bookedRoom=roomsOfHotel.get(j);
                    }
                }
                bookedRoom.setRoomAvailable(false);
            }
            bookinguser.bookRoom(bookedRoom);
            body.getChildren().add(bookSuccess);
        });
    }
    
    public void bookBtnCustomer(){
        bookbtn.setOnAction(e->{
            body.getChildren().remove(bookSuccess);
            roomToBook.setRoomAvailable(false);
            body.getChildren().add(bookSuccess);
        });
    }
    
    public void CustomerTextField(){
           customerEmailField.setDisable(true);
           roomAmenitiesField.setText(roomToBook.getAmenities());
           roomNumberField.setText(String.valueOf(roomToBook.getRoomNumber()));
           roomTypeField.setText(roomToBook.getType());
           roomHotelField.setText(roomToBook.getHotel().getHotelName());
           roomPriceField.setText(String.valueOf(roomToBook.getPrice()));
           customerNameField.setText(bookinguser.getName());
           customerEmailField.setText(bookinguser.getEmail());
    }
    
    public Button  goToHomebtn(){
        Button goToHome=new Button("Home");    
        goToHome.setOnAction(e->{
            if(SignInterfacePane.logedINUser instanceof Customer){
                new RoomInterfacePane().start(new Stage());
                RoomInterfacePane.homestage.show();
            }
            else{
               AddRoomInterfacepane addRoomVIEW=new AddRoomInterfacepane();
               addRoomVIEW.start(new Stage());
            }
            bookRoom.hide();
        });
    return goToHome;
    }
    
    @Override
    public void start(Stage stage) {
    LogedINUser=SignInterfacePane.logedINUser;
    initBookinUser();
    bookRoom=stage;
         //css
        body.setAlignment(Pos.CENTER);
        bookSuccess.setStyle("-fx-text-fill: green;");
        bookbtnVBox.setAlignment(Pos.BASELINE_RIGHT);
        //add items to body
        body.getChildren().addAll(RoomDetailsLabel(),roomTypeLabel,roomTypeField,roomPriceLabel,roomPriceField,roomHotelLabel,roomHotelField,roomNumberLabel,roomNumberField,roomAmenitiesLabel,roomAmenitiesField);
        body.getChildren().addAll(CustomerDetailsLabel(),customerNameLabel,customerNameField,customerEmailLabel,customerEmailField,bookbtnVBox);
        DisableTextField();
        //handle if the page for staff or customer 
        if(LogedINUser instanceof Staff){
            AddHotelBoxItems();
            HotelBoxHandle();
            SearchUseerButton();
            bookBtnStaff();
        }
        else if(LogedINUser instanceof Customer){
            CustomerTextField();
            bookBtnCustomer();
        } 
       //show stage
        goToHomeHBox.getChildren().add(goToHomebtn());
        VBox root = new VBox(Header(),body,goToHomeHBox);
        root.setPadding(new Insets(20)); 
        Scene scene = new Scene(root, 800, 650);
        stage.setTitle("Book Room");
        stage.setScene(scene);
        stage.show();
    }
  }
