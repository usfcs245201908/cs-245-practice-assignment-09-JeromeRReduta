import java.util.*;

public class BinaryHeapDemo {
    public static void main(String[] args) {
        BinaryHeap b = new BinaryHeap();

        for (int i = 0; i < 10; i++)
            b.add(i);

        b.remove();

        System.out.println(b.toString());
    }

}
