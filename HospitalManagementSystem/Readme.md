# 🏥 Hospital Management System (Java)

A comprehensive **Hospital Management System (HMS)** built entirely in **Core Java** using **Object-Oriented Programming (OOP)** principles.  
This project efficiently manages patients, doctors, appointments, and billing. Offering a real-world simulation of hospital operations.

---

## 💡 Overview

The Hospital Management System provides a **menu-driven console interface** that allows administrators, doctors, and receptionists to handle essential hospital tasks such as managing patient data, scheduling appointments, generating bills, and viewing reports.

The system follows an **OOP architecture**, with each entity represented as a separate Java class, ensuring modularity, scalability, and maintainability.

---

## 🔹 Core Features (Functional Requirements)

### 🧍 Patient Management
- Add new patient records  
- View all patients  
- Update patient details (disease, doctor assigned, etc.)  
- Delete patient records  
- Search patients by **ID** or **name**

### 🩺 Doctor Management
- Add new doctor profiles  
- View all doctors  
- Update doctor specialization or availability  
- Delete doctor records  
- Search doctor by **ID** or **specialization**

### 📅 Appointment Management
- Schedule appointments between patients and doctors  
- Check doctor availability before scheduling  
- View all appointments  
- Cancel or reschedule appointments  

### 💳 Billing System
- Generate bills for patients  
- Include doctor fees, medicine costs, and room charges  
- Automatically calculate total  

### 📊 Report Generation
- Generate patient's whole time report   

---

## 🧱 Entities (OOP Classes)

| Entity | Attributes | Description |
|:-------|:------------|:-------------|
| **Patient** | `patientId`, `name`, `age`, `gender`, `disease`, `doctorAssigned`, `contactNumber`, `address` | Stores patient information |
| **Doctor** | `doctorId`, `name`, `specialization`, `availability`, `contactNumber` | Stores doctor details |
| **Appointment** | `appointmentId`, `patientId`, `doctorId`, `date`, `time`, `status` | Handles scheduling and management of appointments |
| **Bill** | `billId`, `patientId`, `doctorFee`, `medicineCost`, `roomCharge`, `totalAmount` | Manages billing and total calculation |
| **Hospital** | `ArrayList` of patients, doctors, appointments, and bills | Acts as the main controller to manage all operations |

---

## ⚙️ System Workflow

- Display Main Menu: <br>
  1.)Manage Patients

  2.)Manage Doctors

  3.)Manage Appointments

  4.)Manage Billing

  5.)View Reports

  6.)Exit

### 🧍 Manage Patients
- Add new patient → auto-generate ID  
- Update or delete existing records  
- Search by name or ID  

### 🩺 Manage Doctors
- Add or edit doctor details  
- Manage specialization and availability  
- Search by ID or specialization  

### 📅 Manage Appointments
- Enter Patient ID → Doctor ID → Date → Time  
- Check if doctor is available  
- Schedule or reschedule appointment  

### 💳 Billing System
- Enter patient ID and charges  
- Automatically calculate total  

### 📊 Reports
- Show particular patient's all appointments and bills

### 🛑 Exit
- Cleanly terminates the system

---

## 🧠 Concepts Used
- **Object-Oriented Programming (OOP)**
  - Classes & Objects
  - Encapsulation
  - Data Abstraction
  - Method Overloading
- **Java Collections (ArrayList)**
- **Modular Design**
- **Menu-Driven Console Application**
- **Data Validation & Control Flow**

---

## 🧑‍💻 Author
Developed by **Nisarg Pandya**  
A Java console project demonstrating strong OOP architecture, real-world problem-solving, and modular system design.
