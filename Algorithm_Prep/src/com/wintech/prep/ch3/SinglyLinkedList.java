package com.wintech.prep.ch3;

/**
 * Created by Prabu on 3/4/2016.
 */
public class SinglyLinkedList {
    private Node head;

    
}

class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}