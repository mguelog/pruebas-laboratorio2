package org.pruebas;

public class DoubleLinkedListQueue implements DoubleEndedQueue{

    private DequeNode first;
    private DequeNode last;
    private int size;

    public DoubleLinkedListQueue(){
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public void append(DequeNode node) {
        if(node == null){
            throw new IllegalArgumentException("Null node");
        }else if (size == 0){
            this.first = node;
            this.last = node;
            size++;
        }else {
            this.last.setNext(node);
            node.setPrevious(this.last);
            node.setNext(null);

            this.last=node;
            size++;
        }
    }

    @Override
    public void appendLeft(DequeNode node) {
        if(node == null){
            throw new IllegalArgumentException("Null node");
        }else if(size == 0){
            this.first = node;
            this.last = node;
            size++;
        }else {
            this.first.setPrevious(node);
            node.setNext(this.first);
            node.setPrevious(null);

            this.first=node;
            size++;
        }
    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode peekFirst() {
        return null;
    }

    @Override
    public DequeNode peekLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public DequeNode getFirst() {
        return first;
    }

    public DequeNode getLast() {
        return last;
    }

    public void setFirst(DequeNode node) {
        first = node;
    }

    public void setLast(DequeNode node) {
        last = node;
    }
}
