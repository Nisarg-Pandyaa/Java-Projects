package HMS;

public class Patient {
    private String patientID;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String doctorAssigned;
    private String contactNumber;
    private String address;

    //CONSTRUCTOR
    public Patient(String patientID,String name,int age,String gender,String disease,String doctorAssigned,String contactNumber,String address){
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.doctorAssigned = doctorAssigned;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    //GETTER & SETTER
    public String getPatientID(){
        return patientID;
    }
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getDisease(){
        return disease;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }

    public String getDoctorAssigned(){
        return doctorAssigned;
    }
    public void setDoctorAssigned(String doctorAssigned){
        this.doctorAssigned = doctorAssigned;
    }

    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }


}

