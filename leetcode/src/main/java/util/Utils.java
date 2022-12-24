package util;

public class Utils {
    public static ListNode buildSingleLinkedListFromArray(int[] arr) {
        ListNode ln = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (ln == null) {
                ln = new ListNode(arr[i], null);
            } else {
                ln = new ListNode(arr[i], ln);
            }
        }
        return ln;
    }

    public static String getListStringResult(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
