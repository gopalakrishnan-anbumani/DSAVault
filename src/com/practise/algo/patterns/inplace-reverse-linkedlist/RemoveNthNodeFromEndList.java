//LeetCode - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode front = dummyNode;
        int count = 0;
        while(front != null && count < n){
            front = front.next;
            count++;
        }
        ListNode curr = dummyNode;
        while(front.next != null){
            front = front.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummyNode.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
