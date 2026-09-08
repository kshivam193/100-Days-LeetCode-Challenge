class Solution {

    long[] dp = new long[100003];

    long fun(int i, List<Integer> nums, HashMap<Integer, Integer> m1) {

        if(i >= nums.size()) return 0;

        if(dp[i] != -1) return dp[i];

        int id = nums.size();

        for(int j = i + 1; j < nums.size(); j++) {
            if(nums.get(j) > nums.get(i) + 2) {
                id = j;
                break;
            }
        }

        long t = 1L * nums.get(i) * m1.get(nums.get(i))
                + fun(id, nums, m1);

        long nt = fun(i + 1, nums, m1);

        return dp[i] = Math.max(t, nt);
    }

    public long maximumTotalDamage(int[] nums) {

        HashMap<Integer, Integer> m1 = new HashMap<>();

        for(int a : nums)
            m1.put(a, m1.getOrDefault(a, 0) + 1);

        List<Integer> v1 = new ArrayList<>();

        for(int a : m1.keySet())
            v1.add(a);

        Collections.sort(v1);

        Arrays.fill(dp, -1);

        return fun(0, v1, m1);
    }
}