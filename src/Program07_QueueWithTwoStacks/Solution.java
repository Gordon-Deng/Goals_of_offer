package Program07_QueueWithTwoStacks;

import java.util.Stack;

/**
 * @Description :
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 *
 * @Solution :
 * stack1储存数据，stack2反转栈元素顺序
 *
 * @learn :
 * 1）stack.size()别在循环中当判定语句，因为push和pop实时改变栈的大小，改用stack.isEmpty()
 * @Author : Gordon Deng
 * @Date :   03:10 2018/3/5
 */

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return Integer.parseInt(null);
        }

        if (!stack2.isEmpty()){
            return stack2.pop();
        }

        else {
            //别使用for (int i = 0; i < stack1.size(); i++){}，因为stack1.size()在pop完后会变小
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
