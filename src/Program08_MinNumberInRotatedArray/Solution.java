package Program08_MinNumberInRotatedArray;

/**
 * @Description :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Solution :
 * 旋转后的数组可以划分为俩个排序好的子数组，而且前面一个数组的元素都大于后面一个数组的元素。
 * 最小元素其实就是数组的分割线，这道题的思路也就是找最小值。
 *
 * @learn :
 * 1）二分法
 * @Author : Gordon Deng
 * @Date :   18:51 2018/3/5
 */

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        int preIndex = 0;
        int afterIndex = array.length-1;
        int midIndex = preIndex;

        //类似于二分查找，当缩小到两个标识位只差一时，分界下标就可以找出来了
        while (array[preIndex] >= array[afterIndex]){
            if (afterIndex - preIndex == 1){
                midIndex = afterIndex;
                break;
            }

            midIndex = (preIndex+afterIndex)/2;

            //如果下标为preIndex,afterIndex,midIndex所指向的数字相同，则只能顺序查找
            if (array[preIndex] == array[afterIndex] && array[midIndex] == array[preIndex]){
                return minInOrder(array, preIndex, afterIndex);
            }

            if (array[midIndex] >= array[preIndex]){
                preIndex = midIndex;
            }
            else {
                afterIndex = midIndex;
            }

        }

        return array[midIndex];
    }

    public int minInOrder(int [] array, int startIndex, int endIndex){
        int result = array[startIndex];
        for (int i = startIndex+1; i <= endIndex; i++) {
            if (result > array[i]){
                result = array[i];
            }
        }

        return result;
    }
}
