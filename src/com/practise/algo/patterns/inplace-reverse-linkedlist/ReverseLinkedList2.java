//https://leetcode.com/problems/reverse-linked-list-ii/
//Eduactive - Patterns - Inplace Reversal Linked List

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        int count = 1;
        ListNode firstPartLastNode = null;
        ListNode leftHead = head;
        while(leftHead != null && count < left){
            count++;
            firstPartLastNode = leftHead;
            leftHead = leftHead.next;
        }
        count = 1;
        ListNode rightHead = head;
        while(rightHead != null && count < right){
            count++;
            rightHead = rightHead.next;
        }
        if(count != right){
            return head;
        }
        rightHead = rightHead.next;

        ListNode prev = rightHead;
        ListNode curr = leftHead;
        ListNode next = null;
        while(curr != rightHead){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(firstPartLastNode != null){
            firstPartLastNode.next = prev;
        } else {
            return prev;
        }
        //prev.next = curr;

        return head;
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
