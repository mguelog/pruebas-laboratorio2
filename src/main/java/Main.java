import org.pruebas.DequeNode;
import org.pruebas.DoubleLinkedListQueue;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedListQueue dllQueue = new DoubleLinkedListQueue();

        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(3, null, null);
        DequeNode dn3 = new DequeNode(20, null, null);
        DequeNode dn4 = new DequeNode(6, null, null);
        DequeNode dn5 = new DequeNode(9, null, null);
        DequeNode dn6 = new DequeNode(21, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);
        dllQueue.append(dn4);
        dllQueue.append(dn5);
        dllQueue.append(dn6);

        System.out.println(dllQueue);

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        dllQueue.sort(comparator);

        System.out.println(dllQueue);

        System.out.println(dllQueue.getAt(3));

        System.out.println(dllQueue.find(10));

        dllQueue.delete(dllQueue.find(1));
        System.out.println(dllQueue);
    }
}
