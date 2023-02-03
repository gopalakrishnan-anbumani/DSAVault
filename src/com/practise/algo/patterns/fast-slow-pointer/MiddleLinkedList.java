//https://leetcode.com/problems/middle-of-the-linked-list/description/
//Eduactive Pattern Coding

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
class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow =  head;
        ListNode fast = head;
        if(head == null || head.next == null){
            return head;
        }
        while(fast != null && fast.next != null){
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next; 
        }
        return slow;
    }
}
