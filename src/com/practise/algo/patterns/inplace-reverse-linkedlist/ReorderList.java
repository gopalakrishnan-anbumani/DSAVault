//https://leetcode.com/problems/reorder-list/description/
//Eduactive - Patterns - Inplace Reversal Linkedlist

class ReorderList {
    
    //Reverse the Second Part. & Merge it
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next=null;
        ListNode reversedList = prev;
        ListNode ptr = head;
        while(ptr != null && reversedList != null){
            ListNode next = ptr.next;
            ListNode nodeToInsert = reversedList;
            reversedList = reversedList.next;
            ptr.next = nodeToInsert;
            nodeToInsert.next = next;
            ptr = next;
        }
    }
    
    
    //Solution using the Stack
    public void reorderList1(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        Stack<ListNode> stack = new Stack<>();
        while(middle != null){
            stack.push(middle);
            middle = middle.next;
        }
        System.out.println(stack);
        slow.next=null;
        ListNode ptr = head;
        ListNode next;
        while(ptr != null && !stack.isEmpty()){
            next = ptr.next;
            ListNode nodeToInsert = stack.pop();
            ptr.next = nodeToInsert;
            nodeToInsert.next = next;
            ptr = next;
        }
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
