package Program04_ReplaceBlank;

import java.util.Arrays;

/**
 * @Description :
 *
 * 相关问题：两个有序数组，合并成一个有序数组，假设第一个数组空间足够容纳两个数组。
 *
 * 分析：考虑到a数组很大，可以直接在a数组上进行合并，但是要讲究效率。
 * 如果单纯从前往后合并，那么效率会非常低，因为a数组后面的数字需要不停的移动。
 * 换一种思路，我们采用从后往前合并，首先计算出总长度，从a数组最后往前移动比较。
 *
 * @Author : Gordon Deng
 * @Date :   20:44 2018/3/1
 */

public class Solution2 {
    public int[] MergeArray(int []fArray, int []sArray){
        int fLenght = fArray.length;
        int sLenght = sArray.length;
        int[] newArray = new int[fLenght + sLenght];

        Arrays.sort(fArray);
        Arrays.sort(sArray);

        for (int i = 0; i < fLenght; i++) {
            newArray[i] = fArray[i];
        }

        int fIndex = fLenght-1;
        int sIndex = sLenght-1;
        int newIndex = fLenght+sLenght-1;

        while (fIndex >= 0 && sIndex >= 0){
            if (fArray[fIndex] > sArray[sIndex]){
                newArray[newIndex--] = fArray[fIndex--];
            }
            else {
                newArray[newIndex--] = sArray[sIndex--];
            }
        }

        while (fIndex >= 0){
            newArray[newIndex--] = fArray[fIndex--];
        }

        while (sIndex >= 0){
            newArray[newIndex--] = fArray[sIndex--];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,11,3,4};
        int []b = new int[]{5,6,7,8};
        Solution2 solution2 = new Solution2();
        int []c = solution2.MergeArray(a,b);

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
