package Program05_PrintListReversingly;

/**
 * @Description :输入一个链表，从尾到头打印链表每个节点的值。
 *
 * @Solution :用栈实现后序遍历
 *
 * @learn :
 * 1）new ArrayList<>()的<>里面记得填数据类型
 * @Author : Gordon Deng
 * @Date :   20:22 2018/3/4
 */

class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}
