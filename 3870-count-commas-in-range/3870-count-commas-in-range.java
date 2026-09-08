class Solution {
    public int countCommas(int n) {
        int count = 0;
        while(n>999){
            count+=1;
            n-=1;
        }
        return count;
    }
}