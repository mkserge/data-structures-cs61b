package sandbox;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedList {
    private int[] array;
    private int lastIndex;

    public ArrayBasedList() {
        array = new int[10];
        lastIndex = -1;
    }

    public void insertItem(int item) {
        insertItem(item, lastIndex + 1);
    }

    public void insertItem(int item, int index) {
        // First check if there is space in the array to insert a new element
        if (lastIndex + 1 == array.length) {
            // Copy the old array into the new one.

            // We can directly use Systems.arraycopy()
            // System.arraycopy(array, 0, newArray, 0, array.length);

            // Or use more readable Arrays.copyOf
            int[] newArray = Arrays.copyOf(array, 2 * array.length);

            // Or go old-school
            // int[] newArray = new int[2 * array.length];
            // for (int i = 0; i < array.length; i++) {
            //     newArray[i] = array[i];
            // }
            array = newArray;
        }
        // Move elements to the right to make up room if need be.
        for (int i = lastIndex; i >= index; i--){
            array[i + 1] = array[i];
        }
        // Insert the new element;
        array[index] = item;
        // Increment the lastIndex;
        lastIndex++;
    }

    public static void main(String[] args) {
        ArrayBasedList myList = new ArrayBasedList();
        myList.insertItem(4);
        myList.insertItem(2);
        myList.insertItem(1);
        myList.insertItem(5);
        myList.insertItem(3);
        myList.insertItem(4);
        myList.insertItem(2);
        myList.insertItem(1);
        myList.insertItem(5);
        myList.insertItem(3);

        System.out.println(myList);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
