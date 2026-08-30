//Doctor Class

public class Doctor{
    private int id;
    private String name;
    private String specialization;

    Doctor(int id, String name, String specialization){
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String toString(){
        return (name);
    }

    //Used in CustomLinkedList class to use findById method
    public int getId(){
        return id;
    }
}