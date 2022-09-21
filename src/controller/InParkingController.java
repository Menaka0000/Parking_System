package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.*;

public class InParkingController extends DataBase {

    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colSlot;
    public TableColumn colParkedTime;
    public Label lblVTotal;
    public Label lblDriver;
    public Label lblDelivery;
    public Label lblBasement;

    public void initialize(){
        ObservableList<InParkingTM> parkingOBL= FXCollections.observableArrayList();
        for(Vehicle1 x:vanArray){
            if(x !=null){
                if(x.getDriverNIC()==null){
                    parkingOBL.add(new InParkingTM(x.getVehicleNumber(),x.getVehicleType(),x.getReservedSlotsVan(),x.getParkedTime() ));
                }
            }
        }
        for(Vehicle1 y:cargoLorryArray){
            if(y !=null){
                if(y.getDriverNIC()==null){
                    parkingOBL.add(new InParkingTM(y.getVehicleNumber(),y.getVehicleType(),y.getReservedSlotsLorry(),y.getParkedTime() ));
                }
            }
        }
        if(busArray[0]!=null){
            if(busArray[0].getDriverNIC()==null){
                parkingOBL.add(new InParkingTM(busArray[0].getVehicleNumber(),busArray[0].getVehicleType(),14,busArray[0].getParkedTime() ));
            }
        }
        tblInParking.setItems(parkingOBL);

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colSlot.setCellValueFactory(new PropertyValueFactory<>("slot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));

        if(getTotalDriver()!=0){ lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblVTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}
    }

}
