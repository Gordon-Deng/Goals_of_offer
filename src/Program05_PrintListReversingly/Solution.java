package Program05_PrintListReversingly;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead_Iteratively(ListNode listNode) {
        Stack<Integer> listNodeStack = new Stack<Integer>();

        while (listNode != null){
            listNodeStack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> listNodeVal = new ArrayList<Integer>();

        while (!listNodeStack.isEmpty()){
            listNodeVal.add(listNodeStack.pop());
        }

        return listNodeVal;
    }
}
