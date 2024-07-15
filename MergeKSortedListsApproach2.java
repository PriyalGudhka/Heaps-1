// Time Complexity : O(nk^2) where n is the average length of the linked list & we have k lists. As we merege 2 lists, length becomes 2n and so on it will become kn for k lists
// Space Complexity: O(nk) for the new list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to add remaining elements from l1 or l2 if either of them becomes null

// Approach: Start with the dummy node. Then iterate over the lists and call the merge method which will merge 2 lists by comapring the values from both the lists. This process is repeated for k lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode merged = new ListNode(Integer.MIN_VALUE);

        for(ListNode list: lists){
            merged = merge(merged, list);
        }

        return merged.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        //If there are still elements in l1, we need to add to the final list
        if(l1 != null){
            curr.next = l1;
        }

        //If there are still elements in l2, we need to add to the final list
        if(l2 != null){
            curr.next = l2;
        }

        return dummy.next;
    }
}