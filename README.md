# Goals_of_offer
剑指offer java版    

Sulotion in java


[1、二维数组中的查找](#1).  [2、替换空格](#2).  [3、从尾到头打印链表](#3).  [4、重建二叉树](#4).  [5、用两个栈实现队列](#5).  [6、旋转数组的最小数字](#6).  [7、斐波那契数列](#7).  [8、跳台阶](#8).  [9、变态跳台阶](#9).  [10、矩形覆盖](#10).  [11、二进制中1的个数](#11).  [12、数值的整数次方](#12).  [13、调整数组顺序使奇数位于偶数前面](#13).   [14、链表中倒数第k个结点](#14)[15、反转链表](#15).  [16、合并两个排序的链表](#16).  [17、树的子结构](#17).  [18、二叉树的镜像](#18).  [19、顺时针打印矩阵](#19).  [20、包含min函数的栈](#20).  [21、栈的压入、弹出序列](#21).  [22、从上往下打印二叉树](#22).  [23、二叉搜索树的后序遍历序列](#23).  [24、二叉树中和为某一值的路径](#24).  [25、复杂链表的复制](#25).  [26、二叉搜索树与双向链表](#26).  [27、字符串的排列](#27).  [28、数组中出现次数超过一半的数字](#28).  [29、最小的K个数](#29).  [30、连续子数组的最大和](#30).  [31、整数中1出现的次数（从1到n整数中1出现的次数）](#31).  [32、把数组排成最小的数](#32).  [33、丑数](#33).  [34、第一个只出现一次的字符位置](#34).  [35、数组中的逆序对](#35).  [36、两个链表的第一个公共结点](#36).  [37、数字在排序数组中出现的次数](#37).  [38、二叉树的深度](#38).  [39、平衡二叉树](#39).  [40、数组中只出现一次的数字](#40).  [41、和为S的连续正数序列](#41).  [42、和为S的两个数字](#42).  [43、左旋转字符串](#43).  [44、翻转单词顺序列](#44).  [45、扑克牌顺子](#45).  [46、求1+2+3+...+n.md](#46).  [47、求1+2+3+...+n](#47).  [48、不用加减乘除做加法](#48).  [49、把字符串转换成整数](#49).  [50、数组中重复的数字](#50).  [51、构建乘积数组](#51).  [52、正则表达式匹配](#52).  [53、表示数值的字符串](#53).  [54、字符流中第一个不重复的字符](#54).  [55、链表中环的入口结点](#55).  [56、删除链表中重复的结点](#56).  [57、二叉树的下一个结点](#57).  [58、对称的二叉树](#58).  [59、按之字形顺序打印二叉树](#59).  [60、把二叉树打印成多行](#60).  [61、序列化二叉树](#61).  [62、二叉搜索树的第k个结点](#62).  [63、数据流中的中位数](#63).  [64、滑动窗口的最大值](#64).  [65、矩阵中的路径](#65).  [66、机器人的运动范围](#66).  


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
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

## 解题思路
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

## AC代码

```
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
```

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

<p id = "11"></p>

## 题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

## 解题思路

两种方法。
- 第一种，是用位运算，将1每次左移，和数字进行&运算，如果成功，则返回1.
- 第二种，将整数通过方法转换为二进制数，然后统计其中1的数量

## AC代码

```
//第一种 C++
class Solution {
public:
     int  NumberOf1(int n) {
         int index = 1;
         int  number = 0;
         while (index != 0){
             if ((n & index) != 0){
                 number++;
             }
            index = index << 1;
         }
         return number;
     }
};
```

```
//第二种,Java版本
public class Solution {
    public int NumberOf1(int n) {
        int number = 0;
        String string = Integer.toBinaryString(n);
        char[] chars = string.toCharArray();
        for (int i=0; i< string.length(); i++){
            if (chars[i] == '1'){
                number++;
            }
        }
        return number;
    }
}
```
<p id = "12"></p>
## 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

## 解题思路

 * 1.全面考察指数的正负、底数是否为零等情况。
 * 2.写出指数的二进制表达，例如13表达为二进制1101。
 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。

## AC代码

```
//java1
public double Power(double base, int n) {
    double res = 1,curr = base;
    int exponent;
    if(n>0){
        exponent = n;
    }else if(n<0){
        if(base==0)
            throw new RuntimeException("分母不能为0"); 
        exponent = -n;
    }else{// n==0
        return 1;// 0的0次方
    }
    while(exponent!=0){
        if((exponent&1)==1)
            res*=curr;
        curr*=curr;// 翻倍
        exponent>>=1;// 右移一位
    }
    return n>=0?res:(1/res);       
}
```

```
//java2
class Solution {
public:
    double Power(double base, int exponent) {
        double result = 1;
        if (exponent == 0){
            return 1;
        }
        
        int absExponent = abs(exponent);
        for (int i=0; i<absExponent; i++){
            result *= base;
        }
        
        if (exponent < 0){
            result = 1 / result;
        }
        return result;
    }
};
```<p id = "13"></p>
## 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

## 解题思路

思路一
- 1、新建两个数组分别放原数组中的奇数和偶数。
- 2、将奇数数组中的数复制给原数组
- 3、将偶数数组中的数复制到原数组奇数的后边

## AC代码
```
public class Solution {
    public void reOrderArray(int [] array) {  
            int len=array.length;  
            int count1=0;  
            int count2=0;  
            int[] arr1=new int[len];  
            int[] arr2=new int[len];  
            for(int i=0;i<len;i++){  
                if(array[i]%2==0){  
                    arr2[count2++]=array[i];  
                }else{  
                    arr1[count1++]=array[i];  
                }  
            }  
            for(int i=0;i<count1;i++){  
                array[i]=arr1[i];  
            }  
            for(int i=0;i<count2;i++){  
                array[count1+i]=arr2[i];  
            }  
        } 
}
```

## 解题思路

思路二

- 如果要保证奇数和奇数，偶数和偶数之间的相对位置不变。
- 首先寻找第一个奇数，并将其放在0号位置。然后将第一个奇数之前的元素全部往后移一位。
- 依次在第一个奇数之后的元素中寻找奇数，并做移动操作。就可以保证原来的相对顺序。


## AC代码

```
public class Solution {
    public static void reOrderArray(int []array)
    {
        int j=0;//记录第一个为奇数的位置
        int m=0;//记录排好序的奇数的最后一个位置
        for(int i=0;i<array.length;i++)
        {    
            if(array[i]%2==1)//找到第一个奇数
            {
                int temp = array[i];//记录第一个奇数
                int ti=i;
                for(;ti>0;ti--)
                {
                    array[ti]=array[ti-1];//将第一个奇数之前的所有元素往后移一个位置
                }
                array[0] = temp;//将第一个奇数放到array[0]位置
                j=i;
                break;
            }
        }
        for(++j;j<array.length;j++)//依次寻找剩余的奇数
        {
            if(array[j]%2==1)
            {
                int temp = array[j];
                int tj = j;
                for(;tj>m;tj--)
                {
                    array[tj]=array[tj-1];
                }
                array[++m]=temp;
            }
        }   
    }
}
```<p id = "14"></p>
## 题目描述
输入一个链表，输出该链表中倒数第k个结点。

## 解题思路

两个指针pointResult和pointEnd一起指向头结点，然后根据k,移动pointEnd，使pointResult和pointEnd的距离为k-1。然后同时移动pointResult和pointEnd，当pointEnd指向最后一个结点时，pointResult指向倒数第k个结点。这种方法只用遍历一次链表。

## AC代码

```
/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if(pListHead==nullptr || k<1) return nullptr;
        ListNode* pointStart = pListHead;
        ListNode* pointEnd = pListHead;
        int i;
        for(i=1;i<k;i++){  
            if(!pointEnd->next) break;  
            pointEnd = pointEnd->next;  
        }
        if(i!=k) return nullptr;
        while(pointEnd->next){  
            pointEnd = pointEnd->next;
            pointStart = pointStart->next;
        }
        return pointStart;

    }
};
```## 题目描述
输入一个链表，反转链表后，输出链表的所有元素。

## 解题思路
遍历链表，将链表的所有元素存入一个栈中，从栈中取出元素时，依次得到的就是原链表从尾到头的节点。代码如下：

## AC代码

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.Stack;  

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        
        Stack<ListNode> stk = new Stack<ListNode>();
        while (head!=null){
            stk.push(head);
            head = head.next;
        }
        ListNode newHead = stk.pop();
        ListNode resultHead = newHead;
        while (!stk.isEmpty()){
            newHead.next = stk.pop();
            newHead = newHead.next;
        }
        newHead.next=null;
        return resultHead;
        
        
    }
}
```
<p id = "15"></p>
## 题目描述
输入一个链表，反转链表后，输出链表的所有元素。

## 解题思路
遍历链表，将链表的所有元素存入一个栈中，从栈中取出元素时，依次得到的就是原链表从尾到头的节点。代码如下：

## AC代码

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.Stack;  

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        
        Stack<ListNode> stk = new Stack<ListNode>();
        while (head!=null){
            stk.push(head);
            head = head.next;
        }
        ListNode newHead = stk.pop();
        ListNode resultHead = newHead;
        while (!stk.isEmpty()){
            newHead.next = stk.pop();
            newHead = newHead.next;
        }
        newHead.next=null;
        return resultHead;
        
        
    }
}
```
<p id = "16"></p>

