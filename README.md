# Goals_of_offer
剑指offer java版    

Sulotion in java


[1、二维数组中的查找](#b1)[2、替换空格](#2)[3、从尾到头打印链表](#3)[4、重建二叉树](#4)[5、用两个栈实现队列](#5)[6、旋转数组的最小数字](#6)[7、斐波那契数列](#7)[8、跳台阶](#8)[9、变态跳台阶](#9)[10、矩形覆盖](#10)[11、二进制中1的个数](#11)[12、数值的整数次方](#12)[13、调整数组顺序使奇数位于偶数前面](#13)[14、链表中倒数第k个结点](#14)[15、反转链表](#15)[16、合并两个排序的链表](#16)[17、树的子结构](#17)[18、二叉树的镜像](#18)[19、顺时针打印矩阵](#19)[20、包含min函数的栈](#20)[21、栈的压入、弹出序列](#21)[22、从上往下打印二叉树](#22)[23、二叉搜索树的后序遍历序列](#23)[24、二叉树中和为某一值的路径](#24)[25、复杂链表的复制](#25)[26、二叉搜索树与双向链表](#26)[27、字符串的排列](#27)[28、数组中出现次数超过一半的数字](#28)[29、最小的K个数](#29)[30、连续子数组的最大和](#30)[31、整数中1出现的次数（从1到n整数中1出现的次数）](#31)[32、把数组排成最小的数](#32)[33、丑数](#33)[34、第一个只出现一次的字符位置](#34)[35、数组中的逆序对](#35)[36、两个链表的第一个公共结点](#36)[37、数字在排序数组中出现的次数](#37)[38、二叉树的深度](#38)[39、平衡二叉树](#39)[40、数组中只出现一次的数字](#40)[41、和为S的连续正数序列](#41)[42、和为S的两个数字](#42)[43、左旋转字符串](#43)[44、翻转单词顺序列](#44)[45、扑克牌顺子](#45)[46、求1+2+3+...+n.md](#46)[47、求1+2+3+...+n](#47)[48、不用加减乘除做加法](#48)[49、把字符串转换成整数](#49)[50、数组中重复的数字](#50)[51、构建乘积数组](#51)[52、正则表达式匹配](#52)[53、表示数值的字符串](#53)[54、字符流中第一个不重复的字符](#54)[55、链表中环的入口结点](#55)[56、删除链表中重复的结点](#56)[57、二叉树的下一个结点](#57)[58、对称的二叉树](#58)[59、按之字形顺序打印二叉树](#59)[60、把二叉树打印成多行](#60)[61、序列化二叉树](#61)[62、二叉搜索树的第k个结点](#62)[63、数据流中的中位数](#63)[64、滑动窗口的最大值](#64)[65、矩阵中的路径](#65)[66、机器人的运动范围](#66)


<p id = "1"></p>

## 题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

## 解题思路


## AC代码
```
class Solution {
public:
    bool Find(int target, vector<vector<int> > array) 
    {
        int m=array.size();
        int n=array[0].size();
        int row=m-1;
        int column=0;
      
        if(m==0&&n==0)
            return false;
    
            while(row>=0&&column<n)
            {
            if(target>array[row][column])
                    column++;
                else if (target<array[row][column])
                     row--;
                    
                 else 
                     return true;
            }
        
            return false;
          
        
    }
};
```<p id = "2"></p>

## 题目描述
请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

## 解题思路


## AC代码
```
class Solution {
public:
	void replaceSpace(char *str,int length) {
        int blanknumber = 0;
        int oldnumber;
        for (oldnumber=0;str[oldnumber]!='\0';oldnumber++){
            if (str[oldnumber]==' '){
                blanknumber++;
            }
        }        
        int newnumber = oldnumber + blanknumber*2;
        if (newnumber>length)
            return;
        str[newnumber] = '\0';
        int p1 = oldnumber - 1;
        int p2 = newnumber - 1;
        while ( p1>=0 && p2>p1 ) {
            if (str[p1]==' '){
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            } else{
                str[p2--] = str[p1];
            }
            p1--;
        }
	}
};
```
<p id = "3"></p>

## 题目描述
输入一个链表，从尾到头打印链表每个节点的值。

## 解题思路
借助栈，遍历链表

## AC代码
```
/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
*/
class Solution {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> result;//存储输出的节点的值
        stack<struct ListNode*> nodes;//用栈来存储每个节点
        struct ListNode* pNode = head;//从链表头开始
        //进栈
        while(pNode != NULL){
            nodes.push(pNode);
            //pNode=pNode->next；
            pNode = pNode->next;
        }
        
        //出栈
        while(!nodes.empty()){
            pNode = nodes.top();
            result.push_back(pNode->val);
            nodes.pop();
        }
        return result;
    }
};
```
<p id = "4"></p>

## 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

## 解题思路
递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解，直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点

## AC代码
```
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
```

<p id = "5"></p>

## 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

## 解题思路
用stack1来实现队列的push操作，用stack2来实现队列的pop操作，当stack2为空时，将stack1的数据全部压入stack2，等待队列的pop操作。

## AC代码
```
class Solution
{
public:
    void push(int node) {
        stack1.push(node);
    }

    int pop() {
        int result;
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        result = stack2.top();
        stack2.pop();
        return result;
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};
```
<p id = "6"></p>

## 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

## 解题思路
遍历数组

## AC代码
```
class Solution {
public:
    int minNumberInRotateArray(vector<int> rotateArray) {
        int size = rotateArray.size();
        if (size == 0){
            return 0;
        }
        int tmp = rotateArray[0];
        for (int i = 0; i < size; i++ ){
            if (rotateArray[i] < tmp){
                tmp = rotateArray[i];
            }
        }
        return tmp;
    }
};
```
<p id = "7"></p>

## 题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39

## 解题思路
斐波那契数列

这题的n是从0开始的：
```
if(n<=1) return n;
else return Fibonacci(n-1)+Fibonacci(n-2);
```
本题用递归会溢出，故使用用循环。
## AC代码

方法一
```
class Solution {
public:
    int Fibonacci(int n) {
        int first = 0, second = 1,target=0;

        if (n < 2)
            return n ;
        for (int i = 0; i < n-1; i++)
        {
            target = first + second;
            first = second;
            second = target;
        }
        
        return target;
    }
};
```



方法二

```

class Solution {
public:
    int Fibonacci(int n) {
  //第一种方法 算法复杂度太高
    /*  if (n <= 2)
            return n - 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        return 0;*/
        //第二种方法 节省空间，时间快
        int first = 0, second = 1,target=0;

        if (n < 2)
            return n ;
        for (int i = 0; i < n-1; i++)
        {
            target = first + second;
            first = second;
            second = target;
        }
        
        return target;
    }
};
```
<p id = "8"></p>

## 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

## 解题思路
斐波那契数列指的是这样一个数列： 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368。

可以观察到，从第3个数开始，每个数的值都等于前连个数之和。

同时，定义f(0)=0, f(1)=1.

则 f(2)=f(1)+f(0)=1;

　 f(3)=f(2)+f(1)=2;

　 ... 依次类推，

　 f(n)=f(n-1)+f(n-2)

该问题实质是斐波那契数列求和，递推公式为 f(n)=f(n-1)+f(n-2);

可以考虑，小青蛙每一步跳跃只有两种选择：一是再跳一级阶梯到达第 i 级阶梯，此时小青蛙处于第 i-1 级阶梯；或者再跳两级阶梯到达第 i 级阶梯，此时小青蛙处于第 i-2 级阶梯。

于是，i 级阶梯的跳法总和依赖于前 i-1 级阶梯的跳法总数f(i-1)和前 i-2 级阶梯的跳法总数f(i-2)。因为只有两种可能性，所以，f(i)=f(i-1)+f(i-2);

依次类推，可以递归求出n级阶梯跳法之和。

## AC代码

```
//递归写法
class Solution {
public:
    int jumpFloor(int number) {
        if (number < 0){
            return 0;
        }
        
        if (number < 3){
            return number;
        }
        
        return jumpFloor(number-1) + jumpFloor(number-2);
    }
};
```

```
//非递归算法
class Solution {
public:
    int jumpFloor(int number) {
        if (number < 0){
            return 0;
        }
        
        if (number < 3){
            return number;
        }
        int total=0;
        int firstElem=1;
        int secondElem=2;
        for (int i=3;i<=number;i++){
            total = firstElem + secondElem;
            firstElem = secondElem;
            secondElem = total;
        }
        return total;
    }
};
```

<p id = "9"></p>


## 题目描述


## 解题思路


## AC代码

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
其实就是斐波那契数列问题。
假设f(n)是n个台阶跳的次数。
  1. f(1) = 1
  2. f(2) 会有两个跳得方式，一次1阶或者2阶，这回归到了问题f(1),f(2) = f(2-1) + f(2-2)
  3. f(3) 会有三种跳得方式，1阶、2阶、3阶，那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3).因此结论是
