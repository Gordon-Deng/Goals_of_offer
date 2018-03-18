package BasicSort01_Quick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Quick {
    public void sort(int[] array){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        //Collections.shuffle()使数组乱序
        Collections.shuffle(list);

        Iterator<Integer> ite = list.iterator();
        int i = 0;
        while (ite.hasNext()){
            array[i++] = ite.next();
        }

        sort(array, 0, array.length-1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high){
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int last = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= last){
                i++;
                //用异或做交换运算的两个值不能相同
                if (i != j){
                    //（a ^ b） ^ b=a ^ (b ^ b)=a ^0=a
                    array[i] = array[i]^array[j];
                    array[j] = array[i]^array[j];
                    array[i] = array[i]^array[j];
                }
            }
        }

        if ((i+1) != high){
            array[i+1] = array[i+1]^array[high];
            array[high] = array[i+1]^array[high];
            array[i+1] = array[i+1]^array[high];
        }

        return i+1;
    }

}
