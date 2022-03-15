package org.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleLinkedListQueueTest {
    private DoubleLinkedListQueue dllQueue;

    @BeforeEach
    public void setup() {
        dllQueue = new DoubleLinkedListQueue();
    }

    @Test
    public void tes1(){
        assertEquals(true, true);
    }

    @Test
    public void shouldAppendRightFirstAndLastIfTheQueueIsEmpty() {
        DequeNode dn = new DequeNode(5, null, null);
        dllQueue.append(dn);

        assertTrue();
    }
}
