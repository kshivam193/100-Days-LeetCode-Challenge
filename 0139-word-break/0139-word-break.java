class Solution {

    HashMap<String, Integer> dp = new HashMap<>();

    public int fun(int i, String s, HashMap<String, Integer> m1, String tmp) {

        if (i >= s.length()) {

            if (tmp.length() == 0)
                return 1;

            return 0;
        }

        String key = i + "+" + tmp;

        if (dp.containsKey(key))
            return dp.get(key);

        int m = 0;

        tmp += s.charAt(i);

        // TAKE
        if (m1.containsKey(tmp)) {

            int a = fun(i + 1, s, m1, "");

            m = m | a;
        }

        // NOT TAKE
        int a = fun(i + 1, s, m1, tmp);

        m = m | a;

        dp.put(key, m);

        return m;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashMap<String, Integer> m1 = new HashMap<>();

        for (String a : wordDict) {
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        dp.clear();

        return fun(0, s, m1, "") == 1;
    }
}