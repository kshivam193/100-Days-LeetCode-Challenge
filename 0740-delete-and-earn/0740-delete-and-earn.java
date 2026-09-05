class Solution {

    int[] dp = new int[20005];

    public int fun(int i, int[] nums, HashMap<Integer, Integer> m1) {

        if (i == nums.length - 1) {
            return nums[i] * m1.get(nums[i]);
        }

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int m = 0;

        // Current and next value are consecutive
        if (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {

            int a = (nums[i] * m1.get(nums[i]))
                    + fun(i + 2, nums, m1);

            m = Math.max(m, a);
        }

        // Current and next value are NOT consecutive
        if (i + 1 < nums.length && nums[i + 1] != nums[i] + 1) {

            int a = (nums[i] * m1.get(nums[i]))
                    + fun(i + 1, nums, m1);

            m = Math.max(m, a);
        }

        // Don't take current
        int a = fun(i + 1, nums, m1);

        m = Math.max(m, a);

        return dp[i] = m;
    }


    public int deleteAndEarn(int[] nums) {

        HashMap<Integer, Integer> m1 = new HashMap<>();

        // Frequency count
        for (int a : nums) {
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        // Store unique sorted values
        ArrayList<Integer> v1 = new ArrayList<>(m1.keySet());

        Collections.sort(v1);

        int[] arr = new int[v1.size()];

        for (int i = 0; i < v1.size(); i++) {
            arr[i] = v1.get(i);
        }

        Arrays.fill(dp, -1);

        return fun(0, arr, m1);
    }
}