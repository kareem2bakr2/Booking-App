package bookingapp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
public class SignInterfacePane{
    public static Stage signStage;
    public static User logedINUser;
    //backgroundimage
        Image backgroundimg =new Image("file:///D:\\00-spring 2025\\project\\advanced\\istockphoto-472899538-612x612.jpg");
        ImageView backgroundImageView = new ImageView(backgroundimg);
        public void BackgroundImg(){
            backgroundImageView.setOpacity(0.75);
            backgroundImageView.setFitWidth(signStage.getWidth());  
            backgroundImageView.setFitHeight(signStage.getHeight());  
            backgroundImageView.setPreserveRatio(false); 
        }
    //signin /signup pane
        VBox signPane =new VBox();
    //sign in component
        Text welcome = new Text("BOOK YOUR ROOM NOW !");
        Label emailLabel=new Label("Email :");
        TextField emailInput =new TextField();
        Label passwordLabel=new Label("Password :"); 
        PasswordField paawordInput=new PasswordField();
        Button signin=new Button("Sign in");
        HBox newaccount =new HBox();
    //sign up component
        Label signUp =new Label("Sign Up");
        Label nameLabel =new Label("Enter Full Name : ");
        TextField nameInput =new TextField();
        Label positionLabel =new Label("Enter Empolyee position : ");
        TextField positionInput =new TextField();
        Label phoneLabel =new Label("Enter phone number : ");
        TextField phoneInput =new TextField();
        Button register =new Button("Register");
        ComboBox<String> comboBox = new ComboBox<>();
        Label retunToSigninBtn= new Label("Have An Account?  Sign in");
        VBox returnToSigninBox =new VBox(retunToSigninBtn);
        Label ex1=new Label("Invalid user Data");
        Label notRegisteredEmailOrincorrectPassword=new Label("Email Address isn't registered or Incorrect Password");
        Label signup=new Label("Dont have Account? Sign Up");

    public void displaySignin(){
        signPane.getChildren().clear();
        signPane.getChildren().addAll(welcome,emailLabel,emailInput,passwordLabel,paawordInput,signin,newaccount);
    }
   
    public void displaySignup(){
        signPane.getChildren().clear();
        signPane.getChildren().addAll(signUp,nameLabel,nameInput,emailLabel,emailInput,passwordLabel,paawordInput,phoneLabel,phoneInput,comboBox,register,returnToSigninBox);
    }
    
    public void handleUserType(){
        comboBox.getItems().addAll("Customer","Staff","Admin");
          comboBox.setOnAction(e -> {
            String accountType=comboBox.getValue();
           switch(accountType){
           case("Customer"):
            signPane.getChildren().remove(positionLabel);
            signPane.getChildren().remove(positionInput);

               break;
           case("Admin"):
            signPane.getChildren().remove(positionLabel);
            signPane.getChildren().remove(positionInput);

               break;
           case("Staff"):
            signPane.getChildren().add(10,positionLabel);
            signPane.getChildren().add(11,positionInput);
               break;
           default :break;
            }
        });}
    
    public void labelCSS(){
        notRegisteredEmailOrincorrectPassword.setTextFill(Color.RED); 
    //welcome message adjusment 
        welcome.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        welcome.setFill(Color.ORANGE); 
    //signup click and hover
        signup.setOnMouseEntered(e -> signup.setTextFill(Color.DARKBLUE));
        signup.setOnMouseExited(e -> signup.setTextFill(Color.BLACK));
   //Sign up
        signUp.setFont(Font.font(15));
        signUp.setTextFill(Color.BURLYWOOD);
   //return to signin click and hover
        retunToSigninBtn.setOnMouseEntered(e -> retunToSigninBtn.setTextFill(Color.DARKBLUE));
        retunToSigninBtn.setOnMouseExited(e -> retunToSigninBtn.setTextFill(Color.BLACK));
// sign pane fitst display
        signPane.setSpacing(10);
        signPane.setStyle("-fx-background-color: white; -fx-padding:15px" );
        signPane.setAlignment(Pos.CENTER);
    }
   
public void signinhandle() {
    signin.setOnAction(e -> {
        
        signPane.getChildren().remove(notRegisteredEmailOrincorrectPassword);
        boolean userFound = false;
        for(int i = 0; i < Project.users.size(); i++) {
            String returnInput = emailInput.getText();
            String userEmail = Project.users.get(i).getEmail();
            if(returnInput.equals(userEmail)) {
                if(Project.users.get(i).getPassword().equals(paawordInput.getText())) {
                    userFound = true;
                    logedINUser = Project.users.get(i);
                    if (Project.users.get(i) instanceof Customer) {
                        RoomInterfacePane RoomView = new RoomInterfacePane();
                        RoomView.start(new Stage());
                        signStage.hide();
                    } else {
                        bookRoomInterfacePane bookRoomView = new bookRoomInterfacePane();
                        bookRoomView.start(new Stage());
                        signStage.hide();
                    }
                    break;
                }
            }
        }
        if (!userFound) {
            signPane.getChildren().add(notRegisteredEmailOrincorrectPassword);
        }
    });
}
    public void RegisterHandle(){
        register.setOnAction(e->{
        String accountType=comboBox.getValue();
              try{
                signPane.getChildren().remove(ex1);        
              switch(accountType){
                          case("Customer"):
                              Project.users.add(new Customer(nameInput.getText(),emailInput.getText(),paawordInput.getText(),phoneInput.getText()));
                              break;
                          case("Staff"):
                              Project.users.add(new Recipient(nameInput.getText(),emailInput.getText(),paawordInput.getText(),phoneInput.getText(),positionInput.getText()));
                              break;
                          case("Admin"):
                              Project.users.add(new Admin(nameInput.getText(),emailInput.getText(),paawordInput.getText(),phoneInput.getText()));
                              break;
                          default:break;
                      }
              displaySignin();
              }catch(UnsupportedOperationException exception){
                  System.out.println(exception);
              } 
              catch(NullPointerException exception){
                  ex1.setTextFill(Color.RED);
                  signPane.getChildren().add(ex1);
              }
          }); 
    }
    
    public void onChangeWidthHandle(){
            signStage.widthProperty().addListener((observable, oldValue, newValue) -> {
                backgroundImageView.setFitWidth(newValue.doubleValue()); 
                signPane.setMaxWidth(newValue.doubleValue()/2);
             });
            signStage.heightProperty().addListener((observable, oldValue, newValue) -> {
                backgroundImageView.setFitHeight(newValue.doubleValue());
                signPane.setMaxHeight(newValue.doubleValue()*0.40);
            });
    } 
   
    
    
    public StackPane SignPane(Stage primaryStage) {
        
    signStage=primaryStage;
   
    // Background image
        BackgroundImg();
    //CSS
        labelCSS();
    //body
        newaccount.getChildren().add(signup);
        signinhandle();
        displaySignin();
        handleUserType();
        RegisterHandle();
        onChangeWidthHandle();
        signup.setOnMouseClicked(e->displaySignup());
        returnToSigninBox.setOnMouseClicked(e->{displaySignin();  });
  
  
  
        BorderPane signinBorder=new BorderPane();
        signinBorder.setCenter(signPane);
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView,signinBorder);
        return root;       
    }

}

