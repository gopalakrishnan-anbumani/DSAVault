//https://leetcode.com/problems/swap-nodes-in-pairs/description/
//Eduactive - Patterns

class SwapNodesInPairs {
    //Optimised Solution;
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;

            prev = curr;
            curr = prev.next;
        }
        return dummyNode.next;
    }
    
    //My Solution. Got idea of solved previous problems.
    public ListNode swapPairs(ListNode head) {
        int count = 0;
        ListNode ptr =head;
        ListNode last = null;
        ListNode currentStarting = head;
        ListNode result = (head != null && head.next != null) ? head.next : head;
        while(ptr != null){
            count++;
            if(count == 2){
                ListNode nextBatch = ptr.next;
                //Reverse
                ListNode curr = currentStarting;
                ListNode prev = nextBatch;
                ListNode next = null; 
                while(curr != nextBatch){
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                if(last != null){
                    last.next = prev;
                }
                last = currentStarting;
                ptr = last;
                count = 0;
            } else {
                currentStarting = ptr;
            }
            ptr = ptr.next;
        }
        return result;
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
