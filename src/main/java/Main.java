import org.pruebas.DequeNode;
import org.pruebas.DoubleLinkedListQueue;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedListQueue dllQueue = new DoubleLinkedListQueue();

        DequeNode dn1 = new DequeNode(1, null, null);
        DequeNode dn2 = new DequeNode(2, null, null);
        DequeNode dn3 = new DequeNode(3, null, null);
        dllQueue.append(dn1);
        dllQueue.append(dn2);
        dllQueue.append(dn3);

        System.out.println(dllQueue);
    }
}
