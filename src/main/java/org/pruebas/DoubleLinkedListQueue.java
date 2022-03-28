package org.pruebas;

import java.util.Comparator;

/**
 * Class representing an implementation of a double-ended queue (deque). There are two pointer
 * to the first and the last node of the double-ended queue. Also, there is an integer for keep the size.
 * The deque is composed of DequeNodes.
 *
 * @param <T>
 */

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoubleLinkedListQueue() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public void append(DequeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Null node");
        } else if (size == 0) {
            this.first = node;
            this.last = node;
            size++;
        } else {
            this.last.setNext(node);
            node.setPrevious(this.last);
            node.setNext(null);

            this.last = node;
            size++;
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Null node");
        } else if (size == 0) {
            this.first = node;
            this.last = node;
            size++;
        } else {
            this.first.setPrevious(node);
            node.setNext(this.first);
            node.setPrevious(null);

            this.first = node;
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
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }

        DequeNode<T> dq = first;
        for (int i = 0; i < position; i++) {
            dq = dq.getNext();
        }
        return dq;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode<T> dq = first;
        int i = 0;

        while (i < size && !item.equals(dq.getItem())) {
            dq = dq.getNext();
            i++;
        }
        return dq;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if (this.size == 0) {
            throw new RuntimeException("The queue is empty");
        }
        if (node == null) {
            throw new RuntimeException("The node is null");
        }
        DequeNode<T> dq = first;
        int i = 0;

        while (i < size && !node.equals(dq)) {
            dq = dq.getNext();
            i++;
        }

        if (i < size) {
            if (dq.isFirstNode()) {
                dq.getNext().setPrevious(null);
                this.first = dq.getNext();
            } else if (dq.isLastNode()) {
                dq.getPrevious().setNext(null);
                this.last = dq.getPrevious();
            } else {
                dq.getPrevious().setNext(dq.getNext());
                dq.getNext().setPrevious(dq.getPrevious());
            }

            dq.setNext(null);
            dq.setPrevious(null);
            dq = null;
            size--;
        }
    }

    //Implementation based on Selection Sort
    public void sort(Comparator<T> comparator) {
        for (int j = 0; j < size - 1; j++) {
            int iMin = j;
            for (int i = j + 1; i < size; i++) {
                if (comparator.compare(this.getAt(i).getItem(), this.getAt(iMin).getItem()) < 0) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                swap(j, iMin);
            }
        }
    }

    //Swaps nodes at index j and i
    private void swap(int j, int i) {
        DequeNode<T> jNode = this.getAt(j);
        DequeNode<T> iNode = this.getAt(i);

        T jItem = jNode.getItem();
        jNode.setItem(iNode.getItem());
        iNode.setItem(jItem);
    }

}
