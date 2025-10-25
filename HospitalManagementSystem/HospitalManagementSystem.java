package HMS;

import java.util.*;

public class HospitalManagementSystem {

    private static void patientMenu(Hospital hp, Scanner sc) {
        while(true){
            System.out.println("<=====(PATIENT MENU)=====>");
            System.out.println("[1] Add New Patient");
            System.out.println("[2] Update Patient's Details");
            System.out.println("[3] Remove Patient");
            System.out.println("[4] See Patient Details");
            System.out.println("[5] Patient List");
            System.out.println("[0] Back");

            int pChoosen = sc.nextInt();
            sc.nextLine();

            switch(pChoosen){
                case 1:
                    hp.addPatient();
                    break;

                case 2:
                    hp.updatePatient();
                    break;

                case 3:
                    hp.removePatient();
                    break;

                case 4:
                    hp.searchPatient();
                    break;

                case 5:
                    hp.viewAllPatient();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Please Enter Valid Choice!");

            }
        }
    }

    private static void doctorMenu(Hospital hp, Scanner sc) {
        while(true){
            System.out.println("<=====(DOCTOR MENU)=====>");
            System.out.println("[1] Add Doctor");
            System.out.println("[2] Update Doctor's Details");
            System.out.println("[3] Remove Doctor");
            System.out.println("[4] See Doctor Details");
            System.out.println("[5] Doctor List");
            System.out.println("[0] Back");

            int dChoosen = sc.nextInt();
            sc.nextLine();

            switch (dChoosen){
                case 1:
                    hp.addDoctor();
                    break;

                case 2:
                    hp.updateDoctor();
                    break;

                case 3:
                    hp.removeDoctor();
                    break;

                case 4:
                    hp.searchDoctor();
                    break;

                case 5:
                    hp.viewAllDoctor();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Please Enter Valid Choice!");
            }
        }
    }

    private static void appointmentMenu(Hospital hp, Scanner sc) {
        while(true){
            System.out.println("<=====(APPOINTMENT MENU)=====>");
            System.out.println("[1] Schedule An Appointment");
            System.out.println("[2] Re-Schedule An Appointment");
            System.out.println("[3] Cancel An Appointment");
            System.out.println("[4] Appointment History");
            System.out.println("[0] Back");

            int aChoosen = sc.nextInt();
            sc.nextLine();

            switch (aChoosen){
                case 1:
                    hp.scheduleAppointment();
                    break;

                case 2:
                    hp.reScheduleAppointment();
                    break;

                case 3:
                    hp.cancelAppointment();
                    break;

                case 4:
                    hp.viewAllAppointments();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Please Enter Valid Choice!");
            }
        }
    }

    private static void billingMenu(Hospital hp, Scanner sc) {
        while(true){
            System.out.println("<=====(BILLING MENU)=====>");
            System.out.println("[1] Generate Bill");
            System.out.println("[2] All Bills");
            System.out.println("[3] Patient's Bills");
            System.out.println("[0] Back");

            int bChoosen = sc.nextInt();
            sc.nextLine();

            switch(bChoosen){
                case 1:
                    hp.generateBill();
                    break;

                case 2:
                    hp.viewAllBills();
                    break;

                case 3:
                    hp.viewPatientBills();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Please Enter Valid Choice!");

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hospital HP =new Hospital();

        while(true){
            System.out.println("<===============================================>");
            System.out.println("        {HOSPITAL MANAGEMENT SYSTEM MENU}        ");
            System.out.println("<===============================================>");
            System.out.println("[1] Patient Management");
            System.out.println("[2] Doctor Management");
            System.out.println("[3] Appointment Management");
            System.out.println("[4] Bills Management");
            System.out.println("[5] Report Management");
            System.out.println("[0] Exit");

            System.out.println("Enter Your Choice : ");

            int choosen = sc.nextInt();
            sc.nextLine();

            switch (choosen){
                case 1:
                    patientMenu(HP,sc);
                    break;
                    
                case 2:
                    doctorMenu(HP,sc);
                    break;
                    
                case 3:
                    appointmentMenu(HP,sc);
                    break;

                case 4:
                    billingMenu(HP,sc);
                    break;

                case 5:
                    HP.viewReport();
                    break;

                case 0:
                    System.out.println("Thank You For Using Hospital Management System");
                    return;

                default:
                    System.out.println("Please Enter Valid Choice!");

            }

        }
    }

}
