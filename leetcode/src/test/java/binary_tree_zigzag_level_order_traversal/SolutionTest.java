package binary_tree_zigzag_level_order_traversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        Solution s = new Solution();
        List<List<Integer>> actual = s.zigzagLevelOrder(root);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(List.of(3)));
        expect.add(new ArrayList<>(List.of(20, 9)));
        expect.add(new ArrayList<>(List.of(15, 7)));

        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {

        TreeNode root = new TreeNode(1);

        Solution s = new Solution();
        List<List<Integer>> actual = s.zigzagLevelOrder(root);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(List.of(1)));

        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {

        Solution s = new Solution();
        List<List<Integer>> actual = s.zigzagLevelOrder(null);
        List<List<Integer>> expect = new ArrayList<>();

        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case4_success() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        Solution s = new Solution();
        List<List<Integer>> actual = s.zigzagLevelOrder(root);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(List.of(1)));
        expect.add(new ArrayList<>(List.of(3, 2)));
        expect.add(new ArrayList<>(List.of(4, 5)));

        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case5_success() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), null);
        root.right = new TreeNode(3, null, new TreeNode(5));

        Solution s = new Solution();
        List<List<Integer>> actual = s.zigzagLevelOrder(root);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(List.of(1)));
        expect.add(new ArrayList<>(List.of(3, 2)));
        expect.add(new ArrayList<>(List.of(4, 5)));

        Assertions.assertEquals(expect, actual);
    }
}
