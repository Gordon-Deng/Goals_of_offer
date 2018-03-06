package Program09_Fibonacci;

/**
 * @Description :
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * @Solution :
 * 0112。。。。
 * @learn :
 * 1)nothing
 * @Author : Gordon Deng
 * @Date :   05:08 2018/3/7
 */

public class Solution {
    public int Fibonacci(int n) {
        int [] inputData = {0,1};

        if (n <= 2){
            return inputData[n];
        }

        int FIB_FIRST_MINUS = 0;
        int FIB_SECOND_MINUS = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = FIB_FIRST_MINUS + FIB_SECOND_MINUS;
            FIB_FIRST_MINUS = FIB_SECOND_MINUS;
            FIB_SECOND_MINUS = result;
        }

        return result;
    }
}
