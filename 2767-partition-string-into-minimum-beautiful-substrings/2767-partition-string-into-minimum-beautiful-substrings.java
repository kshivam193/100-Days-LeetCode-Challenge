class Solution {

    boolean isBeautiful(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    int fun(int i, String s) {

        if (i == s.length()) {
            return 0;
        }

        if (s.charAt(i) == '0') {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        int num = 0;

        for (int j = i; j < s.length(); j++) {

            num = num * 2 + (s.charAt(j) - '0');

            if (isBeautiful(num)) {

                int next = fun(j + 1, s);

                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + next);
                }
            }
        }

        return ans;
    }

    public int minimumBeautifulSubstrings(String s) {

        int ans = fun(0, s);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}