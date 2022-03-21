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
        if (size == 0) {
            throw new RuntimeException("The queue is empty");
        } else if (size == 1) {
            this.first = null;
            this.last = null;
            size = 0;
        } else {
            this.first.getNext().setPrevious(null);
            this.first = this.first.getNext();
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if (size == 0) {
            throw new RuntimeException("The queue is empty");
        } else if (size == 1) {
            this.first = null;
            this.last = null;
            size = 0;
        } else {
            this.last.getPrevious().setNext(null);
            this.last = this.last.getPrevious();
            size--;
        }
    }

    @Override
    public DequeNode peekFirst() {
        return first;
    }

    @Override
    public DequeNode peekLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        DequeNode dq = this.first;

        for(int i = 0; i < this.size; i++){
            sb.append(dq.toString());
            dq = dq.getNext();
        }
        sb.append(" }");

        return sb.toString();
    }
}
