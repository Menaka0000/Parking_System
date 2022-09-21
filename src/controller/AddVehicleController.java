package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class AddVehicleController extends DataBase {
    public ComboBox cmboType;
    public TextField txtVehicleNumber;
    public TextField txtMaxWeight;
    public TextField txtPassengers;
    public Label lblVTotal;
    public Label lblDelivery;
    public Label lblBasement;
    public Label lblDriver;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss  a");
    Date date = new Date();

    public void initialize(){
        cmboType.getItems().addAll("Bus","Van","Cargo Lorry");
        setLabels();
    }

    public void addOnAction(ActionEvent actionEvent) {
        int vehicleCount=0;
        int vanSlot=1;
        int lorrySlot=5;

        String type =(String) cmboType.getValue();
        System.out.println(type);
        switch (type) {
            case "Van": {
                int tempCount = 0;
                for (Vehicle1 x : vanArray) {
                    if (x == null) {
                        break;
                    }
                    tempCount++;
                    if (tempCount == 4) {
                        vanSlot = 12;
                    } else if (tempCount == 5) {
                        vanSlot = 13;
                    } else {
                        vanSlot++;
                    }
                }

                for (Vehicle1 x : vanArray) {
                    if (x == null) {
                        vanArray[vehicleCount] = new Van(vanSlot, txtVehicleNumber.getText(), "van", txtMaxWeight.getText(), txtPassengers.getText(), null,null,formatter.format(date) );
                        //vanSlotArray[vehicleCount] = vanSlot;
                        makeAlertNotification("\n\t\t\t\tA van added successfully");
                        vehicleSlotID[vanSlot-1]=txtVehicleNumber.getText();
                        if (vehicleCount == 3) {
                            vanSlot = 12;
                        }
                        break;
                    }
                    vehicleCount++;
                }
                System.out.println(Arrays.toString(vanArray));
                System.out.println(Arrays.toString(vanSlotArray));

                if (vanArray[vanArray.length-1 ] != null) {
                    System.out.println("You can't Add another Van at the movement");
                }

                for (Vehicle1 y : vanArray) {
                    if (y != null) {
                        System.out.print(y.getReservedSlotsVan());
                    }
                }
                System.out.println(Arrays.toString(vehicleSlotID));

            }
            break;
            case "Cargo Lorry": {
                //int tempCount = 0;
                for (Vehicle1 x : cargoLorryArray) {
                    if (x == null) {
                        break;
                    }
                   // tempCount++;
                    lorrySlot++;
                }


                for (Vehicle1 x : cargoLorryArray) {
                    if (x == null) {
                        System.out.println(lorrySlot);
                        cargoLorryArray[vehicleCount] = new CargoLorry(lorrySlot, txtVehicleNumber.getText(), "Cargo Lorry", txtMaxWeight.getText(), txtPassengers.getText(), null,null,formatter.format(date));
                        //lorrySlotArray[vehicleCount] = lorrySlot;
                        makeAlertNotification("\n\t\t\t\tA cargo lorry added successfully");
                        vehicleSlotID[lorrySlot-1]=txtVehicleNumber.getText();
                        break;
                    }
                    vehicleCount++;
                }
//                System.out.println(Arrays.toString(cargoLorryArray));
//                System.out.println(Arrays.toString(lorrySlotArray));

                if (cargoLorryArray[cargoLorryArray.length-1 ] != null) {
                    System.out.println("You can't Add another Lorry at the movement");
                }

                for (Vehicle1 y : cargoLorryArray) {
                    if (y != null) {
                        System.out.print(y.getReservedSlotsLorry());
                    }
                }
                System.out.println(Arrays.toString(vehicleSlotID));
            }break;
            case "Bus":{
                if(busArray[0]==null){
                    busArray[0]=new Bus(14,txtVehicleNumber.getText(),"Bus",txtMaxWeight.getText(),txtPassengers.getText(),null,null,formatter.format(date));
                    makeAlertNotification("\n\t\t\t\tA bus added successfully");
                    vehicleSlotID[13]=txtVehicleNumber.getText();
                }else{
                    System.out.println("you can't add another Bus at the Movement ");
                }
                System.out.println(Arrays.toString(busArray));
                System.out.println(Arrays.toString(vehicleSlotID));
            }break;
        }
         setLabels();
    }
    public void setLabels(){
        if(getTotalDriver()!=0){ lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblVTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}
    }
}

