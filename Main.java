//Driver class file

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    
    static CustomLinkedList<Patient> patients = new CustomLinkedList<>();
    static CustomLinkedList<Doctor> doctors = new CustomLinkedList<>();
    static CustomQueue<Appointment> appointments = new CustomQueue<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //Loop will make sure the menu displays as long as the user does not exit.
        //Loop also calls on the functions which handle all menu options.
        int choice = 0;
        do{
            try{
                displayMenu();
                choice = in.nextInt();
                in.nextLine();
                switch(choice){
                    case 1: addPatient(in); break;
                    case 2: addDoctor(in); break;
                    case 3: displayPatient(); break;
                    case 4: displayDoctors(); break;
                    case 5: createAppointment(in); break;
                    case 6: processAppointment(); break;
                    case 7: System.out.println("Exiting Program."); break;
                    default: System.out.println(("Invalid option. Select option 1-7."));
                }
                
            } catch(InputMismatchException e){
                System.out.println("Must enter a valid Integer.");
                in.nextLine();
            }
        } while(choice != 7);
        in.close();
    }

    public static void displayMenu(){
        System.out.println("\nHospital Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Display Patients");
        System.out.println("4. Display Doctors");
        System.out.println("5. Create Appointment");
        System.out.println("6. Process Next Appointment");
        System.out.println("7. Exit");
    }

    //Add Patient helper method.
    public static void addPatient(Scanner in){

        System.out.print("Enter Patient ID: ");
        int enteredID = in.nextInt();
        in.nextLine();

        //Checks if patient ID already exists before adding patient.
        if(patients.exists(enteredID)){
            System.out.println("Error, ID already exists.");
            return;
        //If patient ID does not exist, more information is requested and patient is added.
        } else {
            System.out.print("Enter Patient Name: ");
            String name = in.nextLine();

            //Checks if string is empty
            if(name.trim().isEmpty()){
                System.out.println("Error, need a name field.");
                return;
            }

            System.out.print("Enter Patient Age: ");
            int age = in.nextInt();

            Patient patient = new Patient(enteredID, name, age);
            patients.add(patient);
            System.out.println("Patient added successfully");
        }
    }
    //Add doctor helper method.
    public static void addDoctor(Scanner in){
        System.out.print("Enter Doctor ID: ");
        int enteredID = in.nextInt();
        in.nextLine();

        //Checks if doctor ID already exists before adding doctor.
        if(doctors.exists(enteredID)){
            System.out.println("Error, ID already exists.");
            return;
        //If doctor ID does not exist, more information is requested and doctor is added.
        } else {
            System.out.print("Enter doctor Name: ");
            String name = in.nextLine();

            //Checks if string is empty
            if(name.trim().isEmpty()){
                System.out.println("Error, need a name field.");
                return;
            }

            System.out.print("Enter doctor Specialization: ");
            String specialization = in.next();
            in.nextLine();

            //Checks if string is empty
            if(specialization.trim().isEmpty()){
                System.out.println("Error, need a specialization field.");
                return;
            }

            Doctor doctor = new Doctor(enteredID, name, specialization);
            doctors.add(doctor);
            System.out.println("Doctor added successfully.");
        }
    }

    //Display Patients.
    public static void displayPatient(){patients.displayAll();}
    //Display Doctors.
    public static void displayDoctors(){doctors.displayAll();}

    public static void createAppointment(Scanner in){
        if(patients.isEmpty() || doctors.isEmpty()){
            System.out.println("Patient/Doctor lists are empty, no appointment can be made.");
            return;
        }
        //Checks if patient ID exists in the patient list
        System.out.print("Enter Patient ID: ");
        int patientID = in.nextInt();
        Patient p = patients.findById(patientID);
        if(p == null){
            System.out.println("Patient ID could not be found.");
            return;
        }
        //Checks if doctor ID exists in the doctor list
        System.out.print("Enter Doctor ID: ");
        int doctorID = in.nextInt();
        Doctor d = doctors.findById(doctorID);
        if(d == null){
            System.out.println("Doctor ID could not be found.");
            return;
        }
        
        //Creates new appointment object and adds in to appointments queue.
        Appointment app = new Appointment(p , d);
        appointments.enqueue(app);
        System.out.println("Appointment added to queue.");
    }

    public static void processAppointment(){
        if(appointments.isEmpty()){
            System.out.println("Appointments list is empty.");
            return;
        }

        Appointment currentAppt = appointments.dequeue();
        System.out.println("Processing: Appointment: " + currentAppt.toString());
    }

}