// Time Complexity : O(nklogk) where n is the average length of the linked list & we have k lists. If every insertion takes logk and we have nk elements
// Space Complexity: O(k) as in the min heap we have k elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Using PriorityQueue (Min Heap). Start by adding head elements of all the list in the queue. Then create a new list by inserting the dummy node and maintaining curr node. Iterate until queue is not empty. First poll the min element and add to current's next and move current pointer. If min's next element is not null add in the queue.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);

        //O(klogk)
        for(ListNode list : lists){
            if(list != null){
                q.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!q.isEmpty()){

            ListNode min = q.poll(); //logk
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                q.add(min.next); //logk
            }
        }
        return dummy.next;
    }
}