package Others01_TopK;

public class Solution {
    int partition(int []data, int first, int end){
        if (data == null || first < 0 || end > data.length){
            return Integer.parseInt(null);
        }

        int begin = first;
        int sentry = data[end];

        for (int i = first; i < end; i++) {
            if (data[i] < sentry ){
                int temp = data[i];
                data[i] = data[begin];
                data[begin] = temp;

                begin++;
            }
        }

        data[end] = data[begin];
        data[begin] = sentry;
        return begin;
    }

    public void getTopKMinBySort(int []data, int first, int end, int k){
        if (first < end){
            int partionIndex = partition(data, first, end);
            if (partionIndex == k-1){
                return ;
            }

            else if (partionIndex > k-1){
                getTopKMinBySort(data, first, partionIndex-1, k);
            }
            else {
                getTopKMinBySort(data, first, partionIndex+1, k);
            }
        }
    }
}
