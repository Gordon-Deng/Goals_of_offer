# Goals_of_offer
剑指offer java版    

Sulotion in java （Part of c++）


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
```
<p id = "13"></p>

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
```
<p id = "14"></p>

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
```
<p id = "19"></p>

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
```
<p id = "20"></p>

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
```
<p id = "21"></p>

## 题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

## 解题思路

思路：借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
举例：
入栈1,2,3,4,5
出栈4,5,3,2,1
首先1入辅助栈，此时栈顶1≠4，继续入栈2
此时栈顶2≠4，继续入栈3
此时栈顶3≠4，继续入栈4
此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
此时栈顶3≠5，继续入栈5
此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
….
依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。

## AC代码

```
import java.util.ArrayList;
import java.util.Stack;  

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = pushA.length;
        int m=0;
        Stack<Integer> s = new Stack<Integer>();
        
        for (int j=0;j<i;j++){
            s.push(pushA[j]);
            while (!s.isEmpty() && s.peek()==popA[m]){
                s.pop();
                m++;
            }
        }
        return s.isEmpty();
    }
}
```
<p id = "22"></p>

## 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

## 解题思路
> 层次遍历，基于队列

注意不管是广度优先遍历一个有向图还是一颗树，都会用到队列。第一步我们把起始结点（对树而言是根结点）放入到队列中。接下来每一次从队列的头部取出一个结点，遍历这个结点之后把从它能到达的结点（对数而言是子结点）都依次放入队列。我们重复这个遍历过程，直到队列中的结点全部被遍历为止。

## AC代码
```
import java.util.ArrayList;
import java.util.LinkedList;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //声明list和队列
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        //先考虑边界
        if (root == null){
            return list;
        }
        queue.add(root);
        while (queue.size() != 0){
            TreeNode top = queue.get(0);
            list.add(top.val);
            if (top.left!=null){
                queue.add(top.left);
            }
            if (top.right!=null){
                queue.add(top.right);
            }
            queue.remove(0);
        }
        return list;
    }
}



-------------------------------------------------------------------------------------------

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    if(root==null)//先考虑边界情况

            return new ArrayList();

        //初始化list和queue

        ArrayList<Integer> list=new ArrayList();

        LinkedList<TreeNode> queue=new LinkedList();

        //现将根结点入队列

        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode treeNode=queue.poll();

            list.add(treeNode.val);

            if(treeNode.left!=null)

                queue.offer(treeNode.left);

            if(treeNode.right!=null)

                queue.offer(treeNode.right);

        }

        return list;
    }
}
```

<p id = "23"></p>

## 题目描述

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

## 解题思路

对于一个二叉树的后序遍历序列来说，最后一个数一定是根节点，然后前面的数中，从最开始到第一个大于根节点的数都是左子树中的数，而后面到倒数第二个数应该都是大于根节点的，是右子树，如果后面的数中有小于根节点的，那么说明这个序列不是二叉搜索树的后序遍历序列


## AC代码
```
import java.util.Arrays;  

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        //判断非空
        if ( (sequence==null) || sequence.length<=0){
            return false;
        }
        int len = sequence.length;
        int root = sequence[len-1];
        int i=0;
        for ( ;i<len-1;i++){
            if (root <= sequence[i]){
                break;
            }
        }
        int j=i;
        for (;j<len-1;j++){
            if (root > sequence[j]){
                return false;
            }
        }
        boolean leftFlag = true;
        //左子树0,i
        if (i>0) {
            leftFlag=VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
        }
        boolean rightFlag = true;
        //右子树i,len-1
        if (j<len-1) {
            rightFlag=VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,len-1));
        }
        return leftFlag && rightFlag;
    }
}
```

<p id = "24"></p>

## 题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

## 解题思路
二叉树遍历

## AC代码
```

