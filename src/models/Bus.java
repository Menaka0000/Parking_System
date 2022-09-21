package models;

import javafx.scene.control.ComboBox;

public class Bus extends DataBase implements Vehicle1 {
    public int reservedSlotOfBus;
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private String numOfPassengers;
    private String driverNIC;
    String leftTime;
    String parkedTime;

    public Bus(int reservedSlotOfBus,String vehicleNumber, String vehicleType, String maximumWeight, String numOfPassengers, String driverNIC,String leftTime, String parkedTime) {
        this.setReservedSlotOfBus(reservedSlotOfBus);
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaximumWeight(maximumWeight);
        this.setNumOfPassengers(numOfPassengers);
        this.setDriverNIC(driverNIC);
        this.leftTime = leftTime;
        this.parkedTime = parkedTime;
    }

    @Override
    public void parkVehicle(Vehicle1 y ,String vehicleNum) {
        if(busArray[0].getVehicleNumber().equals(vehicleNum)){
            vehicleSlotID[13] = busArray[0].getVehicleNumber();
            driverReset(busArray[0]);
            busArray[0].setParkedTime(formatter.format(date));
//            System.out.println("Park method of bla bla bus called");
        }
    }

    @Override
    public void leavePark(Vehicle1 y , String vehicleNum, ComboBox cmboDriver) {
        if(busArray[0].getVehicleNumber().equals(vehicleNum)) {
            vehicleSlotID[13] = null;
            busArray[0].setLeftTime(formatter.format(date));
            for (Driver a : DriverArray) {
                if (((String) cmboDriver.getValue()).equals(a.getDriverName())) {
                    busArray[0].setDriverNIC(a.getNIC());
                    onDeliveryDrivers[onDeliveryArrayCount++]=a.getDriverName();
                    if(onDeliveryArrayCount==14){onDeliveryArrayCount=0;}
//                    System.out.println("A bus Added Successfully");
                    break;
                }
            }
        }
    }
    @Override
    public int getReservedSlotsVan() {
        return 0;
    }

    @Override
    public int getReservedSlotsLorry() {
        return 0;
    }

    public int getReservedSlotOfBus(){return reservedSlotOfBus;}

    public void setReservedSlotOfBus(int reservedSlotOfBus){this.reservedSlotOfBus=reservedSlotOfBus;}

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public String getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(String numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    @Override
    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }


    public String getLeftTime() {
        return leftTime;
    }

    public String getParkedTime() {
        return parkedTime;
    }
}
