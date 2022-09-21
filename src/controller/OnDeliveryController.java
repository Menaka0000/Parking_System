package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DataBase;
import models.Driver;
import models.OnDeliveryTM;
import models.Vehicle1;

public class OnDeliveryController extends DataBase {
    public TableColumn colVehicleNumber;
    public TableView tblOnDelivery;
    public TableColumn colType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public Label lblDriver;
    public Label lblBasement;
    public Label lblDelivery;
    public Label lblVTotal;

    public void initialize(){
        ObservableList <OnDeliveryTM> deliveryOBL= FXCollections.observableArrayList();
        for(Vehicle1 x:vanArray){
            if(x !=null){
                if(x.getDriverNIC()!=null){
                    for(Driver name:DriverArray){
                        if(x.getDriverNIC().equals(name.getNIC())){
                            deliveryOBL.add(new OnDeliveryTM(x.getVehicleNumber(),x.getVehicleType(),name.driverName,x.getLeftTime() ));
                            break;
                        }
                    }

                }
            }

        }for(Vehicle1 y:cargoLorryArray){
            if(y !=null){
                if(y.getDriverNIC()!=null){
                    for(Driver name:DriverArray){
                        if(y.getDriverNIC().equals(name.getNIC())){
                            deliveryOBL.add(new OnDeliveryTM(y.getVehicleNumber(),y.getVehicleType(),name.driverName,y.getLeftTime() ));
                            break;
                        }
                    }

                }
            }

        }
        if(busArray[0]!=null){
            if(busArray[0].getDriverNIC()!=null){
                for(Driver name:DriverArray){
                    if (busArray[0].getDriverNIC().equals(name.getNIC())) {
                        deliveryOBL.add(new OnDeliveryTM(busArray[0].getVehicleNumber(), busArray[0].getVehicleType(), name.driverName, busArray[0].getLeftTime()));
                        break;
                    }
                }
            }
        }
        tblOnDelivery.setItems(deliveryOBL);

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        if(getTotalDriver()!=0){ lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblVTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}

    }
}
