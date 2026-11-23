
import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        for (int n : nums3) set3.add(n);

        Set<Integer> ans = new HashSet<>();

        for (int n : set1) {
            if (set2.contains(n) || set3.contains(n)) {
                ans.add(n);
            }
        }

        for (int n : set2) {
            if (set3.contains(n)) {
                ans.add(n);
            }
        }

        return new ArrayList<>(ans);
    }
}