## 题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

## 解题思路

- 链表1的头结点的值小于链表2的头结点的值，因此链表1的头结点是合并后链表的头结点。
- 在剩余的结点中，链表2的头结点的值小于链表1的头结点的值，因此链表2的头结点是剩余结点的头结点，把这个结点和之前已经合并好的链表的尾结点链接起来。

## AC代码

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list3;
        if (list1.val < list2.val){
            list3 = list1;
            list3.next = Merge(list1.next, list2);
        }else{
            list3 = list2;
            list3.next = Merge(list1, list2.next);
        }
        return list3;
    }
}
```
<p id = "17"></p>
## 题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

## 解题思路

这题主要分两步，一判断根结点，二判断左右子节点，方法采用递归，最重要的是，一定要判断结点是否为空，否则肯定会遭到面试官的鄙视

## AC代码

```
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       if(root1==null||root2==null){
           return false;
       }
        return isSubtree(root1,root2)||isSubtree(root1.left,root2)||isSubtree(root1.right,root2);
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val==root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }else{
            return false;
        }
    }
}
```

<p id = "18"></p>

## 题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树             
            8        
           /  \         
          6   10                   
         / \  / \                 
        5  7 9 11                 
        镜像二叉树                 
            8                 
           /  \                 
          10   6                 
         / \  / \                 
        11 9 7  5                 

## 解题思路

- 1.交换根结点的左右子结点；
- 2.将左右子结点看作根结点进行1的操作


## AC代码
```
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null || ((root.left == null)&& (root.right == null) )){
            return;
        }
        //交换左右子树
        TreeNode pTem = root.left;
        root.left = root.right;
        root.right = pTem;
        //当左右子结点不为空时，递归调用自身，整个过程就是一个递归，注意递归停止的条件
        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }
}
```<p id = "19"></p>
## 题目描述
输入一个矩阵如下:

 1     2     3    4
 5     6     7    8
 9     10    11   12
 13    14    15   16

则依次打印出数字:1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10

## 解题思路

一看题目很简单，上手发现其实循环很乱。看了 其他人的做法，大多都是记录循环的圈数，然后每次右行、下行、左行、上行。但缺点在于 若出现只剩下一行或一列的情况，处理较复杂。
本题采取记录最外圈四个角的位置方法， 
当满足左右间距大于1，上下间距大于1时，每次剥下一圈，将四个角都往内移一位，再判断是否满足条件； 
当不满足上述条件时，判断是一行或者一列或者单独一个元素，将该行、该列、该元素加入List。 

## AC代码
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int top=0,right=matrix[0].length-1,bom=matrix.length-1,left=0;
       ArrayList<Integer> list = new ArrayList<Integer>();
       while((right>left)&&(bom>top)){
            //从左到右
            for (int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            //从上到下
            for (int i=top+1;i<=bom;i++) {
                list.add(matrix[i][right]);
            }
            //从右到左
            for (int i=right-1;i>=left;i--){
                list.add(matrix[bom][i]);
            }
            //从下到上
            for (int i=bom-1;i>top;i--){
                list.add(matrix[i][left]);
            }
           top++;
           right--;
           left++;
           bom--;
        }
        //只有一行
        if ((top==bom)&&(left<right)){
            for (int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
        }
        //只有一列
        if ((right==left)&&(top<bom)){
            for (int i=top;i<=bom;i++){
                list.add(matrix[i][left]);
            }
        }
        //只有一个
        if ((right==left)&&(top==bom)){
            list.add(matrix[top][left]);
        }
        return list;
    }
}
```<p id = "20"></p>
## 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

