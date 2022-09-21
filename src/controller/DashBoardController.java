package controller;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import models.DataBase;
import models.Driver;
import models.Vehicle1;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DashBoardController extends DataBase {
    public Label time;
    public Label lblSelect;
    public Label lblDate;
    public Label lblNameOfDate;
    public Label lblMonth;
    public ImageView imjeArrow;
    public JFXButton btnLogin;
    public AnchorPane ContextOneAP;
    public ComboBox cmboDriver;
    public ComboBox comboType;
    public Label lblTypeOFVehicle;
    public JFXButton btnDelivery;
    public JFXButton btnPark;
    public Label lblSlotNumber;
    private volatile boolean stop=false;


    public void initialize(){
    TimeNow();
    setDate();
    TranslateTransition translate=new TranslateTransition();
    translate.setNode(imjeArrow);
    translate.setDuration(Duration.millis(1000));
    translate.setAutoReverse(true);
    translate.setCycleCount(TranslateTransition.INDEFINITE);
    translate.setByY(28);
    translate.play();
    try {
        if(busArray[0]!=null){comboType.getItems().add(busArray[0].getVehicleNumber());}
        for (Vehicle1 x : vanArray) {
            if(x!=null){
            comboType.getItems().add(x.getVehicleNumber());
            }else{break;}
        }
        for (Vehicle1 x : cargoLorryArray) {
            if(x!=null){
            comboType.getItems().add(x.getVehicleNumber());
            }else{break;}
        }

        for (Driver x : DriverArray) {
            if (x != null) {
                cmboDriver.getItems().add(x.getDriverName());
            }else{break;}
        }
        }catch (Exception e){
            System.out.println("e1234");
        }
    }

    private void TimeNow(){
        Thread thread=new Thread(()->{
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
            while(!stop){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println("e");
                }
                final String timeNow=sdf.format(new Date());
                Platform.runLater(()->{
                    time.setText(timeNow);
                });
            }
        });
        thread.start();
    }

    public void setDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date();
        // Calendar c = Calendar. getInstance(); c. setTime(date);
        // int dayOfWeek = c. get(Calendar. DAY_OF_WEEK);
        String dayWeekText = new SimpleDateFormat("EEEE"). format(date);
        String monthText = new SimpleDateFormat("LLLL"). format(date);
        lblMonth.setText(monthText);
        lblDate.setText(formatter.format(date));
        lblNameOfDate.setText(dayWeekText);
    }

    public void ManagementLoginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent root = FXMLLoader.load(resource);
        ContextOneAP.getChildren().clear();
        ContextOneAP.getChildren().add(root);
    }

    public void exitOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }

   public void searchOnAction(ActionEvent actionEvent) {
   try{
       String vehicleNum = (String) comboType.getValue();
           if (validateVehicle()) {
               lblTypeOFVehicle.setText(searchTypeOfVehicle());
               lblSlotNumber.setText(" ");
               cmboDriver.getSelectionModel().clearSelection();
               btnPark.setDisable(true);
               btnDelivery.setDisable(false);
           }else{
               btnPark.setDisable(false);
               btnDelivery.setDisable(true);
               switch (searchTypeOfVehicle()){

                   case "Van":{
                       for (Vehicle1 y : vanArray) {
                           if (y.getVehicleNumber().equals(vehicleNum)) {
                              displayDriverName(y);
                               lblTypeOFVehicle.setText("Van");
                               Arrays.sort(vanSlotArray);
                               for (int availableSlot:vanSlotArray){
                                   if(availableSlot!=0){
                                       lblSlotNumber.setText(Integer.toString(availableSlot));
                                       break;
                                   }
                               }
                               break;
                           }
                       }
                   }break;

                   case " Cargo Lorry": {
                       for (Vehicle1 z : cargoLorryArray) {
                           if (z.getVehicleNumber().equals(vehicleNum)) {
                              displayDriverName(z);
                               lblTypeOFVehicle.setText("Cargo Lorry");
                               Arrays.sort(lorrySlotArray);
                               for (int availableSlot : lorrySlotArray) {
                                   if (availableSlot != 0) {
                                       lblSlotNumber.setText(Integer.toString(availableSlot));
                                       break;
                                   }
                               }
                               break;
                           }
                       }
                   }break;

                   case "Bus":{
                       if(busArray[0].getVehicleNumber().equals(vehicleNum)){
                           lblSlotNumber.setText("14");
                           displayDriverName(busArray[0]);
                           lblTypeOFVehicle.setText("Bus");
                       }
                   }break;
           }
    }
       }catch (Exception e){
            System.out.println("Error in Search on action");
       }
    }

    public void parkOnAction(ActionEvent actionEvent) {
        try{
            String vehicleNum = (String) comboType.getValue();
            if (validateVehicle()) {
            }else{
                switch (searchTypeOfVehicle()){
                    case "Van":{
                        for (Vehicle1 y : vanArray) {
                            if(y!=null){
                            y.parkVehicle(y,vehicleNum);
                            }
                        }
                    }break;

                    case " Cargo Lorry": {
                        for (Vehicle1 z : cargoLorryArray) {
                            if(z!=null){
                            z.parkVehicle(z,vehicleNum);
                            }
                        }
                    }break;

                    case "Bus":{
                      busArray[0].parkVehicle(busArray[0],vehicleNum );
                    }break;
                }
            }
        }catch (Exception e){
            makeNotification("    There is no vehicle to park\n    Search for vehicle");
            System.out.println("Error in park on action");}
    }

    public void DeliveryOnAction(ActionEvent actionEvent) {
      try{
            String vehicleNum = (String) comboType.getValue();
            if (validateVehicle() && validateDriver()) {
                switch (searchTypeOfVehicle()) {
                    case "Bus": {
                        busArray[0].leavePark(busArray[0], vehicleNum, cmboDriver);
                    }break;

                    case "Van": {
                        for (Vehicle1 x : vanArray) {
                            if (x != null) {
                                x.leavePark(x, vehicleNum, cmboDriver);
                            }
                        }

                    }break;
                    case " Cargo Lorry": {
                        for (Vehicle1 c : cargoLorryArray) {
                            if(c!=null) {
                                c.leavePark(c, vehicleNum, cmboDriver);
                            }
                        }
                    }break;
                }
            } else {
               makeNotification("On Delivery Driver or Vehicle\nPlease Try Again");
               System.out.println("On Delivery Driver or Vehicle\nPlease Try Again");
            }
        }catch (Exception e){
          makeNotification("    Please select both,\n     1.Vehicle\n     2.Driver  ");
          System.out.println("Error in Delivery on action");
        }
   }

    public void displayDriverName(Vehicle1 y){
        for(Driver b : DriverArray){
            if(b!=null){
                if(b.getNIC().equals(y.getDriverNIC())){
                    cmboDriver.setValue(b.getDriverName());
                }
            }
        }
    }

    public boolean validateVehicle(){
        String vehicleNum = (String) comboType.getValue();
        System.out.println(vehicleNum);
        for (String x : vehicleSlotID) {
            System.out.print(x+" ");
            if (vehicleNum.equals(x)){
                System.out.println("true");
                return  true;
            }
        }
        System.out.println("false");
        return  false;
    }

    public boolean validateDriver(){
        String driverName=(String) cmboDriver.getValue();
        System.out.println(driverName);
        for(String tempName:onDeliveryDrivers){
            if(tempName!=null){
            if(tempName.equals(driverName)){
                System.out.println("false");
                return false;
            }}
        }
        System.out.println("true");
        return true;
    }

    public String searchTypeOfVehicle(){
        String vehicleNum = (String) comboType.getValue();
        if(vehicleNum.equals(busArray[0].getVehicleNumber())){return "Bus";}
        for(int i=0; i<6; i++ ){
            if(vanArray[i]!=null){
                if(vanArray[i].getVehicleNumber().equals(vehicleNum)){
                return "Van";
                }
            }
        }
        return " Cargo Lorry";
    }
}
