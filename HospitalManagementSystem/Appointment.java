package HMS;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment{
    private String appointmentID;
    private String patientID;
    private String doctorID;
    private LocalDate date;
    private LocalTime time;
    private String status;

    //CONSTRUCTOR
    public Appointment(String appointmentID,String patientID,String doctorID,LocalDate date,LocalTime time,String status){
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    //GETTER & SETTER
    public String getAppointmentID(){
        return appointmentID;
    }
    public void setAppointmentID(String appointmentID){
        this.appointmentID = appointmentID;
    }

    public String getPatientID(){
        return patientID;
    }
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public String getDoctorID(){
        return doctorID;
    }
    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

