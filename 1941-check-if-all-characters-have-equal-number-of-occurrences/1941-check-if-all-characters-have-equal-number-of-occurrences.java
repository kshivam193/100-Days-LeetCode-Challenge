
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (count == 0) {
                    count = freq[i];
                } else if (count != freq[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
