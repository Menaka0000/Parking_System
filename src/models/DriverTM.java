package models;

public class DriverTM {
    private String name;
    private String NIC;
    private String DLNo;
    private String address;
    private String contact;

    public DriverTM() {
    }

    public DriverTM(String name, String NIC, String DLNo, String address, String contact) {
        this.setName(name);
        this.setNIC(NIC);
        this.setDLNo(DLNo);
        this.setAddress(address);
        this.setContact(contact);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDLNo() {
        return DLNo;
    }

    public void setDLNo(String DLNo) {
        this.DLNo = DLNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
