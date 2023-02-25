//https://leetcode.com/problems/reverse-linked-list/description/
//Eduactive - Patterns

import java.util.*;
public class ReverseLinkedList{
    public static LinkedListNode reverse(LinkedListNode head) {
      LinkedListNode prev = null;
      LinkedListNode curr = head;
      LinkedListNode next;
      while(curr!=null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
    return prev;
  }
