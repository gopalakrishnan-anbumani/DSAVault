//https://leetcode.com/problems/reverse-nodes-in-k-group/
//Eduactive - Patterns

class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        boolean run = true;
        ListNode startOfNextGroup = head;
        ListNode curr = head;
        ListNode endOfPrevGroup = null;
        ListNode resultHead = null;
        while(run){
            //find start of Next K group
            int count = 0;
            while(startOfNextGroup != null && count < k){
                count++;
                startOfNextGroup = startOfNextGroup.next;
            }
            if(count != k){
                run = false;
                break;
            }
            //Reverse the K Group
            ListNode prev = startOfNextGroup;
            ListNode next;
            while(curr != startOfNextGroup) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            //Now Curr & startOfNextGroup are in same node
            //Set result head to return
            if(resultHead == null){
                resultHead = prev;
            }
            if(endOfPrevGroup != null){
                endOfPrevGroup.next = prev;
            }
            while(prev.next != curr){
                prev = prev.next;
            }
            endOfPrevGroup = prev;
        }
        return resultHead;
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
