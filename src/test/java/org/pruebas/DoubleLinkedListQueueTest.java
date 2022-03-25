package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue<Integer> dllQueue;

    @BeforeEach
    public void setup() {
        dllQueue = new DoubleLinkedListQueue<>();
    }

    // Tests for constructor
    @Test
    public void shouldConstructorFirstAndLastEqualsNullAndSizeEqualsZero() {
        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null && dllQueue.size() == 0);
    }

    // Tests for append
    @Test
    public void shouldAppendRightFirstAndLastEqualsNodeIfTheQueueIsEmpty() {
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);

        dllQueue.append(dn);

        assertTrue(dllQueue.peekFirst().equals(dn) && dllQueue.peekLast().equals(dn));
    }

    @Test
    public void shouldAppendRightLastEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        dllQueue.append(dn1);

        dllQueue.append(dn2);

        assertEquals(dllQueue.peekLast(), dn2);
    }

    @Test
    public void shouldAppendRightOfNullNodeRaiseAnException() {
        assertThrows(IllegalArgumentException.class, () -> dllQueue.append(null));
    }

    @Test
    public void shouldAppendRightIncrementSizeByOne() {
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);
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
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);

        dllQueue.appendLeft(dn);

        assertTrue(dllQueue.peekFirst().equals(dn) && dllQueue.peekLast().equals(dn));
    }

    @Test
    public void shouldAppendLeftFirstEqualsNodeIfTheQueueIsNotEmpty() {
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        dllQueue.append(dn1);

        dllQueue.appendLeft(dn2);

        assertEquals(dllQueue.peekFirst(),dn2);
    }

    @Test
    public void shouldAppendLeftOfNullNodeRaiseAnException() {
        assertThrows(IllegalArgumentException.class, () -> dllQueue.appendLeft(null));
    }

    @Test
    public void shouldAppendLeftIncrementSizeByOne() {
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);
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
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);
        dllQueue.append(dn);

        dllQueue.deleteFirst();

        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null);
    }

    @Test
    public void shouldDeleteFirstSetFirstEqualsToSecondNodeIfTheQueueSizeIsGreaterThanOne(){
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        DequeNode<Integer> secondNode = dllQueue.peekFirst().getNext();
        dllQueue.deleteFirst();

        assertEquals(dllQueue.peekFirst(),secondNode);
    }

    @Test
    public void shouldDeleteFirstDecreasesOneTheSizeIfTheQueueIsNotEmpty(){
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
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
        DequeNode<Integer> dn = new DequeNode<>(5, null, null);
        dllQueue.append(dn);

        dllQueue.deleteLast();

        assertTrue(dllQueue.peekFirst() == null && dllQueue.peekLast() == null);
    }

    @Test
    public void shouldDeleteLastSetLastEqualsToPenultimateNodeIfTheQueueSizeIsGreaterThanOne(){
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);

        DequeNode<Integer> penultimateNode = dllQueue.peekLast().getPrevious();
        dllQueue.deleteLast();

        assertEquals(dllQueue.peekLast(),penultimateNode);
    }

    @Test
    public void shouldDeleteLastDecreasesOneTheSizeIfTheQueueIsNotEmpty(){
        DequeNode<Integer> dn1 = new DequeNode<>(5, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
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
        DequeNode<Integer> obtainedNode;

        obtainedNode = dllQueue.peekFirst();

        assertNull(obtainedNode);
    }

    @Test
    public void shouldPeekFirstReturnsFirstNodeOfTheQueueIfNotEmpty(){
        DequeNode<Integer> expectedNode = new DequeNode<>(5, null, null);
        dllQueue.append(expectedNode);

        DequeNode<Integer> obtainedNode = dllQueue.peekFirst();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for peekLast
    @Test
    public void shouldPeekLastReturnsNullIfQueueIsEmpty(){
        DequeNode<Integer> obtainedNode;

        obtainedNode = dllQueue.peekLast();

        assertNull(obtainedNode);
    }

    @Test
    public void shouldPeekLastReturnsFirstNodeOfTheQueueIfNotEmpty(){
        DequeNode<Integer> expectedNode = new DequeNode<>(5, null, null);
        dllQueue.append(expectedNode);

        DequeNode<Integer> obtainedNode = dllQueue.peekLast();

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for size
    @Test
    public void shouldSizeReturnThreeIfQueueHasThreeNodes() {
        int expectedValue;
        int obtainedValue;
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        expectedValue = 3;
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    // Tests for getAt
    @Test
    public void shouldGetAt4OfThreeNodesQueueRaiseAnException() {
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        assertThrows(IllegalArgumentException.class, () -> dllQueue.getAt(4));
    }

    @Test
    public void shouldGetAt2ReturnTheThirdNodeIfQueueHasFourNodes() {
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> dn4 = new DequeNode<>(4, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);
        dllQueue.append(dn4);

        DequeNode<Integer> expectedNode = dn3;
        DequeNode<Integer> obtainedNode = dllQueue.getAt(2);

        assertEquals(expectedNode, obtainedNode);
    }

    // Tests for find
    @Test
    public void shouldFind5ReturnNullIfQueueHasThreeNodesWithNo5AsItem() {
        DequeNode<Integer> dn1 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(4, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        DequeNode<Integer> obtainedNode = dllQueue.find(5);

        assertNull(obtainedNode);
    }

    @Test
    public void shouldFind4ReturnSecondNodeIfQueueHasThreeNodesWith4AsItemAtTheSecondNode() {
        DequeNode<Integer> dn1 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(4, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(7, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        DequeNode<Integer> expectedNode = dn2;
        DequeNode<Integer> obtainednode = dllQueue.find(4);

        assertEquals(expectedNode, obtainednode);
    }

    //Tests for delete
    @Test
    public void shouldDeleteRaiseAnExceptionIfQueueIsEmpty(){
        DequeNode<Integer> dn = new DequeNode<>(1, null, null);

        assertThrows(RuntimeException.class, () -> dllQueue.delete(dn));
    }

    @Test
    public void shouldDeleteDecreaseSizeByOneIfTheNodeExists(){
        int expectedValue;
        int obtainedValue;
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        expectedValue = dllQueue.size() -1;

        dllQueue.delete(dn1);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteRaiseAnExceptionIfGivenANullNode(){
        DequeNode<Integer> dn = new DequeNode<>(1, null, null);
        dllQueue.append(dn);

        assertThrows(RuntimeException.class, () -> dllQueue.delete(null));
    }

    @Test
    public void shouldDeleteNotChangeTheSizeIfNodeIsNotContainedInQueue(){
        int expectedValue;
        int obtainedValue;
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        dllQueue.append(dn1);
        expectedValue = dllQueue.size();

        dllQueue.delete(dn2);
        obtainedValue = dllQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldFindOfTheFirstNodeReturnsNullIfDeleteTheFirstNodeInAQueue(){
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        dllQueue.delete(dn1);

        assertNull(dllQueue.find(1));
    }

    @Test
    public void shouldFindOfTheLastNodeReturnsNullIfDeleteTheLastNodeInAQueue(){
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        dllQueue.delete(dn3);

        assertNull(dllQueue.find(3));
    }

    @Test
    public void shouldFindOfTheMidNodeReturnsNullIfDeleteTheMidNodeInAQueue(){
        DequeNode<Integer> dn1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        dllQueue.delete(dn2);

        assertNull(dllQueue.find(2));
    }

    //Tests for sort()
    @Test
    public void shouldSortFunctionSortAQueueOfFourNodesUnsorted() {
        Comparator<Integer> comparator = Integer::compare;

        DequeNode<Integer> dn1 = new DequeNode<>(2, null, null);
        DequeNode<Integer> dn2 = new DequeNode<>(7, null, null);
        DequeNode<Integer> dn3 = new DequeNode<>(4, null, null);
        DequeNode<Integer> dn4 = new DequeNode<>(8, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);
        dllQueue.append(dn4);

        dllQueue.sort(comparator);

        assertTrue((dllQueue.getAt(0).getItem()) <= (dllQueue.getAt(1).getItem()) &&
                (dllQueue.getAt(1).getItem()) <= (dllQueue.getAt(2).getItem()) &&
                (dllQueue.getAt(2).getItem()) <= (dllQueue.getAt(3).getItem()));
    }
}
