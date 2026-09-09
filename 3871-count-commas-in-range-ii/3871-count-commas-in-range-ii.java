class Solution {
    public long countCommas(long n) {

        long curr=1000;
        long ans=0;

        while(curr<=n){
            ans+=n-curr+1;
            curr*=1000;
        }
        return ans;
    }
}