package Other03_Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


/**
 * @Description :
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @Solution :
 * for循环将每个位置的数据交换到第一位
 * 按相同的方式全排列剩余的位
 * 递归排列
 * 再把交换的字符换回来
 *
 * @learn :
 * （1）set.addll(collection)
 *
 * @Author : Gordon Deng
 * @Date :   19:07 2018/3/14
 */

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0){
            return result;
        }

        HashSet<String> set = new HashSet<>();
        getFullPermutationSet(set, str.toCharArray(), 0);
        result.addAll(set);
        Collections.sort(result);
        return result;

    }

    public void getFullPermutationSet(HashSet<String> result, char[] str, int k) {
        if (k == str.length){
            result.add(new String(str));
            return;
        }

        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            getFullPermutationSet(result, str, k+1);
            swap(str, i, k);
        }
    }

    void swap(char[] str, int i, int j){
        if (i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
