package binary_tree_zigzag_level_order_traversal;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> r = new ArrayList<>();

        Queue<TreeNode> q1 = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        q1.add(root);
        int level = 0;
        r.add(List.of(root.val));
        while (!q1.isEmpty()) {

            TreeNode node = q1.poll();
//            System.out.println("level=" + level + " node:" + node.val);

            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);

            if (q1.isEmpty() && !list.isEmpty()) {
//                System.out.println("next level");
                level++;
                ArrayList<Integer> content = new ArrayList<>();
                if (level % 2 != 0) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        content.add(list.get(i).val);
                    }
                } else {
                    for (TreeNode n : list) {
                        content.add(n.val);
                    }
                }
                r.add(content);
                q1.addAll(list);
                list.clear();
            }
        }
        return r;
    }
}
