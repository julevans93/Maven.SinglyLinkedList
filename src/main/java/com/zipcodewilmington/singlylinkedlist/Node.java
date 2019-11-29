package com.zipcodewilmington.singlylinkedlist;


public class Node <E>{
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public E getData(){
        return data;
    }

    public boolean compareTo(Node<E> next){
        return (this.getData().toString().compareToIgnoreCase(next.getData().toString()) >0);
    }

    public void swapNext(){
        E data = this.getData();
        this.setData(next.getData()).getNext().setData(data);
    }

    public Node<E> setData(E data){
        this.data = data;
        return this;
    }
}
