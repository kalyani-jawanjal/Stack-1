import java.util.Stack;

//Time and Space - O(n)
class DailyTempretures {
    public int[] dailyTemperatures(int[] nums) {
        if(nums == null && nums.length == 0) return nums;

        int[] answer = new int[nums.length];
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{nums[0], 0});

        for(int i=1; i<nums.length; i++) {

            while(!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                int index = stack.peek()[1];
                answer[index] = i - index;
                stack.pop();
            }

            stack.push(new int[]{nums[i], i});
        }

        return answer;
    }
}
