package Others02_Bitmap;

/**
 * @Description :
 * 一个最多包含n个整数的文件，每个数都小于n，其中n=10^7。如果在输入文件中有任何重复出现就是致命错误。
 * 没有其他数据与该数相关联。
 * （该题改编自 编程珠玑：位图法排序，当输入数据集包含负数）
 *
 * 输出：按升序排列的输入正数的列表。
 * 约束：最多有1MB的内存空间可用，有充足的磁盘存储空间可用。运行时间最多几分钟，运行时间为10秒就不需要进一步优化。
 *
 * @Solution :
 * 第一阶段：将所有的位都置为0，从而将集合初始化为空，集合大小设为数组最大值减去最小值加一,。
 * 第二阶段：通过读入文件中的每个整数与最小值的差来建立集合，将每个对应的位置都置为1，比如{-3，1，2}，a[-3-(-3)=0] = -3。
 * 第三阶段：检验每一位，如果该为为1，就输出对应的整数，有此产生有序的输出文件。
 *
 * @learn :
 * @Author : Gordon Deng
 * @Date :   01:37 2018/3/8
 */

public class Solution {
    public int[] Bitmap(int[] Array){
        int ARRAY_LENGTH = Array.length;
        int MAX_NUMBER = Array[0];
        int MIN_NUMBER = MAX_NUMBER;

        for (int spiderNumber : Array){
            if (spiderNumber < MIN_NUMBER){
                MIN_NUMBER = spiderNumber;
            }

            if (spiderNumber > MAX_NUMBER){
                MAX_NUMBER = spiderNumber;
            }
        }

        int[] newArray = new int[MAX_NUMBER-MIN_NUMBER+1];

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            newArray[Array[i]-MIN_NUMBER] = 1;
        }

        int arrayIndex = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == 1){
               Array[arrayIndex] = i+MIN_NUMBER;
               arrayIndex++;
            }
        }

        return Array;
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    int[] ints = {-3, 5, -2, 4};
    //
    //    int[] bitmap = solution.Bitmap(ints);
    //    for (int a: bitmap ){
    //        System.out.println(a);
    //    }
    //}
}
