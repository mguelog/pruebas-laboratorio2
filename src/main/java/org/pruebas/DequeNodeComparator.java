package org.pruebas;

import java.util.Comparator;

public class DequeNodeComparator implements Comparator<DequeNode> {



    @Override
    public int compare(DequeNode o1, DequeNode o2) {
        int d1 = (int) o1.getItem();
        int d2 = (int) o2.getItem();

        return Integer.compare(d1,d2);
    }



}
