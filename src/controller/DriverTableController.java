package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DataBase;
import models.Driver;
import models.DriverTM;

public class DriverTableController extends DataBase {
    public TableView tblDriver;
    public TableColumn colDriverName;
    public TableColumn colNIC;
    public TableColumn colDrivingLicenseNp;
    public TableColumn colAddress;
    public TableColumn colContact;
    public Label lblVTotal;
    public Label lblDriver;
    public Label lblDelivery;
    public Label lblBasement;

    public void initialize(){
        ObservableList<DriverTM> tmObservableList= FXCollections.observableArrayList();
        for(Driver z:DriverArray){
            if(z!=null){
                tmObservableList.add(new DriverTM(z.getDriverName(),z.getNIC(),z.getDrivingLicenseNum(),z.getAddress(),z.getContactNum()));
            }
        }
        tblDriver.setItems(tmObservableList);

        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colDrivingLicenseNp.setCellValueFactory(new PropertyValueFactory<>("DLNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        if(getTotalDriver()!=0){lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblVTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}
    }

}
