//Node class used to create the nodes in the queue

public class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
    }
}