//https://leetcode.com/problems/palindrome-linked-list/description/
//Eduactive Pattern - Fast Slow Pointer

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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            middle = middle.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode current = middle;
        ListNode next = middle;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        while(prev != null){
            if(head.val != prev.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
