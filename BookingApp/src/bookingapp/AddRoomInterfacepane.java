package bookingapp;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class AddRoomInterfacepane extends Application {
    public static Stage addRoomRef;
    public static User LogedINUser;
    //public body Components >> used by many functions
        VBox body =new VBox(5);
        //text fields and combobox<choose hotel>
            TextField roomNameField=new TextField();
            TextField roomTypeField=new TextField();
            TextField roomPriceField=new TextField();
            TextField newHotelNameField=new TextField();
            TextField newHotelAddressField=new TextField();
            TextField roomNumberField=new TextField();
            TextField roomAmenitiesField=new TextField();
            ComboBox<String> hotelComboBox = new ComboBox<>();
        //Labels 
            Label invaledData=new Label("Invalid Data");
            Label addedsuccessfully=new Label("Room Added successfully");
            Label newHotelNameLabel=new Label("new Hotel Name : ");
            Label newHoteladdressLabel=new Label("new Hotel address : ");
    //Header
    
        public VBox Header(){
            Label headerLabel = new Label("Add Room");
            headerLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: Olive;");
            VBox header = new VBox(headerLabel);
            header.setAlignment(Pos.CENTER);
            header.setStyle("-fx-background-color: Moccasin;");
        return header;
    }
    
    //Body
        
        public VBox Body(){
        body.setAlignment(Pos.CENTER);
        //body Labels
            Label roomNameLabel=new Label("Room Name : ");
            Label roomTypeLabel=new Label("Room Type : ");
            Label roomPriceLabel=new Label("Room Price : ");
            Label roomHotelLabel=new Label("Hotel Name");
            Label roomNumberLabel=new Label("Room Number : ");
            Label roomAmenitiesLabel=new Label(" Room Amenities : ");
        //combo box
            HandleHoelComboBox();
            body.getChildren().addAll(roomNameLabel,roomNameField,roomHotelLabel,hotelComboBox,roomNumberLabel,roomNumberField,roomTypeLabel,roomTypeField,roomPriceLabel,roomPriceField,roomAmenitiesLabel,roomAmenitiesField);
            addedsuccessfully.setStyle("-fx-text-fill:green;");
        return body;
        }
        
        public void HandleHoelComboBox(){ 
            hotelComboBox.setPromptText("Select a Hotel");
            //adding hotelnames
                for(int i=0;i<Project.hotels.size();i++){
                    hotelComboBox.getItems().add(Project.hotels.get(i).getHotelName());
                }
                hotelComboBox.getItems().add("New Hotel");
            //adding new hotel    
             hotelComboBox.setOnAction(e->{
                if(hotelComboBox.getValue()!=null&&hotelComboBox.getValue().equals("New Hotel")){
                body.getChildren().add(4,newHotelNameLabel);
                body.getChildren().add(5,newHotelNameField);
                body.getChildren().add(6,newHoteladdressLabel);
                body.getChildren().add(7,newHotelAddressField);
                }
                else{
                body.getChildren().removeAll(newHotelNameLabel,newHotelNameField,newHoteladdressLabel,newHotelAddressField);
                }
        });
        }
    
    //Footer 
        
        public Button returToBookRoom(){
            Button bookRoombtn=new Button("Book Room");
            bookRoombtn.setOnAction(e->{
            bookRoomInterfacePane.bookRoom.show();
            addRoomRef.hide();
            });
        return bookRoombtn;
        }
        
        public Button RefreshButton(){
                Button refreshBtn =new Button("Refresh");
                refreshBtn.setOnAction(e->{
                    body.getChildren().remove(addedsuccessfully);
                    hotelComboBox.setValue(null);
                    roomNameField.setText(null);
                    roomPriceField.setText(null);
                    roomTypeField.setText(null);
                    body.getChildren().removeAll(newHotelNameLabel,newHotelNameField,newHoteladdressLabel,newHotelAddressField);
                    roomAmenitiesField.setText(null);
                    roomNumberField.setText(null);
                    body.getChildren().remove(invaledData);
                });
            return refreshBtn;
        }
        
        public VBox addRoomButton(){
            Button addRoombtn=new Button("ADD");
            addRoombtn.setOnAction(e->{
                try{
                body.getChildren().removeAll(addedsuccessfully,invaledData);
                //adding new hotel
                    if(hotelComboBox.getValue().equals("New Hotel")){
                        Project.hotels.add(new Hotel(newHotelNameField.getText(),newHotelAddressField.getText()));
                        hotelComboBox.getItems().add(newHotelNameField.getText());
                    }
                //choose hotel
                    Hotel hotelroom = Project.hotels.get(0); 
                    for (int i=0;i<Project.hotels.size();i++){
                    if(hotelComboBox.getValue().equals(Project.hotels.get(i).getHotelName()))
                    hotelroom=Project.hotels.get(i);
                    }
                //adding rooom
                    Project.rooms.add(new Room(Integer.parseInt(roomPriceField.getText()),Integer.parseInt(roomNumberField.getText()), hotelroom,roomTypeField.getText()));
                    String[] roomAmenitiesArray =roomAmenitiesField.getText().split(",");
                    for(int j=0 ; j < roomAmenitiesArray.length;j++){
                        Project.rooms.getLast().addAmenity(roomAmenitiesArray[j]);
                    }
                //addsuccess label
                body.getChildren().add(addedsuccessfully);
                }
                catch(NullPointerException ex1){
                body.getChildren().add(invaledData);
                }
                catch (NumberFormatException ex2) {
                     body.getChildren().add(invaledData);
                }
            });
            VBox addRoomVBox =new VBox(addRoombtn);
            addRoomVBox.setAlignment(Pos.BASELINE_RIGHT);
        return addRoomVBox;
    }
    
        public HBox footerButtons(){
            HBox lastLinebtnsHbox=new HBox(10); 
            lastLinebtnsHbox.getChildren().addAll(returToBookRoom(),RefreshButton());
        return lastLinebtnsHbox;
        }
    @Override
    public void start(Stage stage) {
        addRoomRef = stage;
        

        VBox root = new VBox(Header(),Body(),addRoomButton(),footerButtons());
        root.setPadding(new Insets(20)); 

        Scene scene = new Scene(root, 800, 650);
        stage.setTitle("ADD NEW ROOM");
        stage.setScene(scene);
        stage.show();
    }
}
