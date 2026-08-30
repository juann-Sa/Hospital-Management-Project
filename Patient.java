//Patient Class

public class Patient{
    private int id;
    private String name;
    private int age;

    Patient(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return (name);
    }

    //Used in CustomLinkedList class to use findById method
    public int getId(){
        return id;
    }
}