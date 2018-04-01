package Other03_MaxMultiplication;

import java.util.Scanner;

/**
 * 题目:
 * 给出一个整数n，将n分解成至少两个整数之和，使得这些整数的乘积最大化，输出能获得的最大的乘积。
 * 
 * 输入描述:
 * in:
 * 10
 * 
 * 输出描述:
 * out:
 * 36
 * 
 * 解析:
 * 这个题还是要一丁点数学知识的，给你一个数n = a + b，a * b何时最大，那必然是a和b尽量靠近时才最大，现在这个n可以分解成多个数字相加，那么这些数字相乘什么时候最大呢，和两个数字一样，这些数字肯定也是都靠在一起才最大
 * 什么叫靠在一起呢，就是任意两个数只差的绝对值小于等于1，那么这些数字必然可以分解成x, x, x, ...,x + 1, x + 1, ...这种形式。
 * 这么一想，这个代码就好写了，枚举其中的从1到n / 2枚举x，先看看可以分解成多少个数字，结果是n / x，还剩下n % x，把n % x一个一个分配到之前的x中
 * 这里要特别注意，n % x有可能大于n / x，这说明，把n % x分配完，还有剩下的，不符合要求，而且这种情况肯定会在枚举x = x + 1时会处理，因此过滤掉这种x就行了。
 * 14 = 5 + 5 + 4 然后把4分配给两个 5（+1）剩下2，2再分给6（+1）
 */

public class Main {
    
    public Scanner cin = new Scanner(System.in);

    Main() {
        
        while (cin.hasNext()) {
            long n = cin.nextLong();
            
            //5 = 2 * 3
            long ans = n / 2 * (n - n / 2);
            
            //遇到余数分完还有剩的情况的话，交给x+1处理
            for (int i = 1; i <= n / 2; i++) {
                if (n / i <= n % i) {
                    continue;
                }
                
                ans = (long) Math.max(ans, Math.pow(i + 1, n % i) * Math.pow(i, n / i - (n % i)));
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
