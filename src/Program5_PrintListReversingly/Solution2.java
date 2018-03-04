package Program5_PrintListReversingly;

import java.util.ArrayList;

public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead_Recursively(ListNode listNode){
        ArrayList<Integer> listNodeVal = new ArrayList<>();

        if (listNode != null){
            if (listNode.next != null){
                printListFromTailToHead_Recursively(listNode.next);

                listNodeVal.add(listNode.val);
            }
        }

        return listNodeVal;
    }
}
