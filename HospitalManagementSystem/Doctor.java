package HMS;

public class Doctor{
    private String doctorID;
    private String name;
    private String specialization;
    private String availability;
    private String contactNumber;

    //CONSTRUCTOR
    public Doctor(String doctorID,String name,String specialization,String availability,String contactNumber){
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.contactNumber = contactNumber;
    }

    //GETTER & SETTER
    public String getDoctorID(){
        return doctorID;
    }
    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSpecialization(){
        return specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public String getAvailability(){
        return availability;
    }
    public void setAvailability(String availability){
        this.availability = availability;
    }

    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

}