import java.util.ArrayList;
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
    // 存放所有路径
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    // 用于遍历
    ArrayList<Integer> list = new ArrayList<Integer>();
    int num = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null){
            return lists;
        }
        num += root.val;
        list.add(root.val);
        // 如果此时路径长度值刚好等于目标值，并且此时所在结点为叶子结点(路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径),路径存入lists
        if (num == target && root.left == null && root.right == null)
        {
            // 存放路径结点值
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++)
            {
                path.add(list.get(i));
            }
            lists.add(path);
        }
        
         // 先遍历左子树
        if (num < target && root.left != null)
        {
            FindPath(root.left, target);
        }
        // 左子树遍历结束，遍历右子树
        if (num < target && root.right != null)
        {
            FindPath(root.right, target);
        }
        // 去掉这个结点值
        num -= root.val;
        // 删除该结点，返回到父结点
        list.remove(list.size() - 1);
        return lists;
    }
}
```
<p id = "25"></p>

## 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）


## 解题思路

不用辅助空间的情况下实现O（n）的时间效率。分为三步：
- 第一步复制原始链表上的每一个结点N创建对应的N’，并把N’放在N之后。如下图：
![image](http://upload-images.jianshu.io/upload_images/688387-12b11de24a08dee6?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

 
- 第二步：设置每个结点的random 指针。如果原始链表上的结点N的random指向S，则对应的复制结点N’的random指向S’。如下图：
![image](http://upload-images.jianshu.io/upload_images/688387-0ed3a35b6ad6fceb?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 第三步：把长链表分为两个链表：把奇数位置的结点用next连接起来就是原始链表，把偶数位置的结点用next连接起来就是复制出来的链表。
![image](http://upload-images.jianshu.io/upload_images/688387-101dea2c6be5178a?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## AC代码
```
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur!=null){
            if (pCur.random!=null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        //拆分链表
        RandomListNode head = pHead.next;
        RandomListNode cur = head;//A'B'C'
        pCur = pHead;//ABC
        while (pCur!=null){
            pCur.next = pCur.next.next;
            if (cur.next!=null){
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
```
<p id = "26"></p>

## 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。


## 解题思路
递归做法
- 1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
- 2、定位到左链表的最后一个节点(左子树最右边的节点)
- 3、如果左子树链表不为空，则将当前root追加到左子树链表后
- 4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
- 5、如果右子树链表不为空，将右子树链表追加到当前root后
- 6，根据左子树链表是否为空返回的整体双向链表的头节点




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
    public TreeNode Convert(TreeNode root) {
        if(root==null){//假如根节点为空，返回空
            return null;
        }
        if(root.left==null&&root.right==null){//假如只有一个根节点，则返回根节点
            return root;
        }
        //1、将左子树构造成双链表，并返回该链表头结点left
        TreeNode left=Convert(root.left);

        //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
        TreeNode p=left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点，
        while(p!=null&&p.right!=null){
            p=p.right;//最终p为左子树最右边的节点
        }
        //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if(left!=null){//左子树链表不为空
            p.right=root;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
            root.left=p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
        }
        //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right=Convert(root.right);

        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){//右子树链表不为空
            right.left=root;//右子树链表的头结点right的左指针指向当前root
            root.right=right;//当前root的右指针指向右子树链表的头结点right
        }
        return left!=null?left:root;//根据左子树链表是否为空返回整个双向链表的头指针。 
    }
}
```
<p id = "27"></p>

## 题目描述

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

### 输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

## 解题思路

分析：这是一道很好的考查对递归理解的编程题，因此在过去一年中频繁出现在各大公司的面试、笔试题中。         
我们以三个字符abc为例来分析一下求字符串排列的过程。首先我们固定第一个字符a，求后面两个字符bc的排列。当两个字符bc的排列求好之后，我们把第一个字符a和后面的b交换，得到bac，接着我们固定第一个字符b，求后面两个字符ac的排列。现在是把c放到第一位置的时候了。记住前面我们已经把原先的第一个字符a和后面的b做了交换，为了保证这次c仍然是和原先处在第一位置的a交换，我们在拿c和第一个字符交换之前，先要把b和a交换回来。在交换b和a之后，再拿c和处在第一位置的a进行交换，得到cba。我们再次固定第一个字符c，求后面两个字符b、a的排列。
既然我们已经知道怎么求三个字符的排列，那么固定第一个字符之后求后面两个字符的排列，就是典型的递归思路了。


## AC代码
```
import java.util.ArrayList;  
import java.util.Collections;  
public class Solution {  
    public ArrayList<String> Permutation(String str) {  
        ArrayList<String> list = new ArrayList<String>();  
        char[] ch = str.toCharArray();  
        Permu(ch, 0, list);  
        Collections.sort(list);  
        return  list;  
    }  
  
    public void Permu(char[] str, int i, ArrayList<String> list) {  
        if (str == null) {  
            return;  
        }  
        if (i == str.length - 1) {  
            if(list.contains(String.valueOf(str))){  
                return;  
            }  
            list.add(String.valueOf(str));  
        } else {  
            //boolean num=true;  
            for (int j = i; j < str.length; j++) {  
                char temp = str[j];  
                str[j] = str[i];  
                str[i] = temp;  
  
                Permu(str, i + 1, list);  
  
                temp = str[j];  
                str[j] = str[i];  
                str[i] = temp;  
            }  
        }  
  
    }  
  
  
}  
```
<p id = "28"></p>
## 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

## 解题思路
这个算法我已开始想到的是用hashmap来做，以数字为key，value是重复的次数，最后找出重复次数最多的那个，与lenght/2对比一下，应该是可以做出来。但是看了别人的算法，觉得非常好。

上面的代码，思路很好，类似于‘士兵攻打阵地’。我们把数组想象为一群士兵，这些士兵来自不同阵营，士兵们一个一个走出军营去攻打阵地，第一个兵占领阵地以后，后面来的兵可能是自己人，也可能不是自己人，是自己人的话，count+1，不是自己人的话，同归于尽，最后肯定剩下一个人活到最后，但是这个人并不一定属于人最多的那一个阵营。比如:'3,3,3,1,2,0'，第一个3先上去，第二个3再上去，第三个3再上去，这时候count=3，后面1上去，3-1=2，2上去，2-1=1，1上去，1-1=0，这时候留在最后的是0，但是0显然不是人数最多那个阵营的兵，人数最多的那个阵营都被别的阵营消耗掉了。如果出场顺序变为:'3,1,3,3,2,0'，那最后留下的人就是3，但是3个3并没有> (6/2)。如果3的数量再多一个，那么不论怎么出场，最后剩下的就是3，毕竟人多，与一半的人同归于尽后总会剩下人的，这时候显然4个3>(7/2)。

## AC代码
```
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (length < 1){
            return 0;
        }
        int num = array[0], count = 1;
        for (int i = 0 ; i < length; i++){
            if (num == array[i]){
                count++;
            }else{
                count--;
            }
            if (count==0){
                num = array[i];
                count = 1;
            }
        }
        
        //Verified
        count = 0;
        for (int i=0; i < length; i++){
            if (num == array[i]){
               count++;
            }
        }
        if ( count > length/2 ){
            return num;
        }else{
            return 0;
        }
    }
}
```
<p id = "29"></p>
## 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

## 解题思路
先插入排序，再进行输出排序后的数组的前K个数即可。

## AC代码
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = input.length;
        if (k < 0 ||k > len){
            return list;
        }
        for (int i=1; i < len;i++){
            int j=i;
            int tmp = input[i];
            while (j>0 && tmp < input[j-1]){
                input[j] = input[j-1];
                j--;
            }
            input[j] = tmp;
        }

        for (int i = 0; i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}

```

<p id = "30"></p>

## 题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)

## 解题思路
从第一个数字开始累加，如果和大于之前保存的最大值则替换最大值为当前的和，如果和小于0则从当前的数字开始累加。 

## AC代码
```
public class Solution {
    public int FindGreatestSumOfSubArray(int []nums) {  
        if(nums.length<=0 || nums == null)
            throw new NullPointerException();
        int sum = 0;
        int max = -1<<31;// int maxSum = INT_MIN;   用来保存最大和，初始化为最小的负整数
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum > max) {
                max = sum;  // 将最大和更新为当前和
            }
            if(sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }  
}
```
<p id = "31"></p>
## 题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。

## 解题思路 
  ● 常规思路（暴力解决），一个数一个数的计数
  ● 寻找数学规律，[数学规律](http://blog.csdn.net/huzhigenlaohu/article/details/51779365)

## AC代码
```
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for (int i=0; i<=n;i++){
            int tmp = i;
            while (tmp>0){
                if (tmp%10==1){
                    count++;
                }
                tmp/=10;
            }
        }
        return count;
    }
}
```
<p id = "32"></p>

## 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

## 解题思路

### 方法一
Comparator接口，两个对象要使用compareTo方法比较大小，就必须实现Comparator接口的compare方法，比如String就实现了这个方法，所以可以直接使用compareTo进行比较。sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序。大概是这个意思

### AC代码

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int n = numbers.length;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        for(Integer j : list){
            s+=j;
        }
        return s;
    }
}
```

### 方法二
 * 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较

### AC代码
```
public String PrintMinNumber(int [] numbers) {
    if(numbers == null || numbers.length == 0) return "";
    int len = numbers.length;
    String[] str = new String[len];
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < len; i++){
        str[i] = String.valueOf(numbers[i]);
    }
    Arrays.sort(str,new Comparator<String>(){
        @Override
        public int compare(String s1, String s2) {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        }
    });
    for(int i = 0; i < len; i++){
        sb.append(str[i]);
    }
    return sb.toString();
}
```
<p id = "33"></p>

## 题目描述
把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

## 解题思路
两个关键点，
- 1、ugly一定是也只能是2，3，5的倍数 
- 2、后面的ugly由前面的ugly生成。因此可以维护一个ugly number的数组，一个ugly number一定可以表示成 2*x 或 3*x 或 5*x，x是ugly number。


## AC代码

```
package offer;

import static jdk.nashorn.internal.objects.NativeMath.min;

//剑指Offer，丑数
public class Chou {

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int M2 = 0;//数组最后一个2的倍数所在的位置
        int M3 = 0;//数组最后一个3的倍数所在的位置
        int M5 = 0;//数组最后一个5的倍数所在的位置
        for (int i = 1; i < index; i++) {
            int number = min(result[M2]*2,result[M3]*3,result[M5]*5);
            System.out.println(number);
            result[i] = number;
            if (result[M2]*2 == number){
                M2++;
            }
            if (result[M3]*3 == number){
                M3++;
            }
            if (result[M5]*5 == number){
                M5++;
            }
        }
        return result[index-1];
    }

    public static int min(int a, int b, int c){
        int min = (a<b)?a:b;
        return (min<c)?min:c;
    }

    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(4));
    }

}
```
<p id = "34"></p>

## 题目描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置

## 解题思路
- 使用哈希表，键值（key）为字符，值（value）是该字符出现的次数。      
- 由于本题的特殊性，我们只需要一个非常简单的哈希表就能满足要求。字符类型（char）是一个长度为8位的数据类型，因此总共有256种可能。所以，我们创建一个长度为256的数组，每个字符根据其ASCII码的值做为数组的下标对应数组中的一个数字，而该下标所对应的数字就是该字符出现的次数。       
- 第一次扫描字符串时，在哈希表中更新一个字符出现的次数的时间是O(1)，所以整个扫描的时间是O(n)。
- 第二次扫描时，同样的，只需要O(1)的时间就可以得到字符出现的次数，所以时间复杂度仍然是O(n)。       
- 我们需要一个长度为256的int数组，它占用1K空间。因为这个数组的大小是常数，可以认为该算法的空间复杂度是O(1)。 
　　
http://blog.csdn.net/sjt19910311/article/details/50740303

## AC代码
```
public class Solution {
    
    public static int FirstNotRepeatingChar(String str) {
        if (str.isEmpty()){
            return -1;
        }

        //初始化哈希表
        int[] hashTable = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hashTable[i]=0;
        }

        //出现一次加一次
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            hashTable[str.charAt(i)]++;
        }

        //找到出现一次
        for (int i = 0; i < str.length(); i++) {
            if (hashTable[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
```
<p id = "35"></p>

## 题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007


输入描述: 题目保证输入的数组中没有的相同的数字    

数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5


## 解题思路
归并排序，求出逆序次数

## AC代码

```
public class Solution {
    int cnt;

    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }

    /*
         * 归并排序(从上往下)
         */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    /*
         * 将一个数组中的两个相邻有序区间合并成一个
         */
    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;  // core code, calculate InversePairs............
                cnt = cnt%1000000007;
            }
        }

        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
```
<p id = "36"></p>

## 题目描述
输入两个链表，找出它们的第一个公共结点。

## 解题思路
- 方法一：运用HasnMap的特性,key的唯一性
- 方法二：找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走（因为2个链表用公共的尾部）

## AC代码

### 方法一
```
import java.util.HashMap;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        HashMap<ListNode, Integer> hashMap= new HashMap<ListNode, Integer>();
        while (current1!=null){
            hashMap.put(current1,null);
            current1 = current1.next;
        }
        
        while (current2!=null){
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }
        
        return null;
    }
}
```


### 方法二
```
import java.util.HashMap;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;
    }

    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;
        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
```
<p id = "37"></p>

## 题目描述
统计一个数字在排序数组中出现的次数。

## 解题思路
遍历

## AC代码
```
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length < 0 ){
           return 0;
        }
        int count = 0;
        for (int i=0; i<array.length; i++){
            if (k == array[i]){
                count++;
            }
        }
       return count;
    }
}
```
<p id = "38"></p>

## 题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

## 解题思路
递归

## AC代码
```
import java.lang.Math;
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
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max( TreeDepth(root.left)+1 , TreeDepth(root.right)+1 );
    }
}
```
<p id = "39"></p>
<p id = "40"></p>

## 题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

## 解题思路
使用hashMap统计使用次数

## AC代码
```
import java.util.HashMap;
import java.util.Map.Entry;
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null&&array.length<=1){
            num1[0]=num2[0]=0;
            return;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0; i < array.length; i++){
            if (hashMap.containsKey(array[i])){
                hashMap.put(array[i],2);
            }else{
                hashMap.put(array[i],1);
            }
        }
        num1[0] = 0;
        for(Integer key:hashMap.keySet()){
            if (hashMap.get(key)==1){
                if(num1[0]==0){
                    num1[0]=key;
                }else{
                    num2[0]=key;
                }
            }
        }
    }
}
```
<p id = "41"></p>

## 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

## 解题思路
* 初始化small=1，big=2;
* small到big序列和等于sum,small++,big++;小于sum，big++;大于sum，small++;
* 当small增加到(1+sum)/2时停止

## AC代码
```
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (sum<=1){
            return lists;
        }
        int small = 1;
        int big = 2;
        while ( small < (1+sum)/2){
            int curSum = totalSum(small,big);
            if (curSum == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int j=small;j<=big;j++){
                    list.add(j);
                }
                lists.add(list);
                small++;big++;
            }else if (curSum < sum){
                big++;
            }else{
                small++;
            }
        }
        return lists;
    }
    //计算当前序列的和
    public int totalSum(int small,int big){
        int total = 0;
        for (int i = small;i<=big;i++){
            total+=i;
        }
        return total;
    }   
}
```
<p id = "42"></p>

## 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。

## 解题思路
定义两个指针start＝0，end＝array.length-1,s = array[start]+array[end],然后夹逼遍历   
1）s < sum,因为是递增序列，所以start++    
2）s > sum, end--    
3）s == sum,     在这个地方是可以优化的，普通的思路可能在这里判断乘积是不是小于之前的乘积，然后继续
遍历，其实因为这个序列是递增的，所以两头的乘积是最小的，及第一个s ==      sum就是我们所求的，          
证明如下：              
x+y >= 2sqrt(x*y),               
x*y <= ((x+y)/2)^2 = (sum^2)/4         
y - x越大，乘积就越小，等号成立条件是x == y

## AC代码
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int start = 0;
        int end = array.length-1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (start<end){
            if (array[start]+array[end] < sum){
                start++;
            } else if (array[start]+array[end]>sum){
                end --;
            } else{
                res.add(array[start]);
                res.add(array[end]);
                return res;
            }
        }
        return res;
    }
}
```
<p id = "43"></p>

## 题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

## 解题思路：
- 1、移动n位，即外围循环n次；
- 2、内部每个字符，依次左移；

## AC代码
```
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str.trim().equals(""))
            return str;
        char[] chs = str.toCharArray();
        for (int i=0; i<n; i++){
            char temp = chs[0];
            int j=0;
            for (; j<chs.length-1; j++){
                chs[j] = chs[j+1];
            }
            chs[j] = temp;
        }
        String newStr = String.valueOf(chs);
        return newStr;
    }
}
```
<p id = "44"></p>

## 题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？


## 解题思路
这道题我被坑了一会~估计是没有想的比较的清楚，获取吧！就是输入为空串的时候，没有考虑到可能是很多空串的时候，需要使用trim函数进行处理一哈！这个头脑有点呆萌！             
其他的旋转函数很简单的，利用我们的分割函数处理就好了，这里有点缺陷，加入最后个字符有很多的空串呢，这个我们就没有考虑这么多啦，满足基本的常见的情形就好了，没有必要较真。                   
分割处理好了，从最后个元素开始链接起来就行啦，这个还是比较的简单的！


## AC代码
```
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")){
            return str;
        }
        String[] array = str.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = array.length-1;i>=1;i--){
            buffer.append(array[i]).append(" ");
        }
        buffer.append(array[0]);
        return buffer.toString();
    }
}
```
<p id = "45"></p>

## 题目描述
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。

## 解题思路
- 1、排序 
- 2、计算所有相邻数字间隔总数 
- 3、计算0的个数 
- 4、如果2、3相等，就是顺子 
- 5、如果出现对子，则不是顺子

## AC代码
```
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        int length = numbers.length;
        int numberOfZero = 0;
        int numberOfInterval = 0;
        if (length==0){
            return false;
        }
        Arrays.sort(numbers);
        for (int i=0; i<length-1; i++){
            if (numbers[i]==0){
                numberOfZero++;
                continue;
            }
            if (numbers[i] == numbers[i+1]){
                return false;
            }
            numberOfInterval += numbers[i+1]-numbers[i]-1;
        }
        if (numberOfZero >= numberOfInterval){
            return true;
        }
        return false;
    }
}
```
<p id = "46"></p>

## 题目描述
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)


## 解题思路
### 第一种：经典的解法， 用环形链表模拟圆圈。
创建一个总共有 n 个结点的环形链表，然后每次在这个链表中删除第 m 个结点。

```
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        //int start = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size(); // 【A】
            }
            list.remove(idx);
            // 确保idx指向每一轮的第一个位置
            // 下面的可以不用，【A】已经可以保证其正确性了，可以分析n=6，m=6的第一次删除情况
            //  if (idx == list.size()) {
            //      idx = 0;
            //  }
        }
        return list.get(0);
    }
