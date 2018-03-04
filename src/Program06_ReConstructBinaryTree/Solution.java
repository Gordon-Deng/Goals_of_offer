package Program06_ReConstructBinaryTree;

/**
 * @Description :
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @Solution :
 * 依次取出前序遍历的节点，在中序遍历中寻找对应位置，递归左右子树，最后取出遍历过的节点。
 *
 * @learn :
 * 1）递归的逻辑需要好好想想，比如：i-startIn+startPre和startPre+1+i-startIn
 * @Author : Gordon Deng
 * @Date :   01:13 2018/3/5
 */

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = ConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    private TreeNode ConstructBinaryTree(int[] pre, int startPre, int endPre,
                                         int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]){
                root.left = ConstructBinaryTree(pre, startPre+1, i-startIn+startPre, in, startIn, i-1);
                root.right = ConstructBinaryTree(pre, startPre+1+i-startIn, endPre, in, i+1, endIn);

                break;
            }
        }

        return root;
    }
}
