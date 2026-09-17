class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        boolean[] used = new boolean[nums2.length];
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !used[j]) {
                    temp[count] = nums1[i];
                    count++;
                    used[j] = true;
                    break;
                }
            }
        }

        int[] ans = new int[count];

        for (int i = 0; i < count; i++) {
            ans[i] = temp[i];
        }

        return ans;
    }
}