```

### 第二种：分析法
首先我们定义一个关于 n 和 m 的方程町矶时，表示每次在 n 个数字 0，1， … ，n-1中每次删除第 m 个数字最后剩下的数字。

在这 n个数字中， 第一个被删除的数字是(m-1)%n。为了简单起见，我们把(m- 1)%n 记为 k，那么删除k之后剩下的 n-1 个数字为 0，1，… ，k-1，k+1，… ，n-1，并且下一次删除从数字 k+1 开始计数。相当于在剩下的序列中， k+1 排在最前面，从而形成 k+1，... ，n- 1，0，I，… ，k-1 。该序列最后剩下的数字也应该是关于 n 和 m 的函数。由于这个序列的规律和前面最初的序列不一样（最初的序列是从 0 开始的连续序列），因此该函数不同于前面的函数，记为 f’(n-1,m)。最初序列最后剩下的数字 f(n, m）一定是删除一个数字之后的序列最后剩下的数字，即 f(n, m)=f’(n-1, m）。

接下来我们把剩下的这 n-1 个数字的序列 k-1， …，n-1，0，1，… ，k-1 做一个映射，映射的结果是形成一个从 0 到 n-2 的序列：

![约瑟夫环规律](http://wiki.jikexueyuan.com/project/for-offer/images/63.png)

最终的递推关系式为     
f(1,m) = 0;  (n=1)    
f(n,m)=(f(n-1,m)+m)%n; （n>1）


```
public static int lastRemaining2(int n, int m) {
    if (n < 1 || m < 1) {
        return -1;
    }
    int last = 0;
    for (int i = 2; i <=n ; i++) {
        last = (last + m)%i;
    }
    return last;
}
```


## AC代码
```
package offer;

