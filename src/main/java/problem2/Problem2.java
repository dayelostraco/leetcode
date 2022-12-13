package problem2;

import java.math.BigInteger;

public final class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String listNode1AsIntegerString = convertListNode(l1, "");
        String listNode2AsIntegerString = convertListNode(l2, "");

        BigInteger total = new BigInteger(listNode1AsIntegerString).add(new BigInteger(listNode2AsIntegerString));

        return convertInt(total.toString(), 0, null);
    }

    private String convertListNode(ListNode currentNode, String stringValue) {
        if(currentNode.next != null) {
            return convertListNode(currentNode.next, stringValue + currentNode.val);
        } else {
            return new StringBuilder(stringValue + currentNode.val).reverse().toString();
        }
    }

    private ListNode convertInt(String nodeValStr, int nodeValStrPos, ListNode listNode) {

        if(nodeValStrPos < nodeValStr.length()) {
            ListNode listNodeNext = new ListNode(
                    Integer.parseInt(String.valueOf(nodeValStr.charAt(nodeValStrPos))), listNode);
            nodeValStrPos++;
            return convertInt(nodeValStr, nodeValStrPos, listNodeNext);
        } else {
            return listNode;
        }
    }
}
