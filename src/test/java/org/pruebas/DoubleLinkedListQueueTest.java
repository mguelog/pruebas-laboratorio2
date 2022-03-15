package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {
    private DoubleLinkedListQueue dllQueue;

    @BeforeEach
    public void setup() {
        dllQueue = new DoubleLinkedListQueue();
    }

    @Test
    public void shouldAppendRightFirstAndLastEqualsNodeIfTheQueueIsEmpty() {
        DequeNode dn = new DequeNode(5, null, null);

        dllQueue.append(dn);

        assertTrue(dllQueue.getFirst().equals(dn) && dllQueue.getLast().equals(dn));
    }

    @Test
    public void shouldAppendRightLastEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);

        dllQueue.append(dn1);
        dllQueue.append(dn2);

        assertTrue(dllQueue.getLast().equals(dn2));
    }

    @Test
    public void shouldAppendRightOfNullNodeRaiseAnException() {
        DequeNode dn = null;

        assertThrows(IllegalArgumentException.class, () -> dllQueue.append(dn));
    }

    @Test
    public void shouldAppendRightIncrementSizeByOne() {
        DequeNode dn = new DequeNode(5, null, null);
        int expectedValue;
        int obtainedValue;

        expectedValue = dllQueue.size() + 1;
        dllQueue.append(dn);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldAppendLeftFirstAndLastEqualsNodeIfTheQueueIsEmpty() {
        DequeNode dn = new DequeNode(5, null, null);

        dllQueue.appendLeft(dn);

        assertTrue(dllQueue.getFirst().equals(dn) && dllQueue.getLast().equals(dn));
    }

    @Test
    public void shouldAppendLeftFirstEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);

        dllQueue.append(dn1);
        dllQueue.appendLeft(dn2);

        assertTrue(dllQueue.getFirst().equals(dn2));
    }

    @Test
    public void shouldAppendLeftOfNullNodeRaiseAnException() {
        DequeNode dn = null;

        assertThrows(IllegalArgumentException.class, () -> dllQueue.appendLeft(dn));
    }

    @Test
    public void shouldAppendLeftIncrementSizeByOne() {
        DequeNode dn = new DequeNode(5, null, null);
        int expectedValue;
        int obtainedValue;

        expectedValue = dllQueue.size() + 1;
        dllQueue.appendLeft(dn);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }
}
