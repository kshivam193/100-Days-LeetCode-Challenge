class Solution {
    static void fun(int n, String tmp, List<String> ans, int a , int b) {
        if (tmp.length() == 2 * n) {
            ans.add(tmp);
            return;
        }
        if(a < n) fun(n, tmp + "(", ans, a + 1, b);
        
        if(b < a) fun(n, tmp + ")", ans, a , b + 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        fun(n, "", s, 0, 0);
        return s;
    }
}