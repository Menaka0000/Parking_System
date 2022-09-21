package models;

public class Driver {
    public String driverName;
    public String NIC;
    public String drivingLicenseNum;
    public String contactNum;

    public Driver(String driverName, String NIC, String drivingLicenseNum, String address, String contactNum) {
        this.driverName = driverName;
        this.NIC = NIC;
        this.drivingLicenseNum = drivingLicenseNum;
        this.address = address;
        this.contactNum = contactNum;
    }

//    public void setDriverName(String driverName) {
//        this.driverName = driverName;
//    }
//
//    public void setNIC(String NIC) {
//        this.NIC = NIC;
//    }
//
//    public void setDrivingLicenseNum(String drivingLicenseNum) {
//        this.drivingLicenseNum = drivingLicenseNum;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setContactNum(String contactNum) {
//        this.contactNum = contactNum;
//    }

    public String address;

    public String getDriverName() {
        return driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public String getDrivingLicenseNum() {
        return drivingLicenseNum;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNum() {
        return contactNum;
    }




}
