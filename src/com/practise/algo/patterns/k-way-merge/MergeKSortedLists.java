//23. Merge k Sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/description/
//Eduactive - Patterns Coding

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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode listNode : lists){
            if(listNode != null){
                pq.add(listNode);
            }
        }
        if(!pq.isEmpty()){
            root = pq.poll();
            if(root.next != null){
                pq.add(root.next);
            }
        }
        ListNode current = root;
        while(!pq.isEmpty()){
            ListNode minElement = pq.poll();
            current.next = minElement;
            if(minElement.next != null){
                pq.add(minElement.next);
            }
            current = current.next;
        }
        return root;
    }
}
