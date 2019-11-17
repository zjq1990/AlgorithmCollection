package jzOffer;


import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 递归
    public int TreeDepth_Solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepth_Solution(root.left);
        int right = TreeDepth_Solution(root.right);
        return left > right ? left + 1 : right + 1;
    }

    // 非递归 层序遍历
    public int TreeDepth_Solution1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 0;
        int nextCount = q.size();//下一层的节点数量
        int depth = 0;
        while (q.size() != 0) {
            TreeNode t = q.poll();
            count++;

            if (t.left != null) {
                q.add(t.left);
            }

            if (t.right != null) {
                q.add(t.right);
            }

            // 如果遍历一层结束时，深度加一
            if (count == nextCount) {
                depth++;
                count = 0;
                nextCount = q.size();
            }
        }

        return depth;
    }
}
