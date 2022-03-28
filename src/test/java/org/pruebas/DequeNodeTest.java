package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    private DequeNode<Integer> dequeNode;

    @BeforeEach
    public void setup() {
        dequeNode = null;
    }

    // Tests for getItem
    @Test
    public void shouldGetItemReturnsNullIfNodeHasNullItem() {
        dequeNode = new DequeNode<>(null, null, null);

        Object obtainedItem = dequeNode.getItem();

        assertNull(obtainedItem);
    }

    @Test
    public void shouldGetItemReturnsFiveIfNodesItemIsFive() {
        dequeNode = new DequeNode<>(5, null, null);

        Object expectedValue = 5;
        Object obtainedValue = dequeNode.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    // Tests for getNext
    @Test
    public void shouldGetNextReturnsNullIfNodeHasNotNext() {
        dequeNode = new DequeNode<>(0, null, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getNext();

        assertNull(obtainedDequeNode);
    }

    @Test
    public void shouldGetNextReturnsANodeIfNodeHasNext() {
        DequeNode<Integer> nextNode = new DequeNode<>(1, null, dequeNode);
        dequeNode = new DequeNode<>(0, nextNode, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getNext();

        assertEquals(nextNode, obtainedDequeNode);
    }

    // Tests for getPrevious
    @Test
    public void shouldGetPreviousReturnsNullIfNodeHasNotPrevious() {
        dequeNode = new DequeNode<>(0, null, null);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getPrevious();

        assertNull(obtainedDequeNode);
    }

    @Test
    public void shouldGetPreviousReturnsANodeIfNodeHasPrevious() {
        DequeNode<Integer> previousNode = new DequeNode<>(1, dequeNode, null);
        dequeNode = new DequeNode<>(0, null, previousNode);

        DequeNode<Integer> obtainedDequeNode = dequeNode.getPrevious();

        assertEquals(previousNode, obtainedDequeNode);
    }

    // Tests for setNext
    @Test
    public void shouldSetNextOfNullNodeNextEqualsNull() {
        dequeNode = new DequeNode<>(0, null, null);

        dequeNode.setNext(null);

        assertNull(dequeNode.getNext());
    }

    @Test
    public void shouldSetNextOfNotNullNodeNextEqualsThatNode() {
        DequeNode<Integer> expectedNode = new DequeNode<>(1, null, dequeNode);
        dequeNode = new DequeNode<>(0, null, null);

        dequeNode.setNext(expectedNode);
        DequeNode<Integer> obtainedNode = dequeNode.getNext();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for setPrevious
    @Test
    public void shouldSetPreviousOfNullNodePreviousEqualsNull() {
        dequeNode = new DequeNode<>(0, null, null);

        dequeNode.setPrevious(null);

        assertNull(dequeNode.getPrevious());
    }

    @Test
    public void shouldSetPreviousOfNotNullNodePreviousEqualsThatNode() {
        DequeNode<Integer> expectedNode = new DequeNode<>(1, dequeNode, null);
        dequeNode = new DequeNode<>(0, null, null);

        dequeNode.setPrevious(expectedNode);
        DequeNode<Integer> obtainedNode = dequeNode.getPrevious();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for constructor
    @Test
    public void shouldConstructorWorksProperly() {
        DequeNode<Integer> nextNode = new DequeNode<>(1, null, dequeNode);
        DequeNode<Integer> previousNode = new DequeNode<>(2, dequeNode, null);

        dequeNode = new DequeNode<>(5, nextNode, previousNode);

        assertTrue(dequeNode.getItem().equals(5) && dequeNode.getNext().equals(nextNode) && dequeNode.getPrevious().equals(previousNode));
    }

    // Tests for isFirstNode
    @Test
    public void shouldIsFirstNodeReturnsFalseIfNodeHasPrevious() {
        DequeNode<Integer> previousNode = new DequeNode<>(1, dequeNode, null);
        dequeNode = new DequeNode<>(0, null, previousNode);

        assertFalse(dequeNode.isFirstNode());
    }

    @Test
    public void shouldIsFirstNodeReturnsTrueIfNodeHasNotPrevious() {
        dequeNode = new DequeNode<>(0, null, null);

        assertTrue(dequeNode.isFirstNode());
    }

    // Tests for isLastNode
    @Test
    public void shouldIsLastNodeReturnsFalseIfNodeHasNext() {
        DequeNode<Integer> nextNode = new DequeNode<>(1, null, dequeNode);
        dequeNode = new DequeNode<>(0, nextNode, null);

        assertFalse(dequeNode.isLastNode());
    }

    @Test
    public void shouldIsLastNodeReturnsTrueIfNodeHasNotNext() {
        dequeNode = new DequeNode<>(0, null, null);

        assertTrue(dequeNode.isLastNode());
    }

    // Tests for isNotATerminalNode
    @Test
    public void shouldIsNotATerminalNodeReturnsFalseIfIsFirstNode() {
        dequeNode = new DequeNode<>(0, null, null);

        assertFalse(dequeNode.isNotATerminalNode());
    }

    @Test
    public void shouldIsNotATerminalNodeReturnsFalseIfIsLastNode() {
        dequeNode = new DequeNode<>(0, null, null);

        assertFalse(dequeNode.isNotATerminalNode());
    }

    @Test
    public void shouldIsNotATerminalNodeReturnsTrueIfNodeHasPreviousAndHasNext() {
        DequeNode<Integer> nextNode = new DequeNode<>(1, null, dequeNode);
        DequeNode<Integer> previousNode = new DequeNode<>(2, dequeNode, null);
        dequeNode = new DequeNode<>(0, nextNode, previousNode);

        assertTrue(dequeNode.isNotATerminalNode());
    }
}
