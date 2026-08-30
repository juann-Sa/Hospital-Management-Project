//Appointment Class

public class Appointment{
    private Patient patient;
    private Doctor doctor;

    Appointment(Patient patient, Doctor doctor){
        this.patient = patient;
        this.doctor = doctor;
    }

    public String toString(){
        return ("Patient [" + patient + "] with Doctor [" + doctor + "]");
    }
}
