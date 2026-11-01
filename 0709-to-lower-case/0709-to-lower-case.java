
class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            result.append(Character.toLowerCase(ch));
        }

        return result.toString();
    }
}
