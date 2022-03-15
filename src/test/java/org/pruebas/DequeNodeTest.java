package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    private DequeNode dequeNode;

    @BeforeEach
    public void setup(){
        dequeNode = null;
    }

    //Test for getNext
    @Test
    public void shouldGetNextReturnsNullIfNodeHasNotNext(){
        dequeNode = new DequeNode<>(0,null, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getNext();

        assertNull(obtainedDequeNode);
    }

    @Test
    public void shouldGetNextReturnsANodeIfNodeHasNext(){
        DequeNode nextNode = new DequeNode(1, null, dequeNode);
        dequeNode = new DequeNode<>(0,nextNode, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getNext();

        assertEquals(nextNode, obtainedDequeNode);
    }

    //Tests for getPrevious
    @Test
    public void shouldGetPreviousReturnsNullIfNodeHasNotPrevious(){
        dequeNode = new DequeNode<>(0,null, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getPrevious();

        assertNull(obtainedDequeNode);
    }

    @Test
    public void shouldGetPreviousReturnsANodeIfNodeHasPrevious(){
        DequeNode previousNode = new DequeNode(1, dequeNode, null);
        dequeNode = new DequeNode<>(0, null, previousNode);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getPrevious();

        assertEquals(previousNode, obtainedDequeNode);
    }

    //Tests for isFirstNode
    @Test
    public void shouldIsFirstNodeReturnsFalseIfNodeHasPrevious(){
        DequeNode previousNode = new DequeNode(1, dequeNode, null);
        dequeNode = new DequeNode<>(0, null, previousNode);

        assertFalse(dequeNode.isFirstNode());
    }

    @Test
    public void shouldIsFirstNodeReturnsTrueIfNodeHasNotPrevious(){
        dequeNode = new DequeNode<>(0, null, null);

        assertTrue(dequeNode.isFirstNode());
    }

    //Tests for isLastNode
    @Test
    public void shouldIsLastNodeReturnsFalseIfNodeHasNext(){
        DequeNode nextNode = new DequeNode(1, null, dequeNode);
        dequeNode = new DequeNode<>(0, nextNode, null);

        assertFalse(dequeNode.isLastNode());
    }

    @Test
    public void shouldIsLastNodeReturnsTrueIfNodeHasNotNext(){
        dequeNode = new DequeNode<>(0, null, null);

        assertTrue(dequeNode.isLastNode());
    }

    //Tests for isNotATerminalNode
    @Test
    public void shouldIsNotATerminalNodeReturnsFalseIfIsFirstNode(){
        dequeNode = new DequeNode<>(0, null, null);

        assertFalse(dequeNode.isNotATerminalNode());
    }

    @Test
    public void shouldIsNotATerminalNodeReturnsFalseIfIsLastNode(){
        dequeNode = new DequeNode<>(0, null, null);

        assertFalse(dequeNode.isNotATerminalNode());
    }

    @Test
    public void shouldIsNotATerminalNodeReturnsTrueIfNodeHasPreviousAndHasNext(){
        DequeNode nextNode = new DequeNode(1, null, dequeNode);
        DequeNode previousNode = new DequeNode(2, dequeNode, null);
        dequeNode = new DequeNode<>(0, nextNode, previousNode);

        assertTrue(dequeNode.isNotATerminalNode());
    }
}