import java.util.LinkedList;
import java.util.List;
public class Test46 {
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        //int start = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size(); // 【A】
            }
            list.remove(idx);
            // 确保idx指向每一轮的第一个位置
            // 下面的可以不用，【A】已经可以保证其正确性了，可以分析n=6，m=6的第一次删除情况
            //  if (idx == list.size()) {
            //      idx = 0;
            //  }
        }
        return list.get(0);
    }
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }
        return last;
    }
    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
    }
    private static void test01() {
        System.out.println(lastRemaining(5, 3)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(6, 6)); // 最后余下3
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
    }
    private static void test02() {
        System.out.println(lastRemaining2(5, 3)); // 最后余下3
        System.out.println(lastRemaining2(5, 2)); // 最后余下2
        System.out.println(lastRemaining2(6, 7)); // 最后余下4
        System.out.println(lastRemaining2(6, 6)); // 最后余下3
        System.out.println(lastRemaining2(0, 0)); // 最后余下-1
    }
}
```
<p id = "47"></p>

## 题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

## 解题思路
- 1.需利用逻辑与的短路特性实现递归终止。        
- 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；   
- 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。

## AC代码
```
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0) && ((sum += Sum_Solution(n-1))>0) ;
        return sum;
    }
}
```
<p id = "48"></p>

## 题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

## 解题思路
首先看十进制是如何做的： 5+7=12，三步走   
第一步：相加各位的值，不算进位，得到2。    
第二步：计算进位值，得到10。 如果这一步的进位值为0，那么第一步得到的值就是最终结果。     
第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。 

同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111。     
第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。  
第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。   
第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。 
继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。  

## AC代码
```
public class Solution {
    public int Add(int num1,int num2) {
        while (num2!=0){
            int tmp  = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = tmp;
        }
        return num1;
    }
}
```
<p id = "49"></p>

## 题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0

### 输入描述:
输入一个字符串,包括数字字母符号,可以为空
### 输出描述:
如果是合法的数值表达则返回该数字，否则返回0
### 示例1
- 输入
    - +2147483647    
    - 1a33
- 输出
    - 2147483647
    - 0

## 解题思路
- 1、把符号位提取出来
- 2、遇到非数字直接 return 0
- 3、最后返回检查符号位


## AC代码
```
public class Solution {
    public int StrToInt(String str) {
        if (str.trim().equals("") || str.length()<0){
            return 0;
        }
        char[] chs = str.toCharArray();
        int fuhao = 0;
        if (chs[0]=='-'){
            fuhao = 1;
        }
        int sum = 0;
        for (int i=fuhao;i< chs.length;i++){
            if (chs[i]=='+'){
                continue;
            }
            if (chs[i]>57 || chs[i]<48){
                return 0;
            }
            sum = sum*10+ chs[i]-48;
        }
        return fuhao>0? (sum*-1):sum;
    }
}
```
<p id = "50"></p>

## 题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

## 解题思路
- 1、新开数组长度的布尔数组，表示该数字是否被访问过。
- 2、遍历数组，访问过设为true。
- 3、发现该数字已被访问过，则返回。

## AC代码

```
//boolean只占一位，所以还是比较省的
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
```
<p id = "51"></p>

## 题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

## 解题思路
B[i]的值可以看作下图的矩阵中每行的乘积。
下三角用连乘可以很容求得，上三角，从下向上也是连乘。
因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。

![三角形连乘规律](https://uploadfiles.nowcoder.net/images/20160829/841505_1472459965615_8640A8F86FB2AB3117629E2456D8C652)

## AC代码
```
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B =  new int[length];
        if (length<= 0){
            return B;
        }
        //上三角
        B[0] = 1;
        for (int i=1;i<length;i++){
            B[i] = B[i-1] * A[i-1];
        }
        //下三角
        int temp = 1;
        for (int j=length-2;j>=0;j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
```
<p id = "52"></p>

## 题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

## 解题思路
当模式中的第二个字符不是“*”时：      
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。       
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
      
而当模式中的第二个字符是“*”时：     
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：    
1、模式后移2字符，相当于x*被忽略；    
2、字符串后移1字符，模式后移2字符；    
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；   

**这里需要注意的是：Java里，要时刻检验数组是否越界。**

## AC代码
```
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
```
<p id = "53"></p>

## 题目描述

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

## 解题思路
正则匹配
> .2在Java、Python 中都是数字

## AC代码
```
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
```
<p id = "54"></p>

## 题目描述

请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
### 输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。

## 解题思路
一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。时间复杂度为O(n)，空间复杂度O(n)。

## AC代码
```
public class Solution {
    int[] hashtable = new int[256];
    StringBuffer s =  new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if (hashtable[ch]==0){
            hashtable[ch]=1;
        }else{
            hashtable[ch]++;
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chs = s.toString().toCharArray();
        for (char c : chs){
            if (hashtable[c]==1){
                return c;
            }
        }
        return '#';
    }
}
```
<p id = "55"></p>

## 题目描述
一个链表中包含环，请找出该链表的环的入口结点。


## 解题思路
第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1 == p2找到在环中的相汇点。        
第二步，找环的入口。接上步，当p1 == p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。

## AC代码
```
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                p2 = pHead;
                while (p1!=p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2){
                    return p1;
                }
            }
        }
        return null;
    }
}
```
<p id = "56"></p>

## 题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

## 解题思路
![解题思路](https://uploadfiles.nowcoder.net/images/20160912/1596387_1473616154125_4A47A0DB6E60853DEDFCFDF08A5CA249)

1.加一个头结点     
2.两个临时指针p,q    
3.找前后不相等的节点   

## AC代码
```
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        
        //声明一个头结点，和两个指针
        int myFirst = -1;
        //万一链表的头结点也为-1，那么我就改成-2
        if (myFirst == pHead.val){
            myFirst = -2;
        }
        ListNode head = new ListNode(myFirst);
        head.next = pHead;
        ListNode p = head;
        ListNode q = head.next;
        
        while (q!=null){
            while ((q.next!=null) && (q.val == q.next.val)){
                q = q.next;
            }
            if (p.next != q){
                q = q.next;
                p.next = q;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        //返回的时候，注意去掉头结点（自己创建的辅助节点）
        return head.next;
    }
}
```
<p id = "57"></p>

## 题目描述

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

## 解题思路
> 首先知道中序遍历的规则是：左根右，然后作图

![中序遍历](https://uploadfiles.nowcoder.net/files/20171225/773262_1514198075109_20151104234034251)

结合图，我们可发现分成两大类：     
1、有右子树的，那么下个结点就是右子树最左边的点；（eg：D，B，E，A，C，G）          
2、没有右子树的，也可以分成两类，    
 a)是父节点左孩子（eg：N，I，L） ，那么父节点就是下一个节点 ；           
 b)是父节点的右孩子（eg：H，J，K，M）找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置。如果没有eg：M，那么他就是尾节点。


## AC代码
```
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //分析二叉树的下一个节点，一共有以下情况：
        //1.二叉树为空，则返回空；
        //2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
        //3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
        if (pNode == null){
            return null;
        }
        
        if (pNode.right!=null){
            TreeLinkNode p = pNode.right;
            while (p.left!=null){
                p = p.left;
            }
            return p;
        }
        
        while (pNode.next!=null){
            TreeLinkNode proot = pNode.next;
            if (pNode == proot.left){
                return proot;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
```
<p id = "58"></p>

## 题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

## 解题思路
* 首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
* 左子树的右子树和右子树的左子树相同即可，采用递归
* 非递归也可，采用栈或队列存取各级子树根节点


## AC代码
```
/*
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
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    
    boolean comRoot(TreeNode left , TreeNode right){
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val !=  right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
    
}
```
<p id = "59"></p>

## 题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

## 解题思路
大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，在海量数据时，这样效率太低了。（我有一次面试，算法考的就是之字形打印二叉树，用了reverse，直接被鄙视了，面试官说海量数据时效率根本就不行。）

下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
* 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
* 1)可用做队列,实现树的层次遍历
* 2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历

## AC代码
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;  
/*
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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList();
        if (pRoot == null){
            return ret;
        }
        
        ArrayList<Integer> list =  new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;
        while (queue.size()!=1){
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                if (leftToRight){
                    iter = queue.iterator();//从前往后遍历
                }else{
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()){
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null){
                queue.addLast(node.left);
            }
            if (node.right != null){
                queue.addLast(node.right);
            }
        }
        return ret;
    }

}
```
<p id = "60"></p>

## 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

## 解题思路
利用Java中的LinkedList的底层实现是双向链表的特点，
可用做队列,实现树的层次遍历。

## AC代码
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList();
        if (pRoot == null){
            return ret;
        }
        
        ArrayList<Integer> list =  new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        while (queue.size()!=1){
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                iter = queue.iterator();//从前往后遍历
                while (iter.hasNext()){
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null){
                queue.addLast(node.left);
            }
            if (node.right != null){
                queue.addLast(node.right);
            }
        }
        return ret;
    }
    
}
```
<p id = "61"></p>

## 题目描述
请实现两个函数，分别用来序列化和反序列化二叉树

## 解题思路
如果二叉树的序列化是从根节点开始，那么对应的而反序列化也是从根节点开始的。因此可以使用二叉树的前序遍历来序列化二叉树，当前序遍历碰到null值时，使用“#”表示，每一个节点的数值之间用“，”隔开。


## AC代码
```
/*
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
    public int index = -1;  // 节点在序列中的索引
    String Serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        if (root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val+",");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();
  }
    TreeNode Deserialize(String str) {
        index++;
        int length = str.length();
        if(index > length){
            return null;
        }
        String[] nodeStr = str.split(",");
        TreeNode pNode = null;
        if (!nodeStr[index].equals("#") ){
            pNode = new TreeNode(Integer.valueOf(nodeStr[index]));
            pNode.left = Deserialize(str);
            pNode.right = Deserialize(str);
        }
        return pNode;
  }
}
```
<p id = "62"></p>

## 题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
## 解题思路
设置一个计数器。中序遍历过程中，累加计算访问过的节点数目，当计数器等于要求的k时，则返回该节点

## AC代码
```
/*
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
    int index=0;
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }


}
```
<p id = "63"></p>

## 题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

## 解题思路
 考虑将流中的数据分为相同数量的两部分，也就是两个堆，一个堆中的数据全都小于另外一个堆，小一点的堆里作为最大堆，大一点的堆作为最小堆，这样这两个堆顶元素就与所求的中位数相关。


## AC代码
```
import java.util.*;
public class Solution {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
```
<p id = "64"></p>

## 题目描述

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

## 解题思路
假设窗口大小为w，
- 1、简单的方法：    
遍历数组，从数组第w-1位开始，每次移动一位，并计算窗口w的最大值。
时间复杂度：
计算窗口的最大值需O(w)，移动n-w+1次，时间复杂度为O(nw)

- 2、最大堆方法:     
构建一个窗口w大小的最大堆，每次从堆中取出窗口的最大值，随着窗口往右滑动，需要将堆中不属于窗口的堆顶元素删除。
时间复杂度：
正常情况下，往堆中插入数据为O(lgw)，如果数组有序，则为O(lgn),因为滑动过程中没有元素从堆中被删除，滑动n-w+1次，复杂度为O(nlgn).
- 3、双队列方法：    
最大堆解法在堆中保存有冗余的元素，比如原来堆中元素为[10 5 3]，新的元素为11，则此时堆中会保存有[11 5 3]。其实此时可以清空整个队列，然后再将11加入到队列即可，即只在队列中保持[11]。使用双向队列可以满足要求，滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列。当遇到比当前滑动窗口最大值更大的值时，则将队列清空，并将新的最大值插入到队列中。如果遇到的值比当前最大值小，则直接插入到队列尾部。每次移动的时候需要判断当前的最大值是否在有效范围，如果不在，则需要将其从队列中删除。由于每个元素最多进队和出队各一次，因此该算法时间复杂度为O(N)。

## AC代码
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();  
        if(num.length==0||size<1){  
            return list;  
        }  
        for(int i=0;i<num.length-size+1;i++){  
            int max = num[i];  
            for(int j=i;j<i+size;j++){  
                if(max<num[j]){  
                    max = num[j];  
                }  
            }  
            list.add(max);  
        }  
        return list; 
    }
}
```
<p id = "65"></p>

## 题目描述
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

## 解题思路

- 回溯法。试探，如果当前路不通了，回溯（重置访问标志为false，返回到上一层）
- 
> 关于回溯法：   
回溯法也是设计递归过程的一种重要方法，它的求解过程实质上是一个先序遍历一棵"状态树"的过程,只是这棵树不是遍历前预先建立的,而是隐含在遍历过程中。

## AC代码
```
public class Solution {
     public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {  
        int flag[] = new int[matrix.length];  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (helper(matrix, rows, cols, i, j, str, 0, flag))//每个元素作为起始顶点一次  
                    return true;  
            }  
        }  
        return false;  
    }  
   
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {  
        int index = i * cols + j;  
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)  
            return false;  
        if(k == str.length - 1) return true;  
        flag[index] = 1;  
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)  
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)  
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)  
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {  
            return true;  
        }  
        flag[index] = 0;//回溯  
        return false;  
    }  
}

```
<p id = "66"></p>

## 题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

## 解题思路
> 回溯法

- 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
返回1 + 4 个方向的探索值之和。      
- 2.探索时，判断当前节点是否可达的标准为：    
     - 1）当前节点在矩阵内；
     - 2）当前节点未被访问过；
     - 3）当前节点满足limit限制。

## AC代码
```
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold,rows,cols,0,0,visited);
    }
    
    public int countingSteps(int limit,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols
            || visited[r][c] || bitSum(r) + bitSum(c) > limit)  return 0;
        visited[r][c] = true;
        return countingSteps(limit,rows,cols,r - 1,c,visited)
            + countingSteps(limit,rows,cols,r,c - 1,visited)
            + countingSteps(limit,rows,cols,r + 1,c,visited)
            + countingSteps(limit,rows,cols,r,c + 1,visited)
            + 1;
    }
    public int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }
}
```