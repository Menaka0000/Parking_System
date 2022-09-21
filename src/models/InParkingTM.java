package models;

public class InParkingTM {
    private String vehicleNumber;
    private String type;
    private int slot;
    private String parkedTime;

    public InParkingTM(String vehicleNumber, String type, int slot, String parkedTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setType(type);
        this.setSlot(slot);
        this.setParkedTime(parkedTime);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }
}
