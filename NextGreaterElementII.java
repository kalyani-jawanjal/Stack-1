import java.util.Arrays;
import java.util.Stack;

//Time and space - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack();
        stack.push(0);

        Arrays.fill(res, -1);

        for(int i=1; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }

        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
        }

        return res;
    }
}

