package HMS;

import javax.print.Doc;
import java.lang.constant.DynamicConstantDesc;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hospital{
    //DATA STORAGE
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Bill> bills;
    private PriorityQueue<Integer> recyclePID;
    private PriorityQueue<Integer> recycleDID;
    private int nextPatientId = 1;
    private int nextDoctorId = 1;
    private int nextAppointmentID = 1;

    private Scanner sc = new Scanner(System.in);

    //CONSTRUCTOR
    public Hospital(){
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        bills = new ArrayList<>();
        recyclePID = new PriorityQueue<>();
        recycleDID = new PriorityQueue<>();
    }

    //PATIENT MANAGEMENT
    public void addPatient(){
        System.out.println("~~~ [ADD NEW PATIENT] ~~~");

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine().toUpperCase();

        System.out.println("Enter Disease:");
        String disease = sc.nextLine();

        System.out.println("Enter Doctor Assigned:");
        String drAssigned = sc.nextLine();

        System.out.println("Enter Patient's Contact Number:");
        String contactNumber = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        String patientID;
        if(!recyclePID.isEmpty()) patientID = "P" + (recyclePID.poll());
        else patientID = "P" + (nextPatientId++);


        Patient newPatient = new Patient(patientID,name,age,gender,disease,drAssigned,contactNumber,address);

        patients.add(newPatient);

        System.out.println("Patient "+name+" Added Successfully With ID: "+patientID);
    }
    public void viewAllPatient(){
        System.out.println("~~~ [PATIENT LIST] ~~~");
        if(patients.isEmpty()){
            System.out.println("No Patient Found");
            return;
        }

        for(Patient p : patients){
            System.out.println(p.getPatientID() +" : "+p.getName());
        }

    }
    public void updatePatient(){
        System.out.println("~~~ [UPDATE PATIENT'S DETAILS] ~~~");
        System.out.println("Enter Patient ID To Update:");
        String pid = sc.nextLine().toUpperCase();

        Patient found = null;
        for(Patient p : patients){
            if(p.getPatientID().toUpperCase().equals(pid)){
                found = p;
                break;
            }
        }

        if(found == null){
            System.out.println("Patient Not Found");
            return;
        }

        System.out.println("Editing Patient Details");
        System.out.println(found.getPatientID() +" : "+ found.getName());

        System.out.println("Enter New Disease (Leave Blank To Skip):");
        String newDisease = sc.nextLine();
        if(!newDisease.isBlank()) found.setDisease(newDisease);

        System.out.println("Enter New Doctor Assigned (Leave Blank To Skip):");
        String newDr = sc.nextLine();
        if(!newDr.isBlank()) found.setDoctorAssigned(newDr);

        System.out.println("Enter New Contact Number (Leave Blank To Skip):");
        String newNo = sc.nextLine();
        if(!newNo.isBlank()) found.setContactNumber(newNo);

        System.out.println("Enter New Address (Leave Blank To Skip):");
        String newAddress = sc.nextLine();
        if(!newAddress.isBlank()) found.setAddress(newAddress);

        System.out.println("Patient "+found.getPatientID()+" -> Details Updated!");

    }
    public void removePatient(){
        //Can add fn to view list
        System.out.println("~~~ [REMOVE PATIENT] ~~~");
        System.out.println("Enter Patient ID To Remove:");
        String pid = sc.nextLine().toUpperCase();

        boolean found = false;

        for(int i=0;i<patients.size();i++){
            Patient p = patients.get(i);
            if(p.getPatientID().toUpperCase().equals(pid)){
                patients.remove(i);

                //get P[number]
                try {
                    int numPart = Integer.parseInt(pid.substring(1));
                    recyclePID.add(numPart);
                } catch (NumberFormatException e){
                    System.out.println("Error In Parsing Integer From "+pid);
                }

                System.out.println(p.getName() + " (" + pid + ") removed from records.");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Patient With ID "+pid+" Doesn't Exist");
        }

    }
    public void searchPatient(){
        System.out.println("~~~ [SEARCH PATIENT] ~~~");
        System.out.println("Enter Patient ID:");
        String pid = sc.nextLine().toUpperCase();

        boolean found = false;
        for(Patient p : patients){
            if(p.getPatientID().toUpperCase().equals(pid)){
                System.out.println(p);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No Matching Patient Found!");
        }
    }

    //DOCTOR MANAGEMENT
    public void addDoctor(){
        System.out.println("~~~ [ADD NEW DOCTOR] ~~~");

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Doctor's Specialization:");
        String speciality = sc.nextLine();

        System.out.println("Enter Contact Number:");
        String contactNumber = sc.nextLine();

        String drID;
        if(!recycleDID.isEmpty()) drID = "D" + (recycleDID.poll());
        else drID = "D" + (nextDoctorId++);

        String available = "YES" ;

        Doctor newDoctor = new Doctor(drID,name,speciality,available,contactNumber);

        doctors.add(newDoctor);

        System.out.println("Dr. "+name+" Is Added Successfully With ID: "+drID);
    }
    public void viewAllDoctor(){
        System.out.println("~~~ [DOCTOR LIST] ~~~");

        if(doctors.isEmpty()){
            System.out.println("No Doctor Found");
            return;
        }

        for(Doctor d : doctors){
            System.out.println(d.getDoctorID()+" : "+d.getName()+" ~ Availability ("+d.getAvailability()+")");
        }
    }
    public void updateDoctor(){
        //Can add fn to print dr's deatils first
        System.out.println("~~~ [UPDATE DOCTOR'S DETAILS] ~~~");
        System.out.println("Enter Doctor ID To Update: ");
        String did = sc.nextLine().toUpperCase();

        Doctor found = null;
        for(Doctor d : doctors){
            if(d.getDoctorID().toUpperCase().equals(did)){
                found = d;
                break;
            }
        }

        if(found == null){
            System.out.println("Doctor Not Found");
            return;
        }

        System.out.println("Editing Doctor Details");
        System.out.println(found.getDoctorID()+" : "+found.getName());

        System.out.println("Enter Doctor's New Specialization (Leave Blank To Skip): ");
        String newSpec = sc.nextLine();
        if(!newSpec.isBlank()) found.setSpecialization(newSpec);

        System.out.println("Enter Doctor's New Contact Number (Leave Blank To Skip): ");
        String newConNum = sc.nextLine();
        if(!newConNum.isBlank()) found.setContactNumber(newConNum);

        System.out.println("Doctor "+found.getDoctorID()+" -> Details Updates!");


    }
    public void removeDoctor(){
        //Can add fn to view list
        System.out.println("~~~ [REMOVE DOCTOR] ~~~");
        System.out.println("Enter Doctor ID To Remove:");
        String did = sc.nextLine().toUpperCase();

        boolean found = false;

        for(int i=0;i<doctors.size();i++){
            Doctor d = doctors.get(i);
            if(d.getDoctorID().toUpperCase().equals(did)){
                doctors.remove(i);

                //get D[number]
                try {
                    int numPart = Integer.parseInt(did.substring(1));
                    recycleDID.add(numPart);
                } catch (NumberFormatException e){
                    System.out.println("Error In Parsing Integer From "+did);
                }

                System.out.println(d.getName() + " (" + did + ") removed from records.");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Doctor With ID "+did+" Doesn't Exist");
        }

    }
    public void searchDoctor(){
        System.out.println("~~~ [SEARCH DOCTOR] ~~~");
        System.out.println("Enter Doctor ID:");
        String did = sc.nextLine().toUpperCase();

        boolean found = false;
        for(Doctor d : doctors){
            if(d.getDoctorID().toUpperCase().equals(did)){
                System.out.println(d);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No Matching Doctor Found!");
        }

    }

    //APPOINTMENT MANAGEMENT
    public void scheduleAppointment(){
        System.out.println("~~~ [SCHEDULE NEW APPOINTMENT] ~~~");

        System.out.println("Enter Patient ID:");
        String pid = sc.nextLine();
        Patient patient = null;
        for(Patient p : patients){
            if(p.getPatientID().toUpperCase().equals(pid)){
                patient = p;
                 break;
            }
        }
        if(patient==null){
            System.out.println("Patient Not Found!");
            return;
        }

        System.out.println("Enter Doctor ID:");
        String did = sc.nextLine();
        Doctor doctor = null;
        for(Doctor d : doctors){
            if(d.getDoctorID().toUpperCase().equals(did)){
                doctor = d;
                break;
            }
        }
        if(doctor==null){
            System.out.println("Doctor Not Found!");
            return;
        }

        if(!doctor.getAvailability().toUpperCase().equals("YES")){
            System.out.println("Dr. "+doctor.getName()+" ("+doctor.getDoctorID()+") Is Currently Not Available!");
            return;
        }

        System.out.print("Enter appointment date (yyyy-MM-dd): ");
        String dateInput = sc.nextLine();

        System.out.print("Enter appointment time (HH:mm): ");
        String timeInput = sc.nextLine();
        LocalDate date = null;
        LocalTime time = null;
        try {
            date = LocalDate.parse(dateInput);
            time = LocalTime.parse(timeInput);

        } catch (Exception e) {
            System.out.println("Invalid date or time format! Please use yyyy-MM-dd for date and HH:mm for time.");
            return;
        }

        String appID = "A"+ (nextAppointmentID++);

        Appointment newApp = new Appointment(appID,pid,did,date,time,"Scheduled");

        appointments.add(newApp);

        System.out.println("Appointment Is Scheduled For Patient "+patient.getName()+" ("+patient.getPatientID()+") With Dr. "+doctor.getName()+" ("+doctor.getDoctorID()+") !");

    }
    public void reScheduleAppointment(){
        //can add fn to show details of appointment
        System.out.println("~~~ [RE-SCHEDULE APPOINTMENT] ~~~");
        System.out.println("Enter Appointment ID:");
        String appID  = sc.nextLine().toUpperCase();

        Appointment da = null;
        for(Appointment a : appointments){
            if(a.getAppointmentID().toUpperCase().equals(appID)){
                if(a.getStatus().equalsIgnoreCase("Cancelled")){
                    System.out.println("This Appointment Is Cancelled");
                    return;
                }
                da = a;
                break;
            }
        }

        if(da==null){
            System.out.println("No Appointment Found!");
            return;
        }

        System.out.println("Enter New Doctor ID (Leave Blank To Skip):");
        String newDr = sc.nextLine();
        if(!newDr.isBlank()){
            boolean drExists = false;
            for(Doctor d : doctors) {
                if(d.getDoctorID().toUpperCase().equals(newDr)) {
                    drExists = true;
                    break;
                }
            }
            if(!drExists) {
                System.out.println("No Doctor Found With ID " + newDr);
                return;
            }

            da.setDoctorID(newDr);
        }

        System.out.println("Enter New Date To Schedule [yyyy-MM-dd] (Leave Blank To Skip):");
        String dateInput = sc.nextLine().trim();
        LocalDate date = null;
        if(!dateInput.isBlank()){
            try {
                date = LocalDate.parse(dateInput);

            } catch (Exception e) {
                System.out.println("Invalid date format! Please use yyyy-MM-dd for date.");
                return;
            }
            da.setDate(date);
        }

        System.out.println("Enter New Time To Schedule [HH:mm] (Leave Blank To Skip):");
        String timeInput = sc.nextLine().trim();
        LocalTime time = null;
        if(!timeInput.isBlank()){
            try {
                time = LocalTime.parse(timeInput);

            } catch (Exception e) {
                System.out.println("Invalid time format! Please use HH:mm for time.");
                return;
            }
            da.setTime(time);
        }
        if(!da.getStatus().equalsIgnoreCase("Scheduled"))
            da.setStatus("Scheduled");
        System.out.println("Appointment "+da.getAppointmentID()+" Of Patient "+getPatientNameByID(da.getPatientID())+" Is Rescheduled!");
    }
    public void cancelAppointment(){
        System.out.println("~~~ [CANCEL APPOINTMENT] ~~~");
        System.out.println("Enter Appointment ID:");
        String appID = sc.nextLine().toUpperCase();

        boolean found = false;

        for (Appointment a : appointments) {
            if (a.getAppointmentID().toUpperCase().equals(appID)) {
                if (a.getStatus().equalsIgnoreCase("Cancelled")) {
                    System.out.println("This appointment is already cancelled!");
                    return;
                }
                a.setStatus("Cancelled");
                System.out.println("Appointment " + appID + " has been cancelled successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("No Appointment Found With ID "+appID);
    }
    public void viewAllAppointments(){
        System.out.println("~~~ [ALL APPOINTMENTS] ~~~");
        if(appointments.isEmpty()){
            System.out.println("No Appointments Found!");
            return;
        }
        for(Appointment a : appointments){
            String pName = getPatientNameByID(a.getPatientID());
            String dName = getDoctorNameByID(a.getDoctorID());
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            System.out.println(a.getAppointmentID()+" | Patient: "+pName+" ("+a.getPatientID()+") | Doctor: "+dName+" ("+a.getDoctorID()+") | Date: "+a.getDate().format(dateFormatter)+" | Time: "+a.getTime().format(timeFormatter)+" | Status: "+a.getStatus());
        }

    }
    private String getPatientNameByID(String pid) {
        for (Patient p : patients) {
            if (p.getPatientID().equalsIgnoreCase(pid)) return p.getName();
        }
        return "Unknown";
    }
    private String getDoctorNameByID(String did) {
        for (Doctor d : doctors) {
            if (d.getDoctorID().equalsIgnoreCase(did)) return d.getName();
        }
        return "Unknown";
    }

    //BILLS MANAGEMENT
    public void generateBill(){
        System.out.println("~~~ [GENERATE BILL] ~~~");
        System.out.print("Enter Patient ID: ");
        String pid = sc.nextLine().toUpperCase();

        // Validate Patient ID
        Patient targetPatient = null;
        for (Patient p : patients) {
            if (p.getPatientID().toUpperCase().equals(pid)) {
                targetPatient = p;
                break;
            }
        }

        if (targetPatient == null) {
            System.out.println("No Patient Found With ID " + pid);
            return;
        }

        System.out.print("Enter Doctor Fee: ");
        double doctorFee = sc.nextDouble();
        System.out.print("Enter Medicine Fee: ");
        double medicineFee = sc.nextDouble();
        System.out.print("Enter Room Charge: ");
        double roomCharge = sc.nextDouble();
        sc.nextLine(); // consume newline

        double total = doctorFee + medicineFee + roomCharge;

        // Generate unique Bill ID
        String billID = "B" + (bills.size() + 1);

        Bill newBill = new Bill(billID,pid,doctorFee,medicineFee,roomCharge,total);
        bills.add(newBill);

        System.out.println("Bill Generated Successfully!");
        System.out.println("Bill ID: " + billID + " | Patient: " + targetPatient.getName());
        System.out.println("Total Amount: ₹" + total);
    }
    public void viewAllBills(){
        System.out.println("~~~ [ALL BILLS] ~~~");
        if (bills.isEmpty()) {
            System.out.println("No Bills Found!");
            return;
        }

        for (Bill b : bills) {
            String pName = getPatientNameByID(b.getPatientID());
            System.out.println("--------------------------------------------");
            System.out.println("Bill ID: " + b.getBillID());
            System.out.println("Patient: " + pName + " (" + b.getPatientID() + ")");
            System.out.println("Doctor Fee: ₹" + b.getDoctorFee());
            System.out.println("Medicine Fee: ₹" + b.getMedicineFee());
            System.out.println("Room Charge: ₹" + b.getRoomCharge());
            System.out.println("Total Amount: ₹" + b.getTotalAmount());
            System.out.println("--------------------------------------------");
        }
    }
    public void viewPatientBills(){
        System.out.println("~~~ [PATIENT BILLS] ~~~");
        System.out.print("Enter Patient ID: ");
        String pid = sc.nextLine().toUpperCase();

        // Validate patient existence
        Patient targetPatient = null;
        for (Patient p : patients) {
            if (p.getPatientID().toUpperCase().equals(pid)) {
                targetPatient = p;
                break;
            }
        }

        if (targetPatient == null) {
            System.out.println("No Patient Found With ID " + pid);
            return;
        }

        boolean found = false;
        for (Bill b : bills) {
            if (b.getPatientID().equalsIgnoreCase(pid)) {
                if (!found) {
                    System.out.println("Bills for " + targetPatient.getName() + " (" + pid + "):");
                    found = true;
                }
                System.out.println("--------------------------------------------");
                System.out.println("Bill ID: " + b.getBillID());
                System.out.println("Doctor Fee: ₹" + b.getDoctorFee());
                System.out.println("Medicine Fee: ₹" + b.getMedicineFee());
                System.out.println("Room Charge: ₹" + b.getRoomCharge());
                System.out.println("Total Amount: ₹" + b.getTotalAmount());
            }
        }

        if (!found)
            System.out.println("No bills found for this patient.");
        else
            System.out.println("--------------------------------------------");
    }

    //REPORT GENERATION
    public void viewReport(){
        System.out.println("~~~ [PATIENT REPORT GENERATION] ~~~");
        System.out.println("Enter Patient ID:");
        String pid = sc.nextLine().toUpperCase();

        Patient found = null;
        for(Patient p : patients){
            if(p.getPatientID().toUpperCase().equals(pid)){
                found = p;
                break;
            }
        }

        if(found==null){
            System.out.println("No Patient Found ID : "+pid);
            return;
        }

        System.out.println("<====={"+found.getName()+"'s Report}=====>");
        System.out.println();
        System.out.println("Patient ID: "+found.getPatientID());
        System.out.println("Name: "+found.getName());
        System.out.println("Age: "+found.getAge());
        System.out.println("Gender: "+found.getGender());
        System.out.println("Disease: "+found.getDisease());
        System.out.println("Doctor Assigned: "+found.getDoctorAssigned());
        System.out.println("Contact: "+found.getContactNumber());
        System.out.println("Address: "+found.getAddress());
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println(">Appointment History<");
        boolean hasAppointment = false;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        for (Appointment a : appointments) {
            if (a.getPatientID().equalsIgnoreCase(pid)) {
                String dName = getDoctorNameByID(a.getDoctorID());
                System.out.println("v");
                System.out.println("Appointment ID: " + a.getAppointmentID());
                System.out.println("Doctor: " + dName + " (" + a.getDoctorID() + ")");
                System.out.println("Date: " + a.getDate().format(dateFormatter));
                System.out.println("Time: " + a.getTime().format(timeFormatter));
                System.out.println("Status: " + a.getStatus());
                hasAppointment = true;
            }
        }
        if (!hasAppointment) System.out.println("No appointment records found.");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println(">Billing History<");
        boolean hasBill = false;
        for(Bill b : bills){
            if(b.getPatientID().toUpperCase().equals(pid)){
                System.out.println("v");
                System.out.println("Bill ID: "+b.getBillID());
                System.out.println("Doctor Fee: "+b.getDoctorFee());
                System.out.println("Medicine Fee: "+b.getMedicineFee());
                System.out.println("Room Charge: "+b.getRoomCharge());
                System.out.println("Total Amount: "+b.getTotalAmount());
                hasBill = true;
            }
        }

        if(!hasBill) System.out.println("No Billing Record Found.");
        System.out.println();
        System.out.println("<====={End Of Report}=====>");
    }
}
