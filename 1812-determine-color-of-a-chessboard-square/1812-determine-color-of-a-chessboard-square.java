
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(0) - 'a' + 1;
        int col = coordinates.charAt(1) - '0';

        return (row + col) % 2 == 1;
    }
}
