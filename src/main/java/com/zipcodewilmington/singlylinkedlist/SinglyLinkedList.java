package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <E>{
    private Node<E> head;
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

    public void add(E data){
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

//    public void remove(Object data, int index){
//        Node tempNode = new Node(data);
//        Node currentNode = head;
//
//        if (currentNode != null){
//            for (int i = 0; i < index && currentNode.getNext() != null; i++){
//                currentNode = currentNode.getNext();
//            }
//        }
//        tempNode.setNext(currentNode.getNext());
//        currentNode.setNext(tempNode);
//
//    }

    public boolean remove(int index){
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

    public int find(E searchData){
        Node<E> currentNode = null;
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

    public boolean contains(E data){
        int index = find(data);
        if (index >= 0){
            return true;
        }
        return false;
    }

    public E get(int index){
        if (index < 0){return null;}
        Node<E> currentNode = null;
        if (head != null) {
            if (head.getNext() == null) { return null; }
            currentNode = head.getNext();
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null) {
                    return null;
                }
                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }
        return (E) currentNode;
    }

    public SinglyLinkedList<E> copy(){
        SinglyLinkedList<E> listCopy = new SinglyLinkedList<E>();
        Node<E> currentNode = null;
        if (this.head == null){return listCopy;}
        if (this.head.getNext() == null){
            listCopy.add((E) "");
            listCopy.clear();
        }
        if (this.head.getNext() != null){
            currentNode = this.head.getNext();
            while (currentNode != null){
                listCopy.add(currentNode.getData());
                currentNode = currentNode.getNext();
            }
        }
        return listCopy;
    }

    public boolean clear(){
        if (head != null){
            head.setNext(null);
            counter = 0;
            return true;
        }
        return false;
    }

    public SinglyLinkedList<E> sort(){
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (Node<E> node = this.head; node.getNext() != null; node = node.getNext()){
                if (node.compareTo(node.getNext())) {
                    node.swapNext();
                    sorted = false;
                }
            }
        }
        return this;
    }
 }
