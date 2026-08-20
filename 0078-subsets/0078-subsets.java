class Solution {
     List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findsubsets(nums, 0, new ArrayList<>());
        return res;
    }
    public void findsubsets(int[] nums, int index, List<Integer>sublist){
        //base case
        if(index == nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }
        //pick
        sublist.add(nums[index]);
        findsubsets(nums, index+1, sublist);
        sublist.remove(sublist.size()-1);
        //not pick
        findsubsets(nums, index+1, sublist);
    }
}