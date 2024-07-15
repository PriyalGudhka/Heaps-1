// Time Complexity : O(nlogk) where k is the sumber of elements in a heap and every inserting will take logk and we have total n elements
// Space Complexity: O(k) as in the min heap we have k elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Using PriorityQueue (Min Heap). Iterate over the nums and start adding in the queue. And check when size of priority queue is greater than k then remove the elements from the queue. Then finally return the topmost element in the priority queue
class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}