## 解题思路

本题借助辅助栈，以及一个变量用来记录最小元素，当把元素压入栈时，比较元素与最小元素间的关系，若大于最小元素，则将最小元素压入辅助栈，此元素压入数据栈，若元素小于最小元素，则将此元素压入数据栈和辅助栈。代码如下

## AC代码

```

import java.util.Stack;

public class Solution {

    Stack<Integer> st1 = new Stack<Integer>();//数据栈
    Stack<Integer> st2 = new Stack<Integer>();//辅助栈
    Integer temp = null;
    public void push(int node) {
        if (temp!=null){
            if (node<=temp){
                temp = node;
                st1.push(node);
                st2.push(node);
            }else{
                st1.push(node);
                st2.push(temp);
            }
        }else{
            temp = node;
            st1.push(node);
            st2.push(node);
        }
    }
    
    public void pop() {
        if (!st1.empty()&&!st2.empty()){
            int m = st1.pop();
            st2.pop();
            temp = m;
        }
    }
    
    public int top() {
        int top = st1.pop();
        st1.push(top);
        return top;
    }
    
    public int min() {
        int min = st2.pop();
        st2.push(min);
        return min;
    }
}
```<p id = "21"></p><p id = "22"></p><p id = "23"></p><p id = "24"></p><p id = "25"></p><p id = "26"></p><p id = "27"></p><p id = "28"></p><p id = "29"></p><p id = "30"></p><p id = "31"></p><p id = "32"></p><p id = "33"></p><p id = "34"></p><p id = "35"></p><p id = "36"></p><p id = "37"></p><p id = "38"></p><p id = "39"></p><p id = "40"></p><p id = "41"></p><p id = "42"></p><p id = "43"></p><p id = "44"></p><p id = "45"></p><p id = "46"></p><p id = "47"></p><p id = "48"></p><p id = "49"></p><p id = "50"></p><p id = "51"></p><p id = "52"></p><p id = "53"></p><p id = "54"></p><p id = "55"></p><p id = "56"></p><p id = "57"></p><p id = "58"></p><p id = "59"></p><p id = "60"></p><p id = "61"></p><p id = "62"></p><p id = "63"></p><p id = "64"></p><p id = "65"></p><p id = "66"></p>