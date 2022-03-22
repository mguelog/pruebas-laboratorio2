package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue dllQueue;

    @BeforeEach
    public void setup() {
        dllQueue = new DoubleLinkedListQueue();
    }

    // Tests for constructor
    @Test
    public void shouldConstructorFirstAndLastEqualsNullAndSizeEqualsZero() {
        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null && dllQueue.size() == 0);
    }

    // Tests for append
    @Test
    public void shouldAppendRightFirstAndLastEqualsNodeIfTheQueueIsEmpty() {
        DequeNode dn = new DequeNode(5, null, null);

        dllQueue.append(dn);

        assertTrue(dllQueue.peekFirst().equals(dn) && dllQueue.peekLast().equals(dn));
    }

    @Test
    public void shouldAppendRightLastEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);

        dllQueue.append(dn2);

        assertTrue(dllQueue.peekLast().equals(dn2));
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

    // Tests for appendLeft
    @Test
    public void shouldAppendLeftFirstAndLastEqualsNodeIfTheQueueIsEmpty() {
        DequeNode dn = new DequeNode(5, null, null);

        dllQueue.appendLeft(dn);

        assertTrue(dllQueue.peekFirst().equals(dn) && dllQueue.peekLast().equals(dn));
    }

    @Test
    public void shouldAppendLeftFirstEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);

        dllQueue.appendLeft(dn2);

        assertTrue(dllQueue.peekFirst().equals(dn2));
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

    // Tests for DeleteFirst
    @Test
    public void shouldDeleteFirstRaiseAnExceptionIfTheQueueIsEmpty(){
        assertThrows(RuntimeException.class, () -> dllQueue.deleteFirst());
    }

    @Test
    public void shouldDeleteFirstSetNullFirstAndLastIfTheQueueIsSizeOne(){
        DequeNode dn = new DequeNode(5, null, null);
        dllQueue.append(dn);

        dllQueue.deleteFirst();

        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null);
    }

    @Test
    public void shouldDeleteFirstSetFirstEqualsToSecondNodeIfTheQueueSizeIsGreaterThanOne(){
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        DequeNode secondNode = dllQueue.peekFirst().getNext();
        dllQueue.deleteFirst();

        assertEquals(dllQueue.peekFirst(),secondNode);
    }

    @Test
    public void shouldDeleteFirstDecreasesOneTheSizeIfTheQueueIsNotEmpty(){
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        int expectedValue = dllQueue.size() - 1;
        dllQueue.deleteFirst();
        int obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    // Tests for DeleteLast
    @Test
    public void shouldDeleteLastRaiseAnExceptionIfTheQueueIsEmpty(){
        assertThrows(RuntimeException.class, () -> dllQueue.deleteLast());
    }

    @Test
    public void shouldDeleteLastSetNullFirstAndLastIfTheQueueIsSizeOne(){
        DequeNode dn = new DequeNode(5, null, null);
        dllQueue.append(dn);

        dllQueue.deleteLast();

        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null);
    }

    @Test
    public void shouldDeleteLastSetLastEqualsToPenultimateNodeIfTheQueueSizeIsGreaterThanOne(){
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        DequeNode penultimateNode = dllQueue.peekLast().getPrevious();
        dllQueue.deleteLast();

        assertEquals(dllQueue.peekLast(),penultimateNode);
    }

    @Test
    public void shouldDeleteLastDecreasesOneTheSizeIfTheQueueIsNotEmpty(){
        DequeNode dn1 = new DequeNode(5, null, null);
        DequeNode dn2 = new DequeNode(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        int expectedValue = dllQueue.size() - 1;
        dllQueue.deleteLast();
        int obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    // Tests for peekFirst
    @Test
    public void shouldPeekFirstReturnsNullIfQueueIsEmpty(){
        DequeNode expectedNode;
        DequeNode obtainedNode;

        expectedNode = null;
        obtainedNode = dllQueue.peekFirst();

        assertEquals(expectedNode, obtainedNode);
    }

    @Test
    public void shouldPeekFirstReturnsFirstNodeOfTheQueueIfNotEmpty(){
        DequeNode expectedNode = new DequeNode(5, null, null);
        dllQueue.append(expectedNode);

        DequeNode obtainedNode = dllQueue.peekFirst();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for peekLast
    @Test
    public void shouldPeekLastReturnsNullIfQueueIsEmpty(){
        DequeNode expectedNode;
        DequeNode obtainedNode;

        expectedNode = null;
        obtainedNode = dllQueue.peekLast();

        assertEquals(expectedNode, obtainedNode);
    }

    @Test
    public void shouldPeekLastReturnsFirstNodeOfTheQueueIfNotEmpty(){
        DequeNode expectedNode = new DequeNode(5, null, null);
        dllQueue.append(expectedNode);

        DequeNode obtainedNode = dllQueue.peekLast();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for size
    @Test
    public void shouldSizeReturnThreeIfQueueHasThreeNodes() {
        int expectedValue;
        int obtainedValue;
        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(2, null, null);
        DequeNode dn3 = new DequeNode(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        expectedValue = 3;
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    //Tests for delete
    @Test
    public void shouldDeleteRaiseAnExceptionIfQueueIsEmpty(){
        DequeNode dn = new DequeNode(1, null, null);

        assertThrows(RuntimeException.class, () -> dllQueue.delete(dn));
    }

    @Test
    public void shouldDeleteDecreaseSizeByOneIfTheNodeExists(){
        int expectedValue;
        int obtainedValue;
        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(2, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        expectedValue = dllQueue.size() -1;

        dllQueue.delete(dn1);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteRaiseAnExceptionIfGivenANullNode(){
        DequeNode dn = new DequeNode(1, null, null);
        dllQueue.append(dn);

        assertThrows(RuntimeException.class, () -> dllQueue.delete(null));
    }

    @Test
    public void shouldDeleteNotChangeTheSizeIfNodeIsNotContainedInQueue(){
        int expectedValue;
        int obtainedValue;
        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(2, null, null);
        dllQueue.append(dn1);
        expectedValue = dllQueue.size();

        dllQueue.delete(dn2);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldFindReturnsNullIfDeleteAnExistingNodeInAQueue(){
        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(2, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        dllQueue.delete(dn1);

        assertNull(dllQueue.find(1));
    }
}
