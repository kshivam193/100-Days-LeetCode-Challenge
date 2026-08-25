class Solution {

    void fun(int[] candidates, int target, int index,
             List<Integer> output, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        if (candidates[index] <= target) {
            output.add(candidates[index]);

            fun(candidates, target - candidates[index], index,
                output, ans);

            output.remove(output.size() - 1);
        }

        fun(candidates, target, index + 1, output, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        fun(candidates, target, 0, output, ans);

        return ans;
    }
}