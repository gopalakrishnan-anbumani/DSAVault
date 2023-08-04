//https://leetcode.com/contest/weekly-contest-331/problems/take-gifts-from-the-richest-pile/


import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class TakeGiftsFromtheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        long res = 0l;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int gift : gifts) {
        	pq.add(gift);
        }
        
        for(int i=0;i<k;i++) {
        	int gift = pq.poll();
        	int remainingGift = (int)Math.sqrt(gift);
        	pq.add(remainingGift);
        }
        Iterator<Integer> it = pq.iterator();
        while(it.hasNext()) {
        	res = res + it.next();
        }
        return res;
    }
}


/*
You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:

Choose the pile with the maximum number of gifts.
If there is more than one pile with the maximum number of gifts, choose any.
Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
Return the number of gifts remaining after k seconds.*/
