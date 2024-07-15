// Time Complexity : O(nlog(n-k)) where k is the number of elements in a heap and every inserting will take log(n -k) and we have total n elements
// Space Complexity: O(n - k) as in the max heap we have n - k elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. In the comparator wrote a - b instead of b - a

// Approach: Using PriorityQueue (Max Heap with comparator). Keep a min variable with having Integer.MAX_VALUE as the initial value which will maintain the min element of the removed nodes from the queue. Iterate over the nums and start adding in the queue. And check when size of priority queue is greater than  n - k then remove the elements from the queue. Now compare the removed elemet with min and update min if smaller than the current min. Then finally return the min element.

class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);

            if(pq.size() > n - k){
                int val = pq.poll();
                min = Math.min(min, val);
            }
        }

        return min;
    }
}