class Solution {

    int[] dp = new int[102];
    
    public int fun(int[] nums, int i) {
        // Base case
        if (i >= nums.length) {
            return 0;

        }
        if(dp[i] != -1) return dp[i];

        int c = nums[i] + fun(nums, i + 2);
        int c2 = fun(nums, i + 1);

        int ans = Math.max(c, c2);
        dp[i] = ans;
        return ans;
    }
    

    public int rob(int[] nums) {
        for(int i =0 ; i< dp.length ; i++) dp[i] = -1;
        
        return fun(nums, 0);
    }
}
