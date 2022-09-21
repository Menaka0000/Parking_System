package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.DataBase;
import models.Driver;
import java.util.Arrays;

public class AddDriverController extends DataBase {
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtDrivingLicenseNum;
    public TextField txtAddress;
    public TextField txtContact;
    public Label lblVTotal;
    public Label lblBasement;
    public Label lblDelivery;
    public Label lblDriver;

    public void initialize(){
       setLabels();
    }

    public void driverAddOnAction(ActionEvent actionEvent) {
        int index=0;
        for (Driver x:DriverArray){
            if( x==null){
                DriverArray[index]=new Driver(txtName.getText(),txtNIC.getText(),txtDrivingLicenseNum.getText(),txtAddress.getText(),txtContact.getText());
                makeAlertNotification("\n\t\t\t\tA Driver added Successfully");
                break;
            }
            index++;
        }
        System.out.println(Arrays.toString(DriverArray));

        if(DriverArray[DriverArray.length-1]!=null) {
            System.out.println("You can't Add another driver at the movement");
        }

        for(Driver y : DriverArray){
            if(y!=null){
                System.out.println(y.getDriverName());
            }
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
