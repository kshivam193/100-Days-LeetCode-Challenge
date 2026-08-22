class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void fun(List<Integer> nums, List<Integer> tmp) {
        ans.add(new ArrayList<>(tmp));

        if (nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> ip = new ArrayList<>(nums);
            List<Integer> op = new ArrayList<>(tmp);

            op.add(nums.get(i));

            for (int j = 0; j <= i; j++) {
                ip.remove(0);
            }

            fun(ip, op);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans.clear();

        List<Integer> tmp = new ArrayList<>();

        for (int num : nums) {
            tmp.add(num);
        }

        fun(tmp, new ArrayList<>());

        return ans;
    }
}