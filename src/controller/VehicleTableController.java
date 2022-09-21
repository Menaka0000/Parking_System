package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DataBase;
import models.Vehicle1;

public class VehicleTableController extends DataBase {
    public TableColumn colVehicleNumber;
    public TableColumn colType;
    public TableColumn colWeight;
    public TableColumn colPassengers;
    public TableView tblVehicle;
    public Label lblVTotal;
    public Label lblDriver;
    public Label lblDelivery;
    public Label lblBasement;

    public void initialize(){
        ObservableList<Vehicle1>vehicleObservableList= FXCollections.observableArrayList();
        vehicleObservableList.add(busArray[0]);
        for(Vehicle1 x:vanArray){
            if(x!=null){
                vehicleObservableList.add(x);
            }
        }
        for(Vehicle1 y : cargoLorryArray){
            if(y!=null){
                vehicleObservableList.add(y);
            }
        }

        tblVehicle.setItems(vehicleObservableList);

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("maximumWeight"));
        colPassengers.setCellValueFactory(new PropertyValueFactory<>("numOfPassengers"));

        if(getTotalDriver()!=0){ lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblVTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}
    }
}
