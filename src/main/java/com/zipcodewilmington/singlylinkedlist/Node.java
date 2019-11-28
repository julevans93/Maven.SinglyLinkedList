package com.zipcodewilmington.singlylinkedlist;


public class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public Object getData(){
        return data;
    }
}
