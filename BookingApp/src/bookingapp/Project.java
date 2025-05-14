package bookingapp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Project extends Application {
    
    
public static void main(String[] args) {
        launch(args);
    }
public static Stage primary;    
public static   ArrayList<User> users=new ArrayList<>();
public static   ArrayList<Hotel> hotels=new ArrayList<>();
public static   ArrayList<Room> rooms=new ArrayList<>();

public void initUsers(){
users.add(new Customer("Kareem Bakr", "kareembakr63@gmail.com", "123","01012280087"));
users.add(new Admin("Hazem Bakr", "hazembakr00@gmail.com", "123","01012284323"));
users.add(new Manager("Mohamed Alaa", "mohamdalaa12@gmail.com", "123","01044280086","CEO"));
users.add(new Recipient("Ahmed Hany", "ahmedhany43@gmail.com", "123","01060300431","Call center"));
users.add(new Customer("Mahmoud", "mahmoud8j@gmail.com", "123","01013330033"));
users.add(new Customer("Mostafa", "mostafalaaa02@gmail.com", "123","01123343425"));
users.add(new Recipient("test user", "123", "123","010342534087","hr"));
}
public void initHotels(){
hotels.add(new Hotel("Four Seasons","Corniche El Nile, Cairo"));
hotels.add(new Hotel("Hilton Alexandria","544 El Geish Road, Alexandria"));
hotels.add(new Hotel("JW Marriott ","Ring Road, Mirage City, New Cairo"));
hotels.add(new Hotel("Steigenberger Hotel","Tahrir Square, Downtown Cairo"));
hotels.add(new Hotel("Tolip Hotel","Borg El Arab, Alexandria"));
}
public void inithotelRooms(){
//rooms.add(new Room("Single Room"));
rooms.add(new Room(1200, 101, hotels.get(0),"Single Room" ));
rooms.add(new Room(850, 111, hotels.get(0),"Double  Room" ));
rooms.add(new Room(1300, 2011, hotels.get(0),"Twin  Room" ));
rooms.add(new Room(2200, 210, hotels.get(0),"Suite" ));
rooms.add(new Room(2500, 403, hotels.get(1),"Deluxe  Room" ));
rooms.add(new Room(3000, 504, hotels.get(1),"King Suite" ));
rooms.add(new Room(2500, 201, hotels.get(1),"Duplex" ));
rooms.add(new Room(2000, 234, hotels.get(1),"Family Room" ));
rooms.add(new Room(700, 777, hotels.get(1),"Economy Room" ));
rooms.add(new Room(4000, 1001, hotels.get(2),"Penthouse" ));
rooms.add(new Room(1200, 1678, hotels.get(2),"Single Room" ));
rooms.add(new Room(850, 196, hotels.get(2),"Double  Room" ));
rooms.add(new Room(1300, 2688, hotels.get(2),"Twin  Room" ));
rooms.add(new Room(2200, 798, hotels.get(3),"Suite" ));
rooms.add(new Room(2500, 933, hotels.get(3),"Deluxe  Room" ));
rooms.add(new Room(3000, 230, hotels.get(3),"King Suite" ));
rooms.add(new Room(1200, 3223, hotels.get(4),"Single Room" ));
rooms.add(new Room(850, 332, hotels.get(4),"Double  Room" ));
rooms.add(new Room(1300, 212, hotels.get(4),"Twin  Room" ));
rooms.add(new Room(2200, 4244, hotels.get(4),"Suite" ));
}



    @Override
    public void start(Stage primaryStage) {
        initUsers();
        initHotels();
        inithotelRooms();
        SignInterfacePane signImplmentaation=new SignInterfacePane();
        StackPane root=signImplmentaation.SignPane(primaryStage);
        
        Scene scene = new Scene(root, 800, 650);
        primaryStage.setTitle("Booking App");
        primaryStage.setScene(scene);
        primaryStage.show();
        primary=primaryStage;
    }

}

