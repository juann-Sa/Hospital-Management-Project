//Custom Linked List class used to build what will become the queue

public class CustomLinkedList <T>{
    Node<T> head;

    public void add(T data){
        if(head == null){
            head = new Node<>(data);
        }else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new Node<>(data);
        }

    }

    public T findById(int id){
        Node<T> temp = head;
        //checks if the data entered is a patient or a doctor, uses casting to be able to use getId method and compare ID
        while(temp != null){
            if(temp.data instanceof Patient){
                Patient currentPatient = (Patient) temp.data;
                if(currentPatient.getId() == id){
                    return temp.data;
                }
            } else if(temp.data instanceof Doctor){
                Doctor currentDoctor = (Doctor) temp.data;
                if(currentDoctor.getId() == id){
                    return temp.data;
                }
            }
            temp = temp.next;
        }
        //if the id is not found, nothing is returned
        return null;
    }
    //by calling findById we can recycle that code to know if the ID exists in the list
    public boolean exists(int id){
        if(findById(id) != null){
            return true;
        } else {
            return false;
        }

    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    public void displayAll(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
}