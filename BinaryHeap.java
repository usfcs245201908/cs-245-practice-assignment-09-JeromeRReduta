import java.util.*;

public class BinaryHeap {
    private int[] arr = new int[10];
    private int size = 0;

    public BinaryHeap() {}

    // Returns i of left child
    // getRChildI = getLChildI(...) + 1
    public int getLChildI(int pos) {
        return 2*pos + 1;
    }

    public int getParentI(int pos) {
        return (pos - 1) / 2;
    }

    public void add(int item) {
        if (size == arr.length)
            growArray();

        int childI = size++;
        int parentI = getParentI(childI);
        arr[childI] = item;

        while (higherPrio(arr[childI], arr[parentI])) {
            swap(arr, childI, parentI);
            childI = parentI;
            parentI = getParentI(childI);
        }
    }


    private void growArray() {
        arr = Arrays.copyOfRange(arr, 0, 2*arr.length);
    }

    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];

        arr[pos1] = arr[pos2];

        arr[pos2] = temp;
    }



    public int size() {return size;}

    // Checks if num1 has higher prio than num2
    // Min heap: lower num has higher prio

    // To make max heap: just change < into >
    public boolean higherPrio(int num1, int num2) {
        return num1 < num2;
    }

    // Swap 1st and last element, reduce size by 1,...
    // ...reorder tree (siftdown), and return removed that swapped element
    public int remove() {
        int removed = arr[0];
        swap(arr, 0, --size);
        siftdown(0);

        return removed;


    }
    private void siftdown(int pos) {
        int childI = getLChildI(pos);

        if (childI >= size)
            return;

        if (childI + 1 < size &&
                !higherPrio(arr[childI], arr[childI + 1]))
            childI++;

        if (!higherPrio(arr[pos], arr[childI])) {
            swap(arr, pos, childI);
            siftdown(childI);
        }
    }

    public String toString() {
        return Arrays.toString(arr);
    }


}
