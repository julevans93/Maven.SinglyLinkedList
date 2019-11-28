package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    private Node head;
    private static int counter;

    public SinglyLinkedList() {
//        this.head = new Node(null);
//        counter = 0;
    }

    private static  int getCounter(){
        return counter;
    }

    private static void incrementCounter(){
        counter++;
    }

    private void decrementCounter(){
        counter--;
    }

    public int size(){
        return getCounter();
    }

    public void add(Object data){
        if (head == null){
            head = new Node(data);
        }

        Node tempNode = new Node(data);
        Node currentNode = head;

        if (currentNode != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(tempNode);
        }
        incrementCounter();
    }

    public void remove(Object data, int index){
        Node tempNode = new Node(data);
        Node currentNode = head;

        if (currentNode != null){
            for (int i = 0; i < index && currentNode.getNext() != null; i++){
                currentNode = currentNode.getNext();
            }
        }
        tempNode.setNext(currentNode.getNext());
        currentNode.setNext(tempNode);

    }

    public Boolean remove(int index){
        if (index < 1 || index > size())
            return false;

        Node currentNode = head;
        if (head != null){
            for (int i = 0; i < index; i++){
                if (currentNode.getNext() == null)
                    return false;

                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());

            decrementCounter();
            return true;
        }
        return false;
    }

    public int find(Object searchData){
        Node currentNode = null;
        if (head != null){
            if (head.getNext() == null){
                return -1;
            }
            currentNode = head.getNext();
            for (int i = 0; i < size(); i++){
                if (currentNode.getData().equals(searchData)){
                    return i;
                }
                currentNode = currentNode.getNext();
            }
        }
        return -1;
    }

    public boolean contains(Object data){
        int index = find(data);
        if (index >= 0){
            return true;
        }
        return false;
    }

}
