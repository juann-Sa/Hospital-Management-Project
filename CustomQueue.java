//Queue class uses Custom Linked List class but forces FIFO structure
public class CustomQueue<T>{
    Node<T> front;
    Node<T> rear;

    public void enqueue(T data){
        Node<T> element = new Node<>(data);
        //if the queue is empty then the front and rear point to the same element
        if(isEmpty()){
            front = element;
            rear = element;
            //places the new element in last place and updates rear
        } else {
            rear.next = element;
            rear = element;
        }
    }

    public T dequeue(){
        //if list is empty, there is nothing to return
        if(isEmpty()){
            return null;
        } else {
            Node<T> temp = front;
            front = front.next;

            //if the last element is removed, then rear must also point to null
            if(front == null){
                rear = null;
        }

            return temp.data;
        }
    }
    
    public boolean isEmpty(){
        if(front == null){
            return true;
        } else {
            return false;
        }
    }

    public void displayQueue(){
        Node<T> temp = front;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}