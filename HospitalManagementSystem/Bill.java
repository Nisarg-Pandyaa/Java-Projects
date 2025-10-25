package HMS;

public class Bill{
    private String billID;
    private String patientID;
    private double doctorFee;
    private double medicineFee;
    private double roomCharge;
    private double totalAmount;

    //CONSTRUCTOR
    public Bill(String billID,String patientID,double doctorFee,double medicineFee,double roomCharge,double totalAmount){
        this.billID = billID;
        this.patientID = patientID;
        this.doctorFee = doctorFee;
        this.medicineFee = medicineFee;
        this.roomCharge = roomCharge;
        this.totalAmount = totalAmount;
    }

    //GETTER & SETTER
    public String getBillID() {
        return billID;
    }
    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public double getDoctorFee() {
        return doctorFee;
    }
    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public double getMedicineFee() {
        return medicineFee;
    }
    public void setMedicineFee(double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public double getRoomCharge() {
        return roomCharge;
    }
    public void setRoomCharge(double roomCharge) {
        this.roomCharge = roomCharge;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

