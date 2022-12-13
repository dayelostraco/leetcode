package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    Problem2 problem2 = new Problem2();
    ListNode case1ListNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode case1ListNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    @Test
    void addTwoNumbers() {
        ListNode result = problem2.addTwoNumbers(case1ListNode1, case1ListNode2);

        assertNotNull(result);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }
}