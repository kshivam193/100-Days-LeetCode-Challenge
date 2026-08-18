class Solution {
    public int func (String s ){
        int n = s.length();
        int cost = 0 ;
        for (int i = 0; i < n / 2; i++) {
            int a1 = s.charAt(i) - 'a';
            int a2 = s.charAt(n-1-i) - 'a';


            int diff = Math.abs(a1 - a2 );
            cost += Math.min(diff , 26 - diff );
        }
        return cost ;
    }
    public int minOperations(String s) {
    int n = s.length();
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {

        int cost = i + func(s);
        ans = Math.min(ans, cost);

        s = s.substring(1) + s.charAt(0);
    }

    return ans;
    }
}