f(3) = f(3-1)+f(3-2)+f(3-3)
  4. f(n)时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1) == f(n) = 2*f(n-1)
所以，可以得出结论
f(n) = 2*f(n-1)

http://blog.csdn.net/qq_23217629/article/details/51723722

class Solution {
public:
    int jumpFloorII(int number) {
        if (number < 0){
            return 0;
        }
        
        if (number < 2){
            return number;
        }
        
        return 2 * jumpFloorII(number-1);
    }
};

<p id = "10"></p>

## 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？


## 解题思路
　　观察题目中的矩形，2*n的，是个长条形。本来脑中想象的是复杂的华容道，但是既然只是简单的长条形，那么依然逆向分析。既然是长条形的，那么从后向前，最后一个矩形2*2的，只有两种情况：


![image](http://upload-images.jianshu.io/upload_images/688387-959385f71be6724a..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


- 第一种是最后是由一个2*(n-1)的矩形加上一个竖着的2*1的矩形
- 另一种是由一个2*(n-2)的矩形，加上两个横着的2*1的矩形

因此我们可以得出， 第2*n个矩形的覆盖方法等于第2*(n-1)加上第2*(n-2)的方法。

## AC代码
```
class Solution {
public:
    int rectCover(int number) {
        if (number < 0){
            return 0;
        }
        if (number < 3){
            return number;
        }
        return rectCover(number-1) + rectCover(number-2);
    }
};
```

<p id = "11"></p><p id = "12"></p><p id = "13"></p><p id = "14"></p><p id = "15"></p><p id = "16"></p><p id = "17"></p><p id = "18"></p><p id = "19"></p><p id = "20"></p><p id = "21"></p><p id = "22"></p><p id = "23"></p><p id = "24"></p><p id = "25"></p><p id = "26"></p><p id = "27"></p><p id = "28"></p><p id = "29"></p><p id = "30"></p><p id = "31"></p><p id = "32"></p><p id = "33"></p><p id = "34"></p><p id = "35"></p><p id = "36"></p><p id = "37"></p><p id = "38"></p><p id = "39"></p><p id = "40"></p><p id = "41"></p><p id = "42"></p><p id = "43"></p><p id = "44"></p><p id = "45"></p><p id = "46"></p><p id = "47"></p><p id = "48"></p><p id = "49"></p><p id = "50"></p><p id = "51"></p><p id = "52"></p><p id = "53"></p><p id = "54"></p><p id = "55"></p><p id = "56"></p><p id = "57"></p><p id = "58"></p><p id = "59"></p><p id = "60"></p><p id = "61"></p><p id = "62"></p><p id = "63"></p><p id = "64"></p><p id = "65"></p><p id = "66"></p>